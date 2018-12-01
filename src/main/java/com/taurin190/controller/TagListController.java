package com.taurin190.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class TagListController {
    @GetMapping("/tag")
    public ModelAndView tag(
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        mav.setViewName("tag_list.html");
        return mav;
    }

    @GetMapping("/tag/{tagName}")
    public ModelAndView tagList(
            @Nullable
            @RequestParam("p") String page,
            @PathVariable String tagName,
            ModelAndView mav) {
        mav.setViewName("tag_list.html");
        return mav;
    }
}
