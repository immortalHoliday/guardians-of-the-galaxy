package com.neuedu.web02.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
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

        public Criteria andExamidIsNull() {
            addCriterion("examid is null");
            return (Criteria) this;
        }

        public Criteria andExamidIsNotNull() {
            addCriterion("examid is not null");
            return (Criteria) this;
        }

        public Criteria andExamidEqualTo(Integer value) {
            addCriterion("examid =", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotEqualTo(Integer value) {
            addCriterion("examid <>", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThan(Integer value) {
            addCriterion("examid >", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examid >=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThan(Integer value) {
            addCriterion("examid <", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThanOrEqualTo(Integer value) {
            addCriterion("examid <=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidIn(List<Integer> values) {
            addCriterion("examid in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotIn(List<Integer> values) {
            addCriterion("examid not in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidBetween(Integer value1, Integer value2) {
            addCriterion("examid between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotBetween(Integer value1, Integer value2) {
            addCriterion("examid not between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andExamnameIsNull() {
            addCriterion("examname is null");
            return (Criteria) this;
        }

        public Criteria andExamnameIsNotNull() {
            addCriterion("examname is not null");
            return (Criteria) this;
        }

        public Criteria andExamnameEqualTo(String value) {
            addCriterion("examname =", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotEqualTo(String value) {
            addCriterion("examname <>", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameGreaterThan(String value) {
            addCriterion("examname >", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameGreaterThanOrEqualTo(String value) {
            addCriterion("examname >=", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameLessThan(String value) {
            addCriterion("examname <", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameLessThanOrEqualTo(String value) {
            addCriterion("examname <=", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameLike(String value) {
            addCriterion("examname like", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotLike(String value) {
            addCriterion("examname not like", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameIn(List<String> values) {
            addCriterion("examname in", values, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotIn(List<String> values) {
            addCriterion("examname not in", values, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameBetween(String value1, String value2) {
            addCriterion("examname between", value1, value2, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotBetween(String value1, String value2) {
            addCriterion("examname not between", value1, value2, "examname");
            return (Criteria) this;
        }

        public Criteria andExamdateIsNull() {
            addCriterion("examdate is null");
            return (Criteria) this;
        }

        public Criteria andExamdateIsNotNull() {
            addCriterion("examdate is not null");
            return (Criteria) this;
        }

        public Criteria andExamdateEqualTo(Date value) {
            addCriterion("examdate =", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotEqualTo(Date value) {
            addCriterion("examdate <>", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateGreaterThan(Date value) {
            addCriterion("examdate >", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateGreaterThanOrEqualTo(Date value) {
            addCriterion("examdate >=", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateLessThan(Date value) {
            addCriterion("examdate <", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateLessThanOrEqualTo(Date value) {
            addCriterion("examdate <=", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateIn(List<Date> values) {
            addCriterion("examdate in", values, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotIn(List<Date> values) {
            addCriterion("examdate not in", values, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateBetween(Date value1, Date value2) {
            addCriterion("examdate between", value1, value2, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotBetween(Date value1, Date value2) {
            addCriterion("examdate not between", value1, value2, "examdate");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNull() {
            addCriterion("paperid is null");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("paperid is not null");
            return (Criteria) this;
        }

        public Criteria andPaperidEqualTo(Integer value) {
            addCriterion("paperid =", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotEqualTo(Integer value) {
            addCriterion("paperid <>", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThan(Integer value) {
            addCriterion("paperid >", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paperid >=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThan(Integer value) {
            addCriterion("paperid <", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Integer value) {
            addCriterion("paperid <=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidIn(List<Integer> values) {
            addCriterion("paperid in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotIn(List<Integer> values) {
            addCriterion("paperid not in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidBetween(Integer value1, Integer value2) {
            addCriterion("paperid between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("paperid not between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andActivecodeIsNull() {
            addCriterion("activecode is null");
            return (Criteria) this;
        }

        public Criteria andActivecodeIsNotNull() {
            addCriterion("activecode is not null");
            return (Criteria) this;
        }

        public Criteria andActivecodeEqualTo(String value) {
            addCriterion("activecode =", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotEqualTo(String value) {
            addCriterion("activecode <>", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeGreaterThan(String value) {
            addCriterion("activecode >", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeGreaterThanOrEqualTo(String value) {
            addCriterion("activecode >=", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLessThan(String value) {
            addCriterion("activecode <", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLessThanOrEqualTo(String value) {
            addCriterion("activecode <=", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeLike(String value) {
            addCriterion("activecode like", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotLike(String value) {
            addCriterion("activecode not like", value, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeIn(List<String> values) {
            addCriterion("activecode in", values, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotIn(List<String> values) {
            addCriterion("activecode not in", values, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeBetween(String value1, String value2) {
            addCriterion("activecode between", value1, value2, "activecode");
            return (Criteria) this;
        }

        public Criteria andActivecodeNotBetween(String value1, String value2) {
            addCriterion("activecode not between", value1, value2, "activecode");
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

        public Criteria andBackup3IsNull() {
            addCriterion("backup3 is null");
            return (Criteria) this;
        }

        public Criteria andBackup3IsNotNull() {
            addCriterion("backup3 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup3EqualTo(Integer value) {
            addCriterion("backup3 =", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotEqualTo(Integer value) {
            addCriterion("backup3 <>", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3GreaterThan(Integer value) {
            addCriterion("backup3 >", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3GreaterThanOrEqualTo(Integer value) {
            addCriterion("backup3 >=", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3LessThan(Integer value) {
            addCriterion("backup3 <", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3LessThanOrEqualTo(Integer value) {
            addCriterion("backup3 <=", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3In(List<Integer> values) {
            addCriterion("backup3 in", values, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotIn(List<Integer> values) {
            addCriterion("backup3 not in", values, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3Between(Integer value1, Integer value2) {
            addCriterion("backup3 between", value1, value2, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotBetween(Integer value1, Integer value2) {
            addCriterion("backup3 not between", value1, value2, "backup3");
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