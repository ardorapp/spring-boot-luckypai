package cash.pai.lucky.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.entity.AuthorityEntity;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.RegisterParam;


public interface PaiAuthorityService {
      AuthorityEntity findById(String id);
      Result insert(AuthorityEntity registerParam)  ;
}
