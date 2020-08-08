package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.dao.AuthorityDao;
import cash.pai.lucky.dao.UserAuthorityDao;
import cash.pai.lucky.entity.AuthorityEntity;
import cash.pai.lucky.entity.UserAuthorityEntity;
import cash.pai.lucky.service.PaiAuthorityService;
import cash.pai.lucky.service.PaiUserAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaiUserAuthorityServiceImpl implements PaiUserAuthorityService {

    @Autowired
    UserAuthorityDao userAuthorityDao;


    @Override
    public UserAuthorityEntity findById(String id) {
        return null;
    }

    @Override
    public Integer insert(UserAuthorityEntity userAuthorityEntity) {
        return userAuthorityDao.insert(userAuthorityEntity);
    }
}
