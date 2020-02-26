package util;

import bean.UserResult;

import java.sql.*;

/**
 * created by chenyang
 * on 2020/2/21
 */
public class UserUtil {

    private static UserResult currentUserResult;
    private static Connection connection;
    public static boolean tet = true;


    public static boolean isUserExist(String username, String mySelectSql) {
        String defaultSql = "SELECT COUNT(*) FROM user WHERE name ='" + username + "'";
        String selectSql = mySelectSql == null ? defaultSql : mySelectSql;
        try {
            Statement sm = getConnection().createStatement();
            ResultSet rs = sm.executeQuery(selectSql);
            rs.next();
            if (rs.getInt(1) == 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

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

    public static UserResult getCurrentUserResult() {
        return currentUserResult;
    }

    public static void setCurrentUserResult(UserResult currentUserResult) {
        UserUtil.currentUserResult = currentUserResult;
    }
}
