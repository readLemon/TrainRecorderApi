package com.train.spring.controller;

import com.train.spring.bean.ApiConfig;
import com.train.spring.bean.Result;
import com.train.spring.bean.UserResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.train.spring.service.UserServiceImpl;
import com.train.spring.util.UserUtil;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userServiceImpl.login(username, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public String register(@RequestParam("username")String username, @RequestParam("password")String password) {
        System.out.println("register has be clicked");
        return userServiceImpl.register(username, password);
    }

    @RequestMapping(value = "/testJson", method = RequestMethod.GET)
    @ResponseBody
    public String register() {
        UserResult use = new UserResult();
        use.setName("55555");
        use.setPsw("156156");
        use.setAge(2222);
        System.out.println("register has be clicked");
        Result result = new Result();
        result.setStatus(ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL);
        result.setInfo(ApiConfig.ResponseInfo.REQUEST_SUCCESSFULL);
        result.setData(use);
//        result.lisy.add(use);
        System.out.println(UserUtil.tet);
        UserUtil.tet = false;
        return Result.toJson(result);
    }


}
