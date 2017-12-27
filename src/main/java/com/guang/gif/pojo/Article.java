package com.guang.gif.pojo;

import java.util.Date;

public class Article {
    private Long id;

    private Date cDate;

    private Long commentNum;

    private Boolean grelease;

    private String picPath;

    private String headPath;

    private String keywords;

    private Long loveNum;

    private Long showNum;

    private Long tagId;

    private String title;
    
    private Boolean meLove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public Boolean getGrelease() {
        return grelease;
    }

    public void setGrelease(Boolean grelease) {
        this.grelease = grelease;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath == null ? null : headPath.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public Long getLoveNum() {
        return loveNum;
    }

    public void setLoveNum(Long loveNum) {
        this.loveNum = loveNum;
    }

    public Long getShowNum() {
        return showNum;
    }

    public void setShowNum(Long showNum) {
        this.showNum = showNum;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

	public Boolean getMeLove() {
		return meLove;
	}

	public void setMeLove(Boolean meLove) {
		this.meLove = meLove;
	}
    
    
}