package com.neuedu.web02.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserExamRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExamRecordExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andIstestIsNull() {
            addCriterion("istest is null");
            return (Criteria) this;
        }

        public Criteria andIstestIsNotNull() {
            addCriterion("istest is not null");
            return (Criteria) this;
        }

        public Criteria andIstestEqualTo(Integer value) {
            addCriterion("istest =", value, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestNotEqualTo(Integer value) {
            addCriterion("istest <>", value, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestGreaterThan(Integer value) {
            addCriterion("istest >", value, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestGreaterThanOrEqualTo(Integer value) {
            addCriterion("istest >=", value, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestLessThan(Integer value) {
            addCriterion("istest <", value, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestLessThanOrEqualTo(Integer value) {
            addCriterion("istest <=", value, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestIn(List<Integer> values) {
            addCriterion("istest in", values, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestNotIn(List<Integer> values) {
            addCriterion("istest not in", values, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestBetween(Integer value1, Integer value2) {
            addCriterion("istest between", value1, value2, "istest");
            return (Criteria) this;
        }

        public Criteria andIstestNotBetween(Integer value1, Integer value2) {
            addCriterion("istest not between", value1, value2, "istest");
            return (Criteria) this;
        }

        public Criteria andDuringtimeIsNull() {
            addCriterion("duringtime is null");
            return (Criteria) this;
        }

        public Criteria andDuringtimeIsNotNull() {
            addCriterion("duringtime is not null");
            return (Criteria) this;
        }

        public Criteria andDuringtimeEqualTo(Integer value) {
            addCriterion("duringtime =", value, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeNotEqualTo(Integer value) {
            addCriterion("duringtime <>", value, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeGreaterThan(Integer value) {
            addCriterion("duringtime >", value, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("duringtime >=", value, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeLessThan(Integer value) {
            addCriterion("duringtime <", value, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeLessThanOrEqualTo(Integer value) {
            addCriterion("duringtime <=", value, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeIn(List<Integer> values) {
            addCriterion("duringtime in", values, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeNotIn(List<Integer> values) {
            addCriterion("duringtime not in", values, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeBetween(Integer value1, Integer value2) {
            addCriterion("duringtime between", value1, value2, "duringtime");
            return (Criteria) this;
        }

        public Criteria andDuringtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("duringtime not between", value1, value2, "duringtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeIsNull() {
            addCriterion("switchtime is null");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeIsNotNull() {
            addCriterion("switchtime is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeEqualTo(Integer value) {
            addCriterion("switchtime =", value, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeNotEqualTo(Integer value) {
            addCriterion("switchtime <>", value, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeGreaterThan(Integer value) {
            addCriterion("switchtime >", value, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("switchtime >=", value, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeLessThan(Integer value) {
            addCriterion("switchtime <", value, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeLessThanOrEqualTo(Integer value) {
            addCriterion("switchtime <=", value, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeIn(List<Integer> values) {
            addCriterion("switchtime in", values, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeNotIn(List<Integer> values) {
            addCriterion("switchtime not in", values, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeBetween(Integer value1, Integer value2) {
            addCriterion("switchtime between", value1, value2, "switchtime");
            return (Criteria) this;
        }

        public Criteria andSwitchtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("switchtime not between", value1, value2, "switchtime");
            return (Criteria) this;
        }

        public Criteria andJudgeIsNull() {
            addCriterion("judge is null");
            return (Criteria) this;
        }

        public Criteria andJudgeIsNotNull() {
            addCriterion("judge is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeEqualTo(Integer value) {
            addCriterion("judge =", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotEqualTo(Integer value) {
            addCriterion("judge <>", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeGreaterThan(Integer value) {
            addCriterion("judge >", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("judge >=", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLessThan(Integer value) {
            addCriterion("judge <", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLessThanOrEqualTo(Integer value) {
            addCriterion("judge <=", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeIn(List<Integer> values) {
            addCriterion("judge in", values, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotIn(List<Integer> values) {
            addCriterion("judge not in", values, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeBetween(Integer value1, Integer value2) {
            addCriterion("judge between", value1, value2, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotBetween(Integer value1, Integer value2) {
            addCriterion("judge not between", value1, value2, "judge");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreIsNull() {
            addCriterion("totalgetscore is null");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreIsNotNull() {
            addCriterion("totalgetscore is not null");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreEqualTo(BigDecimal value) {
            addCriterion("totalgetscore =", value, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreNotEqualTo(BigDecimal value) {
            addCriterion("totalgetscore <>", value, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreGreaterThan(BigDecimal value) {
            addCriterion("totalgetscore >", value, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalgetscore >=", value, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreLessThan(BigDecimal value) {
            addCriterion("totalgetscore <", value, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalgetscore <=", value, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreIn(List<BigDecimal> values) {
            addCriterion("totalgetscore in", values, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreNotIn(List<BigDecimal> values) {
            addCriterion("totalgetscore not in", values, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalgetscore between", value1, value2, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andTotalgetscoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalgetscore not between", value1, value2, "totalgetscore");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperIsNull() {
            addCriterion("submitpaper is null");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperIsNotNull() {
            addCriterion("submitpaper is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperEqualTo(Integer value) {
            addCriterion("submitpaper =", value, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperNotEqualTo(Integer value) {
            addCriterion("submitpaper <>", value, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperGreaterThan(Integer value) {
            addCriterion("submitpaper >", value, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperGreaterThanOrEqualTo(Integer value) {
            addCriterion("submitpaper >=", value, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperLessThan(Integer value) {
            addCriterion("submitpaper <", value, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperLessThanOrEqualTo(Integer value) {
            addCriterion("submitpaper <=", value, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperIn(List<Integer> values) {
            addCriterion("submitpaper in", values, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperNotIn(List<Integer> values) {
            addCriterion("submitpaper not in", values, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperBetween(Integer value1, Integer value2) {
            addCriterion("submitpaper between", value1, value2, "submitpaper");
            return (Criteria) this;
        }

        public Criteria andSubmitpaperNotBetween(Integer value1, Integer value2) {
            addCriterion("submitpaper not between", value1, value2, "submitpaper");
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