package cash.pai.lucky.dao;

import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.RegisterParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
	 Integer insert(UserEntity userEntity);

	UserEntity findById(@Param("userId") String userId);


	List findByCondition(UserEntity userEntity)  ;
}
