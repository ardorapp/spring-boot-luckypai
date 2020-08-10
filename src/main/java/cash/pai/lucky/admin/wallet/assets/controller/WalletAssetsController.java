package cash.pai.lucky.admin.wallet.assets.controller;

import cash.pai.lucky.admin.common.controller.CommonController;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.service.WalletAssetsService;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/wallet/assets/")
public class WalletAssetsController extends CommonController<WalletAssetsVo, WalletAssets, String> {
    @Autowired
    private WalletAssetsService walletAssetsService;

    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("wallet/assets/assets", "assets", walletAssetsService.get("1").getData());
    }
}
