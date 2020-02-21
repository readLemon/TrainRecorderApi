package dao;

import bean.PersonalDataBean;
import bean.Result;
import dao.iface.ITrainDao;
import util.UserUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/21
 */
public class TrainDaoImpl implements ITrainDao {

    private PreparedStatement ps = null;

    @Override
    public boolean addAbsent(String username, long time, String absentProject) {
        String sql = "INSERT INTO absent (name, time, project) VALUES (?,?,?)";
        try {
            ps = UserUtil.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setTimestamp(2, new Timestamp(time));
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
        String sql = "INSERT INTO leave (name, project, reason) VALUES (?,?,?)";
        try {
            ps = UserUtil.getConnection().prepareStatement(sql);

            ps.setString(1, username);
            ps.setTimestamp(2, new Timestamp(time));
            ps.setString(3, leaveReason);
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
    public List<PersonalDataBean.Absent> getPersonalAbsents(String username) {
       String sql = "SELECT * FROM absent WHERE name='"+username+"'";
//        Result result = UserUtil.getConnection();
        return null;
    }

    @Override
    public List<PersonalDataBean.Leave> getPersonalLeaves(String username) {
        return null;
    }

    private boolean excuteSql(String sql)  {
        try {
            Statement st = UserUtil.getConnection().createStatement();
            int row = st.executeUpdate(sql);
            if (row == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
