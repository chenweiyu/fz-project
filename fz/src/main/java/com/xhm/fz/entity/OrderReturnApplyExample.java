package com.xhm.fz.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderReturnApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderReturnApplyExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdIsNull() {
            addCriterion("company_address_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdIsNotNull() {
            addCriterion("company_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdEqualTo(Long value) {
            addCriterion("company_address_id =", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdNotEqualTo(Long value) {
            addCriterion("company_address_id <>", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdGreaterThan(Long value) {
            addCriterion("company_address_id >", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("company_address_id >=", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdLessThan(Long value) {
            addCriterion("company_address_id <", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("company_address_id <=", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdIn(List<Long> values) {
            addCriterion("company_address_id in", values, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdNotIn(List<Long> values) {
            addCriterion("company_address_id not in", values, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdBetween(Long value1, Long value2) {
            addCriterion("company_address_id between", value1, value2, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("company_address_id not between", value1, value2, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andClothingIdIsNull() {
            addCriterion("clothing_id is null");
            return (Criteria) this;
        }

        public Criteria andClothingIdIsNotNull() {
            addCriterion("clothing_id is not null");
            return (Criteria) this;
        }

        public Criteria andClothingIdEqualTo(Long value) {
            addCriterion("clothing_id =", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotEqualTo(Long value) {
            addCriterion("clothing_id <>", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdGreaterThan(Long value) {
            addCriterion("clothing_id >", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("clothing_id >=", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdLessThan(Long value) {
            addCriterion("clothing_id <", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdLessThanOrEqualTo(Long value) {
            addCriterion("clothing_id <=", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdIn(List<Long> values) {
            addCriterion("clothing_id in", values, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotIn(List<Long> values) {
            addCriterion("clothing_id not in", values, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdBetween(Long value1, Long value2) {
            addCriterion("clothing_id between", value1, value2, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotBetween(Long value1, Long value2) {
            addCriterion("clothing_id not between", value1, value2, "clothingId");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
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

        public Criteria andMemberUsernameIsNull() {
            addCriterion("member_username is null");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameIsNotNull() {
            addCriterion("member_username is not null");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameEqualTo(String value) {
            addCriterion("member_username =", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameNotEqualTo(String value) {
            addCriterion("member_username <>", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameGreaterThan(String value) {
            addCriterion("member_username >", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("member_username >=", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameLessThan(String value) {
            addCriterion("member_username <", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameLessThanOrEqualTo(String value) {
            addCriterion("member_username <=", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameLike(String value) {
            addCriterion("member_username like", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameNotLike(String value) {
            addCriterion("member_username not like", value, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameIn(List<String> values) {
            addCriterion("member_username in", values, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameNotIn(List<String> values) {
            addCriterion("member_username not in", values, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameBetween(String value1, String value2) {
            addCriterion("member_username between", value1, value2, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andMemberUsernameNotBetween(String value1, String value2) {
            addCriterion("member_username not between", value1, value2, "memberUsername");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIsNull() {
            addCriterion("return_amount is null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIsNotNull() {
            addCriterion("return_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountEqualTo(BigDecimal value) {
            addCriterion("return_amount =", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotEqualTo(BigDecimal value) {
            addCriterion("return_amount <>", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountGreaterThan(BigDecimal value) {
            addCriterion("return_amount >", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("return_amount >=", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountLessThan(BigDecimal value) {
            addCriterion("return_amount <", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("return_amount <=", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIn(List<BigDecimal> values) {
            addCriterion("return_amount in", values, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotIn(List<BigDecimal> values) {
            addCriterion("return_amount not in", values, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_amount between", value1, value2, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_amount not between", value1, value2, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnNameIsNull() {
            addCriterion("return_name is null");
            return (Criteria) this;
        }

        public Criteria andReturnNameIsNotNull() {
            addCriterion("return_name is not null");
            return (Criteria) this;
        }

        public Criteria andReturnNameEqualTo(String value) {
            addCriterion("return_name =", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotEqualTo(String value) {
            addCriterion("return_name <>", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameGreaterThan(String value) {
            addCriterion("return_name >", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameGreaterThanOrEqualTo(String value) {
            addCriterion("return_name >=", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameLessThan(String value) {
            addCriterion("return_name <", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameLessThanOrEqualTo(String value) {
            addCriterion("return_name <=", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameLike(String value) {
            addCriterion("return_name like", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotLike(String value) {
            addCriterion("return_name not like", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameIn(List<String> values) {
            addCriterion("return_name in", values, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotIn(List<String> values) {
            addCriterion("return_name not in", values, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameBetween(String value1, String value2) {
            addCriterion("return_name between", value1, value2, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotBetween(String value1, String value2) {
            addCriterion("return_name not between", value1, value2, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneIsNull() {
            addCriterion("return_phone is null");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneIsNotNull() {
            addCriterion("return_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneEqualTo(String value) {
            addCriterion("return_phone =", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotEqualTo(String value) {
            addCriterion("return_phone <>", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneGreaterThan(String value) {
            addCriterion("return_phone >", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("return_phone >=", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneLessThan(String value) {
            addCriterion("return_phone <", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneLessThanOrEqualTo(String value) {
            addCriterion("return_phone <=", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneLike(String value) {
            addCriterion("return_phone like", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotLike(String value) {
            addCriterion("return_phone not like", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneIn(List<String> values) {
            addCriterion("return_phone in", values, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotIn(List<String> values) {
            addCriterion("return_phone not in", values, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneBetween(String value1, String value2) {
            addCriterion("return_phone between", value1, value2, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotBetween(String value1, String value2) {
            addCriterion("return_phone not between", value1, value2, "returnPhone");
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

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andClothingPicIsNull() {
            addCriterion("clothing_pic is null");
            return (Criteria) this;
        }

        public Criteria andClothingPicIsNotNull() {
            addCriterion("clothing_pic is not null");
            return (Criteria) this;
        }

        public Criteria andClothingPicEqualTo(String value) {
            addCriterion("clothing_pic =", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicNotEqualTo(String value) {
            addCriterion("clothing_pic <>", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicGreaterThan(String value) {
            addCriterion("clothing_pic >", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_pic >=", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicLessThan(String value) {
            addCriterion("clothing_pic <", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicLessThanOrEqualTo(String value) {
            addCriterion("clothing_pic <=", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicLike(String value) {
            addCriterion("clothing_pic like", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicNotLike(String value) {
            addCriterion("clothing_pic not like", value, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicIn(List<String> values) {
            addCriterion("clothing_pic in", values, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicNotIn(List<String> values) {
            addCriterion("clothing_pic not in", values, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicBetween(String value1, String value2) {
            addCriterion("clothing_pic between", value1, value2, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingPicNotBetween(String value1, String value2) {
            addCriterion("clothing_pic not between", value1, value2, "clothingPic");
            return (Criteria) this;
        }

        public Criteria andClothingNameIsNull() {
            addCriterion("clothing_name is null");
            return (Criteria) this;
        }

        public Criteria andClothingNameIsNotNull() {
            addCriterion("clothing_name is not null");
            return (Criteria) this;
        }

        public Criteria andClothingNameEqualTo(String value) {
            addCriterion("clothing_name =", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameNotEqualTo(String value) {
            addCriterion("clothing_name <>", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameGreaterThan(String value) {
            addCriterion("clothing_name >", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_name >=", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameLessThan(String value) {
            addCriterion("clothing_name <", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameLessThanOrEqualTo(String value) {
            addCriterion("clothing_name <=", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameLike(String value) {
            addCriterion("clothing_name like", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameNotLike(String value) {
            addCriterion("clothing_name not like", value, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameIn(List<String> values) {
            addCriterion("clothing_name in", values, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameNotIn(List<String> values) {
            addCriterion("clothing_name not in", values, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameBetween(String value1, String value2) {
            addCriterion("clothing_name between", value1, value2, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingNameNotBetween(String value1, String value2) {
            addCriterion("clothing_name not between", value1, value2, "clothingName");
            return (Criteria) this;
        }

        public Criteria andClothingBrandIsNull() {
            addCriterion("clothing_brand is null");
            return (Criteria) this;
        }

        public Criteria andClothingBrandIsNotNull() {
            addCriterion("clothing_brand is not null");
            return (Criteria) this;
        }

        public Criteria andClothingBrandEqualTo(String value) {
            addCriterion("clothing_brand =", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandNotEqualTo(String value) {
            addCriterion("clothing_brand <>", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandGreaterThan(String value) {
            addCriterion("clothing_brand >", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_brand >=", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandLessThan(String value) {
            addCriterion("clothing_brand <", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandLessThanOrEqualTo(String value) {
            addCriterion("clothing_brand <=", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandLike(String value) {
            addCriterion("clothing_brand like", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandNotLike(String value) {
            addCriterion("clothing_brand not like", value, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandIn(List<String> values) {
            addCriterion("clothing_brand in", values, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandNotIn(List<String> values) {
            addCriterion("clothing_brand not in", values, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandBetween(String value1, String value2) {
            addCriterion("clothing_brand between", value1, value2, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingBrandNotBetween(String value1, String value2) {
            addCriterion("clothing_brand not between", value1, value2, "clothingBrand");
            return (Criteria) this;
        }

        public Criteria andClothingAttrIsNull() {
            addCriterion("clothing_attr is null");
            return (Criteria) this;
        }

        public Criteria andClothingAttrIsNotNull() {
            addCriterion("clothing_attr is not null");
            return (Criteria) this;
        }

        public Criteria andClothingAttrEqualTo(String value) {
            addCriterion("clothing_attr =", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrNotEqualTo(String value) {
            addCriterion("clothing_attr <>", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrGreaterThan(String value) {
            addCriterion("clothing_attr >", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_attr >=", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrLessThan(String value) {
            addCriterion("clothing_attr <", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrLessThanOrEqualTo(String value) {
            addCriterion("clothing_attr <=", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrLike(String value) {
            addCriterion("clothing_attr like", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrNotLike(String value) {
            addCriterion("clothing_attr not like", value, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrIn(List<String> values) {
            addCriterion("clothing_attr in", values, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrNotIn(List<String> values) {
            addCriterion("clothing_attr not in", values, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrBetween(String value1, String value2) {
            addCriterion("clothing_attr between", value1, value2, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingAttrNotBetween(String value1, String value2) {
            addCriterion("clothing_attr not between", value1, value2, "clothingAttr");
            return (Criteria) this;
        }

        public Criteria andClothingCountIsNull() {
            addCriterion("clothing_count is null");
            return (Criteria) this;
        }

        public Criteria andClothingCountIsNotNull() {
            addCriterion("clothing_count is not null");
            return (Criteria) this;
        }

        public Criteria andClothingCountEqualTo(Integer value) {
            addCriterion("clothing_count =", value, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountNotEqualTo(Integer value) {
            addCriterion("clothing_count <>", value, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountGreaterThan(Integer value) {
            addCriterion("clothing_count >", value, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("clothing_count >=", value, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountLessThan(Integer value) {
            addCriterion("clothing_count <", value, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountLessThanOrEqualTo(Integer value) {
            addCriterion("clothing_count <=", value, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountIn(List<Integer> values) {
            addCriterion("clothing_count in", values, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountNotIn(List<Integer> values) {
            addCriterion("clothing_count not in", values, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountBetween(Integer value1, Integer value2) {
            addCriterion("clothing_count between", value1, value2, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("clothing_count not between", value1, value2, "clothingCount");
            return (Criteria) this;
        }

        public Criteria andClothingPriceIsNull() {
            addCriterion("clothing_price is null");
            return (Criteria) this;
        }

        public Criteria andClothingPriceIsNotNull() {
            addCriterion("clothing_price is not null");
            return (Criteria) this;
        }

        public Criteria andClothingPriceEqualTo(BigDecimal value) {
            addCriterion("clothing_price =", value, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceNotEqualTo(BigDecimal value) {
            addCriterion("clothing_price <>", value, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceGreaterThan(BigDecimal value) {
            addCriterion("clothing_price >", value, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("clothing_price >=", value, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceLessThan(BigDecimal value) {
            addCriterion("clothing_price <", value, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("clothing_price <=", value, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceIn(List<BigDecimal> values) {
            addCriterion("clothing_price in", values, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceNotIn(List<BigDecimal> values) {
            addCriterion("clothing_price not in", values, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("clothing_price between", value1, value2, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("clothing_price not between", value1, value2, "clothingPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceIsNull() {
            addCriterion("clothing_real_price is null");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceIsNotNull() {
            addCriterion("clothing_real_price is not null");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceEqualTo(BigDecimal value) {
            addCriterion("clothing_real_price =", value, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceNotEqualTo(BigDecimal value) {
            addCriterion("clothing_real_price <>", value, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceGreaterThan(BigDecimal value) {
            addCriterion("clothing_real_price >", value, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("clothing_real_price >=", value, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceLessThan(BigDecimal value) {
            addCriterion("clothing_real_price <", value, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("clothing_real_price <=", value, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceIn(List<BigDecimal> values) {
            addCriterion("clothing_real_price in", values, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceNotIn(List<BigDecimal> values) {
            addCriterion("clothing_real_price not in", values, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("clothing_real_price between", value1, value2, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andClothingRealPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("clothing_real_price not between", value1, value2, "clothingRealPrice");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andProofPicsIsNull() {
            addCriterion("proof_pics is null");
            return (Criteria) this;
        }

        public Criteria andProofPicsIsNotNull() {
            addCriterion("proof_pics is not null");
            return (Criteria) this;
        }

        public Criteria andProofPicsEqualTo(String value) {
            addCriterion("proof_pics =", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsNotEqualTo(String value) {
            addCriterion("proof_pics <>", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsGreaterThan(String value) {
            addCriterion("proof_pics >", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsGreaterThanOrEqualTo(String value) {
            addCriterion("proof_pics >=", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsLessThan(String value) {
            addCriterion("proof_pics <", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsLessThanOrEqualTo(String value) {
            addCriterion("proof_pics <=", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsLike(String value) {
            addCriterion("proof_pics like", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsNotLike(String value) {
            addCriterion("proof_pics not like", value, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsIn(List<String> values) {
            addCriterion("proof_pics in", values, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsNotIn(List<String> values) {
            addCriterion("proof_pics not in", values, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsBetween(String value1, String value2) {
            addCriterion("proof_pics between", value1, value2, "proofPics");
            return (Criteria) this;
        }

        public Criteria andProofPicsNotBetween(String value1, String value2) {
            addCriterion("proof_pics not between", value1, value2, "proofPics");
            return (Criteria) this;
        }

        public Criteria andHandleNoteIsNull() {
            addCriterion("handle_note is null");
            return (Criteria) this;
        }

        public Criteria andHandleNoteIsNotNull() {
            addCriterion("handle_note is not null");
            return (Criteria) this;
        }

        public Criteria andHandleNoteEqualTo(String value) {
            addCriterion("handle_note =", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotEqualTo(String value) {
            addCriterion("handle_note <>", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteGreaterThan(String value) {
            addCriterion("handle_note >", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteGreaterThanOrEqualTo(String value) {
            addCriterion("handle_note >=", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteLessThan(String value) {
            addCriterion("handle_note <", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteLessThanOrEqualTo(String value) {
            addCriterion("handle_note <=", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteLike(String value) {
            addCriterion("handle_note like", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotLike(String value) {
            addCriterion("handle_note not like", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteIn(List<String> values) {
            addCriterion("handle_note in", values, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotIn(List<String> values) {
            addCriterion("handle_note not in", values, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteBetween(String value1, String value2) {
            addCriterion("handle_note between", value1, value2, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotBetween(String value1, String value2) {
            addCriterion("handle_note not between", value1, value2, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleManIsNull() {
            addCriterion("handle_man is null");
            return (Criteria) this;
        }

        public Criteria andHandleManIsNotNull() {
            addCriterion("handle_man is not null");
            return (Criteria) this;
        }

        public Criteria andHandleManEqualTo(String value) {
            addCriterion("handle_man =", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManNotEqualTo(String value) {
            addCriterion("handle_man <>", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManGreaterThan(String value) {
            addCriterion("handle_man >", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManGreaterThanOrEqualTo(String value) {
            addCriterion("handle_man >=", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManLessThan(String value) {
            addCriterion("handle_man <", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManLessThanOrEqualTo(String value) {
            addCriterion("handle_man <=", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManLike(String value) {
            addCriterion("handle_man like", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManNotLike(String value) {
            addCriterion("handle_man not like", value, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManIn(List<String> values) {
            addCriterion("handle_man in", values, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManNotIn(List<String> values) {
            addCriterion("handle_man not in", values, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManBetween(String value1, String value2) {
            addCriterion("handle_man between", value1, value2, "handleMan");
            return (Criteria) this;
        }

        public Criteria andHandleManNotBetween(String value1, String value2) {
            addCriterion("handle_man not between", value1, value2, "handleMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManIsNull() {
            addCriterion("receive_man is null");
            return (Criteria) this;
        }

        public Criteria andReceiveManIsNotNull() {
            addCriterion("receive_man is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveManEqualTo(String value) {
            addCriterion("receive_man =", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManNotEqualTo(String value) {
            addCriterion("receive_man <>", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManGreaterThan(String value) {
            addCriterion("receive_man >", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManGreaterThanOrEqualTo(String value) {
            addCriterion("receive_man >=", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManLessThan(String value) {
            addCriterion("receive_man <", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManLessThanOrEqualTo(String value) {
            addCriterion("receive_man <=", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManLike(String value) {
            addCriterion("receive_man like", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManNotLike(String value) {
            addCriterion("receive_man not like", value, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManIn(List<String> values) {
            addCriterion("receive_man in", values, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManNotIn(List<String> values) {
            addCriterion("receive_man not in", values, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManBetween(String value1, String value2) {
            addCriterion("receive_man between", value1, value2, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveManNotBetween(String value1, String value2) {
            addCriterion("receive_man not between", value1, value2, "receiveMan");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteIsNull() {
            addCriterion("receive_note is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteIsNotNull() {
            addCriterion("receive_note is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteEqualTo(String value) {
            addCriterion("receive_note =", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotEqualTo(String value) {
            addCriterion("receive_note <>", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteGreaterThan(String value) {
            addCriterion("receive_note >", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteGreaterThanOrEqualTo(String value) {
            addCriterion("receive_note >=", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteLessThan(String value) {
            addCriterion("receive_note <", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteLessThanOrEqualTo(String value) {
            addCriterion("receive_note <=", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteLike(String value) {
            addCriterion("receive_note like", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotLike(String value) {
            addCriterion("receive_note not like", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteIn(List<String> values) {
            addCriterion("receive_note in", values, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotIn(List<String> values) {
            addCriterion("receive_note not in", values, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteBetween(String value1, String value2) {
            addCriterion("receive_note between", value1, value2, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotBetween(String value1, String value2) {
            addCriterion("receive_note not between", value1, value2, "receiveNote");
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