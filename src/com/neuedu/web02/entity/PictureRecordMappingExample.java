package com.neuedu.web02.entity;

import java.util.ArrayList;
import java.util.List;

public class PictureRecordMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PictureRecordMappingExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExamrecordidIsNull() {
            addCriterion("examrecordid is null");
            return (Criteria) this;
        }

        public Criteria andExamrecordidIsNotNull() {
            addCriterion("examrecordid is not null");
            return (Criteria) this;
        }

        public Criteria andExamrecordidEqualTo(Integer value) {
            addCriterion("examrecordid =", value, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidNotEqualTo(Integer value) {
            addCriterion("examrecordid <>", value, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidGreaterThan(Integer value) {
            addCriterion("examrecordid >", value, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examrecordid >=", value, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidLessThan(Integer value) {
            addCriterion("examrecordid <", value, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidLessThanOrEqualTo(Integer value) {
            addCriterion("examrecordid <=", value, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidIn(List<Integer> values) {
            addCriterion("examrecordid in", values, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidNotIn(List<Integer> values) {
            addCriterion("examrecordid not in", values, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidBetween(Integer value1, Integer value2) {
            addCriterion("examrecordid between", value1, value2, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andExamrecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("examrecordid not between", value1, value2, "examrecordid");
            return (Criteria) this;
        }

        public Criteria andIconpathIsNull() {
            addCriterion("iconpath is null");
            return (Criteria) this;
        }

        public Criteria andIconpathIsNotNull() {
            addCriterion("iconpath is not null");
            return (Criteria) this;
        }

        public Criteria andIconpathEqualTo(String value) {
            addCriterion("iconpath =", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathNotEqualTo(String value) {
            addCriterion("iconpath <>", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathGreaterThan(String value) {
            addCriterion("iconpath >", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathGreaterThanOrEqualTo(String value) {
            addCriterion("iconpath >=", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathLessThan(String value) {
            addCriterion("iconpath <", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathLessThanOrEqualTo(String value) {
            addCriterion("iconpath <=", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathLike(String value) {
            addCriterion("iconpath like", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathNotLike(String value) {
            addCriterion("iconpath not like", value, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathIn(List<String> values) {
            addCriterion("iconpath in", values, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathNotIn(List<String> values) {
            addCriterion("iconpath not in", values, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathBetween(String value1, String value2) {
            addCriterion("iconpath between", value1, value2, "iconpath");
            return (Criteria) this;
        }

        public Criteria andIconpathNotBetween(String value1, String value2) {
            addCriterion("iconpath not between", value1, value2, "iconpath");
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