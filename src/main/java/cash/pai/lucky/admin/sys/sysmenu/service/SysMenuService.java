package cash.pai.lucky.admin.sys.sysmenu.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.*;
import cash.pai.lucky.admin.sys.sysmenu.pojo.SysMenu;
import cash.pai.lucky.admin.sys.sysmenu.vo.SysMenuVo;

import java.util.List;

public interface SysMenuService extends CommonService<SysMenuVo, SysMenu, String> {
    Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo);
}
