package cash.pai.lucky.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.LoginParam;
import cash.pai.lucky.param.RegisterParam;


public interface UserAssetService {
    UserEntity findById(String id);

    Result register(RegisterParam registerParam) throws Exception;

    Result checkCode(String code);

    Result login(LoginParam loginParam);
}
