package com.neuedu.web02.entity;

public class BankTeacherMappingKey {
    private Integer bankid;

    private Integer teacherid;

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

	public BankTeacherMappingKey(Integer bankid, Integer teacherid) {
		super();
		this.bankid = bankid;
		this.teacherid = teacherid;
	}

	public BankTeacherMappingKey() {
		super();
		// TODO 自动生成的构造函数存根
	}
}