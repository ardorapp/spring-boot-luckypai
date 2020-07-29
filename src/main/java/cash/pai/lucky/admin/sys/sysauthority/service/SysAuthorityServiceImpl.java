package cash.pai.lucky.admin.sys.sysauthority.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.config.security.MyFilterInvocationSecurityMetadataSource;
import cash.pai.lucky.admin.sys.sysauthority.pojo.SysAuthority;
import cash.pai.lucky.admin.sys.sysauthority.repository.SysAuthorityRepository;
import cash.pai.lucky.admin.sys.sysauthority.vo.SysAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SysAuthorityServiceImpl extends CommonServiceImpl<SysAuthorityVo, SysAuthority, String> implements SysAuthorityService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysAuthorityRepository sysAuthorityRepository;

    @Autowired
    private SysAuthorityService sysAuthorityService;

    @Autowired
    private MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    /**
     * 重写save方法，当新增、修改权限表后需要去更新权限集合
     */
    @Override
    public Result<SysAuthorityVo> save(SysAuthorityVo entityVo) {
        Result<SysAuthorityVo> result = super.save(entityVo);
        List<SysAuthorityVo> authorityVoList = sysAuthorityService.list(new SysAuthorityVo()).getData();
        myFilterInvocationSecurityMetadataSource.setRequestMap(authorityVoList);
        return result;
    }
}
