package com.train.spring.dao.iface;

import com.train.spring.bean.Late;

import java.sql.SQLException;
import java.util.List;

/**
 * created by chenyang
 * on 2020/3/22
 */
public interface ILateDao {

    boolean addLate(String username, long time, int duration, String project, String team) throws SQLException;

    List<Late> getLates(String username, String team) throws SQLException;
}
