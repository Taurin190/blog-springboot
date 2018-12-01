package com.taurin190.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class TopController {
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index.html");
        return mav;
    }
}
