package com.taurin190.controller;

import com.sun.istack.internal.Nullable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class ListController extends ExceptionHandleController {
    @GetMapping("/blog")
    public ModelAndView list(
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        mav.setViewName("index.html");
        return mav;
    }
}
