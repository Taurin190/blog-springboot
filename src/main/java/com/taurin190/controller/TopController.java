package com.taurin190.controller;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class TopController {
    @Autowired
    AuthorService authorService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        AuthorEntity entity = authorService.getAuthorEntityById(new Integer(1));
        List<BlogEntity> entityList = blogService.getAllBlogEntity();
        mav.setViewName("index.html");
        mav.addObject("author", entity);
        mav.addObject("blog_list", entityList);
        return mav;
    }
}
