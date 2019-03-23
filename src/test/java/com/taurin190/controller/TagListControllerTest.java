package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.service.AuthorService;
import com.taurin190.service.BlogService;
import com.taurin190.service.HeadService;
import com.taurin190.service.TagService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TagListControllerTest extends BaseTest {
    @Mock
    private AuthorService authorService;

    @Mock
    private TagService tagService;

    @Mock
    private BlogService blogService;

    @Mock
    private HeadService headService;

    @InjectMocks
    private TagListController tagListController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void tag() {
        ModelAndView mav = new ModelAndView();
        ModelAndView actual = tagListController.tag(null, mav);
        assertEquals("tag_blog_list.html", actual.getViewName());
    }

    @Test
    public void tagList() {
        AuthorEntity authorEntity = getTestAuthorEntity();
        TagEntity tagEntity = getTestTagEntity();
        List<BlogEntity> blogEntityList = getTestBlogEntityList();
        HeadEntity headEntity = getTestHeadEntity();

        when(authorService.getAuthorEntityById(any(Integer.class))).thenReturn(authorEntity);
        when(tagService.getTagEntityById(any(Integer.class))).thenReturn(tagEntity);
        when(blogService.getAllBlogByTagId(any(Integer.class))).thenReturn(blogEntityList);
        when(headService.getHeadEntity("tag")).thenReturn(headEntity);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = tagListController.tagList(null, 1, mav);
        ModelMap map = actual.getModelMap();

        assertEquals("tag_blog_list.html", actual.getViewName());
        assertTrue(map.containsKey("author"));
        AuthorEntity actualAuthorEntity = (AuthorEntity) map.get("author");
        assertTrue(map.containsKey("tag"));
        TagEntity actualTagEntity = (TagEntity) map.get("tag");
        assertTrue(map.containsKey("blog_list"));
        List<BlogEntity> actualBlogEntityList = (List<BlogEntity>) map.get("blog_list");
        assertTrue(map.containsKey("head_object"));
        HeadEntity actualHeadEntity = (HeadEntity) map.get("head_object");

        // assert AuthorEntity
        assertEquals("Koichi Taura", actualAuthorEntity.getAuthorName());
        assertEquals("Nice to meet you", actualAuthorEntity.getSelfIntroduction());
        assertEquals("https://github.com/Taurin190", actualAuthorEntity.getGithubAccount());
        assertEquals("https://twitter.com/Tauitter51", actualAuthorEntity.getTwitterAccount());
        assertTrue(actualAuthorEntity.isValid());

        // assert TagEntity
        assertEquals(new Integer(1), actualTagEntity.getId());
        assertEquals("test", actualTagEntity.getName());

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
