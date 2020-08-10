package cash.pai.lucky.assets.info.service;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonService;
import cash.pai.lucky.assets.info.pojo.AssetsInfo;
import cash.pai.lucky.assets.info.vo.AssetsInfoVo;

import java.util.List;

public interface AssetsInfoService extends CommonService<AssetsInfoVo, AssetsInfo, String> {
    Result<List<AssetsInfoVo>> findByAssetsEnable(Boolean assetsEnable);
}
