package com.neuedu.web02.entity;

import java.math.BigDecimal;

public class UserExamRecord extends UserExamRecordKey {
    private Integer istest;

    private Integer duringtime;

    private Integer switchtime;

    private Integer judge;

    private BigDecimal totalgetscore;

    private Integer submitpaper;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Integer getIstest() {
        return istest;
    }

    public void setIstest(Integer istest) {
        this.istest = istest;
    }

    public Integer getDuringtime() {
        return duringtime;
    }

    public void setDuringtime(Integer duringtime) {
        this.duringtime = duringtime;
    }

    public Integer getSwitchtime() {
        return switchtime;
    }

    public void setSwitchtime(Integer switchtime) {
        this.switchtime = switchtime;
    }

    public Integer getJudge() {
        return judge;
    }

    public void setJudge(Integer judge) {
        this.judge = judge;
    }

    public BigDecimal getTotalgetscore() {
        return totalgetscore;
    }

    public void setTotalgetscore(BigDecimal totalgetscore) {
        this.totalgetscore = totalgetscore;
    }

    public Integer getSubmitpaper() {
        return submitpaper;
    }

    public void setSubmitpaper(Integer submitpaper) {
        this.submitpaper = submitpaper;
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