package cash.pai.lucky.admin.sys.sysmenu.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.sysmenu.pojo.SysMenu;
import cash.pai.lucky.admin.sys.sysmenu.repository.SysMenuRepository;
import cash.pai.lucky.admin.sys.sysmenu.vo.SysMenuVo;
import cash.pai.lucky.admin.sys.sysusermenu.service.SysUserMenuService;
import cash.pai.lucky.admin.sys.sysusermenu.vo.SysUserMenuVo;
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
public class SysMenuServiceImpl extends CommonServiceImpl<SysMenuVo, SysMenu, String> implements SysMenuService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Autowired
    private SysUserMenuService sysUserMenuService;

    @Override
    public Result<String> delete(String id) {
        //先删除子节点
        SysMenuVo sysMenuVo = new SysMenuVo();
        sysMenuVo.setMenuParentId(id);
        super.list(sysMenuVo).getData().forEach((menuVo)->{
            super.delete(menuVo.getMenuId());
        });

        //后删除所有用户菜单表关联信息
        SysUserMenuVo sysUserMenuVo = new SysUserMenuVo();
        sysUserMenuVo.setMenuId(id);
        sysUserMenuService.list(sysUserMenuVo).getData().forEach((vo)->{
            sysUserMenuService.delete(vo.getUserMenuId());
        });

        //再删除自己
        return super.delete(id);
    }

    @Override
    public Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo) {
        List<SysMenuVo> menuVoList = new ArrayList<>();
        List<SysMenuVo> sysMenuVoList = super.list(entityVo).getData();
        sysMenuVoList.forEach((sysMenuVo) -> {
            if(StringUtils.isEmpty(sysMenuVo.getMenuParentId())){
                //上级节点
                menuVoList.add(sysMenuVo);
            }
        });
        sysMenuVoList.forEach((sysMenuVo) -> {
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

}
