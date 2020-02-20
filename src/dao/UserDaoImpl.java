package dao;

import bean.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    PreparedStatement ps = null;

    @Override
    public void register(String username, String psw) {
        String insertSql = "INSERT INTO user (name, psw) VALUES(?,?)";
        String autoAddSql = "ALTER TABLE user AUTO_INCREMENT =1";
        Statement statement;
        Connection connection;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(insertSql);
            statement = connection.createStatement();
            ps.setString(1, username);
            ps.setString(2, psw);
            statement.executeUpdate(autoAddSql);
            ps.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User login(String username, String psw) {
        String sql = "SELECT * FROM user WHERE name='" + username + "'and psw='" + psw + "'";
        ResultSet rs = null;
        User user = new User();
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(2, username);
            rs = ps.executeQuery();
//                if (rs.next() == null) {
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setPsw(rs.getString("psw"));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/train_recorder?useUnicode=true&characterEncoding=utf-8&useSSL=false";
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

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setName(resultSet.getString("username"));
            user.setAge(resultSet.getInt("age"));
            user.setId(resultSet.getInt("id"));
            return user;
        }
    }


}
