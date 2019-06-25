package com.neuedu.web02.entity;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String iconpath;

    private String mail;

    private Integer state;

    private String activecode;

    private Integer role;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public User() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public User(Integer id, String name, String password, String iconpath, String mail, Integer state,
			String activecode, Integer role, String backup1, Integer backup2, Integer backup3) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.iconpath = iconpath;
		this.mail = mail;
		this.state = state;
		this.activecode = activecode;
		this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIconpath() {
        return iconpath;
    }

    public void setIconpath(String iconpath) {
        this.iconpath = iconpath == null ? null : iconpath.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode == null ? null : activecode.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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