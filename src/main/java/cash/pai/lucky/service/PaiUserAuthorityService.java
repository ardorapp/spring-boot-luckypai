package cash.pai.lucky.service;

import cash.pai.lucky.entity.UserAuthorityEntity;


public interface PaiUserAuthorityService {
      UserAuthorityEntity findById(String id);
      Integer insert(UserAuthorityEntity userAuthorityEntity)  ;
}
