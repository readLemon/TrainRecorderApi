package com.train.spring.dao.iface;

import com.train.spring.bean.UserResult;

public interface IUserDao {

    String register(String username, String psw);

    UserResult login(String username, String psw);

}
