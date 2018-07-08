package com.fireengineering.management.po;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaintenanceExample() {
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

        public Criteria andMaintenanceIdIsNull() {
            addCriterion("maintenance_id is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdIsNotNull() {
            addCriterion("maintenance_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdEqualTo(Integer value) {
            addCriterion("maintenance_id =", value, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdNotEqualTo(Integer value) {
            addCriterion("maintenance_id <>", value, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdGreaterThan(Integer value) {
            addCriterion("maintenance_id >", value, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("maintenance_id >=", value, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdLessThan(Integer value) {
            addCriterion("maintenance_id <", value, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("maintenance_id <=", value, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdIn(List<Integer> values) {
            addCriterion("maintenance_id in", values, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdNotIn(List<Integer> values) {
            addCriterion("maintenance_id not in", values, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdBetween(Integer value1, Integer value2) {
            addCriterion("maintenance_id between", value1, value2, "maintenanceId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("maintenance_id not between", value1, value2, "maintenanceId");
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIsNull() {
            addCriterion("deployment_id is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIsNotNull() {
            addCriterion("deployment_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdEqualTo(String value) {
            addCriterion("deployment_id =", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotEqualTo(String value) {
            addCriterion("deployment_id <>", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdGreaterThan(String value) {
            addCriterion("deployment_id >", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdGreaterThanOrEqualTo(String value) {
            addCriterion("deployment_id >=", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLessThan(String value) {
            addCriterion("deployment_id <", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLessThanOrEqualTo(String value) {
            addCriterion("deployment_id <=", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLike(String value) {
            addCriterion("deployment_id like", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotLike(String value) {
            addCriterion("deployment_id not like", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIn(List<String> values) {
            addCriterion("deployment_id in", values, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotIn(List<String> values) {
            addCriterion("deployment_id not in", values, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdBetween(String value1, String value2) {
            addCriterion("deployment_id between", value1, value2, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotBetween(String value1, String value2) {
            addCriterion("deployment_id not between", value1, value2, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordIsNull() {
            addCriterion("maintenance_record is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordIsNotNull() {
            addCriterion("maintenance_record is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordEqualTo(String value) {
            addCriterion("maintenance_record =", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordNotEqualTo(String value) {
            addCriterion("maintenance_record <>", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordGreaterThan(String value) {
            addCriterion("maintenance_record >", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_record >=", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordLessThan(String value) {
            addCriterion("maintenance_record <", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordLessThanOrEqualTo(String value) {
            addCriterion("maintenance_record <=", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordLike(String value) {
            addCriterion("maintenance_record like", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordNotLike(String value) {
            addCriterion("maintenance_record not like", value, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordIn(List<String> values) {
            addCriterion("maintenance_record in", values, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordNotIn(List<String> values) {
            addCriterion("maintenance_record not in", values, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordBetween(String value1, String value2) {
            addCriterion("maintenance_record between", value1, value2, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceRecordNotBetween(String value1, String value2) {
            addCriterion("maintenance_record not between", value1, value2, "maintenanceRecord");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescIsNull() {
            addCriterion("maintenance_desc is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescIsNotNull() {
            addCriterion("maintenance_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescEqualTo(String value) {
            addCriterion("maintenance_desc =", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescNotEqualTo(String value) {
            addCriterion("maintenance_desc <>", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescGreaterThan(String value) {
            addCriterion("maintenance_desc >", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_desc >=", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescLessThan(String value) {
            addCriterion("maintenance_desc <", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescLessThanOrEqualTo(String value) {
            addCriterion("maintenance_desc <=", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescLike(String value) {
            addCriterion("maintenance_desc like", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescNotLike(String value) {
            addCriterion("maintenance_desc not like", value, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescIn(List<String> values) {
            addCriterion("maintenance_desc in", values, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescNotIn(List<String> values) {
            addCriterion("maintenance_desc not in", values, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescBetween(String value1, String value2) {
            addCriterion("maintenance_desc between", value1, value2, "maintenanceDesc");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDescNotBetween(String value1, String value2) {
            addCriterion("maintenance_desc not between", value1, value2, "maintenanceDesc");
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