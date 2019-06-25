package com.neuedu.web02.entity;

import java.util.Date;

public class Exam {
    private Integer examid;

    private String examname;

    private Date examdate;

    private Integer paperid;

    private String activecode;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Exam() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Exam(Integer examid, String examname, Date examdate, Integer paperid, String activecode, String backup1,
			Integer backup2, Integer backup3) {
		super();
		this.examid = examid;
		this.examname = examname;
		this.examdate = examdate;
		this.paperid = paperid;
		this.activecode = activecode;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname == null ? null : examname.trim();
    }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode == null ? null : activecode.trim();
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