package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.util.UUIDUtil;
import cash.pai.lucky.dao.UserAuthorityDao;
import cash.pai.lucky.dao.UserDao;
import cash.pai.lucky.entity.UserAuthorityEntity;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.RegisterParam;
import cash.pai.lucky.service.RedPackageUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RedPackageUserServiceImpl implements RedPackageUserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserAuthorityDao userAuthorityDao;

    @Override
    public UserEntity findById(String id) {
        UserEntity sysUserEntity = userDao.findById(id);
        return sysUserEntity;
    }

    /**
     * 注册一个普通用户
     * 需要同时插入sys_user和 sys_authority  两张表
     * @param registerParam
     * @return
     */
    @Override
    @Transactional
    public Result register(RegisterParam registerParam) {
        //先根据   和username  判断原来是否存在
        Result result = Result.fail();
        UserEntity existedUser = findByUsername(registerParam.getUserName());
        if (null != existedUser) {
            result = Result.fail("用户名已存在,请修改后再注册。");
        } else {
            Date nowDate=new Date();

            UserEntity newUser = new UserEntity();
            BeanUtils.copyProperties(registerParam, newUser);
            newUser.setCreateTime(nowDate);
            newUser.setValid("Y");
            newUser.setLoginName(registerParam.getUserName());
            newUser.setUpdateTime(nowDate);
            newUser.setLastChangePwdTime(nowDate);
            String userId = UUIDUtil.getUUID();
            newUser.setUserId(userId);
            insert(newUser);

            //插入用户权限表
            UserAuthorityEntity userAuthorityEntity=new UserAuthorityEntity();
            String userAuthorityId = UUIDUtil.getUUID();
            userAuthorityEntity.setUserAuthorityId(userAuthorityId);
            userAuthorityEntity.setCreateTime(nowDate );
            userAuthorityEntity.setUpdateTime(nowDate);
            userAuthorityEntity.setUserId( userId );
            //todo  authority ID先暂时写死，后续改善
            userAuthorityEntity.setAuthorityId("3fb1c570496d4c09ab99b8d31b06zzz");
            userAuthorityDao.insert(userAuthorityEntity);
            result = Result.of(newUser, true, "注册成功!");
        }
        return result;
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

    public UserEntity findByUsername(String username) {
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
