package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DetailControllerTest extends BaseTest{
    @Mock
    private BlogService blogService;

    @Mock
    private HeadService headService;

    @InjectMocks
    private DetailController detailController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void detail() {
        BlogEntity blogEntity = getTestBlogEntity();
        HeadEntity headEntity = getTestHeadEntity();

        when(headService.getHeadEntity(any(String.class))).thenReturn(headEntity);
        when(blogService.getBlogByEnglishTitle(any(String.class))).thenReturn(blogEntity);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = detailController.detail("test", null, mav);
        ModelMap map = actual.getModelMap();


    }
}
