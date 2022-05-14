package com.xhm.fz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClothingCartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClothingCartExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andClothingNumIsNull() {
            addCriterion("clothing_num is null");
            return (Criteria) this;
        }

        public Criteria andClothingNumIsNotNull() {
            addCriterion("clothing_num is not null");
            return (Criteria) this;
        }

        public Criteria andClothingNumEqualTo(Long value) {
            addCriterion("clothing_num =", value, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumNotEqualTo(Long value) {
            addCriterion("clothing_num <>", value, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumGreaterThan(Long value) {
            addCriterion("clothing_num >", value, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumGreaterThanOrEqualTo(Long value) {
            addCriterion("clothing_num >=", value, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumLessThan(Long value) {
            addCriterion("clothing_num <", value, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumLessThanOrEqualTo(Long value) {
            addCriterion("clothing_num <=", value, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumIn(List<Long> values) {
            addCriterion("clothing_num in", values, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumNotIn(List<Long> values) {
            addCriterion("clothing_num not in", values, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumBetween(Long value1, Long value2) {
            addCriterion("clothing_num between", value1, value2, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingNumNotBetween(Long value1, Long value2) {
            addCriterion("clothing_num not between", value1, value2, "clothingNum");
            return (Criteria) this;
        }

        public Criteria andClothingColorIsNull() {
            addCriterion("clothing_color is null");
            return (Criteria) this;
        }

        public Criteria andClothingColorIsNotNull() {
            addCriterion("clothing_color is not null");
            return (Criteria) this;
        }

        public Criteria andClothingColorEqualTo(String value) {
            addCriterion("clothing_color =", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorNotEqualTo(String value) {
            addCriterion("clothing_color <>", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorGreaterThan(String value) {
            addCriterion("clothing_color >", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_color >=", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorLessThan(String value) {
            addCriterion("clothing_color <", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorLessThanOrEqualTo(String value) {
            addCriterion("clothing_color <=", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorLike(String value) {
            addCriterion("clothing_color like", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorNotLike(String value) {
            addCriterion("clothing_color not like", value, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorIn(List<String> values) {
            addCriterion("clothing_color in", values, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorNotIn(List<String> values) {
            addCriterion("clothing_color not in", values, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorBetween(String value1, String value2) {
            addCriterion("clothing_color between", value1, value2, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingColorNotBetween(String value1, String value2) {
            addCriterion("clothing_color not between", value1, value2, "clothingColor");
            return (Criteria) this;
        }

        public Criteria andClothingSizeIsNull() {
            addCriterion("clothing_size is null");
            return (Criteria) this;
        }

        public Criteria andClothingSizeIsNotNull() {
            addCriterion("clothing_size is not null");
            return (Criteria) this;
        }

        public Criteria andClothingSizeEqualTo(String value) {
            addCriterion("clothing_size =", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeNotEqualTo(String value) {
            addCriterion("clothing_size <>", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeGreaterThan(String value) {
            addCriterion("clothing_size >", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_size >=", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeLessThan(String value) {
            addCriterion("clothing_size <", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeLessThanOrEqualTo(String value) {
            addCriterion("clothing_size <=", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeLike(String value) {
            addCriterion("clothing_size like", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeNotLike(String value) {
            addCriterion("clothing_size not like", value, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeIn(List<String> values) {
            addCriterion("clothing_size in", values, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeNotIn(List<String> values) {
            addCriterion("clothing_size not in", values, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeBetween(String value1, String value2) {
            addCriterion("clothing_size between", value1, value2, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andClothingSizeNotBetween(String value1, String value2) {
            addCriterion("clothing_size not between", value1, value2, "clothingSize");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(Date value) {
            addCriterion("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(Date value) {
            addCriterion("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(Date value) {
            addCriterion("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(Date value) {
            addCriterion("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
            addCriterion("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<Date> values) {
            addCriterion("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<Date> values) {
            addCriterion("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(Date value1, Date value2) {
            addCriterion("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
            addCriterion("entry_time not between", value1, value2, "entryTime");
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
