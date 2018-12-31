package com.taurin190.controller;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
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
    AuthorService authorService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private HeadService headService;


    @GetMapping("/blog")
    public ModelAndView list(
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        AuthorEntity entity = authorService.getAuthorEntityById(new Integer(1));
        List<BlogEntity> entityList = blogService.getAllBlogEntity();
        HeadEntity headEntity = headService.getHeadEntity("list");
        mav.setViewName("blog_list.html");
        mav.addObject("author", entity);
        mav.addObject("blog_list", entityList);
        mav.addObject("head_object", headEntity);
        return mav;
    }
}
