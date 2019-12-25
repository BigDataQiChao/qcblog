package com.qcblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SigninlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SigninlogExample() {
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

        public Criteria andLogipIsNull() {
            addCriterion("logip is null");
            return (Criteria) this;
        }

        public Criteria andLogipIsNotNull() {
            addCriterion("logip is not null");
            return (Criteria) this;
        }

        public Criteria andLogipEqualTo(String value) {
            addCriterion("logip =", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipNotEqualTo(String value) {
            addCriterion("logip <>", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipGreaterThan(String value) {
            addCriterion("logip >", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipGreaterThanOrEqualTo(String value) {
            addCriterion("logip >=", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipLessThan(String value) {
            addCriterion("logip <", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipLessThanOrEqualTo(String value) {
            addCriterion("logip <=", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipLike(String value) {
            addCriterion("logip like", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipNotLike(String value) {
            addCriterion("logip not like", value, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipIn(List<String> values) {
            addCriterion("logip in", values, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipNotIn(List<String> values) {
            addCriterion("logip not in", values, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipBetween(String value1, String value2) {
            addCriterion("logip between", value1, value2, "logip");
            return (Criteria) this;
        }

        public Criteria andLogipNotBetween(String value1, String value2) {
            addCriterion("logip not between", value1, value2, "logip");
            return (Criteria) this;
        }

        public Criteria andLogtimeIsNull() {
            addCriterion("logtime is null");
            return (Criteria) this;
        }

        public Criteria andLogtimeIsNotNull() {
            addCriterion("logtime is not null");
            return (Criteria) this;
        }

        public Criteria andLogtimeEqualTo(Date value) {
            addCriterion("logtime =", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotEqualTo(Date value) {
            addCriterion("logtime <>", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeGreaterThan(Date value) {
            addCriterion("logtime >", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logtime >=", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeLessThan(Date value) {
            addCriterion("logtime <", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeLessThanOrEqualTo(Date value) {
            addCriterion("logtime <=", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeIn(List<Date> values) {
            addCriterion("logtime in", values, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotIn(List<Date> values) {
            addCriterion("logtime not in", values, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeBetween(Date value1, Date value2) {
            addCriterion("logtime between", value1, value2, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotBetween(Date value1, Date value2) {
            addCriterion("logtime not between", value1, value2, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogstatusIsNull() {
            addCriterion("logstatus is null");
            return (Criteria) this;
        }

        public Criteria andLogstatusIsNotNull() {
            addCriterion("logstatus is not null");
            return (Criteria) this;
        }

        public Criteria andLogstatusEqualTo(String value) {
            addCriterion("logstatus =", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusNotEqualTo(String value) {
            addCriterion("logstatus <>", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusGreaterThan(String value) {
            addCriterion("logstatus >", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusGreaterThanOrEqualTo(String value) {
            addCriterion("logstatus >=", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusLessThan(String value) {
            addCriterion("logstatus <", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusLessThanOrEqualTo(String value) {
            addCriterion("logstatus <=", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusLike(String value) {
            addCriterion("logstatus like", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusNotLike(String value) {
            addCriterion("logstatus not like", value, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusIn(List<String> values) {
            addCriterion("logstatus in", values, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusNotIn(List<String> values) {
            addCriterion("logstatus not in", values, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusBetween(String value1, String value2) {
            addCriterion("logstatus between", value1, value2, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLogstatusNotBetween(String value1, String value2) {
            addCriterion("logstatus not between", value1, value2, "logstatus");
            return (Criteria) this;
        }

        public Criteria andLognameIsNull() {
            addCriterion("logname is null");
            return (Criteria) this;
        }

        public Criteria andLognameIsNotNull() {
            addCriterion("logname is not null");
            return (Criteria) this;
        }

        public Criteria andLognameEqualTo(String value) {
            addCriterion("logname =", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameNotEqualTo(String value) {
            addCriterion("logname <>", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameGreaterThan(String value) {
            addCriterion("logname >", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameGreaterThanOrEqualTo(String value) {
            addCriterion("logname >=", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameLessThan(String value) {
            addCriterion("logname <", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameLessThanOrEqualTo(String value) {
            addCriterion("logname <=", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameLike(String value) {
            addCriterion("logname like", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameNotLike(String value) {
            addCriterion("logname not like", value, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameIn(List<String> values) {
            addCriterion("logname in", values, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameNotIn(List<String> values) {
            addCriterion("logname not in", values, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameBetween(String value1, String value2) {
            addCriterion("logname between", value1, value2, "logname");
            return (Criteria) this;
        }

        public Criteria andLognameNotBetween(String value1, String value2) {
            addCriterion("logname not between", value1, value2, "logname");
            return (Criteria) this;
        }

        public Criteria andLogtypeIsNull() {
            addCriterion("logtype is null");
            return (Criteria) this;
        }

        public Criteria andLogtypeIsNotNull() {
            addCriterion("logtype is not null");
            return (Criteria) this;
        }

        public Criteria andLogtypeEqualTo(String value) {
            addCriterion("logtype =", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotEqualTo(String value) {
            addCriterion("logtype <>", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeGreaterThan(String value) {
            addCriterion("logtype >", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeGreaterThanOrEqualTo(String value) {
            addCriterion("logtype >=", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLessThan(String value) {
            addCriterion("logtype <", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLessThanOrEqualTo(String value) {
            addCriterion("logtype <=", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLike(String value) {
            addCriterion("logtype like", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotLike(String value) {
            addCriterion("logtype not like", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeIn(List<String> values) {
            addCriterion("logtype in", values, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotIn(List<String> values) {
            addCriterion("logtype not in", values, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeBetween(String value1, String value2) {
            addCriterion("logtype between", value1, value2, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotBetween(String value1, String value2) {
            addCriterion("logtype not between", value1, value2, "logtype");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("utime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("utime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("utime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("utime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("utime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("utime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("utime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("utime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("utime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("utime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("utime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("utime not between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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