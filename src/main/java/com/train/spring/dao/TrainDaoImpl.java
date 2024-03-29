package com.train.spring.dao;

import com.train.spring.bean.Absent;
import com.train.spring.bean.Leave;
import com.train.spring.dao.iface.ITrainDao;
import org.springframework.stereotype.Repository;
import com.train.spring.util.UserUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/21
 */
@Repository
public class TrainDaoImpl implements ITrainDao {

    private PreparedStatement ps = null;

    @Override
    public boolean addAbsent(String username, long time, String absentProject) {
        String insertSql = "INSERT INTO p_absent (name, time, project) VALUES (?,?,?)";
        try {

            ps = UserUtil.getConnection().prepareStatement(insertSql);
            ps.setString(1, username);
            ps.setTimestamp(2, new Timestamp(time));//Timestamp.valueOf(sdf.format(new Date(time))));
            ps.setString(3, absentProject);
            int re = ps.executeUpdate();
            if (re == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLeave(String username, long time, String leaveProject, String leaveReason) {

//        String insertSql = "INSERT INTO leave(name,project,reason) VALUES(" + username+"," + leaveProject+"," + leaveReason + ")";

        String insertSql = "INSERT INTO p_leave(name,project,reason) VALUES(?,?,?)";
        try {
            ps = UserUtil.getConnection().prepareStatement(insertSql);
            ps.setString(1, username);
            ps.setString(2, leaveProject);
            ps.setString(3, leaveReason);
            int row = ps.executeUpdate();
            if (row == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Absent> getPersonalAbsents(String username) throws SQLException {
        String sql = "SELECT * FROM p_absent WHERE name='" + username + "'";
        List<Absent> absents = new ArrayList<>();

        ps = UserUtil.getConnection().prepareStatement(sql);
        ResultSet queryResult = ps.executeQuery();
        while (queryResult.next()) {
            Absent absent = new Absent();
            absent.setAbsentTime(queryResult.getTimestamp("time").getTime());
            absent.setAbsentProject(queryResult.getString("project"));
            absents.add(absent);
        }
        ps.close();
        queryResult.close();
        UserUtil.getConnection().close();
        return absents;
    }

    @Override
    public List<Leave> getPersonalLeaves(String username) throws SQLException {
        String sql = "SELECT * FROM p_leave WHERE name='" + username + "'";
        ps = UserUtil.getConnection().prepareStatement(sql);
        List<Leave> leaves = new ArrayList<>();
        ResultSet queryResult = ps.executeQuery();

        while (queryResult.next()) {
            Leave leave = new Leave();
            leave.setLeaveProject(queryResult.getString("project"));
            leave.setLeaveReason(queryResult.getString("reason"));
            leave.setLeaveTime(queryResult.getTimestamp("time").getTime());
            leaves.add(leave);
        }
        if (ps != null) {
            ps.close();
        }
        queryResult.close();
        UserUtil.getConnection().close();
        return leaves;
    }

}
