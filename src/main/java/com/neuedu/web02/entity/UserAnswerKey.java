package com.neuedu.web02.entity;

public class UserAnswerKey {
    private Integer examid;

    private Integer questionid;

    private Integer userid;

    public UserAnswerKey() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public UserAnswerKey(Integer examid, Integer questionid, Integer userid) {
		super();
		this.examid = examid;
		this.questionid = questionid;
		this.userid = userid;
	}

	public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}