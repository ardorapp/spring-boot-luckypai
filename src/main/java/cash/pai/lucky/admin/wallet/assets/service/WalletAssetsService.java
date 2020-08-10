package cash.pai.lucky.admin.wallet.assets.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;

import java.util.List;

public interface WalletAssetsService extends CommonService<WalletAssetsVo, WalletAssets, String> {
    Result<List<WalletAssetsVo>> findByAssetsEnable(Boolean assetsEnable);
}
