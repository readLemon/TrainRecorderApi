package service;

import bean.ApiConfig;
import bean.Result;
import bean.UserResult;
import dao.UserDaoImpl;
import org.springframework.stereotype.Service;
import service.iface.IUserService;
import util.UserUtil;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource()
    UserDaoImpl userDao;

    @Override
    public String register(String username, String psw) {
        String re = userDao.register(username, psw);
        Result result = new Result();

        if (re.equals(result.getInfo())) {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.UserInfo.REGISER_SUCCESSFULL);
        } else {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_FAILED);
            result.setInfo(ApiConfig.UserInfo.REGISER_FAILED);
        }
            return Result.toJson(result);
    }

    @Override
    public String login(String username, String psw) {
        UserResult userResult = userDao.login(username, psw);
        Result result = new Result();

        if (UserUtil.isUserExist(username, null)) {
            result.setStatus(ApiConfig.ResponseStatus.INVALIB_USER);
            result.setInfo(ApiConfig.UserInfo.INVALIB_USER);
            return result.toJson();
        }

        if (userResult.getPsw().equals(psw)) {
            userResult.setListNull();
            result.setData(userResult);
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
            result.setInfo(ApiConfig.UserInfo.LOGIN_SUCCESSFULL);
        } else {
            result.setStatus(ApiConfig.ResponseStatus.REQUEST_FAILED);
            result.setInfo(ApiConfig.UserInfo.LOGIN_FAILED);
        }
        return Result.toJson(result);
    }


}
