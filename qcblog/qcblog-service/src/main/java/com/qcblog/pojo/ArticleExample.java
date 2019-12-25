package com.qcblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andAtnameIsNull() {
            addCriterion("atname is null");
            return (Criteria) this;
        }

        public Criteria andAtnameIsNotNull() {
            addCriterion("atname is not null");
            return (Criteria) this;
        }

        public Criteria andAtnameEqualTo(String value) {
            addCriterion("atname =", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameNotEqualTo(String value) {
            addCriterion("atname <>", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameGreaterThan(String value) {
            addCriterion("atname >", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameGreaterThanOrEqualTo(String value) {
            addCriterion("atname >=", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameLessThan(String value) {
            addCriterion("atname <", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameLessThanOrEqualTo(String value) {
            addCriterion("atname <=", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameLike(String value) {
            addCriterion("atname like", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameNotLike(String value) {
            addCriterion("atname not like", value, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameIn(List<String> values) {
            addCriterion("atname in", values, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameNotIn(List<String> values) {
            addCriterion("atname not in", values, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameBetween(String value1, String value2) {
            addCriterion("atname between", value1, value2, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnameNotBetween(String value1, String value2) {
            addCriterion("atname not between", value1, value2, "atname");
            return (Criteria) this;
        }

        public Criteria andAtnumberIsNull() {
            addCriterion("atnumber is null");
            return (Criteria) this;
        }

        public Criteria andAtnumberIsNotNull() {
            addCriterion("atnumber is not null");
            return (Criteria) this;
        }

        public Criteria andAtnumberEqualTo(Integer value) {
            addCriterion("atnumber =", value, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberNotEqualTo(Integer value) {
            addCriterion("atnumber <>", value, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberGreaterThan(Integer value) {
            addCriterion("atnumber >", value, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("atnumber >=", value, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberLessThan(Integer value) {
            addCriterion("atnumber <", value, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberLessThanOrEqualTo(Integer value) {
            addCriterion("atnumber <=", value, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberIn(List<Integer> values) {
            addCriterion("atnumber in", values, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberNotIn(List<Integer> values) {
            addCriterion("atnumber not in", values, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberBetween(Integer value1, Integer value2) {
            addCriterion("atnumber between", value1, value2, "atnumber");
            return (Criteria) this;
        }

        public Criteria andAtnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("atnumber not between", value1, value2, "atnumber");
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

        public Criteria andAtpreIsNull() {
            addCriterion("atpre is null");
            return (Criteria) this;
        }

        public Criteria andAtpreIsNotNull() {
            addCriterion("atpre is not null");
            return (Criteria) this;
        }

        public Criteria andAtpreEqualTo(String value) {
            addCriterion("atpre =", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreNotEqualTo(String value) {
            addCriterion("atpre <>", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreGreaterThan(String value) {
            addCriterion("atpre >", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreGreaterThanOrEqualTo(String value) {
            addCriterion("atpre >=", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreLessThan(String value) {
            addCriterion("atpre <", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreLessThanOrEqualTo(String value) {
            addCriterion("atpre <=", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreLike(String value) {
            addCriterion("atpre like", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreNotLike(String value) {
            addCriterion("atpre not like", value, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreIn(List<String> values) {
            addCriterion("atpre in", values, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreNotIn(List<String> values) {
            addCriterion("atpre not in", values, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreBetween(String value1, String value2) {
            addCriterion("atpre between", value1, value2, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtpreNotBetween(String value1, String value2) {
            addCriterion("atpre not between", value1, value2, "atpre");
            return (Criteria) this;
        }

        public Criteria andAtposIsNull() {
            addCriterion("atpos is null");
            return (Criteria) this;
        }

        public Criteria andAtposIsNotNull() {
            addCriterion("atpos is not null");
            return (Criteria) this;
        }

        public Criteria andAtposEqualTo(String value) {
            addCriterion("atpos =", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposNotEqualTo(String value) {
            addCriterion("atpos <>", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposGreaterThan(String value) {
            addCriterion("atpos >", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposGreaterThanOrEqualTo(String value) {
            addCriterion("atpos >=", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposLessThan(String value) {
            addCriterion("atpos <", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposLessThanOrEqualTo(String value) {
            addCriterion("atpos <=", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposLike(String value) {
            addCriterion("atpos like", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposNotLike(String value) {
            addCriterion("atpos not like", value, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposIn(List<String> values) {
            addCriterion("atpos in", values, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposNotIn(List<String> values) {
            addCriterion("atpos not in", values, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposBetween(String value1, String value2) {
            addCriterion("atpos between", value1, value2, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtposNotBetween(String value1, String value2) {
            addCriterion("atpos not between", value1, value2, "atpos");
            return (Criteria) this;
        }

        public Criteria andAtimgIsNull() {
            addCriterion("atimg is null");
            return (Criteria) this;
        }

        public Criteria andAtimgIsNotNull() {
            addCriterion("atimg is not null");
            return (Criteria) this;
        }

        public Criteria andAtimgEqualTo(String value) {
            addCriterion("atimg =", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgNotEqualTo(String value) {
            addCriterion("atimg <>", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgGreaterThan(String value) {
            addCriterion("atimg >", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgGreaterThanOrEqualTo(String value) {
            addCriterion("atimg >=", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgLessThan(String value) {
            addCriterion("atimg <", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgLessThanOrEqualTo(String value) {
            addCriterion("atimg <=", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgLike(String value) {
            addCriterion("atimg like", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgNotLike(String value) {
            addCriterion("atimg not like", value, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgIn(List<String> values) {
            addCriterion("atimg in", values, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgNotIn(List<String> values) {
            addCriterion("atimg not in", values, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgBetween(String value1, String value2) {
            addCriterion("atimg between", value1, value2, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtimgNotBetween(String value1, String value2) {
            addCriterion("atimg not between", value1, value2, "atimg");
            return (Criteria) this;
        }

        public Criteria andAtlinkIsNull() {
            addCriterion("atlink is null");
            return (Criteria) this;
        }

        public Criteria andAtlinkIsNotNull() {
            addCriterion("atlink is not null");
            return (Criteria) this;
        }

        public Criteria andAtlinkEqualTo(String value) {
            addCriterion("atlink =", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkNotEqualTo(String value) {
            addCriterion("atlink <>", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkGreaterThan(String value) {
            addCriterion("atlink >", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkGreaterThanOrEqualTo(String value) {
            addCriterion("atlink >=", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkLessThan(String value) {
            addCriterion("atlink <", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkLessThanOrEqualTo(String value) {
            addCriterion("atlink <=", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkLike(String value) {
            addCriterion("atlink like", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkNotLike(String value) {
            addCriterion("atlink not like", value, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkIn(List<String> values) {
            addCriterion("atlink in", values, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkNotIn(List<String> values) {
            addCriterion("atlink not in", values, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkBetween(String value1, String value2) {
            addCriterion("atlink between", value1, value2, "atlink");
            return (Criteria) this;
        }

        public Criteria andAtlinkNotBetween(String value1, String value2) {
            addCriterion("atlink not between", value1, value2, "atlink");
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

        public Criteria andAtypeIsNull() {
            addCriterion("atype is null");
            return (Criteria) this;
        }

        public Criteria andAtypeIsNotNull() {
            addCriterion("atype is not null");
            return (Criteria) this;
        }

        public Criteria andAtypeEqualTo(String value) {
            addCriterion("atype =", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotEqualTo(String value) {
            addCriterion("atype <>", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeGreaterThan(String value) {
            addCriterion("atype >", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeGreaterThanOrEqualTo(String value) {
            addCriterion("atype >=", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLessThan(String value) {
            addCriterion("atype <", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLessThanOrEqualTo(String value) {
            addCriterion("atype <=", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLike(String value) {
            addCriterion("atype like", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotLike(String value) {
            addCriterion("atype not like", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeIn(List<String> values) {
            addCriterion("atype in", values, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotIn(List<String> values) {
            addCriterion("atype not in", values, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeBetween(String value1, String value2) {
            addCriterion("atype between", value1, value2, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotBetween(String value1, String value2) {
            addCriterion("atype not between", value1, value2, "atype");
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