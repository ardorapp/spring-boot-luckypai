package cash.pai.lucky.assets.account.vo;

import cash.pai.lucky.admin.common.pojo.PageCondition;
import cash.pai.lucky.assets.info.vo.AssetsInfoVo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AssetsAccountVo extends PageCondition implements Serializable {
    private String id;//表id

    private String userId;//用户id

    private String assetsId;//资产ID

    private AssetsInfoVo walletAssets;

    private String receiveAccount;//接收账号

    private String receiveAddress;//接收地址

    private BigDecimal receiveBalance;//接收余额

    private String sendAccount;//发送账号

    private String sendPrivateKey;//发送私钥

    private String sendAddress;//发送地址

    private BigDecimal sendBalance;//发送余额

    private String accountPassword;//账号密码

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
