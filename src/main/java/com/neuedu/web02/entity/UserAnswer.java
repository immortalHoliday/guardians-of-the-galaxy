package com.neuedu.web02.entity;

import java.math.BigDecimal;

public class UserAnswer extends UserAnswerKey {
    private String useranswer;

    private BigDecimal getscore;

    private Integer state;

    private String backup1;

    private Integer backup2;

    public UserAnswer(Integer examid, Integer questionid, Integer userid, String useranswer, BigDecimal getscore,
			Integer state, String backup1, Integer backup2, Integer backup3) {
		super(examid, questionid, userid);
		this.useranswer = useranswer;
		this.getscore = getscore;
		this.state = state;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	private Integer backup3;

    public UserAnswer(Integer examid, Integer questionid, Integer userid) {
		super(examid, questionid, userid);
		// TODO 自动生成的构造函数存根
	}

	public UserAnswer() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public UserAnswer(String useranswer, BigDecimal getscore, Integer state, String backup1, Integer backup2,
			Integer backup3) {
		super();
		this.useranswer = useranswer;
		this.getscore = getscore;
		this.state = state;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public String getUseranswer() {
        return useranswer;
    }

    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer == null ? null : useranswer.trim();
    }

    public BigDecimal getGetscore() {
        return getscore;
    }

    public void setGetscore(BigDecimal getscore) {
        this.getscore = getscore;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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