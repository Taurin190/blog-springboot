package com.taurin190.controller;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class ProfileController {
    @Autowired
    AuthorService authorService;

    @Autowired
    private HeadService headService;

    @GetMapping("/profile")
    public ModelAndView index(ModelAndView mav) {
        AuthorEntity authorEntity = authorService.getAuthorEntityById(new Integer(1));
        HeadEntity headEntity = headService.getHeadEntity("profile");
        mav.setViewName("index.html");
        mav.addObject("author", authorEntity);
        mav.addObject("head_object", headEntity);
        return mav;
    }
}
