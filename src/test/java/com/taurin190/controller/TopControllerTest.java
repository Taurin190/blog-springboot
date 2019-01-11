package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TopControllerTest extends BaseTest {
    @Mock
    private AuthorService authorService;

    @Mock
    private BlogService blogService;

    @Mock
    private HeadService headService;

    @InjectMocks
    private TopController topController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void index() {
        AuthorEntity authorEntity = getTestAuthorEntity();
        HeadEntity headEntity = getTestHeadEntity();
        List<BlogEntity> blogEntityList = getTestBlogEntityList();

        when(authorService.getAuthorEntityById(any(Integer.class))).thenReturn(authorEntity);
        when(headService.getHeadEntity(any(String.class))).thenReturn(headEntity);
        when(blogService.getAllBlogEntity()).thenReturn(blogEntityList);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = topController.index(mav);
        ModelMap map = actual.getModelMap();

        assertEquals("index.html", actual.getViewName());
        assertTrue(map.containsKey("author"));
        AuthorEntity actualAuthorEntity = (AuthorEntity) map.get("author");
        assertTrue(map.containsKey("head_object"));
        HeadEntity actualHeadEntity = (HeadEntity) map.get("head_object");
        assertTrue(map.containsKey("blog_list"));
        List<BlogEntity> actualBlogEntityList = (List<BlogEntity>) map.get("blog_list");

        // assert AuthorEntity
        assertEquals("Koichi Taura", actualAuthorEntity.getAuthorName());
        assertEquals("Nice to meet you", actualAuthorEntity.getSelfIntroduction());
        assertEquals("https://github.com/Taurin190", actualAuthorEntity.getGithubAccount());
        assertEquals("https://twitter.com/Tauitter51", actualAuthorEntity.getTwitterAccount());
        assertTrue(actualAuthorEntity.isValid());

        // assert HeadEntity
        assertEquals("BLOG TEST - Title", actualHeadEntity.getTitle());
        assertEquals("This is test page", actualHeadEntity.getDescription());
        assertEquals("test", actualHeadEntity.getKeyword());
        assertEquals("http://taurin190.com", actualHeadEntity.getShareUrl());

        // assert List<BlogEntity>
        assertEquals(10, actualBlogEntityList.size());
        assertEquals(new Integer(1), actualBlogEntityList.get(0).getId());
        assertEquals("AAAA BBB CC 1", actualBlogEntityList.get(0).getBlogBody());
        assertEquals("TEST_BLOG:1", actualBlogEntityList.get(0).getEnglishTitle());
        assertEquals("テストブログ1", actualBlogEntityList.get(0).getTitle());
        assertEquals(new Integer(5), actualBlogEntityList.get(4).getId());
        assertEquals("AAAA BBB CC 5", actualBlogEntityList.get(4).getBlogBody());
        assertEquals("TEST_BLOG:5", actualBlogEntityList.get(4).getEnglishTitle());
        assertEquals("テストブログ5", actualBlogEntityList.get(4).getTitle());
        assertEquals(new Integer(10), actualBlogEntityList.get(9).getId());
        assertEquals("AAAA BBB CC 10", actualBlogEntityList.get(9).getBlogBody());
        assertEquals("TEST_BLOG:10", actualBlogEntityList.get(9).getEnglishTitle());
        assertEquals("テストブログ10", actualBlogEntityList.get(9).getTitle());
    }
}
