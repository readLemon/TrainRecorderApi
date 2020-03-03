package com.train.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
//        通过 ModelAndView 对象把模型和视图结合在一起
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("message", "hello spring mvc");
        return mav;
    }
}
