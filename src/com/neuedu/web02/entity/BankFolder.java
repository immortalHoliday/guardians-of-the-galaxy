package com.neuedu.web02.entity;

public class BankFolder {
    private Integer id;

    private String name;

    private Integer deleteflag;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
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