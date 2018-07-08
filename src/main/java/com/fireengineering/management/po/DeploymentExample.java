package com.fireengineering.management.po;

import java.util.ArrayList;
import java.util.List;

public class DeploymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeploymentExample() {
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

        public Criteria andDeploymentIdIsNull() {
            addCriterion("deployment_id is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIsNotNull() {
            addCriterion("deployment_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdEqualTo(Integer value) {
            addCriterion("deployment_id =", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotEqualTo(Integer value) {
            addCriterion("deployment_id <>", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdGreaterThan(Integer value) {
            addCriterion("deployment_id >", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deployment_id >=", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLessThan(Integer value) {
            addCriterion("deployment_id <", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLessThanOrEqualTo(Integer value) {
            addCriterion("deployment_id <=", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIn(List<Integer> values) {
            addCriterion("deployment_id in", values, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotIn(List<Integer> values) {
            addCriterion("deployment_id not in", values, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdBetween(Integer value1, Integer value2) {
            addCriterion("deployment_id between", value1, value2, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deployment_id not between", value1, value2, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationIsNull() {
            addCriterion("deployment_location is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationIsNotNull() {
            addCriterion("deployment_location is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationEqualTo(String value) {
            addCriterion("deployment_location =", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationNotEqualTo(String value) {
            addCriterion("deployment_location <>", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationGreaterThan(String value) {
            addCriterion("deployment_location >", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationGreaterThanOrEqualTo(String value) {
            addCriterion("deployment_location >=", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationLessThan(String value) {
            addCriterion("deployment_location <", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationLessThanOrEqualTo(String value) {
            addCriterion("deployment_location <=", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationLike(String value) {
            addCriterion("deployment_location like", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationNotLike(String value) {
            addCriterion("deployment_location not like", value, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationIn(List<String> values) {
            addCriterion("deployment_location in", values, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationNotIn(List<String> values) {
            addCriterion("deployment_location not in", values, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationBetween(String value1, String value2) {
            addCriterion("deployment_location between", value1, value2, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andDeploymentLocationNotBetween(String value1, String value2) {
            addCriterion("deployment_location not between", value1, value2, "deploymentLocation");
            return (Criteria) this;
        }

        public Criteria andSpotIdIsNull() {
            addCriterion("spot_id is null");
            return (Criteria) this;
        }

        public Criteria andSpotIdIsNotNull() {
            addCriterion("spot_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpotIdEqualTo(Integer value) {
            addCriterion("spot_id =", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdNotEqualTo(Integer value) {
            addCriterion("spot_id <>", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdGreaterThan(Integer value) {
            addCriterion("spot_id >", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("spot_id >=", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdLessThan(Integer value) {
            addCriterion("spot_id <", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdLessThanOrEqualTo(Integer value) {
            addCriterion("spot_id <=", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdIn(List<Integer> values) {
            addCriterion("spot_id in", values, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdNotIn(List<Integer> values) {
            addCriterion("spot_id not in", values, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdBetween(Integer value1, Integer value2) {
            addCriterion("spot_id between", value1, value2, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("spot_id not between", value1, value2, "spotId");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescIsNull() {
            addCriterion("depolyment_desc is null");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescIsNotNull() {
            addCriterion("depolyment_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescEqualTo(String value) {
            addCriterion("depolyment_desc =", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescNotEqualTo(String value) {
            addCriterion("depolyment_desc <>", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescGreaterThan(String value) {
            addCriterion("depolyment_desc >", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescGreaterThanOrEqualTo(String value) {
            addCriterion("depolyment_desc >=", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescLessThan(String value) {
            addCriterion("depolyment_desc <", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescLessThanOrEqualTo(String value) {
            addCriterion("depolyment_desc <=", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescLike(String value) {
            addCriterion("depolyment_desc like", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescNotLike(String value) {
            addCriterion("depolyment_desc not like", value, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescIn(List<String> values) {
            addCriterion("depolyment_desc in", values, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescNotIn(List<String> values) {
            addCriterion("depolyment_desc not in", values, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescBetween(String value1, String value2) {
            addCriterion("depolyment_desc between", value1, value2, "depolymentDesc");
            return (Criteria) this;
        }

        public Criteria andDepolymentDescNotBetween(String value1, String value2) {
            addCriterion("depolyment_desc not between", value1, value2, "depolymentDesc");
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