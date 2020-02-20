package dao;

import bean.User;

import java.sql.Connection;

public interface IUserDao {

    void register(String username, String psw);

    User login(String username, String psw);

    Connection getConnection();

}
