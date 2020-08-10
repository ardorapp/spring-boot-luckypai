package cash.pai.lucky.assets.service;

import java.math.BigDecimal;

public interface AssetsServiceInfo {

    String chain();

    int blocks();

    long mediantime();
    
    String bestBlockHash();

    BigDecimal difficulty();
}
