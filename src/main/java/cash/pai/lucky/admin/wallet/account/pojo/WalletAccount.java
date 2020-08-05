package cash.pai.lucky.admin.wallet.account.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "wallet_account")
@Data
public class WalletAccount implements Serializable {
    @Id
    private String id;//表id

    private String userId;//用户id

    private String assetsId;//资产ID

    private String receiveAccount;//接收账号

    private String receiveAddress;//接收地址

    private String receiveBalance;//接收余额

    private String sendAccount;//发送账号

    private String sendAddress;//发送地址

    private String sendBalance;//发送余额

    private String accountPassword;//账号密码

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
}
