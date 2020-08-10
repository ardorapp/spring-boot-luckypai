package cash.pai.lucky.assets.account.pojo;

import cash.pai.lucky.assets.info.pojo.AssetsInfo;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "assets_account")
@Data
public class AssetsAccount implements Serializable {
    @Id
    private String id;//表id

    private String userId;//用户id

    private String assetsId;//资产ID

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

    @OneToOne
    @JoinColumn(name = "assetsId",referencedColumnName = "assetsId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private AssetsInfo walletAssets;
}
