package com.train.spring.service.iface;

public interface IUserService {

    String register(String username, String psw);
    String login(String username, String psw);

}
