package com.train.spring.bean;

/**
 * created by chenyang
 * on 2020/2/21
 */
public class Absent {
    //缺席的时间
    private long absentTime;
    //缺席的训练项目
    private String absentProject;

    public long getAbsentTime() {
        return absentTime;
    }

    public void setAbsentTime(long absentTime) {
        this.absentTime = absentTime;
    }

    public String getAbsentProject() {
        return absentProject;
    }

    public void setAbsentProject(String absentProject) {
        this.absentProject = absentProject;
    }
}


