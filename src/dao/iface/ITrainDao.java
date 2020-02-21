package dao.iface;

import bean.PersonalDataBean;

import java.util.List;

/**
 * created by chenyang
 * on 2020/2/21
 */
public interface ITrainDao {

    boolean addAbsent(String username, long time, String absentProject);

    boolean addLeave(String username, long time, String leaveProject, String leaveReason);

    List<PersonalDataBean.Absent> getPersonalAbsents(String username);

    List<PersonalDataBean.Leave> getPersonalLeaves(String username);

}
