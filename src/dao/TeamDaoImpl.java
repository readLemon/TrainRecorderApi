package dao;

import bean.TeamTrainData;
import dao.iface.ITeamDao;
import org.springframework.stereotype.Repository;
import util.UserUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/26
 */
@Repository
public class TeamDaoImpl implements ITeamDao {
    private PreparedStatement ps = null;
    private Statement sm = null;
    @Override
    public List<TeamTrainData> getTeamData(String teamName) throws SQLException {
        String selectSql = "SELECT * FROM team_data WHERE name='"+teamName+"'";
        List<TeamTrainData> teamTrainDataData = new ArrayList<>();
        TeamTrainData teamTrainData;
        sm = UserUtil.getConnection().createStatement();
        ResultSet rs = sm.executeQuery(selectSql);
        while (rs.next()) {
            teamTrainData = new TeamTrainData();
            teamTrainData.setTrainPro(rs.getString("project"));
            teamTrainData.setTrainTime(rs.getTimestamp("time").getTime());
            teamTrainDataData.add(teamTrainData);
        }

        return teamTrainDataData;
    }

    @Override
    public boolean addTeamData(String teamName, String project, long time) {
        String insertSql = "INSERT INTO team_data(name, project, time) VALUES(?,?,?) ";
        try {
            ps = UserUtil.getConnection().prepareStatement(insertSql);
            ps.setString(1,teamName);
            ps.setString(2,project);
            ps.setTimestamp(3,new Timestamp(time));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
