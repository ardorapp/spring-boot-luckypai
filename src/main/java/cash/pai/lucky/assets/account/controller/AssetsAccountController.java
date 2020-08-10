package cash.pai.lucky.assets.account.controller;

import cash.pai.lucky.admin.annotation.Decrypt;
import cash.pai.lucky.admin.annotation.Encrypt;
import cash.pai.lucky.admin.common.controller.CommonController;
import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.assets.account.pojo.AssetsAccount;
import cash.pai.lucky.assets.account.service.AssetsAccountService;
import cash.pai.lucky.assets.account.vo.AssetsAccountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/assets/account/")
public class AssetsAccountController extends CommonController<AssetsAccountVo, AssetsAccount, String> {
    @Autowired
    private AssetsAccountService assetsAccountService;

    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("assets/account/account", "account", assetsAccountService.get("1").getData());
    }

    @PostMapping("saveReceiveAddress")
    @Decrypt
    @Encrypt
    public Result<AssetsAccountVo> saveReceiveAddress(AssetsAccountVo entityVo) {
        return assetsAccountService.saveReceiveAddress(entityVo);
    }

//    @PostMapping("validationAddress")
//    public Result<Boolean> validationAddress(WalletAccountVo entityVo) {
//        WalletAssetsVo walletAssetsVo = walletAssetsService.get(entityVo.getAssetsId()).getData();
//        AssetsServiceFactory serviceFactory = AssetsServiceHub.getAssetsServiceFactory(walletAssetsVo.getAssetsSymbol());
//        return Result.of(serviceFactory.validationAddress(entityVo.getReceiveAddress()));
//    }
}
