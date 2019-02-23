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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

        when(blogService.getBlogByEnglishTitle(any(String.class))).thenReturn(blogEntity);
        when(headService.getDetailHeadEntity("detail", blogEntity)).thenReturn(headEntity);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = detailController.detail("test", null, mav);
        ModelMap map = actual.getModelMap();

        assertEquals("detail.html", actual.getViewName());
        assertTrue(map.containsKey("blog"));
        BlogEntity actualBlogEntity = (BlogEntity) map.get("blog");
        assertTrue(map.containsKey("head_object"));
        HeadEntity actualHeadEntity = (HeadEntity) map.get("head_object");

        // assert HeadEntity
        assertEquals("BLOG TEST - Title", actualHeadEntity.getTitle());
        assertEquals("This is test page", actualHeadEntity.getDescription());
        assertEquals("test", actualHeadEntity.getKeyword());
        assertEquals("http://taurin190.com", actualHeadEntity.getShareUrl());

        // assert List<BlogEntity>
        assertEquals(new Integer(1), actualBlogEntity.getId());
        assertEquals("AAAA BBB CC 1", actualBlogEntity.getBlogBody());
        assertEquals("TEST_BLOG:1", actualBlogEntity.getEnglishTitle());
        assertEquals("テストブログ1", actualBlogEntity.getTitle());

    }
}
