package cash.pai.lucky.assets.info.repository;

import cash.pai.lucky.admin.common.repository.CommonRepository;
import cash.pai.lucky.assets.info.pojo.AssetsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetsInfoRepository extends CommonRepository<AssetsInfo, String> {
    List<AssetsInfo> findByAssetsEnable(Boolean assetsEnable);
}
