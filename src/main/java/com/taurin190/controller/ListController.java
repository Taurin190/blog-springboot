package com.taurin190.controller;

import com.taurin190.entity.BlogEntity;
import com.taurin190.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class ListController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public ModelAndView list(
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        List<BlogEntity> entityList = blogService.getAllBlogEntity();
        mav.setViewName("blog_list.html");
        mav.addObject("blog_list", entityList);
        return mav;
    }
}
