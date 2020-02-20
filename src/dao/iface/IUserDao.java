package dao.iface;

import bean.User;

import java.sql.Connection;

public interface IUserDao {

    String register(String username, String psw);

    User login(String username, String psw);

    Connection getConnection();

}
