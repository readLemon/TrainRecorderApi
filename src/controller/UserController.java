package controller;

import bean.ApiConfig;
import bean.Result;
import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserServiceImpl;

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
        return userServiceImpl.addUser(username, password);
    }



}
