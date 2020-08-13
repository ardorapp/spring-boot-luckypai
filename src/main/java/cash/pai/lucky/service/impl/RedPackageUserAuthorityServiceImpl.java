package cash.pai.lucky.service.impl;

import cash.pai.lucky.dao.UserAuthorityDao;
import cash.pai.lucky.entity.UserAuthorityEntity;
import cash.pai.lucky.service.RedPackageUserAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedPackageUserAuthorityServiceImpl implements RedPackageUserAuthorityService {

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
