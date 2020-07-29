package cash.pai.lucky.admin.sys.sysuser.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.admin.sys.sysuser.pojo.SysUser;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {
    Result<SysUserVo> findByLoginName(String username);
    Result<SysUserVo> resetPassword(String userId);
    PersistentTokenRepository getPersistentTokenRepository2();
}
