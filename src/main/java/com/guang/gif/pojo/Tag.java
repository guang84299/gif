package com.guang.gif.pojo;

public class Tag {
    private Long id;

    private String name;

    private Long showNum;

    private String namePy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getShowNum() {
        return showNum;
    }

    public void setShowNum(Long showNum) {
        this.showNum = showNum;
    }

    public String getNamePy() {
        return namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy == null ? null : namePy.trim();
    }
}