package com.bugsystem.domain;

public class Bug_user {
    private Integer bugUserid;

    private Integer bugId;

    private Integer userId;

    private String createTime;

    public Integer getBugUserid() {
        return bugUserid;
    }

    public void setBugUserid(Integer bugUserid) {
        this.bugUserid = bugUserid;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}