package com.neuedu.web02.entity;

public class Label {
    private Integer labelid;

    private String labelname;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Label() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Label(Integer labelid, String labelname, String backup1, Integer backup2, Integer backup3) {
		super();
		this.labelid = labelid;
		this.labelname = labelname;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public Integer getLabelid() {
        return labelid;
    }

    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname == null ? null : labelname.trim();
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