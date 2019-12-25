package com.qcblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlinkExample() {
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

        public Criteria andFlnameIsNull() {
            addCriterion("flname is null");
            return (Criteria) this;
        }

        public Criteria andFlnameIsNotNull() {
            addCriterion("flname is not null");
            return (Criteria) this;
        }

        public Criteria andFlnameEqualTo(String value) {
            addCriterion("flname =", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotEqualTo(String value) {
            addCriterion("flname <>", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameGreaterThan(String value) {
            addCriterion("flname >", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameGreaterThanOrEqualTo(String value) {
            addCriterion("flname >=", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameLessThan(String value) {
            addCriterion("flname <", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameLessThanOrEqualTo(String value) {
            addCriterion("flname <=", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameLike(String value) {
            addCriterion("flname like", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotLike(String value) {
            addCriterion("flname not like", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameIn(List<String> values) {
            addCriterion("flname in", values, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotIn(List<String> values) {
            addCriterion("flname not in", values, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameBetween(String value1, String value2) {
            addCriterion("flname between", value1, value2, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotBetween(String value1, String value2) {
            addCriterion("flname not between", value1, value2, "flname");
            return (Criteria) this;
        }

        public Criteria andFlinkIsNull() {
            addCriterion("flink is null");
            return (Criteria) this;
        }

        public Criteria andFlinkIsNotNull() {
            addCriterion("flink is not null");
            return (Criteria) this;
        }

        public Criteria andFlinkEqualTo(String value) {
            addCriterion("flink =", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkNotEqualTo(String value) {
            addCriterion("flink <>", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkGreaterThan(String value) {
            addCriterion("flink >", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkGreaterThanOrEqualTo(String value) {
            addCriterion("flink >=", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkLessThan(String value) {
            addCriterion("flink <", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkLessThanOrEqualTo(String value) {
            addCriterion("flink <=", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkLike(String value) {
            addCriterion("flink like", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkNotLike(String value) {
            addCriterion("flink not like", value, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkIn(List<String> values) {
            addCriterion("flink in", values, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkNotIn(List<String> values) {
            addCriterion("flink not in", values, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkBetween(String value1, String value2) {
            addCriterion("flink between", value1, value2, "flink");
            return (Criteria) this;
        }

        public Criteria andFlinkNotBetween(String value1, String value2) {
            addCriterion("flink not between", value1, value2, "flink");
            return (Criteria) this;
        }

        public Criteria andFlstatusIsNull() {
            addCriterion("flstatus is null");
            return (Criteria) this;
        }

        public Criteria andFlstatusIsNotNull() {
            addCriterion("flstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFlstatusEqualTo(String value) {
            addCriterion("flstatus =", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusNotEqualTo(String value) {
            addCriterion("flstatus <>", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusGreaterThan(String value) {
            addCriterion("flstatus >", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusGreaterThanOrEqualTo(String value) {
            addCriterion("flstatus >=", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusLessThan(String value) {
            addCriterion("flstatus <", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusLessThanOrEqualTo(String value) {
            addCriterion("flstatus <=", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusLike(String value) {
            addCriterion("flstatus like", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusNotLike(String value) {
            addCriterion("flstatus not like", value, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusIn(List<String> values) {
            addCriterion("flstatus in", values, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusNotIn(List<String> values) {
            addCriterion("flstatus not in", values, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusBetween(String value1, String value2) {
            addCriterion("flstatus between", value1, value2, "flstatus");
            return (Criteria) this;
        }

        public Criteria andFlstatusNotBetween(String value1, String value2) {
            addCriterion("flstatus not between", value1, value2, "flstatus");
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

        public Criteria andFlcontentIsNull() {
            addCriterion("flcontent is null");
            return (Criteria) this;
        }

        public Criteria andFlcontentIsNotNull() {
            addCriterion("flcontent is not null");
            return (Criteria) this;
        }

        public Criteria andFlcontentEqualTo(String value) {
            addCriterion("flcontent =", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentNotEqualTo(String value) {
            addCriterion("flcontent <>", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentGreaterThan(String value) {
            addCriterion("flcontent >", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentGreaterThanOrEqualTo(String value) {
            addCriterion("flcontent >=", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentLessThan(String value) {
            addCriterion("flcontent <", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentLessThanOrEqualTo(String value) {
            addCriterion("flcontent <=", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentLike(String value) {
            addCriterion("flcontent like", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentNotLike(String value) {
            addCriterion("flcontent not like", value, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentIn(List<String> values) {
            addCriterion("flcontent in", values, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentNotIn(List<String> values) {
            addCriterion("flcontent not in", values, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentBetween(String value1, String value2) {
            addCriterion("flcontent between", value1, value2, "flcontent");
            return (Criteria) this;
        }

        public Criteria andFlcontentNotBetween(String value1, String value2) {
            addCriterion("flcontent not between", value1, value2, "flcontent");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
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

        public Criteria andFltypeIsNull() {
            addCriterion("fltype is null");
            return (Criteria) this;
        }

        public Criteria andFltypeIsNotNull() {
            addCriterion("fltype is not null");
            return (Criteria) this;
        }

        public Criteria andFltypeEqualTo(String value) {
            addCriterion("fltype =", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeNotEqualTo(String value) {
            addCriterion("fltype <>", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeGreaterThan(String value) {
            addCriterion("fltype >", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeGreaterThanOrEqualTo(String value) {
            addCriterion("fltype >=", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeLessThan(String value) {
            addCriterion("fltype <", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeLessThanOrEqualTo(String value) {
            addCriterion("fltype <=", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeLike(String value) {
            addCriterion("fltype like", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeNotLike(String value) {
            addCriterion("fltype not like", value, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeIn(List<String> values) {
            addCriterion("fltype in", values, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeNotIn(List<String> values) {
            addCriterion("fltype not in", values, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeBetween(String value1, String value2) {
            addCriterion("fltype between", value1, value2, "fltype");
            return (Criteria) this;
        }

        public Criteria andFltypeNotBetween(String value1, String value2) {
            addCriterion("fltype not between", value1, value2, "fltype");
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