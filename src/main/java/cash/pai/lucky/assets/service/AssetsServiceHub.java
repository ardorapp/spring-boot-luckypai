package cash.pai.lucky.assets.service;

import cash.pai.lucky.assets.service.pai.PAIAssetsServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class AssetsServiceHub implements InitializingBean {

    private HashMap<String,AssetsServiceFactory> assetsServiceFactories = new HashMap<>();

    @Autowired
    private PAIAssetsServiceFactory paiAssetsServiceFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        paiAssetsServiceFactory.initService();
        assetsServiceFactories.put(paiAssetsServiceFactory.assetsSymbol(),paiAssetsServiceFactory);
    }

    public AssetsServiceFactory getAssetsServiceFactory(String assetsSymbol) {
        return assetsServiceFactories.get(assetsSymbol);
    }

//    public static void setupAssets(List<WalletAccountVo> list) {
//        if (list == null || list.size() == 0) {
//            return;
//        }
//        list.forEach((accountVo)->{
//            AssetsServiceFactory serviceFactory = assetsServiceFactories.get(accountVo.getWalletAssets().getAssetsSymbol());
//            serviceFactory.initAssets(accountVo);
//        });
//    }
}
