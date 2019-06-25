package com.neuedu.web02.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Paper {
    private Integer id;

    private String description;

    private Integer teacherid;

    private Integer state;

    private Date papertime;

    private Integer counttime;

    private BigDecimal totalscore;

    private Integer deleteflag;

    private Integer folderid;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Paper() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Paper(Integer id, String description, Integer teacherid, Integer state, Date papertime, Integer counttime,
			BigDecimal totalscore, Integer deleteflag, Integer folderid, String backup1, Integer backup2,
			Integer backup3) {
		super();
		this.id = id;
		this.description = description;
		this.teacherid = teacherid;
		this.state = state;
		this.papertime = papertime;
		this.counttime = counttime;
		this.totalscore = totalscore;
		this.deleteflag = deleteflag;
		this.folderid = folderid;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getPapertime() {
        return papertime;
    }

    public void setPapertime(Date papertime) {
        this.papertime = papertime;
    }

    public Integer getCounttime() {
        return counttime;
    }

    public void setCounttime(Integer counttime) {
        this.counttime = counttime;
    }

    public BigDecimal getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(BigDecimal totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getFolderid() {
        return folderid;
    }

    public void setFolderid(Integer folderid) {
        this.folderid = folderid;
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