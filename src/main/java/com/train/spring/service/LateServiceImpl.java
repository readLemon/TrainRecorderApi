package com.train.spring.service;

import com.train.spring.bean.ApiConfig;
import com.train.spring.bean.Late;
import com.train.spring.bean.Result;
import com.train.spring.dao.LateDaoImpl;
import com.train.spring.service.iface.ILateService;
import com.train.spring.util.UserUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by chenyang
 * on 2020/3/22
 */
@Service
public class LateServiceImpl implements ILateService {
    @Resource
    private LateDaoImpl lateDao;

    @Override
    public String addLate(String username, long time, int duration, String project, String team) {
        Result result = new Result();
        //判断用户是否存在
        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        boolean re = lateDao.addLate(username, time, duration, project, team);
        if (re) {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.LateInfo.ADD_LATES_SUCCESSFUL);
        } else {
            result.setStatus(ApiConfig.ResponseStatus.ADD_LATE_FAILED);
            result.setInfo(ApiConfig.LateInfo.ADD_LATES_FAILED);
        }
        return result.toJson();
    }

    @Override
    public String getLates(String username, String team) {
        List<Late> lates;
        Result result = new Result();
        //判断用户是否存在
        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        try {
            lates = lateDao.getLates(username, team);

            result.setData(lates);
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.LateInfo.GET_LATES_SUCCESSFUL);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setInfo(ApiConfig.LateInfo.GET_LATES_FAILED);
            result.setStatus(ApiConfig.ResponseStatus.GET_LATES_FAILED);
        }
        return result.toJson();
    }
}
