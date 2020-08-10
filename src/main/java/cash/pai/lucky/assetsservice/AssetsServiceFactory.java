package cash.pai.lucky.assetsservice;

import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;

import java.math.BigDecimal;

public interface AssetsServiceFactory {

    void initService();

    String assetsSymbol();

    AssetsServiceInfo getAssetsServiceInfo();

    void initAssets(WalletAccountVo walletAccountVo);

    String getNewAddress();

    String getPrivateKey(String address);

    boolean importPrivateKey(String privateKey, String account);

    boolean importAddress(String address, String account);

    BigDecimal getBalance(String account);

    boolean validationAddress(String address);
}
