package com.train.spring.controller;

import com.train.spring.service.LateServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * created by chenyang
 * on 2020/3/22
 */
@Controller
public class LateController {
    @Resource
    private LateServiceImpl lateService;

    @RequestMapping(value = "/addLate", method = RequestMethod.POST)
    @ResponseBody
    public String addLate(
            @RequestParam("username") String username,
            @RequestParam("time") long time,
            @RequestParam("duration") int duration,
            @RequestParam("project") String project,
            @RequestParam("team") String team
            ) {
        return lateService.addLate(username, time, duration, project, team);
    }

    @RequestMapping(value = "/getLates", method = RequestMethod.POST)
    @ResponseBody
    public String getLates(
        @RequestParam("username") String username,
        @RequestParam("teamname") String teamname)  {
        return lateService.getLates(username, teamname);
    }



}
