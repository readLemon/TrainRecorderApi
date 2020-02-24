package service.iface;

import bean.PersonalDataBean;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/21
 */
public interface ITrainService {

    String addAbsent(String username, long time, String absentProject);

    String addLeave(String username, long time, String leaveProject, String leaveReason);

    String getPersonalAbsents(String username);

    String getPersonalLeaves(String username);

}
