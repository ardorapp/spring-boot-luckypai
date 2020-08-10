package cash.pai.lucky.assetsservice;

import java.math.BigDecimal;

public interface AssetsServiceInfo {

    String chain();

    int blocks();

    long mediantime();
    
    String bestBlockHash();

    BigDecimal difficulty();
}
