package com.taurin190.controller;

import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotEmpty;

@Controller
@EnableAutoConfiguration
public class DetailController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private HeadService headService;


    @GetMapping("/blog/{title}")
    public ModelAndView detail(
            @NotEmpty
            @PathVariable("title") String title,
            @Nullable
            @RequestParam("p") String page,
            ModelAndView mav) {
        BlogEntity entity = blogService.getBlogByEnglishTitle(title);
        HeadEntity headEntity = headService.getDetailHeadEntity("detail", entity);
        mav.setViewName("detail.html");
        mav.addObject("blog", entity);
        mav.addObject("head_object", headEntity);
        return mav;
    }
}
