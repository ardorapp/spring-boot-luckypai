package cash.pai.lucky.assets.info.vo;

import cash.pai.lucky.admin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AssetsInfoVo extends PageCondition implements Serializable {
    private String assetsId;//表id

    private String assetsSymbol;//资产符号

    private String assetsName;//资产名称

    private String assetsNameZh;//资产中文名称

    private String assetsIntroduction;//资产介绍

    private String assetsHome;//资产官网

    private Boolean assetsEnable;//资产是否可用

    private Integer packetMax;//允许一个红包最大包数量

    private Integer packetMin;//允许一个红包最小包数量

    private BigDecimal amountTotalMax;//允许一个红包最大金额

    private BigDecimal amountTotalMin;//允许一个红包最小金额

    private BigDecimal transactionFee;//一次转账的费用

    private BigDecimal serviceFeeMin;//发每个红包的最低服务费用

    private Float serviceFeeRate;//发每个红包的服务费比例，先按照费率计算服务费，若费率低于最低费用则按照最低服务费收费。

    private String serviceFeeAddress;//服务费收款地址

    private String lastBlockHeight;//最新区块高度

    private Date lastBlockTime;//最新区块时间

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
