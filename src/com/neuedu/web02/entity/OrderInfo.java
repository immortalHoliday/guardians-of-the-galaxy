package com.neuedu.web02.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    private Integer id;

    private Date time;

    private String name;

    private Integer salerid;

    private BigDecimal amount;

    private Integer state;

    private Integer operation;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSalerid() {
        return salerid;
    }

    public void setSalerid(Integer salerid) {
        this.salerid = salerid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
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