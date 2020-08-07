package cash.pai.lucky.assetsservice;

import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import cash.pai.lucky.assetsservice.pai.PAIAssetsServiceFactory;

import java.util.HashMap;
import java.util.List;

public class AssetsServiceHub {

    private static HashMap<String,AssetsServiceFactory> assetsServiceFactories = new HashMap<>();

    static {
        PAIAssetsServiceFactory paiAssetsServiceFactory = new PAIAssetsServiceFactory();
        assetsServiceFactories.put(paiAssetsServiceFactory.assetsSymbol(),paiAssetsServiceFactory);
    }

    public static AssetsServiceFactory getAssetsServiceFactory(String assetsSymbol) {
        return assetsServiceFactories.get(assetsSymbol);
    }

    public static void setupAssets(List<WalletAccountVo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.forEach((accountVo)->{
            AssetsServiceFactory serviceFactory = assetsServiceFactories.get(accountVo.getWalletAssets().getAssetsSymbol());
            serviceFactory.initAssets(accountVo);
        });
    }
}
