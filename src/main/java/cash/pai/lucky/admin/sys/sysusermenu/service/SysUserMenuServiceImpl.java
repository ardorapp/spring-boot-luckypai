package cash.pai.lucky.admin.sys.sysusermenu.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.sysmenu.vo.SysMenuVo;
import cash.pai.lucky.admin.sys.sysusermenu.pojo.SysUserMenu;
import cash.pai.lucky.admin.sys.sysusermenu.repository.SysUserMenuRepository;
import cash.pai.lucky.admin.sys.sysusermenu.vo.SysUserMenuVo;
import cash.pai.lucky.admin.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysUserMenuServiceImpl extends CommonServiceImpl<SysUserMenuVo, SysUserMenu, String> implements SysUserMenuService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserMenuRepository sysUserMenuRepository;

    @Override
    public Result<List<SysMenuVo>> findByUserId(String userId) {
        List<SysMenuVo> menuVoList = new ArrayList<>();
        List<SysUserMenuVo> sysUserMenuVoList = CopyUtil.copyList(sysUserMenuRepository.findByUserId(userId), SysUserMenuVo.class);
        sysUserMenuVoList.forEach((sysUserMenuVo) -> {
            SysMenuVo sysMenuVo = sysUserMenuVo.getSysMenu();
            if(StringUtils.isEmpty(sysMenuVo.getMenuParentId())){
                //上级节点
                menuVoList.add(sysMenuVo);
            }
        });
        sysUserMenuVoList.forEach((sysUserMenuVo) -> {
            SysMenuVo sysMenuVo = sysUserMenuVo.getSysMenu();
            if(!StringUtils.isEmpty(sysMenuVo.getMenuParentId())){
                //子节点
                menuVoList.forEach((sysMenuVoP) -> {
                    if(sysMenuVoP.getMenuId().equals(sysMenuVo.getMenuParentId())){
                        sysMenuVoP.getChildren().add(sysMenuVo);
                    }
                });
            }
        });

        return Result.of(menuVoList);
    }

    @Override
    public Result<Boolean> saveAllByUserId(String userId, String menuIdList) {
        //先删除旧的
        SysUserMenuVo sysUserMenuVo = new SysUserMenuVo();
        sysUserMenuVo.setUserId(userId);
        list(sysUserMenuVo).getData().forEach((userMenuVo)->{
            delete(userMenuVo.getUserMenuId());
        });

        //再保存新的
        for (String menuId : menuIdList.split(",")) {
            sysUserMenuVo.setMenuId(menuId);
            save(sysUserMenuVo);
        }
        return Result.of(true);
    }
}
