package cash.pai.lucky.assetsservice;

import cash.pai.lucky.assetsservice.pai.PAIAssetsServiceFactory;

import java.util.HashMap;

public class AssetsServiceHub {

    private static HashMap<String,AssetsServiceFactory> assetsServiceFactories = new HashMap<>();

    static {
        PAIAssetsServiceFactory paiAssetsServiceFactory = new PAIAssetsServiceFactory();
        assetsServiceFactories.put(paiAssetsServiceFactory.assetsSymbol(),paiAssetsServiceFactory);
    }

    public static AssetsServiceFactory getAssetsServiceFactory(String assetsSymbol) {
        return assetsServiceFactories.get(assetsSymbol);
    }
}
