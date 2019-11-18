package com.example.datajdbc.bean;

import java.sql.Time;

public class Task {
    private int taskId;
    private int userId;
    private String userName;
    private String title;
    private String description;
    private String postAt;
    private String refreshAt;
    private int bounty;
    private int isAccept;
    private int acceptBy;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public int getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(int isAccept) {
        this.isAccept = isAccept;
    }

    public int getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(int acceptBy) {
        this.acceptBy = acceptBy;
    }
}
