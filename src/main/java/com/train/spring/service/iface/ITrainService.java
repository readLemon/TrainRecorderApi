package com.train.spring.service.iface;

/**
 * created by chenyang
 * on 2020/2/21
 */
public interface ITrainService {

    String addAbsent(String username, long time, String absentProject);

    String addLeave(String username, long time, String leaveProject, String leaveReason);

    String getPersonalAbsents(String username);

    String getPersonalLeaves(String username);

}
