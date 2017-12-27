package com.guang.gif.pojo;

import java.util.ArrayList;
import java.util.List;

public class TagExample {
    protected String orderByClause;

    protected boolean distinct;
    
    protected int limitIndex = 0;
    
    protected int limitNum = 100;

    protected List<Criteria> oredCriteria;

    public TagExample() {
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
    
    public int getLimitIndex() {
		return limitIndex;
	}

	public void setLimitIndex(int limitIndex) {
		this.limitIndex = limitIndex;
	}

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShowNumIsNull() {
            addCriterion("show_num is null");
            return (Criteria) this;
        }

        public Criteria andShowNumIsNotNull() {
            addCriterion("show_num is not null");
            return (Criteria) this;
        }

        public Criteria andShowNumEqualTo(Long value) {
            addCriterion("show_num =", value, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumNotEqualTo(Long value) {
            addCriterion("show_num <>", value, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumGreaterThan(Long value) {
            addCriterion("show_num >", value, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumGreaterThanOrEqualTo(Long value) {
            addCriterion("show_num >=", value, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumLessThan(Long value) {
            addCriterion("show_num <", value, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumLessThanOrEqualTo(Long value) {
            addCriterion("show_num <=", value, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumIn(List<Long> values) {
            addCriterion("show_num in", values, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumNotIn(List<Long> values) {
            addCriterion("show_num not in", values, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumBetween(Long value1, Long value2) {
            addCriterion("show_num between", value1, value2, "showNum");
            return (Criteria) this;
        }

        public Criteria andShowNumNotBetween(Long value1, Long value2) {
            addCriterion("show_num not between", value1, value2, "showNum");
            return (Criteria) this;
        }

        public Criteria andNamePyIsNull() {
            addCriterion("name_py is null");
            return (Criteria) this;
        }

        public Criteria andNamePyIsNotNull() {
            addCriterion("name_py is not null");
            return (Criteria) this;
        }

        public Criteria andNamePyEqualTo(String value) {
            addCriterion("name_py =", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotEqualTo(String value) {
            addCriterion("name_py <>", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyGreaterThan(String value) {
            addCriterion("name_py >", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("name_py >=", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLessThan(String value) {
            addCriterion("name_py <", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLessThanOrEqualTo(String value) {
            addCriterion("name_py <=", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLike(String value) {
            addCriterion("name_py like", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotLike(String value) {
            addCriterion("name_py not like", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyIn(List<String> values) {
            addCriterion("name_py in", values, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotIn(List<String> values) {
            addCriterion("name_py not in", values, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyBetween(String value1, String value2) {
            addCriterion("name_py between", value1, value2, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotBetween(String value1, String value2) {
            addCriterion("name_py not between", value1, value2, "namePy");
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