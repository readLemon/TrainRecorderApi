package service.iface;

/**
 * created by chenyang
 * on 2020/2/26
 */
public interface ITeamService {
    String getTeamData(String teamName);

    String addTeamData(String teamName, String project, long time);
}
