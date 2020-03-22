package com.train.spring.dao;

import com.train.spring.bean.Late;
import com.train.spring.dao.iface.ILateDao;
import com.train.spring.util.UserUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by chenyang
 * on 2020/3/22
 */
@Repository
public class LateDaoImpl implements ILateDao {

    private PreparedStatement ps = null;
    private Statement sm = null;

    @Override
    public boolean addLate(String username, long time, int duration, String project, String team) {
        String insertSql = "INSERT INTO p_late(name, time, duration, project, team) VALUE(?,?,?,?,?)";
        try {
            ps = UserUtil.getConnection().prepareStatement(insertSql);
            ps.setString(1,username);
            ps.setTimestamp(2,new Timestamp(time));
            ps.setInt(3, duration);
            ps.setString(4, project);
            ps.setString(5, team);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("LateDaoImpl de addLate SQLException");
        }
        return false;
    }

    @Override
    public List<Late> getLates(String username, String team) throws SQLException {
        String selectSql = "SELECT * FROM p_late Where username= '"+username+"' AND team = '"+team+"'";
        List<Late> lateList = new ArrayList<>();
        Late bean;
        sm = UserUtil.getConnection().createStatement();
        ResultSet rs = sm.executeQuery(selectSql);
        while (rs.next()) {
            bean = new Late();
            bean.setDuration(rs.getInt("duration"));
            bean.setTime(rs.getTimestamp("time").getTime());
            bean.setProject(rs.getString("project"));
            lateList.add(bean);
        }
        return lateList;
    }
}
