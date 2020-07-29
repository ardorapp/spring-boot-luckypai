package cash.pai.lucky.admin.sys.sysuser.repository;

import cash.pai.lucky.admin.common.repository.*;
import cash.pai.lucky.admin.sys.sysuser.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}
