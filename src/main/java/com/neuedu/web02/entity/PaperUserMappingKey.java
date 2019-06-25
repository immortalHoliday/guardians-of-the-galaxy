package com.neuedu.web02.entity;

public class PaperUserMappingKey {
    private Integer paperid;

    private Integer userid;

    public PaperUserMappingKey(Integer paperid, Integer userid) {
		super();
		this.paperid = paperid;
		this.userid = userid;
	}

	public PaperUserMappingKey() {
		super();
		// TODO 自动生成的构造函数存根
	}


    public Integer getPaperid() {
        return paperid;
    }

	public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}