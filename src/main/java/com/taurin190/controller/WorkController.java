package com.taurin190.controller;

import com.taurin190.entity.*;
import com.taurin190.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class WorkController {
    @Autowired
    AuthorService authorService;

    @Autowired
    private WorkService workService;

    @Autowired
    private HeadService headService;

    @GetMapping("/work")
    public ModelAndView tag(
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        HeadEntity headEntity = headService.getHeadEntity("work");
        List<WorkEntity> workEntityList = workService.getAllWorkEntity();
        mav.setViewName("work.html");
        mav.addObject("head_object", headEntity);
        mav.addObject("work_list", workEntityList);
        return mav;
    }
}
