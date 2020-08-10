package cash.pai.lucky.assetsservice.pai;

import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceInfo;
import cash.pai.rpcclient.PaicoinJSONRPCClient;
import cash.pai.rpcclient.PaicoindRpcClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;


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
       try {
           PaicoindRpcClient.BlockChainInfo blockChainInfo = paicoinJSONRPCClient.getBlockChainInfo();
           if (blockChainInfo == null) {
               return null;
           }
           return new PAIAssetsServiceInfo(blockChainInfo);
       } catch (Exception e) {
            log.error("PaicoindRpcClient.getBlockChainInfo() error ",e);
       }
       return null;
    }

    @Override
    public void initAssets(WalletAccountVo walletAccountVo) {
        log.info("initAssets PAI：" + walletAccountVo);
//        if (walletAccountVo.getReceiveAccount()) {
//
//        }
//        paicoinJSONRPCClient.importPrivKey(evn.walletBalancePrivKey, evn.walletBalanceAccount);
    }

    @Override
    public String getNewAddress() {
        try {
            String address = paicoinJSONRPCClient.getNewAddress();
            return address;
        } catch (Exception e) {
            log.error("getNewAddress error ",e);
        }
        return null;
    }

    @Override
    public String getPrivateKey(String address) {
        try {
            String privKey = paicoinJSONRPCClient.dumpPrivKey(address);
            return privKey;
        } catch (Exception e) {
            log.error("getPrivateKey error ",e);
        }
        return null;
    }

    @Override
    public boolean importPrivateKey(String privateKey, String account) {
        try {
            paicoinJSONRPCClient.importPrivKey(privateKey,account);
            return true;
        } catch (Exception e) {
            log.error("importPrivateKey error ",e);
        }
        return false;
    }

    @Override
    public boolean importAddress(String address, String account) {
        try {
            paicoinJSONRPCClient.importAddress(address,account,false);
            return true;
        } catch (Exception e) {
            log.error("importAddress error ",e);
        }
        return false;
    }

    @Override
    public BigDecimal getBalance(String account) {
        try {
            return paicoinJSONRPCClient.getBalance(account);
        } catch (Exception e) {
            log.error("importAddress error ",e);
        }
        return null;
    }

    @Override
    public boolean validationAddress(String address) {
        if (StringUtils.isEmpty(address)) {
            return false;
        }
        //MtMHwVoGLwC9KgewQm9TCxRukHdkQuLEMs
        PaicoindRpcClient.AddressValidationResult result = paicoinJSONRPCClient.validateAddress(address);
        log.info("validationAddress "+result);
        return result.isValid();
    }
}
