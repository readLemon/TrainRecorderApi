package com.train.spring.service.iface;

/**
 * created by chenyang
 * on 2020/3/22
 */
public interface ILateService {

    String addLate(String username, long time, int duration, String project, String team);

    String getLates(String username, String team);

}
