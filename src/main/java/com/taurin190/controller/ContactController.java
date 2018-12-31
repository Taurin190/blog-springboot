package com.taurin190.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class ContactController {

    @GetMapping("/contact")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("contact.html");
        return mav;
    }

    @PostMapping("/contact/send")
    public ModelAndView send(ModelAndView mav) {
        mav.setViewName("contact.html");
        return mav;
    }
}
