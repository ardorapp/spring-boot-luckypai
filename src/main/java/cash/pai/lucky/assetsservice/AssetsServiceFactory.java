package cash.pai.lucky.assetsservice;

import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;

public interface AssetsServiceFactory {

    String assetsSymbol();

    AssetsServiceInfo getAssetsServiceInfo();

    void initAssets(WalletAccountVo walletAccountVo);

    String getNewAddress();

    String getPrivateKey(String address);

    void importPrivateKey(String privateKey, String account);

    void importAddress(String address, String account);
}
