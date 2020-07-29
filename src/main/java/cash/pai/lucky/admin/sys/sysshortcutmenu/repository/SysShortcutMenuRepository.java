package cash.pai.lucky.admin.sys.sysshortcutmenu.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.admin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysShortcutMenuRepository extends CommonRepository<SysShortcutMenu, String> {
    List<SysShortcutMenu> findByUserId(String userId);
}
