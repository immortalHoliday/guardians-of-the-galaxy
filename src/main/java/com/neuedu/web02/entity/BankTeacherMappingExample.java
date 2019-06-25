package com.neuedu.web02.entity;

import java.util.ArrayList;
import java.util.List;

public class BankTeacherMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankTeacherMappingExample() {
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

        public Criteria andBankidIsNull() {
            addCriterion("bankid is null");
            return (Criteria) this;
        }

        public Criteria andBankidIsNotNull() {
            addCriterion("bankid is not null");
            return (Criteria) this;
        }

        public Criteria andBankidEqualTo(Integer value) {
            addCriterion("bankid =", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotEqualTo(Integer value) {
            addCriterion("bankid <>", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThan(Integer value) {
            addCriterion("bankid >", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankid >=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThan(Integer value) {
            addCriterion("bankid <", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThanOrEqualTo(Integer value) {
            addCriterion("bankid <=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidIn(List<Integer> values) {
            addCriterion("bankid in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotIn(List<Integer> values) {
            addCriterion("bankid not in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidBetween(Integer value1, Integer value2) {
            addCriterion("bankid between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotBetween(Integer value1, Integer value2) {
            addCriterion("bankid not between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherid is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherid is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherid =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherid <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherid >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherid >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherid <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherid <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherid in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherid not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherid between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherid not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andBackup1IsNull() {
            addCriterion("backup1 is null");
            return (Criteria) this;
        }

        public Criteria andBackup1IsNotNull() {
            addCriterion("backup1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup1EqualTo(String value) {
            addCriterion("backup1 =", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotEqualTo(String value) {
            addCriterion("backup1 <>", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1GreaterThan(String value) {
            addCriterion("backup1 >", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1GreaterThanOrEqualTo(String value) {
            addCriterion("backup1 >=", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1LessThan(String value) {
            addCriterion("backup1 <", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1LessThanOrEqualTo(String value) {
            addCriterion("backup1 <=", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1Like(String value) {
            addCriterion("backup1 like", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotLike(String value) {
            addCriterion("backup1 not like", value, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1In(List<String> values) {
            addCriterion("backup1 in", values, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotIn(List<String> values) {
            addCriterion("backup1 not in", values, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1Between(String value1, String value2) {
            addCriterion("backup1 between", value1, value2, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup1NotBetween(String value1, String value2) {
            addCriterion("backup1 not between", value1, value2, "backup1");
            return (Criteria) this;
        }

        public Criteria andBackup2IsNull() {
            addCriterion("backup2 is null");
            return (Criteria) this;
        }

        public Criteria andBackup2IsNotNull() {
            addCriterion("backup2 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup2EqualTo(Integer value) {
            addCriterion("backup2 =", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotEqualTo(Integer value) {
            addCriterion("backup2 <>", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2GreaterThan(Integer value) {
            addCriterion("backup2 >", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2GreaterThanOrEqualTo(Integer value) {
            addCriterion("backup2 >=", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2LessThan(Integer value) {
            addCriterion("backup2 <", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2LessThanOrEqualTo(Integer value) {
            addCriterion("backup2 <=", value, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2In(List<Integer> values) {
            addCriterion("backup2 in", values, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotIn(List<Integer> values) {
            addCriterion("backup2 not in", values, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2Between(Integer value1, Integer value2) {
            addCriterion("backup2 between", value1, value2, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackup2NotBetween(Integer value1, Integer value2) {
            addCriterion("backup2 not between", value1, value2, "backup2");
            return (Criteria) this;
        }

        public Criteria andBackupIsNull() {
            addCriterion("backup is null");
            return (Criteria) this;
        }

        public Criteria andBackupIsNotNull() {
            addCriterion("backup is not null");
            return (Criteria) this;
        }

        public Criteria andBackupEqualTo(Integer value) {
            addCriterion("backup =", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotEqualTo(Integer value) {
            addCriterion("backup <>", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThan(Integer value) {
            addCriterion("backup >", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThanOrEqualTo(Integer value) {
            addCriterion("backup >=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThan(Integer value) {
            addCriterion("backup <", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThanOrEqualTo(Integer value) {
            addCriterion("backup <=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupIn(List<Integer> values) {
            addCriterion("backup in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotIn(List<Integer> values) {
            addCriterion("backup not in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupBetween(Integer value1, Integer value2) {
            addCriterion("backup between", value1, value2, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotBetween(Integer value1, Integer value2) {
            addCriterion("backup not between", value1, value2, "backup");
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