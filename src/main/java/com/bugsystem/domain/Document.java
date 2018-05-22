package com.bugsystem.domain;

public class Document {
    private Integer documId;

    private String documUrl;

    private String documType;

    private Integer projectId;

    private String createTime;

    public Integer getDocumId() {
        return documId;
    }

    public void setDocumId(Integer documId) {
        this.documId = documId;
    }

    public String getDocumUrl() {
        return documUrl;
    }

    public void setDocumUrl(String documUrl) {
        this.documUrl = documUrl;
    }

    public String getDocumType() {
        return documType;
    }

    public void setDocumType(String documType) {
        this.documType = documType;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}