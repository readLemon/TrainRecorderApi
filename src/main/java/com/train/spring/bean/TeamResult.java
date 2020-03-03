package com.train.spring.bean;

/**
 * created by chenyang
 * on 2020/2/26
 */
public class TeamResult {
    private String teamName;
    private Object trainData;
    private int totalTrainCount;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Object getTrainData() {
        return trainData;
    }

    public void setTrainData(Object trainData) {
        this.trainData = trainData;
    }

    public int getTotalTrainCount() {
        return totalTrainCount;
    }

    public void setTotalTrainCount(int totalTrainCount) {
        this.totalTrainCount = totalTrainCount;
    }
}
