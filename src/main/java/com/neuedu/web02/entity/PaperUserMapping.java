package com.neuedu.web02.entity;

public class PaperUserMapping extends PaperUserMappingKey {
    private String state;

    private String role;

    private Integer parentid;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public PaperUserMapping(Integer paperid, Integer userid, String state, String role, Integer parentid,
			String backup1, Integer backup2, Integer backup3) {
		super(paperid, userid);
		this.state = state;
		this.role = role;
		this.parentid = parentid;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public PaperUserMapping(Integer paperid, Integer userid) {
		super(paperid, userid);
		// TODO 自动生成的构造函数存根
	}

	public PaperUserMapping() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public PaperUserMapping(String state, String role, Integer parentid, String backup1, Integer backup2,
			Integer backup3) {
		super();
		this.state = state;
		this.role = role;
		this.parentid = parentid;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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