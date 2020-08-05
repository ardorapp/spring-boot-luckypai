package cash.pai.lucky.admin.wallet.account.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletAccountRepository extends CommonRepository<WalletAccount, String> {
}
