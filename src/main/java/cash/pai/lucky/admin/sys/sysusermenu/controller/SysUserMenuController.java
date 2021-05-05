//package cash.pai.lucky.admin.sys.sysusermenu.controller;
//
//import cash.pai.lucky.admin.annotation.Decrypt;
//import cash.pai.lucky.admin.annotation.Encrypt;
//import cash.pai.lucky.admin.common.controller.CommonController;
//import cash.pai.lucky.admin.common.pojo.Result;
//import cash.pai.lucky.admin.sys.sysmenu.service.SysMenuService;
//import cash.pai.lucky.admin.sys.sysmenu.vo.SysMenuVo;
//import cash.pai.lucky.admin.sys.sysusermenu.pojo.SysUserMenu;
//import cash.pai.lucky.admin.sys.sysusermenu.service.SysUserMenuService;
//import cash.pai.lucky.admin.sys.sysusermenu.vo.SysUserMenuVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/sys/sysUserMenu/")
//public class SysUserMenuController extends CommonController<SysUserMenuVo, SysUserMenu, String> {
//    @Autowired
//    private SysUserMenuService sysUserMenuService;
//
//    @Autowired
//    private SysMenuService sysMenuService;
//
//    @PostMapping("findUserMenuAndAllSysMenuByUserId")
//    @Decrypt
//    @Encrypt
//    public Result<Map<String,Object>> findUserMenuAndAllSysMenuByUserId(SysUserMenuVo sysUserMenuVo){
//        HashMap<String, Object> map = new HashMap<>();
//        List<SysMenuVo> userSysMenuVoList = sysUserMenuService.findByUserId(sysUserMenuVo.getUserId()).getData();
//        map.put("userSysMenuVoList",userSysMenuVoList);
//        List<SysMenuVo> sysMenuVoList = sysMenuService.listByTier(new SysMenuVo()).getData();
//        map.put("sysMenuVoList",sysMenuVoList);
//        return Result.of(map);
//    }
//
//    @PostMapping("saveAllByUserId")
//    @Decrypt
//    @Encrypt
//    public Result<Boolean> saveAllByUserId(SysUserMenuVo sysUserMenuVo){
//        return sysUserMenuService.saveAllByUserId( sysUserMenuVo.getUserId(), sysUserMenuVo.getMenuIdList());
//    }
//}
