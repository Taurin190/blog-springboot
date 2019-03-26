package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.form.ContactForm;
import com.taurin190.service.HeadService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ContactControllerTest extends BaseTest {
    @Mock
    private HeadService headService;

    @Mock
    private ContactForm contactForm;

    @InjectMocks
    private ContactController contactController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void index() {
        HeadEntity headEntity = getTestHeadEntity();

        when(headService.getHeadEntity("contact")).thenReturn(headEntity);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = contactController.index(mav);
        ModelMap map = actual.getModelMap();

        assertEquals("contact.html", actual.getViewName());
        assertTrue(map.containsKey("head_object"));
        HeadEntity actualHeadEntity = (HeadEntity) map.get("head_object");

        // assert HeadEntity
        assertEquals("BLOG TEST - Title", actualHeadEntity.getTitle());
        assertEquals("This is test page", actualHeadEntity.getDescription());
        assertEquals("test", actualHeadEntity.getKeyword());
        assertEquals("http://taurin190.com", actualHeadEntity.getShareUrl());
    }

    @Test
    public void send() {
        ModelAndView mav = new ModelAndView();
        ContactForm contactForm = getTestContactForm();
        ModelAndView actual = contactController.send(contactForm,null, mav);
        assertEquals("contact.html", actual.getViewName());
    }
}
