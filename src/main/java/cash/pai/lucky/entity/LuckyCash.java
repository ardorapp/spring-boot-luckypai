package cash.pai.lucky.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LuckyCash {
    private String luckycashId;

    private String userId;

    private String assetsId;

    private BigDecimal amountTotal;

    private BigDecimal amountUsed;

    private BigDecimal amountSend;

    private BigDecimal amountAvailable;

    private BigDecimal amountExpiration;

    private BigDecimal transactionFee;

    private BigDecimal serviceFee;

    private Integer packetTotal;

    private Integer packetUsed;

    private Integer packetSend;

    private Integer packetAvailable;

    private Integer packetExpiration;

    private Integer packetType;

    private Long spendTime;

    private Date expirationTime;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String packetTitle;

    private String packetContent;

    private String packetImage;

    public String getLuckycashId() {
        return luckycashId;
    }

    public void setLuckycashId(String luckycashId) {
        this.luckycashId = luckycashId == null ? null : luckycashId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId == null ? null : assetsId.trim();
    }

    public BigDecimal getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(BigDecimal amountTotal) {
        this.amountTotal = amountTotal;
    }

    public BigDecimal getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(BigDecimal amountUsed) {
        this.amountUsed = amountUsed;
    }

    public BigDecimal getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(BigDecimal amountSend) {
        this.amountSend = amountSend;
    }

    public BigDecimal getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(BigDecimal amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public BigDecimal getAmountExpiration() {
        return amountExpiration;
    }

    public void setAmountExpiration(BigDecimal amountExpiration) {
        this.amountExpiration = amountExpiration;
    }

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getPacketTotal() {
        return packetTotal;
    }

    public void setPacketTotal(Integer packetTotal) {
        this.packetTotal = packetTotal;
    }

    public Integer getPacketUsed() {
        return packetUsed;
    }

    public void setPacketUsed(Integer packetUsed) {
        this.packetUsed = packetUsed;
    }

    public Integer getPacketSend() {
        return packetSend;
    }

    public void setPacketSend(Integer packetSend) {
        this.packetSend = packetSend;
    }

    public Integer getPacketAvailable() {
        return packetAvailable;
    }

    public void setPacketAvailable(Integer packetAvailable) {
        this.packetAvailable = packetAvailable;
    }

    public Integer getPacketExpiration() {
        return packetExpiration;
    }

    public void setPacketExpiration(Integer packetExpiration) {
        this.packetExpiration = packetExpiration;
    }

    public Integer getPacketType() {
        return packetType;
    }

    public void setPacketType(Integer packetType) {
        this.packetType = packetType;
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPacketTitle() {
        return packetTitle;
    }

    public void setPacketTitle(String packetTitle) {
        this.packetTitle = packetTitle == null ? null : packetTitle.trim();
    }

    public String getPacketContent() {
        return packetContent;
    }

    public void setPacketContent(String packetContent) {
        this.packetContent = packetContent == null ? null : packetContent.trim();
    }

    public String getPacketImage() {
        return packetImage;
    }

    public void setPacketImage(String packetImage) {
        this.packetImage = packetImage == null ? null : packetImage.trim();
    }
}