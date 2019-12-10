package com.example.datajdbc.bean;


public class Task {
    private Integer taskId;
    private Integer userId;
    private String userName;
    private String title;
    private String description;
    private String postAt;
    private String refreshAt;
    private Integer bounty;
    private Integer status;
    private Integer acceptBy;
    private String acceptAt;
    private String tips;
    private String category;
    private String finishAt;
    private String expireTime;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostAt() {
        return postAt;
    }

    public void setPostAt(String postAt) {
        this.postAt = postAt;
    }

    public String getRefreshAt() {
        return refreshAt;
    }

    public void setRefreshAt(String refreshAt) {
        this.refreshAt = refreshAt;
    }

    public Integer getBounty() {
        return bounty;
    }

    public void setBounty(Integer bounty) {
        this.bounty = bounty;
    }


    public Integer getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(Integer acceptBy) {
        this.acceptBy = acceptBy;
    }

    public String getAcceptAt() {
        return acceptAt;
    }

    public void setAcceptAt(String acceptAt) {
        this.acceptAt = acceptAt;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(String finishAt) {
        this.finishAt = finishAt;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

