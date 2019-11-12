package com.example.datajdbc.bean;

public class User {
    private Integer userId;
    private String userName;
    private String userPsd;
    private String userSex;

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

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
