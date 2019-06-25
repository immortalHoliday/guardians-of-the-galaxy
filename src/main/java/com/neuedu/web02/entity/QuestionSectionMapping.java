package com.neuedu.web02.entity;

import java.math.BigDecimal;

public class QuestionSectionMapping extends QuestionSectionMappingKey {
    private String type;

    private String label;

    private BigDecimal score;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public QuestionSectionMapping() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public QuestionSectionMapping(String type, String label, BigDecimal score, String backup1, Integer backup2,
			Integer backup3) {
		super();
		this.type = type;
		this.label = label;
		this.score = score;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
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