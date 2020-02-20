package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserServiceImpl;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
