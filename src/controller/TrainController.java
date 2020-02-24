package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TrainServiceImpl;

import javax.annotation.Resource;

/**
 * created by chenyang
 * on 2020/2/22
 */
@Controller
public class TrainController {

    @Resource
    TrainServiceImpl trainService;

    @RequestMapping(value = "/addAbsent", method = RequestMethod.POST)
    @ResponseBody
    public String addAbsent(@RequestParam String username,
                            @RequestParam long time,
                            @RequestParam String project) {

        return trainService.addAbsent(username, time, project);
    }

    @RequestMapping(value = "/addLeave", method = RequestMethod.POST)
    @ResponseBody
    public String addLeave(@RequestParam String username,
                           @RequestParam long time,
                           @RequestParam String leaveProject,
                           @RequestParam String leaveReason) {

        return trainService.addLeave(username, time, leaveProject, leaveReason);
    }

    @RequestMapping(value = "/getAbsents", method = RequestMethod.POST)
    @ResponseBody
    public String getAbsents(@RequestParam String username) {

        return trainService.getPersonalAbsents(username);
    }

    @RequestMapping(value = "/getLeaves", method = RequestMethod.POST)
    @ResponseBody
    public String addAbsent(@RequestParam String username) {

        return   trainService.getPersonalLeaves(username);
    }

}
