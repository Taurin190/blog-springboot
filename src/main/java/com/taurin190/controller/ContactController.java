package com.taurin190.controller;

import com.taurin190.entity.HeadEntity;
import com.taurin190.form.ContactForm;
import com.taurin190.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public ModelAndView send(
            @Validated
            @ModelAttribute ContactForm contactForm,
            BindingResult result,
            ModelAndView mav
    ) {
        if (result == null || result.hasErrors()) {
            mav.setViewName("error.html");
            return mav;
        }
        System.out.println(contactForm.getName());
        HeadEntity headEntity = headService.getHeadEntity("contact");
        mav.setViewName("contact.html");
        mav.addObject("head_object", headEntity);
        return mav;
    }
}
