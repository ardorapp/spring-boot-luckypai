package cash.pai.lucky.admin.user.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;

public interface UserService {
    Result<SysUserVo> updatePassword(String oldPassword, String newPassword);

    Result<SysUserVo> updateUser(SysUserVo sysUserVo);
}
