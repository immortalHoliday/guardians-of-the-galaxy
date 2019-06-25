package com.neuedu.web02.entity;

public class BankTeacherMapping extends BankTeacherMappingKey {
    public BankTeacherMapping(Integer bankid, Integer teacherid) {
		super(bankid, teacherid);
		// TODO 自动生成的构造函数存根
	}

	private Integer state;

    private Integer parentid;

    private String backup1;

    private Integer backup2;

    private Integer backup;

    public BankTeacherMapping() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public BankTeacherMapping(Integer state, Integer parentid, String backup1, Integer backup2, Integer backup) {
		super();
		this.state = state;
		this.parentid = parentid;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup = backup;
	}

	public BankTeacherMapping(Integer bankid, Integer teacherid, Integer state, Integer parentid, String backup1,
			Integer backup2, Integer backup) {
		super(bankid, teacherid);
		this.state = state;
		this.parentid = parentid;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup = backup;
	}

	public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getBackup() {
        return backup;
    }

    public void setBackup(Integer backup) {
        this.backup = backup;
    }
}