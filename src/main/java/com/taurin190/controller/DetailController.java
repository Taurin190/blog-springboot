package com.taurin190.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class DetailController extends ExceptionHandleController{
    @GetMapping("/blog/{id}")
    public ModelAndView detail(ModelAndView mav) {
        mav.setViewName("detail.html");
        return mav;
    }
}
