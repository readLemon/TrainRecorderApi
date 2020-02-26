package dao.iface;

import bean.UserResult;

public interface IUserDao {

    String register(String username, String psw);

    UserResult login(String username, String psw);

}
