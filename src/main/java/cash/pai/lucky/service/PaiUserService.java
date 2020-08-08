package cash.pai.lucky.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.RegisterParam;


public interface PaiUserService {
      UserEntity findById(String id);
      Result register(RegisterParam registerParam)  ;
}
