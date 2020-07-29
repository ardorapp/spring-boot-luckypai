package cash.pai.lucky.admin.sys.sysuserauthority.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.admin.sys.sysuserauthority.pojo.SysUserAuthority;
import cash.pai.lucky.admin.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {
    Result<List<SysUserAuthorityVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
