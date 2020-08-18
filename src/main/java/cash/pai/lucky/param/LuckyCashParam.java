package cash.pai.lucky.param;

import lombok.Data;

import java.math.BigDecimal;


/**
 * 接收创建红包接口参数
 */
@Data
public class LuckyCashParam {

    private String assetsId;//资产ID

    private BigDecimal amountTotal;//总金额

    private int packetTotal;//包总数

    private int packetType;//类型



}
