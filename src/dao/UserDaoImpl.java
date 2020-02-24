package dao;

import bean.ApiConfig;
import bean.User;
import dao.iface.IUserDao;
import org.apache.commons.logging.Log;
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
            return ApiConfig.ResponseInfo.REQUEST_SUCCESSFULL;
        } catch (SQLException e) {
            e.printStackTrace();
            return ApiConfig.ResponseInfo.REQUEST_FAILED;
        }
    }

    @Override
    public User login(String username, String psw) {

        String selectSql = "SELECT COUNT(*) FROM user WHERE name='" + username + "'and psw='" + psw + "'";
        String sql = "SELECT * FROM user WHERE name='" + username + "'and psw='" + psw + "'";
        ResultSet rs = null;
        User user = null;
        try {
            user = new User();
            ps = UserUtil.getConnection().prepareStatement(selectSql);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) == 1){
                ps = UserUtil.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPsw(rs.getString(3));
                user.setAge(rs.getInt(4));
                System.out.println("*********登录成功********");
                System.out.println("*********is:"+rs.getInt(1));
                System.out.println("*********name:"+rs.getString(2));
                System.out.println("*********age:"+rs.getInt(3));
                System.out.println("*********psw:"+rs.getString(4));

            } else {
                System.out.println("*********");
            }
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
