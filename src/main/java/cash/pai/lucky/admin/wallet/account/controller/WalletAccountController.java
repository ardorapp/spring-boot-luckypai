package cash.pai.lucky.admin.wallet.account.controller;

import cash.pai.lucky.admin.common.controller.CommonController;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.service.WalletAccountService;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import cash.pai.lucky.admin.wallet.assets.service.WalletAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/wallet/account/")
public class WalletAccountController extends CommonController<WalletAccountVo, WalletAccount, String> {
    @Autowired
    private WalletAccountService walletAccountService;

    @Autowired
    private WalletAssetsService walletAssetsService;


    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("wallet/account/account", "account", walletAccountService.get("1").getData());
    }
}
