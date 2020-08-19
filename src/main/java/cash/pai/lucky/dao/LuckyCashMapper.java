package cash.pai.lucky.dao;

import cash.pai.lucky.entity.LuckyCash;
import cash.pai.lucky.entity.LuckyCashExample;
import java.util.List;

public interface LuckyCashMapper {
    int deleteByPrimaryKey(String luckycashId);

    int insert(LuckyCash record);

    int insertSelective(LuckyCash record);

    List<LuckyCash> selectByExample(LuckyCashExample example);

    List<LuckyCash> selectByExampleSymbol(LuckyCashExample example);

    LuckyCash selectByPrimaryKey(String luckycashId);

    int updateByPrimaryKeySelective(LuckyCash record);

    int updateByPrimaryKey(LuckyCash record);
}