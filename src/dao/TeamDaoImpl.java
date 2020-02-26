package dao;

import bean.Team;
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
    public List<Team> getTeamData(String teamName) throws SQLException {
        String selectSql = "SELECT * FROM team_data WHERE name='"+teamName+"'";
        List<Team> teamDatas = new ArrayList<>();
        Team team;
        sm = UserUtil.getConnection().createStatement();
        ResultSet rs = sm.executeQuery(selectSql);
        while (rs.next()) {
            team = new Team();
            team.setTeamName(rs.getString("name"));
            team.setTrainPro(rs.getString("project"));
            team.setTrainTime(rs.getTimestamp("time").getTime());
            teamDatas.add(team);
        }

        return teamDatas;
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
