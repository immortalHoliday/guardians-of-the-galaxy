package com.neuedu.web02.entity;

import java.util.ArrayList;
import java.util.List;

public class ChoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChoiceExample() {
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

        public Criteria andChoiceidIsNull() {
            addCriterion("choiceid is null");
            return (Criteria) this;
        }

        public Criteria andChoiceidIsNotNull() {
            addCriterion("choiceid is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceidEqualTo(Integer value) {
            addCriterion("choiceid =", value, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidNotEqualTo(Integer value) {
            addCriterion("choiceid <>", value, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidGreaterThan(Integer value) {
            addCriterion("choiceid >", value, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("choiceid >=", value, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidLessThan(Integer value) {
            addCriterion("choiceid <", value, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidLessThanOrEqualTo(Integer value) {
            addCriterion("choiceid <=", value, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidIn(List<Integer> values) {
            addCriterion("choiceid in", values, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidNotIn(List<Integer> values) {
            addCriterion("choiceid not in", values, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidBetween(Integer value1, Integer value2) {
            addCriterion("choiceid between", value1, value2, "choiceid");
            return (Criteria) this;
        }

        public Criteria andChoiceidNotBetween(Integer value1, Integer value2) {
            addCriterion("choiceid not between", value1, value2, "choiceid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNull() {
            addCriterion("questionid is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("questionid is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Integer value) {
            addCriterion("questionid =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Integer value) {
            addCriterion("questionid <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Integer value) {
            addCriterion("questionid >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionid >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Integer value) {
            addCriterion("questionid <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Integer value) {
            addCriterion("questionid <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Integer> values) {
            addCriterion("questionid in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Integer> values) {
            addCriterion("questionid not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Integer value1, Integer value2) {
            addCriterion("questionid between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("questionid not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContenticonpathIsNull() {
            addCriterion("contenticonpath is null");
            return (Criteria) this;
        }

        public Criteria andContenticonpathIsNotNull() {
            addCriterion("contenticonpath is not null");
            return (Criteria) this;
        }

        public Criteria andContenticonpathEqualTo(String value) {
            addCriterion("contenticonpath =", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathNotEqualTo(String value) {
            addCriterion("contenticonpath <>", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathGreaterThan(String value) {
            addCriterion("contenticonpath >", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathGreaterThanOrEqualTo(String value) {
            addCriterion("contenticonpath >=", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathLessThan(String value) {
            addCriterion("contenticonpath <", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathLessThanOrEqualTo(String value) {
            addCriterion("contenticonpath <=", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathLike(String value) {
            addCriterion("contenticonpath like", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathNotLike(String value) {
            addCriterion("contenticonpath not like", value, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathIn(List<String> values) {
            addCriterion("contenticonpath in", values, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathNotIn(List<String> values) {
            addCriterion("contenticonpath not in", values, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathBetween(String value1, String value2) {
            addCriterion("contenticonpath between", value1, value2, "contenticonpath");
            return (Criteria) this;
        }

        public Criteria andContenticonpathNotBetween(String value1, String value2) {
            addCriterion("contenticonpath not between", value1, value2, "contenticonpath");
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