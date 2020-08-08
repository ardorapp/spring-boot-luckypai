package cash.pai.lucky.admin.wallet.account.controller;

import cash.pai.lucky.admin.annotation.Decrypt;
import cash.pai.lucky.admin.annotation.Encrypt;
import cash.pai.lucky.admin.common.controller.CommonController;
import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.service.WalletAccountService;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.service.WalletAssetsService;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceHub;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/wallet/account/")
public class WalletAccountController extends CommonController<WalletAccountVo, WalletAccount, String> {
    @Autowired
    private WalletAccountService walletAccountService;

    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("wallet/account/account", "account", walletAccountService.get("1").getData());
    }

    @PostMapping("saveReceiveAddress")
    @Decrypt
    @Encrypt
    public Result<WalletAccountVo> saveReceiveAddress(WalletAccountVo entityVo) {
        return walletAccountService.saveReceiveAddress(entityVo);
    }

//    @PostMapping("validationAddress")
//    public Result<Boolean> validationAddress(WalletAccountVo entityVo) {
//        WalletAssetsVo walletAssetsVo = walletAssetsService.get(entityVo.getAssetsId()).getData();
//        AssetsServiceFactory serviceFactory = AssetsServiceHub.getAssetsServiceFactory(walletAssetsVo.getAssetsSymbol());
//        return Result.of(serviceFactory.validationAddress(entityVo.getReceiveAddress()));
//    }
}
