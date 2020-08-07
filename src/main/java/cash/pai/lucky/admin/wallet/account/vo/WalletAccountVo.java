package cash.pai.lucky.admin.wallet.account.vo;

import cash.pai.lucky.admin.common.pojo.PageCondition;
import cash.pai.lucky.admin.wallet.assets.vo.WalletAssetsVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WalletAccountVo extends PageCondition implements Serializable {
    private String id;//表id

    private String userId;//用户id

    private String assetsId;//资产ID

    private WalletAssetsVo walletAssets;

    private String receiveAccount;//接收账号

    private String receiveAddress;//接收地址

    private String receiveBalance;//接收余额

    private String sendAccount;//发送账号

    private String sendPrivateKey;//发送私钥

    private String sendAddress;//发送地址

    private String sendBalance;//发送余额

    private String accountPassword;//账号密码

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
