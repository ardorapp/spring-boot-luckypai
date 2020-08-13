package cash.pai.lucky.assets.info.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.sysuser.service.SysUserService;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.util.CopyUtil;
import cash.pai.lucky.assets.account.pojo.AssetsAccount;
import cash.pai.lucky.assets.account.repository.AssetsAccountRepository;
import cash.pai.lucky.assets.info.pojo.AssetsInfo;
import cash.pai.lucky.assets.info.repository.AssetsInfoRepository;
import cash.pai.lucky.assets.info.vo.AssetsInfoVo;
import cash.pai.lucky.assets.service.AssetsServiceFactory;
import cash.pai.lucky.assets.service.AssetsServiceHub;
import cash.pai.lucky.assets.service.AssetsServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
//@Configuration
//@Component
@EnableScheduling   // 2.开启定时任务
public class AssetsInfoServiceImpl extends CommonServiceImpl<AssetsInfoVo, AssetsInfo, String> implements AssetsInfoService {

    @Autowired
    private AssetsInfoRepository assetsInfoRepository;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private AssetsAccountRepository assetsAccountRepository;

    @Autowired
    private AssetsServiceHub assetsServiceHub;

    @Override
    public Result<AssetsInfoVo> save(AssetsInfoVo entityVo) {
        //调用父类
        return super.save(entityVo);
    }

    //3.添加定时任务
    //或直接指定时间间隔,毫秒
    @Scheduled(fixedRate=20000)
    protected void syncAssetsInfoTasks() {
        super.list(null).getData().forEach((assetsVo)->{
            updateAssetsServiceInfo(assetsVo,assetsServiceHub.getAssetsServiceFactory(assetsVo.getAssetsSymbol()));
//            updateAssetsAccountBalance(assetsVo,assetsServiceHub.getAssetsServiceFactory(assetsVo.getAssetsSymbol()));
        });
    }

    private void updateAssetsServiceInfo(AssetsInfoVo assetsVo, AssetsServiceFactory assetsServiceFactory) {
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

    private void updateAssetsAccountBalance(AssetsInfoVo assetsVo, AssetsServiceFactory assetsServiceFactory) {
        if (assetsServiceFactory == null || assetsVo == null || !assetsVo.getAssetsEnable()) {
            return;
        }
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        //查询在线用户
        for (Object allPrincipal : allPrincipals) {
            User user = (User) allPrincipal;
            SysUserVo sysUserVo = sysUserService.findByLoginName(user.getUsername()).getData();
            AssetsAccount assetsAccount = assetsAccountRepository.findByUserIdAndAssetsId(sysUserVo.getUserId(),assetsVo.getAssetsId());
            if (assetsAccount == null) {
                return;
            }
                if (!StringUtils.isEmpty(assetsAccount.getSendAccount())) {
                    BigDecimal bigDecimal = assetsServiceFactory.getBalance(assetsAccount.getSendAccount());
                    assetsAccount.setSendBalance(bigDecimal);
                }

                if (!StringUtils.isEmpty(assetsAccount.getReceiveAccount())) {
                    BigDecimal bigDecimal = assetsServiceFactory.getBalance(assetsAccount.getReceiveAccount());
                    assetsAccount.setReceiveBalance(bigDecimal);
                }
                //更新该资产下的账户余额。
                assetsAccountRepository.save(assetsAccount);
                log.info("updateAssetsAccountBalance " +assetsAccount);
        }
    }



    @Override
    public Result<List<AssetsInfoVo>> findByAssetsEnable(Boolean assetsEnable) {
        return Result.of(CopyUtil.copyList(assetsInfoRepository.findByAssetsEnable(assetsEnable), AssetsInfoVo.class));
    }
}
