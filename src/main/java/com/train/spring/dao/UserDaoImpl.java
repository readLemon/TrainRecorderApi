package com.train.spring.dao;

import com.train.spring.bean.ApiConfig;
import com.train.spring.bean.UserResult;
import com.train.spring.dao.iface.IUserDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.train.spring.util.UserUtil;

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
    public UserResult login(String username, String psw) {
        String sql = "SELECT * FROM user WHERE name='" + username + "'and psw='" + psw + "'";
        ResultSet rs = null;
        UserResult userResult = new UserResult();
        try {

                ps = UserUtil.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                userResult.setId(rs.getInt(1));
                userResult.setName(rs.getString(2));
                userResult.setPsw(rs.getString(3));
                userResult.setAge(rs.getInt(4));
                userResult.setCaptain(rs.getBoolean(5));
                System.out.println("*********登录成功********");
                System.out.println("*********is:"+rs.getInt(1));
                System.out.println("*********name:"+rs.getString(2));
                System.out.println("*********age:"+rs.getInt(3));
                System.out.println("*********psw:"+rs.getString(4));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userResult;
    }


    private static class UserMapper implements RowMapper<UserResult> {
        @Override
        public UserResult mapRow(ResultSet resultSet, int i) throws SQLException {
            UserResult userResult = new UserResult();
            userResult.setName(resultSet.getString("username"));
            userResult.setAge(resultSet.getInt("age"));
            userResult.setId(resultSet.getInt("id"));
            return userResult;
        }
    }
}
