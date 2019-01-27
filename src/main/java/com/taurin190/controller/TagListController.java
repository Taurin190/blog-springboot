package com.taurin190.controller;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import com.taurin190.service.TagService;
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
public class TagListController {
    @Autowired
    AuthorService authorService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private HeadService headService;

    @GetMapping("/tag")
    public ModelAndView tag(
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        mav.setViewName("tag_list.html");
        return mav;
    }

    @GetMapping("/tag/{id}")
    public ModelAndView tagList(
            @Nullable
            @RequestParam("p") String page,
            @PathVariable int id,
            ModelAndView mav) {
        AuthorEntity entity = authorService.getAuthorEntityById(new Integer(1));
        TagEntity tagEntity = tagService.getTagEntityById(id);
        List<BlogEntity> entityList = blogService.getAllBlogByTagId(id);
        HeadEntity headEntity = headService.getHeadEntity("tag");
        mav.setViewName("tag_list.html");
        mav.addObject("author", entity);
        mav.addObject("tag", tagEntity);
        mav.addObject("blog_list", entityList);
        mav.addObject("head_object", headEntity);
        return mav;
    }
}
