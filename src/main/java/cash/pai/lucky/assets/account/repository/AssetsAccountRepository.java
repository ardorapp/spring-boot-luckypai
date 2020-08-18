package cash.pai.lucky.assets.account.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.assets.account.pojo.AssetsAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetsAccountRepository extends CommonRepository<AssetsAccount, String> {
    List<AssetsAccount> findByUserId(String userId);

    AssetsAccount findByUserIdAndAssetsId(String userId, String assetsId);
}
