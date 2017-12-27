package com.guang.gif.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;
    
    protected int limitIndex = 0;
    
    protected int limitNum = 100;

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

        public Criteria andCDateIsNull() {
            addCriterion("c_date is null");
            return (Criteria) this;
        }

        public Criteria andCDateIsNotNull() {
            addCriterion("c_date is not null");
            return (Criteria) this;
        }

        public Criteria andCDateEqualTo(Date value) {
            addCriterion("c_date =", value, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateNotEqualTo(Date value) {
            addCriterion("c_date <>", value, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateGreaterThan(Date value) {
            addCriterion("c_date >", value, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateGreaterThanOrEqualTo(Date value) {
            addCriterion("c_date >=", value, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateLessThan(Date value) {
            addCriterion("c_date <", value, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateLessThanOrEqualTo(Date value) {
            addCriterion("c_date <=", value, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateIn(List<Date> values) {
            addCriterion("c_date in", values, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateNotIn(List<Date> values) {
            addCriterion("c_date not in", values, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateBetween(Date value1, Date value2) {
            addCriterion("c_date between", value1, value2, "cDate");
            return (Criteria) this;
        }

        public Criteria andCDateNotBetween(Date value1, Date value2) {
            addCriterion("c_date not between", value1, value2, "cDate");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("comment_num is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(Long value) {
            addCriterion("comment_num =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(Long value) {
            addCriterion("comment_num <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(Long value) {
            addCriterion("comment_num >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_num >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(Long value) {
            addCriterion("comment_num <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(Long value) {
            addCriterion("comment_num <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<Long> values) {
            addCriterion("comment_num in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<Long> values) {
            addCriterion("comment_num not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(Long value1, Long value2) {
            addCriterion("comment_num between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(Long value1, Long value2) {
            addCriterion("comment_num not between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andGreleaseIsNull() {
            addCriterion("grelease is null");
            return (Criteria) this;
        }

        public Criteria andGreleaseIsNotNull() {
            addCriterion("grelease is not null");
            return (Criteria) this;
        }

        public Criteria andGreleaseEqualTo(Boolean value) {
            addCriterion("grelease =", value, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseNotEqualTo(Boolean value) {
            addCriterion("grelease <>", value, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseGreaterThan(Boolean value) {
            addCriterion("grelease >", value, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("grelease >=", value, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseLessThan(Boolean value) {
            addCriterion("grelease <", value, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseLessThanOrEqualTo(Boolean value) {
            addCriterion("grelease <=", value, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseIn(List<Boolean> values) {
            addCriterion("grelease in", values, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseNotIn(List<Boolean> values) {
            addCriterion("grelease not in", values, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseBetween(Boolean value1, Boolean value2) {
            addCriterion("grelease between", value1, value2, "grelease");
            return (Criteria) this;
        }

        public Criteria andGreleaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("grelease not between", value1, value2, "grelease");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNull() {
            addCriterion("pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNotNull() {
            addCriterion("pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicPathEqualTo(String value) {
            addCriterion("pic_path =", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotEqualTo(String value) {
            addCriterion("pic_path <>", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThan(String value) {
            addCriterion("pic_path >", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("pic_path >=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThan(String value) {
            addCriterion("pic_path <", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            addCriterion("pic_path <=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLike(String value) {
            addCriterion("pic_path like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotLike(String value) {
            addCriterion("pic_path not like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIn(List<String> values) {
            addCriterion("pic_path in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotIn(List<String> values) {
            addCriterion("pic_path not in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            addCriterion("pic_path between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            addCriterion("pic_path not between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathIsNull() {
            addCriterion("head_path is null");
            return (Criteria) this;
        }

        public Criteria andHeadPathIsNotNull() {
            addCriterion("head_path is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPathEqualTo(String value) {
            addCriterion("head_path =", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotEqualTo(String value) {
            addCriterion("head_path <>", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathGreaterThan(String value) {
            addCriterion("head_path >", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathGreaterThanOrEqualTo(String value) {
            addCriterion("head_path >=", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLessThan(String value) {
            addCriterion("head_path <", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLessThanOrEqualTo(String value) {
            addCriterion("head_path <=", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLike(String value) {
            addCriterion("head_path like", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotLike(String value) {
            addCriterion("head_path not like", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathIn(List<String> values) {
            addCriterion("head_path in", values, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotIn(List<String> values) {
            addCriterion("head_path not in", values, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathBetween(String value1, String value2) {
            addCriterion("head_path between", value1, value2, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotBetween(String value1, String value2) {
            addCriterion("head_path not between", value1, value2, "headPath");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andLoveNumIsNull() {
            addCriterion("love_num is null");
            return (Criteria) this;
        }

        public Criteria andLoveNumIsNotNull() {
            addCriterion("love_num is not null");
            return (Criteria) this;
        }

        public Criteria andLoveNumEqualTo(Long value) {
            addCriterion("love_num =", value, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumNotEqualTo(Long value) {
            addCriterion("love_num <>", value, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumGreaterThan(Long value) {
            addCriterion("love_num >", value, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumGreaterThanOrEqualTo(Long value) {
            addCriterion("love_num >=", value, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumLessThan(Long value) {
            addCriterion("love_num <", value, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumLessThanOrEqualTo(Long value) {
            addCriterion("love_num <=", value, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumIn(List<Long> values) {
            addCriterion("love_num in", values, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumNotIn(List<Long> values) {
            addCriterion("love_num not in", values, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumBetween(Long value1, Long value2) {
            addCriterion("love_num between", value1, value2, "loveNum");
            return (Criteria) this;
        }

        public Criteria andLoveNumNotBetween(Long value1, Long value2) {
            addCriterion("love_num not between", value1, value2, "loveNum");
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

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Long value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Long value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Long value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Long value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Long value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Long> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Long> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Long value1, Long value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Long value1, Long value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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