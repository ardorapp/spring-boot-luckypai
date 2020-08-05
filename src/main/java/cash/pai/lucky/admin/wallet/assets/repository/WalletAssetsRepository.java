package cash.pai.lucky.admin.wallet.assets.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletAssetsRepository extends CommonRepository<WalletAssets, String> {
}
