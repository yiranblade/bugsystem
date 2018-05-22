package com.bugsystem.domain;

public class Bug {
    private Integer bugId;

    private String bugName;

    private String detail;

    private Integer projectId;

    private Integer level;

    private Integer finishedStatus;

    private String createTime;

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFinishedStatus() {
        return finishedStatus;
    }

    public void setFinishedStatus(Integer finishedStatus) {
        this.finishedStatus = finishedStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}