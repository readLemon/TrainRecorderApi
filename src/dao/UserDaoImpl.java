package dao;

import bean.ApiConfig;
import bean.User;
import dao.iface.IUserDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import util.UserUtil;

import java.sql.*;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    private PreparedStatement ps = null;

    @Override
    public String register(String username, String psw) {
        String insertSql = "INSERT INTO user (name, psw) VALUES(?,?)";
//        String autoAddSql = "ALTER TABLE user AUTO_INCREMENT =1";
//        Statement statement;
        try {
            ps = UserUtil.getConnection().prepareStatement(insertSql);
            ps.setString(1, username);
            ps.setString(2, psw);
            ps.executeLargeUpdate();
            return ApiConfig.ResponseInfo.INFO_REQUEST_SUCCESSFULL;
        } catch (SQLException e) {
            e.printStackTrace();
            return ApiConfig.ResponseInfo.STATUS_REQUEST_FAILED;
        }
    }

    @Override
    public User login(String username, String psw) {
        String sql = "SELECT * FROM user WHERE name='" + username + "'and psw='" + psw + "'";
        ResultSet rs = null;
        User user = null;
        try {
            user = new User();
            ps = UserUtil.getConnection().prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,psw);
            rs = ps.executeQuery();

            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setPsw(rs.getString("psw"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
