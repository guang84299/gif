package com.guang.gif.pojo;

import java.util.Date;

public class Comment {
    private Long id;

    private Long articleId;

    private Date cDate;

    private String content;

    private Long floor;

    private String ip;
    
    private String xip;

    private Long loveNum;
    
    private Boolean meLove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
    
    

    public String getXip() {
		return xip;
	}

	public void setXip(String xip) {
		this.xip = xip;
	}

	public Long getLoveNum() {
        return loveNum;
    }

    public void setLoveNum(Long loveNum) {
        this.loveNum = loveNum;
    }
    
    
    public Boolean getMeLove() {
		return meLove;
	}

	public void setMeLove(Boolean meLove) {
		this.meLove = meLove;
	}

	public void initXip()
    {
    		xip = ip.substring(0,5)+"***"+ip.substring(ip.length()-5,ip.length());
    }
}