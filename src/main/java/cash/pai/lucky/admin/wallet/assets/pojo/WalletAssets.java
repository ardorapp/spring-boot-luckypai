package cash.pai.lucky.admin.wallet.assets.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "wallet_assets")
@Data
public class WalletAssets implements Serializable {
    @Id
    private String assetsId;//表id

    private String assetsSymbol;//资产符号

    private String assetsName;//资产名称

    private String assetsNameZh;//资产中文名称

    private String assetsIntroduction;//资产介绍

    private String assetsHome;//资产官网

    private Boolean assetsEnable;//资产是否可用

    private String lastBlockHeight;//最新区块高度

    private Date lastBlockTime;//最新区块时间

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
}
