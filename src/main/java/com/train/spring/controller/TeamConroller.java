package com.train.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.train.spring.service.TeamServiceImpl;

import javax.annotation.Resource;

/**
 * created by chenyang
 * on 2020/2/26
 */
@Controller
public class TeamConroller {

    @Resource
    TeamServiceImpl teamService;

    @RequestMapping(value = "/addTeamData",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addTeamData(
            @RequestParam String teamName,
            @RequestParam String project,
            @RequestParam long time
            ){
        return teamService.addTeamData(teamName, project, time);
    }

    @RequestMapping(value = "/getTeamData", method = RequestMethod.GET)
    @ResponseBody
    public String getTeamData(@RequestParam String teamName) {
        return teamService.getTeamData(teamName);
    }

}
