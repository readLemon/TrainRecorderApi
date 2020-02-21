package util;

import bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * created by chenyang
 * on 2020/2/21
 */
public  class UserUtil {

    private static User currentUser;
    private static Connection connection;



    public static Connection getConnection() {
        if (connection == null) {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://39.97.177.158:3306/train_recorders?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            String user = "root";
            String psw = "9588";
            Connection connection = null;
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, psw);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
        return connection;
    }

    public static void setConnection(Connection connection) {
        UserUtil.connection = connection;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserUtil.currentUser = currentUser;
    }
}
