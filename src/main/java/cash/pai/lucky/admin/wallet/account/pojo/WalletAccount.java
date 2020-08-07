package cash.pai.lucky.admin.wallet.account.pojo;

import cash.pai.lucky.admin.wallet.assets.pojo.WalletAssets;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
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

    private String sendPrivateKey;//发送私钥

    private String sendAddress;//发送地址

    private String sendBalance;//发送余额

    private String accountPassword;//账号密码

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

    @OneToOne
    @JoinColumn(name = "assetsId",referencedColumnName = "assetsId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private WalletAssets walletAssets;
}