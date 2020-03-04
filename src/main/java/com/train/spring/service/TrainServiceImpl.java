package com.train.spring.service;

import com.train.spring.bean.*;
import com.train.spring.dao.TrainDaoImpl;
import org.springframework.stereotype.Service;
import com.train.spring.service.iface.ITrainService;
import com.train.spring.util.UserUtil;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * created by chenyang
 * on 2020/2/22
 */
@Service
public class TrainServiceImpl implements ITrainService {
    @Resource
    TrainDaoImpl trainDao;

    @Override
    public String addAbsent(String username, long time, String absentProject) {
        Result result = new Result();
        //判断用户是否存在
        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        boolean re = trainDao.addAbsent(username, time, absentProject);
        if (re) {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.TrainInfo.ADD_ABSENT_SUCCESS);
        } else {
            result.setStatus(ApiConfig.ResponseStatus.ADD_ABSENT_FAILED);
            result.setInfo(ApiConfig.TrainInfo.ADD_ABSENT_FAILED);
        }
        return result.toJson();
    }

    @Override
    public String addLeave(String username, long time, String leaveProject, String leaveReason) {
        Result result = new Result();
        //判断用户是否存在
        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        boolean re = trainDao.addLeave(username, time, leaveProject, leaveReason);
        if (re) {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.TrainInfo.ADD_LEAVE_SUCCESS);
        } else {
            result.setStatus(ApiConfig.ResponseStatus.ADD_LEAVE_FAILED);
            result.setInfo(ApiConfig.TrainInfo.ADD_LEAVE_FAILED);
        }
        return result.toJson();
    }

    @Override
    public String getPersonalAbsents(String username) {
        List<Absent> absents;
        Result result = new Result();
        //判断用户是否存在
        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        try {
            absents = trainDao.getPersonalAbsents(username);


            result.setData(absents);
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.TrainInfo.GET_ABSENTS_SUCCESSFUL);

        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus(ApiConfig.ResponseStatus.GET_ABSENTS_FAILED);
            result.setInfo(ApiConfig.TrainInfo.GET_ABSENTS_FAILED);
        }

        return result.toJson();
    }

    @Override
    public String getPersonalLeaves(String username) {
        List<Leave> leaves;
        Result result = new Result();
        //判断用户是否存在
        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        try {
            leaves = trainDao.getPersonalLeaves(username);

            result.setData(leaves);
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.TrainInfo.GET_LEAVES_SUCCESSFULL);

        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus(ApiConfig.ResponseStatus.GET_LEAVES_FAILED);
            result.setInfo(ApiConfig.TrainInfo.GET_ABSENTS_FAILED);
        }
        return result.toJson();
    }
}
