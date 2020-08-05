package cash.pai.lucky.admin.wallet.assets.vo;

import cash.pai.lucky.admin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WalletAssetsVo extends PageCondition implements Serializable {
    private String assetsId;//表id

    private String assetsSymbol;//资产符号

    private String assetsName;//资产名称

    private String assetsNameZh;//资产中文名称

    private String assetsIntroduction;//资产介绍

    private String assetsHome;//资产官网

    private String lastBlockHeight;//最新区块高度

    private Date lastBlockTime;//最新区块时间

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
