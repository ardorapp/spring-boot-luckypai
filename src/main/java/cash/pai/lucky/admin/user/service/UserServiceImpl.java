package cash.pai.lucky.admin.user.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.sys.sysuser.service.SysUserService;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.util.MD5Util;
import cash.pai.lucky.admin.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Result<SysUserVo> updatePassword(String oldPassword, String newPassword) {
        SysUserVo sysUserVo = sysUserService.findByLoginName(SecurityUtil.getLoginUser().getUsername()).getData();
        Result<SysUserVo> result = Result.of(null,false,"修改失败，你输入的原密码错误！");
        //确认旧密码
        if(sysUserVo.getPassword().equals(MD5Util.getMD5(oldPassword))){
            sysUserVo.setPassword(MD5Util.getMD5(newPassword));
            result = sysUserService.save(sysUserVo);
            //置空隐私数据
            result.getData().setPassword(null);
        }
        return result;
    }

    @Override
    public Result<SysUserVo> updateUser(SysUserVo sysUserVo) {
        SysUserVo sysUserVo1 = sysUserService.findByLoginName(SecurityUtil.getLoginUser().getUsername()).getData();
        //只允许用户修改这几个选项
        sysUserVo1.setUserName(sysUserVo.getUserName());
        sysUserVo1.setUpdateTime(new Date());

        Result<SysUserVo> result = sysUserService.save(sysUserVo1);
        //置空隐私数据
        result.getData().setPassword(null);
        return result;
    }
}
