package com.qcblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
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

        public Criteria andNtnameIsNull() {
            addCriterion("ntname is null");
            return (Criteria) this;
        }

        public Criteria andNtnameIsNotNull() {
            addCriterion("ntname is not null");
            return (Criteria) this;
        }

        public Criteria andNtnameEqualTo(String value) {
            addCriterion("ntname =", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameNotEqualTo(String value) {
            addCriterion("ntname <>", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameGreaterThan(String value) {
            addCriterion("ntname >", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameGreaterThanOrEqualTo(String value) {
            addCriterion("ntname >=", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameLessThan(String value) {
            addCriterion("ntname <", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameLessThanOrEqualTo(String value) {
            addCriterion("ntname <=", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameLike(String value) {
            addCriterion("ntname like", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameNotLike(String value) {
            addCriterion("ntname not like", value, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameIn(List<String> values) {
            addCriterion("ntname in", values, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameNotIn(List<String> values) {
            addCriterion("ntname not in", values, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameBetween(String value1, String value2) {
            addCriterion("ntname between", value1, value2, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtnameNotBetween(String value1, String value2) {
            addCriterion("ntname not between", value1, value2, "ntname");
            return (Criteria) this;
        }

        public Criteria andNtstatusIsNull() {
            addCriterion("ntstatus is null");
            return (Criteria) this;
        }

        public Criteria andNtstatusIsNotNull() {
            addCriterion("ntstatus is not null");
            return (Criteria) this;
        }

        public Criteria andNtstatusEqualTo(String value) {
            addCriterion("ntstatus =", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusNotEqualTo(String value) {
            addCriterion("ntstatus <>", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusGreaterThan(String value) {
            addCriterion("ntstatus >", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ntstatus >=", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusLessThan(String value) {
            addCriterion("ntstatus <", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusLessThanOrEqualTo(String value) {
            addCriterion("ntstatus <=", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusLike(String value) {
            addCriterion("ntstatus like", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusNotLike(String value) {
            addCriterion("ntstatus not like", value, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusIn(List<String> values) {
            addCriterion("ntstatus in", values, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusNotIn(List<String> values) {
            addCriterion("ntstatus not in", values, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusBetween(String value1, String value2) {
            addCriterion("ntstatus between", value1, value2, "ntstatus");
            return (Criteria) this;
        }

        public Criteria andNtstatusNotBetween(String value1, String value2) {
            addCriterion("ntstatus not between", value1, value2, "ntstatus");
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

        public Criteria andNttypeIsNull() {
            addCriterion("nttype is null");
            return (Criteria) this;
        }

        public Criteria andNttypeIsNotNull() {
            addCriterion("nttype is not null");
            return (Criteria) this;
        }

        public Criteria andNttypeEqualTo(String value) {
            addCriterion("nttype =", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeNotEqualTo(String value) {
            addCriterion("nttype <>", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeGreaterThan(String value) {
            addCriterion("nttype >", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeGreaterThanOrEqualTo(String value) {
            addCriterion("nttype >=", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeLessThan(String value) {
            addCriterion("nttype <", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeLessThanOrEqualTo(String value) {
            addCriterion("nttype <=", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeLike(String value) {
            addCriterion("nttype like", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeNotLike(String value) {
            addCriterion("nttype not like", value, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeIn(List<String> values) {
            addCriterion("nttype in", values, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeNotIn(List<String> values) {
            addCriterion("nttype not in", values, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeBetween(String value1, String value2) {
            addCriterion("nttype between", value1, value2, "nttype");
            return (Criteria) this;
        }

        public Criteria andNttypeNotBetween(String value1, String value2) {
            addCriterion("nttype not between", value1, value2, "nttype");
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