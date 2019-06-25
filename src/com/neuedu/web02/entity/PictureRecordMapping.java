package com.neuedu.web02.entity;

public class PictureRecordMapping {
    private Integer id;

    private Integer examrecordid;

    private String iconpath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamrecordid() {
        return examrecordid;
    }

    public void setExamrecordid(Integer examrecordid) {
        this.examrecordid = examrecordid;
    }

    public String getIconpath() {
        return iconpath;
    }

    public void setIconpath(String iconpath) {
        this.iconpath = iconpath == null ? null : iconpath.trim();
    }
}