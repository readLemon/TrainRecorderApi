package dao;

import bean.PersonalDataBean;
import bean.User;
import dao.iface.ITrainDao;
import org.springframework.stereotype.Repository;
import util.UserUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String insertSql = "INSERT INTO absent (name, time, project) VALUES (?,?,?)";
        String selectSql ="SELECT COUNT(*) FROM user WHERE name='" + username+"'";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            ps = UserUtil.getConnection().prepareStatement(selectSql) ;
            ResultSet resultSet  = ps.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) == 0) {
                return false;
            }

            ps = UserUtil.getConnection().prepareStatement(insertSql);
            ps.setString(1, username);
            ps.setTimestamp(2,new Timestamp(time));//Timestamp.valueOf(sdf.format(new Date(time))));
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

        String insertSql = "INSERT INTO leave" +
                " (name, project, reason)" +
                " VALUES ("
                + username
                + leaveProject
                + leaveReason + ")";
        String selectSql = "SELECT COUNT(name) FROM user WHERE name="+username+"";
        try {
            ps = UserUtil.getConnection().prepareStatement(selectSql) ;
            ResultSet resultSet  = ps.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) > 0) {
                return false;
            }

            Statement st = UserUtil.getConnection().createStatement();
            int row = st.executeUpdate(insertSql);
            if (row == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<PersonalDataBean.Absent> getPersonalAbsents(String username) throws SQLException {
        String sql = "SELECT * FROM absent WHERE name=" + username + "";
        List<PersonalDataBean.Absent> absents = new ArrayList<>();
            ps = UserUtil.getConnection().prepareStatement(sql);
            ResultSet queryResult = ps.executeQuery();
            while (queryResult.next()) {
                PersonalDataBean.Absent absent = new PersonalDataBean.Absent();
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
    public List<PersonalDataBean.Leave> getPersonalLeaves(String username) throws SQLException {
        String sql = "SELECT * FROM leave WHERE name=" + username + "";
        ps = UserUtil.getConnection().prepareStatement(sql);
        List<PersonalDataBean.Leave> leaves = new ArrayList<>();
        ResultSet queryResult = ps.executeQuery();
        while (queryResult.next()) {
            PersonalDataBean.Leave leave = new PersonalDataBean.Leave();
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
