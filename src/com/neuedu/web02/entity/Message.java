package com.neuedu.web02.entity;

public class Message {
    private Integer id;

    private Integer senduserid;

    private Integer getuserid;

    private String message;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(Integer senduserid) {
        this.senduserid = senduserid;
    }

    public Integer getGetuserid() {
        return getuserid;
    }

    public void setGetuserid(Integer getuserid) {
        this.getuserid = getuserid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    public Integer getBackup2() {
        return backup2;
    }

    public void setBackup2(Integer backup2) {
        this.backup2 = backup2;
    }

    public Integer getBackup3() {
        return backup3;
    }

    public void setBackup3(Integer backup3) {
        this.backup3 = backup3;
    }
}