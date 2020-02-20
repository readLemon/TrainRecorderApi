package service;

import bean.User;
import dao.UserDaoImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource()
    UserDaoImpl userDao;

    @Override
    public String addUser(String username, String psw) {
        userDao.register(username, psw);
        return "{\"info\":注册成功}";
    }

    @Override
    public String login(String username, String psw) {
        User result = userDao.login(username, psw);
        if (!result.getPsw().equals(psw)) {
            return "{\"info\":密码错误}";
        } else {
            return "{\"info\":登录成功}";
        }
    }
}
