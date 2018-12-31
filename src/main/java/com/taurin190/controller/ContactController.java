package com.taurin190.controller;

import com.taurin190.entity.HeadEntity;
import com.taurin190.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class ContactController {
    @Autowired
    private HeadService headService;

    @GetMapping("/contact")
    public ModelAndView index(ModelAndView mav) {
        HeadEntity headEntity = headService.getHeadEntity("contact");
        mav.setViewName("contact.html");
        mav.addObject("head_object", headEntity);
        return mav;
    }

    @PostMapping("/contact/send")
    public ModelAndView send(ModelAndView mav) {
        mav.setViewName("contact.html");
        return mav;
    }
}
