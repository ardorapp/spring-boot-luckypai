package cash.pai.lucky.admin.wallet.assets.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.sysuser.service.SysUserService;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.util.CopyUtil;
import cash.pai.lucky.admin.util.SecurityUtil;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.repository.WalletAccountRepository;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.repository.WalletAssetsRepository;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceHub;
import cash.pai.lucky.assetsservice.AssetsServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
//@Configuration
//@Component
@EnableScheduling   // 2.开启定时任务
public class WalletAssetsServiceImpl extends CommonServiceImpl<WalletAssetsVo, WalletAssets, String> implements WalletAssetsService {

    @Autowired
    private WalletAssetsRepository walletAssetsRepository;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private WalletAccountRepository walletAccountRepository;

    @Autowired
    private AssetsServiceHub assetsServiceHub;

    @Override
    public Result<WalletAssetsVo> save(WalletAssetsVo entityVo) {
        //调用父类
        return super.save(entityVo);
    }

    //3.添加定时任务
    //或直接指定时间间隔,毫秒
    @Scheduled(fixedRate=20000)
    protected void syncAssetsInfoTasks() {
        super.list(null).getData().forEach((assetsVo)->{
            updateAssetsServiceInfo(assetsVo,assetsServiceHub.getAssetsServiceFactory(assetsVo.getAssetsSymbol()));
            updateAssetsAccountBalance(assetsVo,assetsServiceHub.getAssetsServiceFactory(assetsVo.getAssetsSymbol()));
        });
    }

    private void updateAssetsServiceInfo(WalletAssetsVo assetsVo,AssetsServiceFactory assetsServiceFactory) {
        if (assetsServiceFactory == null) {
            return;
        }
        AssetsServiceInfo assetsServiceInfo = assetsServiceFactory.getAssetsServiceInfo();
        if (assetsServiceInfo == null) {
            return;
        }
        Date lastBlockTime = new Date(assetsServiceInfo.mediantime() * 1000);
        log.info("update "+assetsVo.getAssetsSymbol()+" LastBlockHeight："+assetsServiceInfo.blocks() + " " +lastBlockTime);
        assetsVo.setUpdateTime(new Date());
        assetsVo.setLastBlockHeight(""+assetsServiceInfo.blocks());
        assetsVo.setLastBlockTime(lastBlockTime);
        save(assetsVo);
    }

    private void updateAssetsAccountBalance(WalletAssetsVo assetsVo,AssetsServiceFactory assetsServiceFactory) {
        if (assetsServiceFactory == null || assetsVo == null || !assetsVo.getAssetsEnable()) {
            return;
        }
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        //查询在线用户
        for (Object allPrincipal : allPrincipals) {
            User user = (User) allPrincipal;
            SysUserVo sysUserVo = sysUserService.findByLoginName(user.getUsername()).getData();
            List<WalletAccount> list = walletAccountRepository.findByUserIdAndAssetsId(sysUserVo.getUserId(),assetsVo.getAssetsId());
            if (list == null || list.size() == 0) {
                return;
            }
            list.forEach((account)->{
                if (!StringUtils.isEmpty(account.getSendAccount())) {
                    BigDecimal bigDecimal = assetsServiceFactory.getBalance(account.getSendAccount());
                    account.setSendBalance(bigDecimal);
                }

                if (!StringUtils.isEmpty(account.getReceiveAccount())) {
                    BigDecimal bigDecimal = assetsServiceFactory.getBalance(account.getReceiveAccount());
                    account.setReceiveBalance(bigDecimal);
                }
                //更新该资产下的账户余额。
                walletAccountRepository.save(account);
                log.info("updateAssetsAccountBalance " +account);
            });
        }


    }



    @Override
    public Result<List<WalletAssetsVo>> findByAssetsEnable(Boolean assetsEnable) {
        return Result.of(CopyUtil.copyList(walletAssetsRepository.findByAssetsEnable(assetsEnable), WalletAssetsVo.class));
    }


}
