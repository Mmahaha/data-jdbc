package com.example.datajdbc.bean;

import java.sql.Time;

public class Task {
    private int taskId;
    private int userId;
    private String title;
    private String decription;
    private Time postAt;
    private Time refreshAt;
    private int bounty;
    private int isAccept;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Time getPostAt() {
        return postAt;
    }

    public void setPostAt(Time postAt) {
        this.postAt = postAt;
    }

    public Time getRefreshAt() {
        return refreshAt;
    }

    public void setRefreshAt(Time refreshAt) {
        this.refreshAt = refreshAt;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public int isAccept() {
        return isAccept;
    }

    public void setAccept(int accept) {
        isAccept = accept;
    }
}
