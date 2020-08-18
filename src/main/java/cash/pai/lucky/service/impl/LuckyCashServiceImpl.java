package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.admin.sys.sysuser.pojo.SysUser;
import cash.pai.lucky.admin.sys.sysuser.repository.SysUserRepository;
import cash.pai.lucky.admin.sys.sysuser.service.SysUserService;
import cash.pai.lucky.admin.sys.sysuser.vo.SysUserVo;
import cash.pai.lucky.admin.util.SecurityUtil;
import cash.pai.lucky.admin.util.UUIDUtil;
import cash.pai.lucky.assets.account.pojo.AssetsAccount;
import cash.pai.lucky.assets.account.repository.AssetsAccountRepository;
import cash.pai.lucky.assets.info.pojo.AssetsInfo;
import cash.pai.lucky.assets.info.repository.AssetsInfoRepository;
import cash.pai.lucky.dao.LuckyCashMapper;
import cash.pai.lucky.entity.LuckyCash;
import cash.pai.lucky.entity.LuckyCashExample;
import cash.pai.lucky.param.LuckyCashParam;
import cash.pai.lucky.service.LuckyCashService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class LuckyCashServiceImpl implements LuckyCashService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private AssetsInfoRepository assetsInfoRepository;

    @Autowired
    private AssetsAccountRepository assetsAccountRepository;

    @Autowired
    private LuckyCashMapper luckyCashMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public LuckyCash findById(String luckycashId) {
        return luckyCashMapper.selectByPrimaryKey(luckycashId);
    }

    @Override
    public List<LuckyCash> findByMyCreate() {
        LuckyCashExample luckyCashExample = new LuckyCashExample();
        String username = SecurityUtil.getLoginUser().getUsername();
        //查询用户
        SysUserVo sysUserVo = sysUserService.findByLoginName(username).getData();
        luckyCashExample.createCriteria().andUserIdEqualTo(sysUserVo.getUserId());
        return luckyCashMapper.selectByExample(luckyCashExample);
    }

    @Override
    public Result create(LuckyCashParam param) {
        String username = SecurityUtil.getLoginUser().getUsername();
        SysUser sysUser = sysUserRepository.findByLoginName(username);
        if (sysUser == null || StringUtils.isEmpty(sysUser.getUserId()) ) {
            return Result.fail("无权创建该用户的红包。");
        }
        Optional<AssetsInfo> optional = assetsInfoRepository.findById(param.getAssetsId());
        if (!optional.isPresent()) {
            return Result.fail("该资产不存在");
        }
        AssetsInfo assetsInfo = optional.get();
        if (assetsInfo == null || !assetsInfo.getAssetsEnable()) {
            return Result.fail("该资产未激活");
        }
        if (param.getAmountTotal().compareTo(assetsInfo.getAmountTotalMax()) > 0) {
            return Result.fail("红包金额不能大于:"+assetsInfo.getAmountTotalMax());
        }
        if (param.getAmountTotal().compareTo(assetsInfo.getAmountTotalMin()) < 0) {
            return Result.fail("红包金额不能小于:"+assetsInfo.getAmountTotalMin());
        }
        if (param.getPacketTotal() > assetsInfo.getPacketMax()) {
            return Result.fail("红包个数不能大于:"+assetsInfo.getPacketMax());
        }
        if (param.getPacketTotal() < assetsInfo.getPacketMin()) {
            return Result.fail("红包个数不能小于:"+assetsInfo.getPacketMin());
        }

        AssetsAccount assetsAccount = assetsAccountRepository.findByUserIdAndAssetsId(sysUser.getUserId(),assetsInfo.getAssetsId());
        if (assetsAccount == null) {
            return Result.fail("该用户名下无对应的资产的账号信息，请先添加账号。");
        }
        if (assetsAccount.getSendBalance().compareTo(param.getAmountTotal()) < 0 ) {
            return Result.fail("余额不足，请先充值或修改金额大小。");
        }

        //计算服务费
        BigDecimal feeRate = new BigDecimal(assetsInfo.getServiceFeeRate());
        BigDecimal serviceFee = param.getAmountTotal().multiply(feeRate);
        if (serviceFee.compareTo(assetsInfo.getServiceFeeMin()) < 0) {
            serviceFee = assetsInfo.getServiceFeeMin();
        }

        Date nowDate=new Date();
        String luckycashId = UUIDUtil.getUUID();
        LuckyCash newLuckyCash = new LuckyCash();
        BeanUtils.copyProperties(param, newLuckyCash);
        newLuckyCash.setLuckycashId(luckycashId);
        newLuckyCash.setAmountUsed(BigDecimal.valueOf(0));
        newLuckyCash.setAmountSend(BigDecimal.valueOf(0));
        newLuckyCash.setAmountAvailable(newLuckyCash.getAmountTotal().subtract(serviceFee));
        newLuckyCash.setAmountExpiration(BigDecimal.valueOf(0));

        newLuckyCash.setPacketUsed(0);
        newLuckyCash.setPacketSend(0);
        newLuckyCash.setPacketAvailable(newLuckyCash.getPacketTotal());
        newLuckyCash.setPacketExpiration(0);

        newLuckyCash.setTransactionFee(BigDecimal.valueOf(0));
        newLuckyCash.setServiceFee(serviceFee);

        newLuckyCash.setStatus(0);
        newLuckyCash.setCreateTime(nowDate);
        newLuckyCash.setUpdateTime(nowDate);
        luckyCashMapper.insert(newLuckyCash);
        return Result.of(newLuckyCash, true, "创建成功!");
    }

    @Override
    public Result save(LuckyCash luckyCashParam) {
        if (StringUtils.isEmpty(luckyCashParam.getLuckycashId())) {
            //创建
            LuckyCashParam lcp = new LuckyCashParam();
            lcp.setAssetsId(luckyCashParam.getAssetsId());
            lcp.setPacketType(luckyCashParam.getPacketType());
            lcp.setAmountTotal(luckyCashParam.getAmountTotal());
            lcp.setPacketTotal(luckyCashParam.getPacketTotal());
            return create(lcp);
        } else {
            //编辑
            LuckyCash updateLuckyCash = new LuckyCash();
            updateLuckyCash.setLuckycashId(luckyCashParam.getLuckycashId());
            updateLuckyCash.setPacketTitle(luckyCashParam.getPacketTitle());
            updateLuckyCash.setPacketContent(luckyCashParam.getPacketContent());
            updateLuckyCash.setPacketImage(luckyCashParam.getPacketImage());
            updateLuckyCash.setStatus(luckyCashParam.getStatus());
            int ret = luckyCashMapper.updateByPrimaryKeySelective(updateLuckyCash);
            if (ret > 0) {
                return Result.of(luckyCashParam);
            } else {
                log.warn(luckyCashParam.toString());
                return Result.fail("保存失败");
            }
        }
    }

    @Override
    public Result delete(String luckycashId) {
        return Result.of(luckyCashMapper.deleteByPrimaryKey(luckycashId),true,"删除成功！");
    }
}
