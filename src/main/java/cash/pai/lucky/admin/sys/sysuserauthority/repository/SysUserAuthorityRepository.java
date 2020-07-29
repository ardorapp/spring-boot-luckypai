package cash.pai.lucky.admin.sys.sysuserauthority.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.admin.sys.sysuserauthority.pojo.SysUserAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserAuthorityRepository extends CommonRepository<SysUserAuthority, String> {
    List<SysUserAuthority> findByUserId(String userId);
}
