package com.train.spring.service;

import com.train.spring.bean.ApiConfig;
import com.train.spring.bean.Result;
import com.train.spring.bean.TeamResult;
import com.train.spring.dao.TeamDaoImpl;
import org.springframework.stereotype.Service;
import com.train.spring.service.iface.ITeamService;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * created by chenyang
 * on 2020/2/26
 */
@Service
public class TeamServiceImpl implements ITeamService {
    @Resource
    private TeamDaoImpl teamDao;
    @Override
    public String getTeamData(String teamName) {
        Result result = new Result();
        TeamResult teamResult = new TeamResult();
        try {
            teamResult.setTrainData(teamDao.getTeamData(teamName));
            teamResult.setTeamName(teamName);

            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.TeamInfo.GET_DATA_SUCCESSFUL);
        } catch (SQLException e) {
            result.setStatus(ApiConfig.ResponseStatus.GET_TEAM_DATA_FAILED);
            result.setInfo(ApiConfig.TeamInfo.GET_DATA_FAILED);
            e.printStackTrace();
        } finally {
            result.setData(teamResult);
        }
        return result.toJson();
    }

    @Override
    public String addTeamData(String teamName, String project, long time) {
        Result result = new Result();

        boolean isSuccess = teamDao.addTeamData(teamName, project, time);
        if (isSuccess) {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.TeamInfo.ADD_DATA_SUCCESSFUL);
        } else {
            result.setStatus(ApiConfig.ResponseStatus.ADD_TEAM_DATA_FAILED);
            result.setInfo(ApiConfig.TeamInfo.ADD_DATA_FAILED);
        }
        return result.toJson();
    }
}
