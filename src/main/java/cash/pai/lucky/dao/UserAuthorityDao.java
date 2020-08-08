package cash.pai.lucky.dao;

import cash.pai.lucky.entity.UserAuthorityEntity;
import cash.pai.lucky.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAuthorityDao {
    Integer insert(UserAuthorityEntity userAuthorityEntity);

    UserAuthorityEntity findById(@Param("userAuthorityId") String userAuthorityId);
}
