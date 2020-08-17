package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.dao.AuthorityDao;
import cash.pai.lucky.entity.AuthorityEntity;
import cash.pai.lucky.service.RedPackageAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssetAuthorityServiceImpl implements RedPackageAuthorityService {

    @Autowired
    AuthorityDao authorityDao;


    @Override
    public AuthorityEntity findById(String id) {
        return null;
    }

    @Override
    public Result insert(AuthorityEntity registerParam) {
        return null;
    }
}
