package com.taurin190.controller;

import com.taurin190.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Controller
@EnableAutoConfiguration
public class DetailController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public ModelAndView detail(
            @NotEmpty
            @PathVariable("id") int id,
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        blogService.getBlogByID(id);
        mav.setViewName("detail.html");
        return mav;
    }
}
