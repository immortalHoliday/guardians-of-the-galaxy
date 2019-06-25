package com.neuedu.web02.entity;

import java.math.BigDecimal;

public class Section {
    private Integer id;

    private Integer paperid;

    private Integer sectionpart;

    private Integer counttime;

    private String name;

    private BigDecimal sectionscore;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Section() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Section(Integer id, Integer paperid, Integer sectionpart, Integer counttime, String name,
			BigDecimal sectionscore, String backup1, Integer backup2, Integer backup3) {
		super();
		this.id = id;
		this.paperid = paperid;
		this.sectionpart = sectionpart;
		this.counttime = counttime;
		this.name = name;
		this.sectionscore = sectionscore;
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

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getSectionpart() {
        return sectionpart;
    }

    public void setSectionpart(Integer sectionpart) {
        this.sectionpart = sectionpart;
    }

    public Integer getCounttime() {
        return counttime;
    }

    public void setCounttime(Integer counttime) {
        this.counttime = counttime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getSectionscore() {
        return sectionscore;
    }

    public void setSectionscore(BigDecimal sectionscore) {
        this.sectionscore = sectionscore;
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