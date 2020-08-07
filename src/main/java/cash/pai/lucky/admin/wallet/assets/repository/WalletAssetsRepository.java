package cash.pai.lucky.admin.wallet.assets.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletAssetsRepository extends CommonRepository<WalletAssets, String> {
    List<WalletAssets> findByAssetsEnable(Boolean assetsEnable);
}
