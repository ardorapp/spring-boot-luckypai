package cash.pai.lucky.assetsservice.pai;

import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceInfo;
import cash.pai.rpcclient.PaicoinJSONRPCClient;
import cash.pai.rpcclient.PaicoindRpcClient;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PAIAssetsServiceFactory implements AssetsServiceFactory {

    private PaicoinJSONRPCClient paicoinJSONRPCClient;

    public PAIAssetsServiceFactory() {
        this.paicoinJSONRPCClient = new PaicoinJSONRPCClient();
    }

    @Override
    public String assetsSymbol() {
        return "PAI";
    }

    @Override
    public AssetsServiceInfo getAssetsServiceInfo() {
        PaicoindRpcClient.BlockChainInfo blockChainInfo = paicoinJSONRPCClient.getBlockChainInfo();
        if (blockChainInfo == null) {
            return null;
        }
        return new PAIAssetsServiceInfo(blockChainInfo);
    }
}
