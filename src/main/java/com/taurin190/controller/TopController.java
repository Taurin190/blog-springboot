package com.taurin190.controller;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class TopController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        AuthorEntity entity = authorService.getAuthorEntityById(new Integer(1));
        mav.setViewName("index.html");
        mav.addObject("author", entity);
        return mav;
    }
}
