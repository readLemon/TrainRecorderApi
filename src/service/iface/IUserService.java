package service.iface;

import bean.User;

public interface IUserService {

    String addUser(String username, String psw);
    String login(String username, String psw);

}
