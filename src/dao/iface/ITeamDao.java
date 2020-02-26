package dao.iface;

import bean.TeamTrainData;

import java.sql.SQLException;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/26
 */
public interface ITeamDao {

    List<TeamTrainData> getTeamData(String teamName) throws SQLException;

    boolean addTeamData(String teamName, String project, long time);
}
