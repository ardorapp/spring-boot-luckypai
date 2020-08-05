package cash.pai.lucky.admin.wallet.account.controller;

import cash.pai.lucky.admin.common.controller.CommonController;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.service.WalletAccountService;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/wallet/account/")
public class WalletAccountController extends CommonController<WalletAccountVo, WalletAccount, String> {
    @Autowired
    private WalletAccountService sysSettingService;

    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("sys/setting/setting", "sys", sysSettingService.get("1").getData());
    }
}
