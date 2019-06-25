package com.neuedu.web02.entity;

import java.util.Date;

public class Bank {
    private Integer id;

    private String name;

    private String description;

	private Date time;

    private Integer deleteflag;

    private Integer folderid;

    private String backup1;

    private Integer backup2;

    private Integer backup3;
    
    public Bank() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Bank(Integer id, String name, String description, Date time, Integer deleteflag, Integer folderid,
			String backup1, Integer backup2, Integer backup3) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.time = time;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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