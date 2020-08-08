package cash.pai.lucky.admin.wallet.account.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;

import java.util.List;

public interface WalletAccountService extends CommonService<WalletAccountVo, WalletAccount, String> {

    List<WalletAccountVo> findByUserId(String userId);

    Result<WalletAccountVo> saveReceiveAddress(WalletAccountVo entityVo);
}
