package cash.pai.lucky.admin.sys.sysusermenu.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.admin.sys.sysusermenu.pojo.SysUserMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMenuRepository extends CommonRepository<SysUserMenu, String> {
    List<SysUserMenu> findByUserId(String userId);
}
