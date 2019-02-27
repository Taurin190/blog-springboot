package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.entity.AuthorEntity;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProfileControllerTest extends BaseTest {
    @Mock
    private AuthorService authorService;

    @Mock
    private HeadService headService;

    @InjectMocks
    private ProfileController profileController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void index() {
        AuthorEntity authorEntity = getTestAuthorEntity();
        HeadEntity headEntity = getTestHeadEntity();

        when(authorService.getAuthorEntityById(any(Integer.class))).thenReturn(authorEntity);
        when(headService.getHeadEntity(any(String.class))).thenReturn(headEntity);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = profileController.index(mav);
        ModelMap map = actual.getModelMap();

        assertEquals("profile.html", actual.getViewName());
        assertTrue(map.containsKey("author"));
        AuthorEntity actualAuthorEntity = (AuthorEntity) map.get("author");
        assertTrue(map.containsKey("head_object"));
        HeadEntity actualHeadEntity = (HeadEntity) map.get("head_object");

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
    }
}
