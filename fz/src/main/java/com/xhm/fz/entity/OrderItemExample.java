package com.xhm.fz.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemExample() {
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

        public Criteria andClothingSnIsNull() {
            addCriterion("clothing_sn is null");
            return (Criteria) this;
        }

        public Criteria andClothingSnIsNotNull() {
            addCriterion("clothing_sn is not null");
            return (Criteria) this;
        }

        public Criteria andClothingSnEqualTo(String value) {
            addCriterion("clothing_sn =", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnNotEqualTo(String value) {
            addCriterion("clothing_sn <>", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnGreaterThan(String value) {
            addCriterion("clothing_sn >", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_sn >=", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnLessThan(String value) {
            addCriterion("clothing_sn <", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnLessThanOrEqualTo(String value) {
            addCriterion("clothing_sn <=", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnLike(String value) {
            addCriterion("clothing_sn like", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnNotLike(String value) {
            addCriterion("clothing_sn not like", value, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnIn(List<String> values) {
            addCriterion("clothing_sn in", values, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnNotIn(List<String> values) {
            addCriterion("clothing_sn not in", values, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnBetween(String value1, String value2) {
            addCriterion("clothing_sn between", value1, value2, "clothingSn");
            return (Criteria) this;
        }

        public Criteria andClothingSnNotBetween(String value1, String value2) {
            addCriterion("clothing_sn not between", value1, value2, "clothingSn");
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

        public Criteria andClothingQuantityIsNull() {
            addCriterion("clothing_quantity is null");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityIsNotNull() {
            addCriterion("clothing_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityEqualTo(Integer value) {
            addCriterion("clothing_quantity =", value, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityNotEqualTo(Integer value) {
            addCriterion("clothing_quantity <>", value, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityGreaterThan(Integer value) {
            addCriterion("clothing_quantity >", value, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("clothing_quantity >=", value, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityLessThan(Integer value) {
            addCriterion("clothing_quantity <", value, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("clothing_quantity <=", value, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityIn(List<Integer> values) {
            addCriterion("clothing_quantity in", values, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityNotIn(List<Integer> values) {
            addCriterion("clothing_quantity not in", values, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("clothing_quantity between", value1, value2, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("clothing_quantity not between", value1, value2, "clothingQuantity");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdIsNull() {
            addCriterion("clothing_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdIsNotNull() {
            addCriterion("clothing_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdEqualTo(Long value) {
            addCriterion("clothing_sku_id =", value, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdNotEqualTo(Long value) {
            addCriterion("clothing_sku_id <>", value, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdGreaterThan(Long value) {
            addCriterion("clothing_sku_id >", value, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("clothing_sku_id >=", value, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdLessThan(Long value) {
            addCriterion("clothing_sku_id <", value, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("clothing_sku_id <=", value, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdIn(List<Long> values) {
            addCriterion("clothing_sku_id in", values, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdNotIn(List<Long> values) {
            addCriterion("clothing_sku_id not in", values, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdBetween(Long value1, Long value2) {
            addCriterion("clothing_sku_id between", value1, value2, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("clothing_sku_id not between", value1, value2, "clothingSkuId");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeIsNull() {
            addCriterion("clothing_sku_code is null");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeIsNotNull() {
            addCriterion("clothing_sku_code is not null");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeEqualTo(String value) {
            addCriterion("clothing_sku_code =", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeNotEqualTo(String value) {
            addCriterion("clothing_sku_code <>", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeGreaterThan(String value) {
            addCriterion("clothing_sku_code >", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_sku_code >=", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeLessThan(String value) {
            addCriterion("clothing_sku_code <", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeLessThanOrEqualTo(String value) {
            addCriterion("clothing_sku_code <=", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeLike(String value) {
            addCriterion("clothing_sku_code like", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeNotLike(String value) {
            addCriterion("clothing_sku_code not like", value, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeIn(List<String> values) {
            addCriterion("clothing_sku_code in", values, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeNotIn(List<String> values) {
            addCriterion("clothing_sku_code not in", values, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeBetween(String value1, String value2) {
            addCriterion("clothing_sku_code between", value1, value2, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingSkuCodeNotBetween(String value1, String value2) {
            addCriterion("clothing_sku_code not between", value1, value2, "clothingSkuCode");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdIsNull() {
            addCriterion("clothing_category_id is null");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdIsNotNull() {
            addCriterion("clothing_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdEqualTo(Long value) {
            addCriterion("clothing_category_id =", value, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdNotEqualTo(Long value) {
            addCriterion("clothing_category_id <>", value, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdGreaterThan(Long value) {
            addCriterion("clothing_category_id >", value, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("clothing_category_id >=", value, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdLessThan(Long value) {
            addCriterion("clothing_category_id <", value, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("clothing_category_id <=", value, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdIn(List<Long> values) {
            addCriterion("clothing_category_id in", values, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdNotIn(List<Long> values) {
            addCriterion("clothing_category_id not in", values, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdBetween(Long value1, Long value2) {
            addCriterion("clothing_category_id between", value1, value2, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andClothingCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("clothing_category_id not between", value1, value2, "clothingCategoryId");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIsNull() {
            addCriterion("promotion_name is null");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIsNotNull() {
            addCriterion("promotion_name is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionNameEqualTo(String value) {
            addCriterion("promotion_name =", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotEqualTo(String value) {
            addCriterion("promotion_name <>", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameGreaterThan(String value) {
            addCriterion("promotion_name >", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_name >=", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLessThan(String value) {
            addCriterion("promotion_name <", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLessThanOrEqualTo(String value) {
            addCriterion("promotion_name <=", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLike(String value) {
            addCriterion("promotion_name like", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotLike(String value) {
            addCriterion("promotion_name not like", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIn(List<String> values) {
            addCriterion("promotion_name in", values, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotIn(List<String> values) {
            addCriterion("promotion_name not in", values, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameBetween(String value1, String value2) {
            addCriterion("promotion_name between", value1, value2, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotBetween(String value1, String value2) {
            addCriterion("promotion_name not between", value1, value2, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNull() {
            addCriterion("promotion_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNotNull() {
            addCriterion("promotion_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_amount =", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_amount <>", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_amount >", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_amount >=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThan(BigDecimal value) {
            addCriterion("promotion_amount <", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_amount <=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_amount in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_amount not in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_amount between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_amount not between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNull() {
            addCriterion("coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNotNull() {
            addCriterion("coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountEqualTo(BigDecimal value) {
            addCriterion("coupon_amount =", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <>", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThan(BigDecimal value) {
            addCriterion("coupon_amount >", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount >=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThan(BigDecimal value) {
            addCriterion("coupon_amount <", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIn(List<BigDecimal> values) {
            addCriterion("coupon_amount in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotIn(List<BigDecimal> values) {
            addCriterion("coupon_amount not in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount not between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountIsNull() {
            addCriterion("integration_amount is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountIsNotNull() {
            addCriterion("integration_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountEqualTo(BigDecimal value) {
            addCriterion("integration_amount =", value, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountNotEqualTo(BigDecimal value) {
            addCriterion("integration_amount <>", value, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountGreaterThan(BigDecimal value) {
            addCriterion("integration_amount >", value, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("integration_amount >=", value, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountLessThan(BigDecimal value) {
            addCriterion("integration_amount <", value, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("integration_amount <=", value, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountIn(List<BigDecimal> values) {
            addCriterion("integration_amount in", values, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountNotIn(List<BigDecimal> values) {
            addCriterion("integration_amount not in", values, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integration_amount between", value1, value2, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andIntegrationAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integration_amount not between", value1, value2, "integrationAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNull() {
            addCriterion("real_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNotNull() {
            addCriterion("real_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealAmountEqualTo(BigDecimal value) {
            addCriterion("real_amount =", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotEqualTo(BigDecimal value) {
            addCriterion("real_amount <>", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThan(BigDecimal value) {
            addCriterion("real_amount >", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount >=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThan(BigDecimal value) {
            addCriterion("real_amount <", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount <=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIn(List<BigDecimal> values) {
            addCriterion("real_amount in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotIn(List<BigDecimal> values) {
            addCriterion("real_amount not in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount not between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationIsNull() {
            addCriterion("gift_integration is null");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationIsNotNull() {
            addCriterion("gift_integration is not null");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationEqualTo(Integer value) {
            addCriterion("gift_integration =", value, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationNotEqualTo(Integer value) {
            addCriterion("gift_integration <>", value, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationGreaterThan(Integer value) {
            addCriterion("gift_integration >", value, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_integration >=", value, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationLessThan(Integer value) {
            addCriterion("gift_integration <", value, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("gift_integration <=", value, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationIn(List<Integer> values) {
            addCriterion("gift_integration in", values, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationNotIn(List<Integer> values) {
            addCriterion("gift_integration not in", values, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("gift_integration between", value1, value2, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_integration not between", value1, value2, "giftIntegration");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthIsNull() {
            addCriterion("gift_growth is null");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthIsNotNull() {
            addCriterion("gift_growth is not null");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthEqualTo(Integer value) {
            addCriterion("gift_growth =", value, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthNotEqualTo(Integer value) {
            addCriterion("gift_growth <>", value, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthGreaterThan(Integer value) {
            addCriterion("gift_growth >", value, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_growth >=", value, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthLessThan(Integer value) {
            addCriterion("gift_growth <", value, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthLessThanOrEqualTo(Integer value) {
            addCriterion("gift_growth <=", value, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthIn(List<Integer> values) {
            addCriterion("gift_growth in", values, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthNotIn(List<Integer> values) {
            addCriterion("gift_growth not in", values, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthBetween(Integer value1, Integer value2) {
            addCriterion("gift_growth between", value1, value2, "giftGrowth");
            return (Criteria) this;
        }

        public Criteria andGiftGrowthNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_growth not between", value1, value2, "giftGrowth");
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