package com.train.spring.bean;

/**
 * created by chenyang
 * on 2020/3/4
 */
public class Leave {
    //请假时间
    private long leaveTime;
    //请假的项目
    private String leaveProject;
    //请假的原因
    private String leaveReason;

    public long getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(long leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveProject() {
        return leaveProject;
    }

    public void setLeaveProject(String leaveProject) {
        this.leaveProject = leaveProject;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
}
