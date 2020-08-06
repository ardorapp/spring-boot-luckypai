package cash.pai.lucky.admin.wallet.assets.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.util.SysSettingUtil;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.repository.WalletAssetsRepository;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceHub;
import cash.pai.lucky.assetsservice.AssetsServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Slf4j
@Service
@Transactional
//@Configuration
//@Component
@EnableScheduling   // 2.开启定时任务
public class WalletAssetsServiceImpl extends CommonServiceImpl<WalletAssetsVo, WalletAssets, String> implements WalletAssetsService {

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
            updateAssetsServiceInfo(assetsVo,AssetsServiceHub.getAssetsServiceFactory(assetsVo.getAssetsSymbol()));
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
}
