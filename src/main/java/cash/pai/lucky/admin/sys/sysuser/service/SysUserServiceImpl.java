package cash.pai.lucky.admin.sys.sysuser.service;

import cash.pai.lucky.admin.common.pojo.PageInfo;
import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.syssetting.service.SysSettingService;
import cash.pai.lucky.admin.sys.sysshortcutmenu.service.SysShortcutMenuService;
import cash.pai.lucky.admin.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import cash.pai.lucky.admin.sys.sysuser.pojo.SysUser;
import cash.pai.lucky.admin.sys.sysuser.repository.SysUserRepository;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.sys.sysuserauthority.service.SysUserAuthorityService;
import cash.pai.lucky.admin.sys.sysusermenu.service.SysUserMenuService;
import cash.pai.lucky.admin.sys.sysusermenu.vo.SysUserMenuVo;
import cash.pai.lucky.admin.util.CopyUtil;
import cash.pai.lucky.admin.util.MD5Util;
import cash.pai.lucky.admin.util.SqlUtil;
import cash.pai.lucky.admin.wallet.account.service.WalletAccountService;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.service.WalletAssetsService;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceHub;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.internal.NativeQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Service
@Transactional
public class SysUserServiceImpl extends CommonServiceImpl<SysUserVo, SysUser, String> implements SysUserService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysSettingService sysSettingService;

    @Autowired
    private SysUserAuthorityService sysUserAuthorityService;

    @Autowired
    private SysUserMenuService sysUserMenuService;

    @Autowired
    private SysShortcutMenuService sysShortcutMenuService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private WalletAccountService walletAccountService;

    @Autowired
    private WalletAssetsService walletAssetsService;

    @Autowired
    private AssetsServiceHub assetsServiceHub;

    @Override
    public Result<String> delete(String id) {
        //删除权限关联表、菜单关联表、个性菜单关联表
        sysUserAuthorityService.findByUserId(id).getData().forEach((vo -> {
            sysUserAuthorityService.delete(vo.getUserAuthorityId());
        }));
        SysUserMenuVo sysUserMenuVo = new SysUserMenuVo();
        sysUserMenuVo.setUserId(id);
        sysUserMenuService.list(sysUserMenuVo).getData().forEach((vo -> {
            sysUserMenuService.delete(vo.getUserMenuId());
        }));
        SysShortcutMenuVo sysShortcutMenuVo = new SysShortcutMenuVo();
        sysShortcutMenuVo.setUserId(id);
        sysShortcutMenuService.list(sysShortcutMenuVo).getData().forEach((vo -> {
            sysShortcutMenuService.delete(vo.getShortcutMenuId());
        }));

        return super.delete(id);
    }

    @Override
    public Result<PageInfo<SysUserVo>> page(SysUserVo entityVo) {
        //SQL
        SysUser entity = CopyUtil.copy(entityVo,SysUser.class);
        StringBuilder sql = SqlUtil.appendFields(entity);
        SqlUtil.appendQueryColumns(entity,sql);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), SysUser.class);

        //分页、排序信息，并设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows(), new Sort(Sort.Direction.ASC, "id"));
        query.setFirstResult((int) pageRequest.getOffset());
        query.setMaxResults(pageRequest.getPageSize());

        //获取分页结果
        Page page = PageableExecutionUtils.getPage(query.getResultList(), pageRequest, () -> {
            //设置countQuerySQL语句
            Query countQuery = em.createNativeQuery("select count(1) from ( " + ((NativeQueryImpl) query).getQueryString() + " ) count_table");
            //设置countQuerySQL参数
            query.getParameters().forEach(parameter -> countQuery.setParameter(parameter.getName(), query.getParameterValue(parameter.getName())));
            //返回一个总数
            return Long.valueOf(countQuery.getResultList().get(0).toString());
        });

        Result<PageInfo<SysUserVo>> result = Result.of(PageInfo.of(page, SysUserVo.class));

        //置空密码
        result.getData().getRows().forEach((sysUserVo) -> {
            sysUserVo.setPassword(null);
        });
        return result;
    }

    @Override
    public Result<SysUserVo> save(SysUserVo entityVo) {
        //新增用户，需要设置初始密码
        if (StringUtils.isEmpty(entityVo.getUserId())) {
            entityVo.setPassword(MD5Util.getMD5(sysSettingService.get("1").getData().getUserInitPassword()));
        }
        Result<SysUserVo> result = super.save(entityVo);
        SysUserVo sysUserVo = result.getData();
        genWalletAccount(sysUserVo.getUserId());
        return result;
    }

    /**
     * 重置初始密码
     */
    @Override
    public Result<SysUserVo> resetPassword(String userId) {
        SysUserVo entityVo = new SysUserVo();
        entityVo.setUserId(userId);
        entityVo.setPassword(MD5Util.getMD5(sysSettingService.get("1").getData().getUserInitPassword()));
        Result<SysUserVo> result = super.save(entityVo);
        result.getData().setPassword(null);
        return result;
    }

    @Override
    public PersistentTokenRepository getPersistentTokenRepository2() {
        return persistentTokenRepository2();
    }

    @Override
    public Result<SysUserVo> findByLoginName(String username) {
        return Result.of(CopyUtil.copy(sysUserRepository.findByLoginName(username), SysUserVo.class));
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository2() {
        JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
        persistentTokenRepository.setDataSource(dataSource);
        return persistentTokenRepository;
    }

    private void genWalletAccount(String userId) {
        //如果该用户还没有对应的资产账号，则生成钱包账号数据，若已存在，则不需要生成。
        List<WalletAssetsVo> list = walletAssetsService.findByAssetsEnable(true).getData();
        if (list == null) {
            return;
        }
        list.forEach((walletAssetsVo)->{
            List<WalletAccountVo> accounts = walletAccountService.findByUserId(userId);
            if (accounts != null && accounts.size() > 0) {
                log.info("existing "+userId+" " + walletAssetsVo.getAssetsSymbol() +" Assets account " + accounts.get(0));
            } else {
                //该资产账号不存在，则新增一个账号数据。
                WalletAccountVo walletAccountVo = new WalletAccountVo();
                walletAccountVo.setUserId(userId);
                walletAccountVo.setAssetsId(walletAssetsVo.getAssetsId());
                walletAccountVo.setReceiveAccount(userId+"_receive");
                walletAccountVo.setSendAccount(userId+"_send");
                AssetsServiceFactory serviceFactory = assetsServiceHub.getAssetsServiceFactory(walletAssetsVo.getAssetsSymbol());
                String address = serviceFactory.getNewAddress();
                String privateKey = serviceFactory.getPrivateKey(address);
                walletAccountVo.setSendAddress(address);
                walletAccountVo.setSendPrivateKey(privateKey);
                Result<WalletAccountVo> result = walletAccountService.save(walletAccountVo);
                serviceFactory.importPrivateKey(privateKey,walletAccountVo.getSendAccount());
                log.info("add "+userId+" " + walletAssetsVo.getAssetsSymbol() +" Assets account " + result.getData());
            }
        });
    }
}
