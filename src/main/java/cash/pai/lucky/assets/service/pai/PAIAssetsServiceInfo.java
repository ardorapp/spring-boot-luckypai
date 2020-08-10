package cash.pai.lucky.assets.service.pai;

import cash.pai.lucky.assets.service.AssetsServiceInfo;
import cash.pai.rpcclient.PaicoindRpcClient;

import java.math.BigDecimal;

public class PAIAssetsServiceInfo implements AssetsServiceInfo {

    private PaicoindRpcClient.BlockChainInfo blockChainInfo;

    public PAIAssetsServiceInfo(PaicoindRpcClient.BlockChainInfo blockChainInfo) {
        this.blockChainInfo = blockChainInfo;
    }

    @Override
    public String chain() {
        return blockChainInfo.chain();
    }

    @Override
    public int blocks() {
        return blockChainInfo.blocks();
    }

    @Override
    public long mediantime() {
        return blockChainInfo.medianTime();
    }

    @Override
    public String bestBlockHash() {
        return blockChainInfo.bestBlockHash();
    }

    @Override
    public BigDecimal difficulty() {
        return blockChainInfo.difficulty();
    }
}
