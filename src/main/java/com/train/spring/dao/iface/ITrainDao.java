package com.train.spring.dao.iface;

import com.train.spring.bean.Absent;
import com.train.spring.bean.Leave;

import java.sql.SQLException;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/21
 */
public interface ITrainDao {

    boolean addAbsent(String username, long time, String absentProject);

    boolean addLeave(String username, long time, String leaveProject, String leaveReason);

    List<Absent> getPersonalAbsents(String username) throws SQLException;

    List<Leave> getPersonalLeaves(String username) throws SQLException;

}
