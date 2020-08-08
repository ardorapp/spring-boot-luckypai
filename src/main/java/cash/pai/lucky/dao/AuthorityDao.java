package cash.pai.lucky.dao;

import cash.pai.lucky.entity.AuthorityEntity;
import cash.pai.lucky.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorityDao {
	 Integer insert(AuthorityEntity userEntity);

	AuthorityEntity findById(@Param("authorityId") String authorityId);
}
