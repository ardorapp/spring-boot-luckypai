package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.util.DateUtil;
import cash.pai.lucky.admin.util.MD5Util;
import cash.pai.lucky.admin.util.UUIDUtil;
import cash.pai.lucky.admin.util.VerifyCodeImageUtil;
import cash.pai.lucky.common.redis.RedisUtil;
import cash.pai.lucky.constant.RedisKeyConstant;
import cash.pai.lucky.dao.UserAuthorityDao;
import cash.pai.lucky.dao.UserDao;
import cash.pai.lucky.entity.UserAuthorityEntity;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.LoginParam;
import cash.pai.lucky.param.RegisterParam;
import cash.pai.lucky.service.MailService;
import cash.pai.lucky.service.UserAssetService;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserAssetServiceImpl implements UserAssetService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserAuthorityDao userAuthorityDao;

    @Autowired
    MailService mailService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public UserEntity findById(String id) {
        UserEntity sysUserEntity = userDao.findById(id);
        return sysUserEntity;
    }

    /**
     * 注册一个普通用户
     * 需要同时插入sys_user和 sys_authority  两张表
     *
     * @param registerParam
     * @return
     */
    @Override
    @Transactional
    public Result register(RegisterParam registerParam) throws Exception {
        //先根据   和username  判断原来是否存在
        Result result = Result.fail();
        UserEntity existedUser = findByUsername(registerParam.getUserName());
        if (null != existedUser) {
            result = Result.fail("用户名已存在,请修改后再注册。");
        } else {
            Date nowDate = new Date();
            String email = registerParam.getEmail();
            String userName = registerParam.getUserName();

            UserEntity newUser = new UserEntity();
            BeanUtils.copyProperties(registerParam, newUser);
            newUser.setCreateTime(nowDate);
            newUser.setValid("N");
            newUser.setLoginName(registerParam.getUserName());
            newUser.setUpdateTime(nowDate);
            newUser.setLastChangePwdTime(nowDate);
            String userId = UUIDUtil.getUUID();
            newUser.setUserId(userId);
            //写入user表
            insert(newUser);

            //插入用户权限表
            UserAuthorityEntity userAuthorityEntity = new UserAuthorityEntity();
            String userAuthorityId = UUIDUtil.getUUID();
            userAuthorityEntity.setUserAuthorityId(userAuthorityId);
            userAuthorityEntity.setCreateTime(nowDate);
            userAuthorityEntity.setUpdateTime(nowDate);
            userAuthorityEntity.setUserId(userId);
            //TODO  authority ID先暂时写死，后续改善
            userAuthorityEntity.setAuthorityId("3fb1c570496d4c09ab99b8d31b06zzz");
            userAuthorityDao.insert(userAuthorityEntity);

            //生成6位数激活码
            String verifyCode = VerifyCodeImageUtil.generateTextCode(VerifyCodeImageUtil.TYPE_NUM_UPPER, 6, null);
            //将激活码放到redis中，过期时间为10分钟
            redisUtil.cacheValue(RedisKeyConstant.VALDATE_CODE_KEY + verifyCode, userName, 600, TimeUnit.SECONDS);
            //发送邮件
            mailService.sendActiveMail(email, verifyCode, userName);
            result = Result.of(newUser, true, "注册成功!");
        }
        return result;
    }

    @Override
    @Transactional
    public Result checkCode(String verifyCode) {
        Result result = Result.fail("激活失败");
        Serializable userName = redisUtil.getValue(RedisKeyConstant.VALDATE_CODE_KEY + verifyCode);
        if (null != userName) {
            Integer count = userDao.activeUser(userName.toString());
            if (1 == count) {
                result = Result.of("激活成功");
                redisUtil.removeValue(RedisKeyConstant.VALDATE_CODE_KEY + verifyCode);
            }
        }
        return result;
    }

    @Override
    @Transactional
    public Result login(LoginParam loginParam) {
        UserEntity param = new UserEntity();
        BeanUtils.copyProperties(loginParam, param);
        List<UserEntity> list = findByCondition(param);
        if (CollectionUtils.isNotEmpty(list)) {
            UserEntity loginUser = list.get(0);
            if ("N".equals(loginUser.getValid())) {
                return Result.of("用户尚未激活，请先激活");
            } else if ("Y".equals(loginUser.getValid())) {
                //登录成功，则用户信息放到redis中，
                String userName = loginUser.getUserName();
                long timeStamp = System.currentTimeMillis();
                String token = MD5Util.getMD5(userName + timeStamp);
                String loginUserJson = JSON.toJSONString(loginUser);
                redisUtil.cacheValue(token, loginUserJson);
                return Result.of("登录成功");
            }
        } else {
            //找不到对于的用户
            return Result.of("用户名或者密码错误，请检查");
        }
        return Result.of("登录失败");
    }

    public Integer insert(UserEntity userEntity) {
        //先根据logigname 和username  判断原来是否存在
        Integer count = userDao.insert(userEntity);
        return count;
    }

    public List findByCondition(UserEntity userEntity) {
        List list = userDao.findByCondition(userEntity);
        return list;
    }

    public UserEntity findByUsername(String username) throws Exception {
        if (StringUtils.isEmpty(username)) {
            throw new Exception("username 不能为空");
        }
        UserEntity param = new UserEntity();
        param.setUserName(username);
        List<UserEntity> list = userDao.findByCondition(param);
        if (CollectionUtils.isEmpty(list)) {
            log.info("找不到对应的用户  username" + username);
            return null;
        }
        return list.get(0);
    }
}
