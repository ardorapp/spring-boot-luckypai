package cash.pai.lucky.assets.account.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.assets.account.pojo.AssetsAccount;
import cash.pai.lucky.assets.account.vo.AssetsAccountVo;

import java.util.List;

public interface AssetsAccountService extends CommonService<AssetsAccountVo, AssetsAccount, String> {

    List<AssetsAccountVo> findByUserId(String userId);

    Result<AssetsAccountVo> saveReceiveAddress(AssetsAccountVo entityVo);
}
