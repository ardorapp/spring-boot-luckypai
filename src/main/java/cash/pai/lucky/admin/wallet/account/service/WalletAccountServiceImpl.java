package cash.pai.lucky.admin.wallet.account.service;

import cash.pai.lucky.admin.common.pojo.PageInfo;
import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.common.service.CommonServiceImpl;
import cash.pai.lucky.admin.sys.sysuser.service.SysUserService;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.util.CopyUtil;
import cash.pai.lucky.admin.util.SecurityUtil;
import cash.pai.lucky.admin.wallet.account.pojo.WalletAccount;
import cash.pai.lucky.admin.wallet.account.repository.WalletAccountRepository;
import cash.pai.lucky.admin.wallet.account.vo.WalletAccountVo;
import cash.pai.lucky.admin.wallet.assets.service.WalletAssetsService;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import cash.pai.lucky.assetsservice.AssetsServiceFactory;
import cash.pai.lucky.assetsservice.AssetsServiceHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class WalletAccountServiceImpl extends CommonServiceImpl<WalletAccountVo, WalletAccount, String> implements WalletAccountService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private WalletAccountRepository walletAccountRepository;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private WalletAssetsService walletAssetsService;

    @Autowired
    private AssetsServiceHub assetsServiceHub;

    @Override
    public Result<WalletAccountVo> saveReceiveAddress(WalletAccountVo entityVo) {
        WalletAssetsVo walletAssetsVo = walletAssetsService.get(entityVo.getAssetsId()).getData();
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
        Result<WalletAccountVo> result = super.save(entityVo);
        return result;
    }

    @Override
    public List<WalletAccountVo> findByUserId(String userId) {
        return CopyUtil.copyList(walletAccountRepository.findByUserId(userId), WalletAccountVo.class);
    }

    @Override
    public Result<PageInfo<WalletAccountVo>> page(WalletAccountVo entityVo) {
        String username = SecurityUtil.getLoginUser().getUsername();
        //查询用户
        SysUserVo sysUserVo = sysUserService.findByLoginName(username).getData();
        entityVo.setUserId(sysUserVo.getUserId());
        return super.page(entityVo);
    }
}
