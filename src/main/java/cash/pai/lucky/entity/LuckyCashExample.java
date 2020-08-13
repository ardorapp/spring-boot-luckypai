package cash.pai.lucky.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LuckyCashExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LuckyCashExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLuckycashIdIsNull() {
            addCriterion("luckycash_id is null");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdIsNotNull() {
            addCriterion("luckycash_id is not null");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdEqualTo(String value) {
            addCriterion("luckycash_id =", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdNotEqualTo(String value) {
            addCriterion("luckycash_id <>", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdGreaterThan(String value) {
            addCriterion("luckycash_id >", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdGreaterThanOrEqualTo(String value) {
            addCriterion("luckycash_id >=", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdLessThan(String value) {
            addCriterion("luckycash_id <", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdLessThanOrEqualTo(String value) {
            addCriterion("luckycash_id <=", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdLike(String value) {
            addCriterion("luckycash_id like", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdNotLike(String value) {
            addCriterion("luckycash_id not like", value, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdIn(List<String> values) {
            addCriterion("luckycash_id in", values, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdNotIn(List<String> values) {
            addCriterion("luckycash_id not in", values, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdBetween(String value1, String value2) {
            addCriterion("luckycash_id between", value1, value2, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andLuckycashIdNotBetween(String value1, String value2) {
            addCriterion("luckycash_id not between", value1, value2, "luckycashId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdIsNull() {
            addCriterion("assets_id is null");
            return (Criteria) this;
        }

        public Criteria andAssetsIdIsNotNull() {
            addCriterion("assets_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssetsIdEqualTo(String value) {
            addCriterion("assets_id =", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdNotEqualTo(String value) {
            addCriterion("assets_id <>", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdGreaterThan(String value) {
            addCriterion("assets_id >", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdGreaterThanOrEqualTo(String value) {
            addCriterion("assets_id >=", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdLessThan(String value) {
            addCriterion("assets_id <", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdLessThanOrEqualTo(String value) {
            addCriterion("assets_id <=", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdLike(String value) {
            addCriterion("assets_id like", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdNotLike(String value) {
            addCriterion("assets_id not like", value, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdIn(List<String> values) {
            addCriterion("assets_id in", values, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdNotIn(List<String> values) {
            addCriterion("assets_id not in", values, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdBetween(String value1, String value2) {
            addCriterion("assets_id between", value1, value2, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAssetsIdNotBetween(String value1, String value2) {
            addCriterion("assets_id not between", value1, value2, "assetsId");
            return (Criteria) this;
        }

        public Criteria andAmountTotalIsNull() {
            addCriterion("amount_total is null");
            return (Criteria) this;
        }

        public Criteria andAmountTotalIsNotNull() {
            addCriterion("amount_total is not null");
            return (Criteria) this;
        }

        public Criteria andAmountTotalEqualTo(BigDecimal value) {
            addCriterion("amount_total =", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalNotEqualTo(BigDecimal value) {
            addCriterion("amount_total <>", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalGreaterThan(BigDecimal value) {
            addCriterion("amount_total >", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_total >=", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalLessThan(BigDecimal value) {
            addCriterion("amount_total <", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_total <=", value, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalIn(List<BigDecimal> values) {
            addCriterion("amount_total in", values, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalNotIn(List<BigDecimal> values) {
            addCriterion("amount_total not in", values, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_total between", value1, value2, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_total not between", value1, value2, "amountTotal");
            return (Criteria) this;
        }

        public Criteria andAmountUsedIsNull() {
            addCriterion("amount_used is null");
            return (Criteria) this;
        }

        public Criteria andAmountUsedIsNotNull() {
            addCriterion("amount_used is not null");
            return (Criteria) this;
        }

        public Criteria andAmountUsedEqualTo(BigDecimal value) {
            addCriterion("amount_used =", value, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedNotEqualTo(BigDecimal value) {
            addCriterion("amount_used <>", value, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedGreaterThan(BigDecimal value) {
            addCriterion("amount_used >", value, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_used >=", value, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedLessThan(BigDecimal value) {
            addCriterion("amount_used <", value, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_used <=", value, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedIn(List<BigDecimal> values) {
            addCriterion("amount_used in", values, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedNotIn(List<BigDecimal> values) {
            addCriterion("amount_used not in", values, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_used between", value1, value2, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountUsedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_used not between", value1, value2, "amountUsed");
            return (Criteria) this;
        }

        public Criteria andAmountSendIsNull() {
            addCriterion("amount_send is null");
            return (Criteria) this;
        }

        public Criteria andAmountSendIsNotNull() {
            addCriterion("amount_send is not null");
            return (Criteria) this;
        }

        public Criteria andAmountSendEqualTo(BigDecimal value) {
            addCriterion("amount_send =", value, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendNotEqualTo(BigDecimal value) {
            addCriterion("amount_send <>", value, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendGreaterThan(BigDecimal value) {
            addCriterion("amount_send >", value, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_send >=", value, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendLessThan(BigDecimal value) {
            addCriterion("amount_send <", value, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_send <=", value, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendIn(List<BigDecimal> values) {
            addCriterion("amount_send in", values, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendNotIn(List<BigDecimal> values) {
            addCriterion("amount_send not in", values, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_send between", value1, value2, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountSendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_send not between", value1, value2, "amountSend");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableIsNull() {
            addCriterion("amount_available is null");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableIsNotNull() {
            addCriterion("amount_available is not null");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableEqualTo(BigDecimal value) {
            addCriterion("amount_available =", value, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableNotEqualTo(BigDecimal value) {
            addCriterion("amount_available <>", value, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableGreaterThan(BigDecimal value) {
            addCriterion("amount_available >", value, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_available >=", value, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableLessThan(BigDecimal value) {
            addCriterion("amount_available <", value, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_available <=", value, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableIn(List<BigDecimal> values) {
            addCriterion("amount_available in", values, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableNotIn(List<BigDecimal> values) {
            addCriterion("amount_available not in", values, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_available between", value1, value2, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountAvailableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_available not between", value1, value2, "amountAvailable");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationIsNull() {
            addCriterion("amount_expiration is null");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationIsNotNull() {
            addCriterion("amount_expiration is not null");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationEqualTo(BigDecimal value) {
            addCriterion("amount_expiration =", value, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationNotEqualTo(BigDecimal value) {
            addCriterion("amount_expiration <>", value, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationGreaterThan(BigDecimal value) {
            addCriterion("amount_expiration >", value, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_expiration >=", value, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationLessThan(BigDecimal value) {
            addCriterion("amount_expiration <", value, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_expiration <=", value, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationIn(List<BigDecimal> values) {
            addCriterion("amount_expiration in", values, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationNotIn(List<BigDecimal> values) {
            addCriterion("amount_expiration not in", values, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_expiration between", value1, value2, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andAmountExpirationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_expiration not between", value1, value2, "amountExpiration");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeIsNull() {
            addCriterion("transaction_fee is null");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeIsNotNull() {
            addCriterion("transaction_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeEqualTo(BigDecimal value) {
            addCriterion("transaction_fee =", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotEqualTo(BigDecimal value) {
            addCriterion("transaction_fee <>", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeGreaterThan(BigDecimal value) {
            addCriterion("transaction_fee >", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_fee >=", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeLessThan(BigDecimal value) {
            addCriterion("transaction_fee <", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_fee <=", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeIn(List<BigDecimal> values) {
            addCriterion("transaction_fee in", values, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotIn(List<BigDecimal> values) {
            addCriterion("transaction_fee not in", values, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_fee between", value1, value2, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_fee not between", value1, value2, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andPacketTotalIsNull() {
            addCriterion("packet_total is null");
            return (Criteria) this;
        }

        public Criteria andPacketTotalIsNotNull() {
            addCriterion("packet_total is not null");
            return (Criteria) this;
        }

        public Criteria andPacketTotalEqualTo(Integer value) {
            addCriterion("packet_total =", value, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalNotEqualTo(Integer value) {
            addCriterion("packet_total <>", value, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalGreaterThan(Integer value) {
            addCriterion("packet_total >", value, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("packet_total >=", value, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalLessThan(Integer value) {
            addCriterion("packet_total <", value, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalLessThanOrEqualTo(Integer value) {
            addCriterion("packet_total <=", value, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalIn(List<Integer> values) {
            addCriterion("packet_total in", values, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalNotIn(List<Integer> values) {
            addCriterion("packet_total not in", values, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalBetween(Integer value1, Integer value2) {
            addCriterion("packet_total between", value1, value2, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("packet_total not between", value1, value2, "packetTotal");
            return (Criteria) this;
        }

        public Criteria andPacketUsedIsNull() {
            addCriterion("packet_used is null");
            return (Criteria) this;
        }

        public Criteria andPacketUsedIsNotNull() {
            addCriterion("packet_used is not null");
            return (Criteria) this;
        }

        public Criteria andPacketUsedEqualTo(Integer value) {
            addCriterion("packet_used =", value, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedNotEqualTo(Integer value) {
            addCriterion("packet_used <>", value, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedGreaterThan(Integer value) {
            addCriterion("packet_used >", value, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("packet_used >=", value, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedLessThan(Integer value) {
            addCriterion("packet_used <", value, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedLessThanOrEqualTo(Integer value) {
            addCriterion("packet_used <=", value, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedIn(List<Integer> values) {
            addCriterion("packet_used in", values, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedNotIn(List<Integer> values) {
            addCriterion("packet_used not in", values, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedBetween(Integer value1, Integer value2) {
            addCriterion("packet_used between", value1, value2, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("packet_used not between", value1, value2, "packetUsed");
            return (Criteria) this;
        }

        public Criteria andPacketSendIsNull() {
            addCriterion("packet_send is null");
            return (Criteria) this;
        }

        public Criteria andPacketSendIsNotNull() {
            addCriterion("packet_send is not null");
            return (Criteria) this;
        }

        public Criteria andPacketSendEqualTo(Integer value) {
            addCriterion("packet_send =", value, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendNotEqualTo(Integer value) {
            addCriterion("packet_send <>", value, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendGreaterThan(Integer value) {
            addCriterion("packet_send >", value, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("packet_send >=", value, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendLessThan(Integer value) {
            addCriterion("packet_send <", value, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendLessThanOrEqualTo(Integer value) {
            addCriterion("packet_send <=", value, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendIn(List<Integer> values) {
            addCriterion("packet_send in", values, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendNotIn(List<Integer> values) {
            addCriterion("packet_send not in", values, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendBetween(Integer value1, Integer value2) {
            addCriterion("packet_send between", value1, value2, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketSendNotBetween(Integer value1, Integer value2) {
            addCriterion("packet_send not between", value1, value2, "packetSend");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableIsNull() {
            addCriterion("packet_available is null");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableIsNotNull() {
            addCriterion("packet_available is not null");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableEqualTo(Integer value) {
            addCriterion("packet_available =", value, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableNotEqualTo(Integer value) {
            addCriterion("packet_available <>", value, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableGreaterThan(Integer value) {
            addCriterion("packet_available >", value, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("packet_available >=", value, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableLessThan(Integer value) {
            addCriterion("packet_available <", value, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("packet_available <=", value, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableIn(List<Integer> values) {
            addCriterion("packet_available in", values, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableNotIn(List<Integer> values) {
            addCriterion("packet_available not in", values, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableBetween(Integer value1, Integer value2) {
            addCriterion("packet_available between", value1, value2, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("packet_available not between", value1, value2, "packetAvailable");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationIsNull() {
            addCriterion("packet_expiration is null");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationIsNotNull() {
            addCriterion("packet_expiration is not null");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationEqualTo(Integer value) {
            addCriterion("packet_expiration =", value, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationNotEqualTo(Integer value) {
            addCriterion("packet_expiration <>", value, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationGreaterThan(Integer value) {
            addCriterion("packet_expiration >", value, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationGreaterThanOrEqualTo(Integer value) {
            addCriterion("packet_expiration >=", value, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationLessThan(Integer value) {
            addCriterion("packet_expiration <", value, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationLessThanOrEqualTo(Integer value) {
            addCriterion("packet_expiration <=", value, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationIn(List<Integer> values) {
            addCriterion("packet_expiration in", values, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationNotIn(List<Integer> values) {
            addCriterion("packet_expiration not in", values, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationBetween(Integer value1, Integer value2) {
            addCriterion("packet_expiration between", value1, value2, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketExpirationNotBetween(Integer value1, Integer value2) {
            addCriterion("packet_expiration not between", value1, value2, "packetExpiration");
            return (Criteria) this;
        }

        public Criteria andPacketTypeIsNull() {
            addCriterion("packet_type is null");
            return (Criteria) this;
        }

        public Criteria andPacketTypeIsNotNull() {
            addCriterion("packet_type is not null");
            return (Criteria) this;
        }

        public Criteria andPacketTypeEqualTo(Integer value) {
            addCriterion("packet_type =", value, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeNotEqualTo(Integer value) {
            addCriterion("packet_type <>", value, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeGreaterThan(Integer value) {
            addCriterion("packet_type >", value, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("packet_type >=", value, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeLessThan(Integer value) {
            addCriterion("packet_type <", value, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeLessThanOrEqualTo(Integer value) {
            addCriterion("packet_type <=", value, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeIn(List<Integer> values) {
            addCriterion("packet_type in", values, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeNotIn(List<Integer> values) {
            addCriterion("packet_type not in", values, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeBetween(Integer value1, Integer value2) {
            addCriterion("packet_type between", value1, value2, "packetType");
            return (Criteria) this;
        }

        public Criteria andPacketTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("packet_type not between", value1, value2, "packetType");
            return (Criteria) this;
        }

        public Criteria andSpendTimeIsNull() {
            addCriterion("spend_time is null");
            return (Criteria) this;
        }

        public Criteria andSpendTimeIsNotNull() {
            addCriterion("spend_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpendTimeEqualTo(Long value) {
            addCriterion("spend_time =", value, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeNotEqualTo(Long value) {
            addCriterion("spend_time <>", value, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeGreaterThan(Long value) {
            addCriterion("spend_time >", value, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("spend_time >=", value, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeLessThan(Long value) {
            addCriterion("spend_time <", value, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeLessThanOrEqualTo(Long value) {
            addCriterion("spend_time <=", value, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeIn(List<Long> values) {
            addCriterion("spend_time in", values, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeNotIn(List<Long> values) {
            addCriterion("spend_time not in", values, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeBetween(Long value1, Long value2) {
            addCriterion("spend_time between", value1, value2, "spendTime");
            return (Criteria) this;
        }

        public Criteria andSpendTimeNotBetween(Long value1, Long value2) {
            addCriterion("spend_time not between", value1, value2, "spendTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNull() {
            addCriterion("expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNotNull() {
            addCriterion("expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeEqualTo(Date value) {
            addCriterion("expiration_time =", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotEqualTo(Date value) {
            addCriterion("expiration_time <>", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThan(Date value) {
            addCriterion("expiration_time >", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_time >=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThan(Date value) {
            addCriterion("expiration_time <", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiration_time <=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIn(List<Date> values) {
            addCriterion("expiration_time in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotIn(List<Date> values) {
            addCriterion("expiration_time not in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeBetween(Date value1, Date value2) {
            addCriterion("expiration_time between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiration_time not between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPacketTitleIsNull() {
            addCriterion("packet_title is null");
            return (Criteria) this;
        }

        public Criteria andPacketTitleIsNotNull() {
            addCriterion("packet_title is not null");
            return (Criteria) this;
        }

        public Criteria andPacketTitleEqualTo(String value) {
            addCriterion("packet_title =", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleNotEqualTo(String value) {
            addCriterion("packet_title <>", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleGreaterThan(String value) {
            addCriterion("packet_title >", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleGreaterThanOrEqualTo(String value) {
            addCriterion("packet_title >=", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleLessThan(String value) {
            addCriterion("packet_title <", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleLessThanOrEqualTo(String value) {
            addCriterion("packet_title <=", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleLike(String value) {
            addCriterion("packet_title like", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleNotLike(String value) {
            addCriterion("packet_title not like", value, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleIn(List<String> values) {
            addCriterion("packet_title in", values, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleNotIn(List<String> values) {
            addCriterion("packet_title not in", values, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleBetween(String value1, String value2) {
            addCriterion("packet_title between", value1, value2, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketTitleNotBetween(String value1, String value2) {
            addCriterion("packet_title not between", value1, value2, "packetTitle");
            return (Criteria) this;
        }

        public Criteria andPacketContentIsNull() {
            addCriterion("packet_content is null");
            return (Criteria) this;
        }

        public Criteria andPacketContentIsNotNull() {
            addCriterion("packet_content is not null");
            return (Criteria) this;
        }

        public Criteria andPacketContentEqualTo(String value) {
            addCriterion("packet_content =", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentNotEqualTo(String value) {
            addCriterion("packet_content <>", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentGreaterThan(String value) {
            addCriterion("packet_content >", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentGreaterThanOrEqualTo(String value) {
            addCriterion("packet_content >=", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentLessThan(String value) {
            addCriterion("packet_content <", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentLessThanOrEqualTo(String value) {
            addCriterion("packet_content <=", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentLike(String value) {
            addCriterion("packet_content like", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentNotLike(String value) {
            addCriterion("packet_content not like", value, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentIn(List<String> values) {
            addCriterion("packet_content in", values, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentNotIn(List<String> values) {
            addCriterion("packet_content not in", values, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentBetween(String value1, String value2) {
            addCriterion("packet_content between", value1, value2, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketContentNotBetween(String value1, String value2) {
            addCriterion("packet_content not between", value1, value2, "packetContent");
            return (Criteria) this;
        }

        public Criteria andPacketImageIsNull() {
            addCriterion("packet_image is null");
            return (Criteria) this;
        }

        public Criteria andPacketImageIsNotNull() {
            addCriterion("packet_image is not null");
            return (Criteria) this;
        }

        public Criteria andPacketImageEqualTo(String value) {
            addCriterion("packet_image =", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageNotEqualTo(String value) {
            addCriterion("packet_image <>", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageGreaterThan(String value) {
            addCriterion("packet_image >", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageGreaterThanOrEqualTo(String value) {
            addCriterion("packet_image >=", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageLessThan(String value) {
            addCriterion("packet_image <", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageLessThanOrEqualTo(String value) {
            addCriterion("packet_image <=", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageLike(String value) {
            addCriterion("packet_image like", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageNotLike(String value) {
            addCriterion("packet_image not like", value, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageIn(List<String> values) {
            addCriterion("packet_image in", values, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageNotIn(List<String> values) {
            addCriterion("packet_image not in", values, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageBetween(String value1, String value2) {
            addCriterion("packet_image between", value1, value2, "packetImage");
            return (Criteria) this;
        }

        public Criteria andPacketImageNotBetween(String value1, String value2) {
            addCriterion("packet_image not between", value1, value2, "packetImage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}