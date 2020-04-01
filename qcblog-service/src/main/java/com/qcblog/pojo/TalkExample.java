package com.qcblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TalkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TalkExample() {
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

        public Criteria andTktitleIsNull() {
            addCriterion("tktitle is null");
            return (Criteria) this;
        }

        public Criteria andTktitleIsNotNull() {
            addCriterion("tktitle is not null");
            return (Criteria) this;
        }

        public Criteria andTktitleEqualTo(String value) {
            addCriterion("tktitle =", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleNotEqualTo(String value) {
            addCriterion("tktitle <>", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleGreaterThan(String value) {
            addCriterion("tktitle >", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleGreaterThanOrEqualTo(String value) {
            addCriterion("tktitle >=", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleLessThan(String value) {
            addCriterion("tktitle <", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleLessThanOrEqualTo(String value) {
            addCriterion("tktitle <=", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleLike(String value) {
            addCriterion("tktitle like", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleNotLike(String value) {
            addCriterion("tktitle not like", value, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleIn(List<String> values) {
            addCriterion("tktitle in", values, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleNotIn(List<String> values) {
            addCriterion("tktitle not in", values, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleBetween(String value1, String value2) {
            addCriterion("tktitle between", value1, value2, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTktitleNotBetween(String value1, String value2) {
            addCriterion("tktitle not between", value1, value2, "tktitle");
            return (Criteria) this;
        }

        public Criteria andTkcontentIsNull() {
            addCriterion("tkcontent is null");
            return (Criteria) this;
        }

        public Criteria andTkcontentIsNotNull() {
            addCriterion("tkcontent is not null");
            return (Criteria) this;
        }

        public Criteria andTkcontentEqualTo(String value) {
            addCriterion("tkcontent =", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentNotEqualTo(String value) {
            addCriterion("tkcontent <>", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentGreaterThan(String value) {
            addCriterion("tkcontent >", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentGreaterThanOrEqualTo(String value) {
            addCriterion("tkcontent >=", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentLessThan(String value) {
            addCriterion("tkcontent <", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentLessThanOrEqualTo(String value) {
            addCriterion("tkcontent <=", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentLike(String value) {
            addCriterion("tkcontent like", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentNotLike(String value) {
            addCriterion("tkcontent not like", value, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentIn(List<String> values) {
            addCriterion("tkcontent in", values, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentNotIn(List<String> values) {
            addCriterion("tkcontent not in", values, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentBetween(String value1, String value2) {
            addCriterion("tkcontent between", value1, value2, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkcontentNotBetween(String value1, String value2) {
            addCriterion("tkcontent not between", value1, value2, "tkcontent");
            return (Criteria) this;
        }

        public Criteria andTkimgIsNull() {
            addCriterion("tkimg is null");
            return (Criteria) this;
        }

        public Criteria andTkimgIsNotNull() {
            addCriterion("tkimg is not null");
            return (Criteria) this;
        }

        public Criteria andTkimgEqualTo(String value) {
            addCriterion("tkimg =", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgNotEqualTo(String value) {
            addCriterion("tkimg <>", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgGreaterThan(String value) {
            addCriterion("tkimg >", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgGreaterThanOrEqualTo(String value) {
            addCriterion("tkimg >=", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgLessThan(String value) {
            addCriterion("tkimg <", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgLessThanOrEqualTo(String value) {
            addCriterion("tkimg <=", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgLike(String value) {
            addCriterion("tkimg like", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgNotLike(String value) {
            addCriterion("tkimg not like", value, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgIn(List<String> values) {
            addCriterion("tkimg in", values, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgNotIn(List<String> values) {
            addCriterion("tkimg not in", values, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgBetween(String value1, String value2) {
            addCriterion("tkimg between", value1, value2, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTkimgNotBetween(String value1, String value2) {
            addCriterion("tkimg not between", value1, value2, "tkimg");
            return (Criteria) this;
        }

        public Criteria andTklinkIsNull() {
            addCriterion("tklink is null");
            return (Criteria) this;
        }

        public Criteria andTklinkIsNotNull() {
            addCriterion("tklink is not null");
            return (Criteria) this;
        }

        public Criteria andTklinkEqualTo(String value) {
            addCriterion("tklink =", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkNotEqualTo(String value) {
            addCriterion("tklink <>", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkGreaterThan(String value) {
            addCriterion("tklink >", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkGreaterThanOrEqualTo(String value) {
            addCriterion("tklink >=", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkLessThan(String value) {
            addCriterion("tklink <", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkLessThanOrEqualTo(String value) {
            addCriterion("tklink <=", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkLike(String value) {
            addCriterion("tklink like", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkNotLike(String value) {
            addCriterion("tklink not like", value, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkIn(List<String> values) {
            addCriterion("tklink in", values, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkNotIn(List<String> values) {
            addCriterion("tklink not in", values, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkBetween(String value1, String value2) {
            addCriterion("tklink between", value1, value2, "tklink");
            return (Criteria) this;
        }

        public Criteria andTklinkNotBetween(String value1, String value2) {
            addCriterion("tklink not between", value1, value2, "tklink");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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