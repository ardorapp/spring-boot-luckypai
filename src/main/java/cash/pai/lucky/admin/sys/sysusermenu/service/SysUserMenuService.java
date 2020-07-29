package cash.pai.lucky.admin.sys.sysusermenu.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.admin.sys.sysmenu.vo.SysMenuVo;
import cash.pai.lucky.admin.sys.sysusermenu.pojo.SysUserMenu;
import cash.pai.lucky.admin.sys.sysusermenu.vo.SysUserMenuVo;

import java.util.List;

public interface SysUserMenuService extends CommonService<SysUserMenuVo, SysUserMenu, String> {
    Result<List<SysMenuVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String menuIdList);
}
