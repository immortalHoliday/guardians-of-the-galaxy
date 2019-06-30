package com.neuedu.web02.entity;

public class GroupUserMapping extends GroupUserMappingKey {
    private String backup1;

    private String backup2;

    private Integer backup3;

    private Integer backup4;

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }

    public Integer getBackup3() {
        return backup3;
    }

    public void setBackup3(Integer backup3) {
        this.backup3 = backup3;
    }

    public Integer getBackup4() {
        return backup4;
    }

    public void setBackup4(Integer backup4) {
        this.backup4 = backup4;
    }
}