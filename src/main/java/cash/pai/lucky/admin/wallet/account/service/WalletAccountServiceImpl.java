package cash.pai.lucky.admin.wallet.account.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.util.SysSettingUtil;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.repository.WalletAccountRepository;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class WalletAccountServiceImpl extends CommonServiceImpl<WalletAccountVo, WalletAccount, String> implements WalletAccountService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private WalletAccountRepository sysSettingRepository;

    @Override
    public Result<WalletAccountVo> save(WalletAccountVo entityVo) {
        //调用父类
        Result<WalletAccountVo> result = super.save(entityVo);

        //更新系统设置时同步更新公用静态集合sysSettingMap
//        SysSettingUtil.setSysSettingMap(result.getData());

        return result;
    }
}
