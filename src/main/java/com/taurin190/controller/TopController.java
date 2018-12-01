package com.taurin190.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class TopController extends ExceptionHandleController {
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index.html");
        return mav;
    }
}
