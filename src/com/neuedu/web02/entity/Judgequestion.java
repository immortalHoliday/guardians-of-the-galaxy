package com.neuedu.web02.entity;

public class Judgequestion {
    private Integer id;

    private Integer typeid;

    private Integer difflevel;

    private Integer labelid;

    private String answer;

    private String description;

    private String descriptioniconpath;

    private String analysis;

    private String analysisiconpath;

    private Integer bankid;

    private String backup1;

    private Integer backup2;

    private Integer backup3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getDifflevel() {
        return difflevel;
    }

    public void setDifflevel(Integer difflevel) {
        this.difflevel = difflevel;
    }

    public Integer getLabelid() {
        return labelid;
    }

    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDescriptioniconpath() {
        return descriptioniconpath;
    }

    public void setDescriptioniconpath(String descriptioniconpath) {
        this.descriptioniconpath = descriptioniconpath == null ? null : descriptioniconpath.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getAnalysisiconpath() {
        return analysisiconpath;
    }

    public void setAnalysisiconpath(String analysisiconpath) {
        this.analysisiconpath = analysisiconpath == null ? null : analysisiconpath.trim();
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
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