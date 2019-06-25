package com.neuedu.web02.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BankPurchase {
    private Integer id;

    private Integer bankid;

    private Integer grade;

    private String sort;

    private Integer saletimes;

    private Integer showbank;

    private BigDecimal price;

    private Date time;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Integer getSaletimes() {
        return saletimes;
    }

    public void setSaletimes(Integer saletimes) {
        this.saletimes = saletimes;
    }

    public Integer getShowbank() {
        return showbank;
    }

    public void setShowbank(Integer showbank) {
        this.showbank = showbank;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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