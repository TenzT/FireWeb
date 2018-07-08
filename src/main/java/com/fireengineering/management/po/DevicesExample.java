package com.fireengineering.management.po;

import java.util.ArrayList;
import java.util.List;

public class DevicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevicesExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(Integer value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(Integer value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(Integer value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(Integer value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(Integer value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<Integer> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<Integer> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(Integer value1, Integer value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andDeviceDescIsNull() {
            addCriterion("\"device _desc\" is null");
            return (Criteria) this;
        }

        public Criteria andDeviceDescIsNotNull() {
            addCriterion("\"device _desc\" is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceDescEqualTo(String value) {
            addCriterion("\"device _desc\" =", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescNotEqualTo(String value) {
            addCriterion("\"device _desc\" <>", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescGreaterThan(String value) {
            addCriterion("\"device _desc\" >", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescGreaterThanOrEqualTo(String value) {
            addCriterion("\"device _desc\" >=", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescLessThan(String value) {
            addCriterion("\"device _desc\" <", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescLessThanOrEqualTo(String value) {
            addCriterion("\"device _desc\" <=", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescLike(String value) {
            addCriterion("\"device _desc\" like", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescNotLike(String value) {
            addCriterion("\"device _desc\" not like", value, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescIn(List<String> values) {
            addCriterion("\"device _desc\" in", values, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescNotIn(List<String> values) {
            addCriterion("\"device _desc\" not in", values, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescBetween(String value1, String value2) {
            addCriterion("\"device _desc\" between", value1, value2, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceDescNotBetween(String value1, String value2) {
            addCriterion("\"device _desc\" not between", value1, value2, "deviceDesc");
            return (Criteria) this;
        }

        public Criteria andDeviceImgIsNull() {
            addCriterion("device_img is null");
            return (Criteria) this;
        }

        public Criteria andDeviceImgIsNotNull() {
            addCriterion("device_img is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceImgEqualTo(String value) {
            addCriterion("device_img =", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgNotEqualTo(String value) {
            addCriterion("device_img <>", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgGreaterThan(String value) {
            addCriterion("device_img >", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgGreaterThanOrEqualTo(String value) {
            addCriterion("device_img >=", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgLessThan(String value) {
            addCriterion("device_img <", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgLessThanOrEqualTo(String value) {
            addCriterion("device_img <=", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgLike(String value) {
            addCriterion("device_img like", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgNotLike(String value) {
            addCriterion("device_img not like", value, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgIn(List<String> values) {
            addCriterion("device_img in", values, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgNotIn(List<String> values) {
            addCriterion("device_img not in", values, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgBetween(String value1, String value2) {
            addCriterion("device_img between", value1, value2, "deviceImg");
            return (Criteria) this;
        }

        public Criteria andDeviceImgNotBetween(String value1, String value2) {
            addCriterion("device_img not between", value1, value2, "deviceImg");
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