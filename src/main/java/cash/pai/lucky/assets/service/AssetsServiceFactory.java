package cash.pai.lucky.assets.service;

import cash.pai.lucky.assets.account.vo.AssetsAccountVo;

import java.math.BigDecimal;

public interface AssetsServiceFactory {

    void initService();

    String assetsSymbol();

    AssetsServiceInfo getAssetsServiceInfo();

    void initAssets(AssetsAccountVo walletAccountVo);

    String getNewAddress();

    String getPrivateKey(String address);

    boolean importPrivateKey(String privateKey, String account);

    boolean importAddress(String address, String account);

    BigDecimal getBalance(String account);

    boolean validationAddress(String address);
}
