package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.util.UUIDUtil;
import cash.pai.lucky.dao.AuthorityDao;
import cash.pai.lucky.dao.UserDao;
import cash.pai.lucky.entity.AuthorityEntity;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.RegisterParam;
import cash.pai.lucky.service.PaiAuthorityService;
import cash.pai.lucky.service.PaiUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PaiAuthorityServiceImpl implements PaiAuthorityService {

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
