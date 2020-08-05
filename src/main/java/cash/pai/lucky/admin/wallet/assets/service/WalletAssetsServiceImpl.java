package cash.pai.lucky.admin.wallet.assets.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.util.SysSettingUtil;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.repository.WalletAssetsRepository;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class WalletAssetsServiceImpl extends CommonServiceImpl<WalletAssetsVo, WalletAssets, String> implements WalletAssetsService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private WalletAssetsRepository sysSettingRepository;

    @Override
    public Result<WalletAssetsVo> save(WalletAssetsVo entityVo) {
        //调用父类
        return super.save(entityVo);
    }
}
