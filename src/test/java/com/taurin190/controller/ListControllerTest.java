package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ListControllerTest extends BaseTest {
    @Mock
    private AuthorService authorService;

    @Mock
    private BlogService blogService;

    @Mock
    private HeadService headService;

    @InjectMocks
    private ListController listController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void list() {
        ModelAndView mav = new ModelAndView();
        ModelAndView actual = listController.list(null, mav);
        ModelMap map = actual.getModelMap();
    }
}
