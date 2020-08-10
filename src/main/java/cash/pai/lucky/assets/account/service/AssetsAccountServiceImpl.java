package cash.pai.lucky.assets.account.service;

import cash.pai.lucky.admin.common.pojo.PageInfo;
import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.sysuser.service.SysUserService;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.util.CopyUtil;
import cash.pai.lucky.admin.util.SecurityUtil;
import cash.pai.lucky.assets.account.pojo.AssetsAccount;
import cash.pai.lucky.assets.account.repository.AssetsAccountRepository;
import cash.pai.lucky.assets.account.vo.AssetsAccountVo;
import cash.pai.lucky.assets.info.service.AssetsInfoService;
import cash.pai.lucky.assets.info.vo.AssetsInfoVo;
import cash.pai.lucky.assets.service.AssetsServiceFactory;
import cash.pai.lucky.assets.service.AssetsServiceHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class AssetsAccountServiceImpl extends CommonServiceImpl<AssetsAccountVo, AssetsAccount, String> implements AssetsAccountService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AssetsAccountRepository assetsAccountRepository;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AssetsInfoService assetsInfoService;

    @Autowired
    private AssetsServiceHub assetsServiceHub;

    @Override
    public Result<AssetsAccountVo> saveReceiveAddress(AssetsAccountVo entityVo) {
        AssetsInfoVo walletAssetsVo = assetsInfoService.get(entityVo.getAssetsId()).getData();
        AssetsServiceFactory serviceFactory = assetsServiceHub.getAssetsServiceFactory(walletAssetsVo.getAssetsSymbol());
        if (!serviceFactory.validationAddress(entityVo.getReceiveAddress())) {
            return Result.of(entityVo,false,"地址不合法");
        }
        //地址合法，则导入钱包账号数据。
        if(!serviceFactory.importAddress(entityVo.getReceiveAddress(),entityVo.getReceiveAccount())){
            //地址导入失败。
            return Result.of(entityVo,false,"地址添加失败，换一个地址试试。");
        }
        //调用父类
        Result<AssetsAccountVo> result = super.save(entityVo);
        return result;
    }

    @Override
    public List<AssetsAccountVo> findByUserId(String userId) {
        return CopyUtil.copyList(assetsAccountRepository.findByUserId(userId), AssetsAccountVo.class);
    }

    @Override
    public Result<PageInfo<AssetsAccountVo>> page(AssetsAccountVo entityVo) {
        String username = SecurityUtil.getLoginUser().getUsername();
        //查询用户
        SysUserVo sysUserVo = sysUserService.findByLoginName(username).getData();
        entityVo.setUserId(sysUserVo.getUserId());
        return super.page(entityVo);
    }
}
