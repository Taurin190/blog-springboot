package com.taurin190.service;

import com.taurin190.BaseTest;
import com.taurin190.entity.BlogEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.BlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BlogServiceTest extends BaseTest {
    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBlogByID() {
        BlogEntity entity = getTestBlogEntity();
        when(blogRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(entity));
        BlogEntity actual = blogService.getBlogByID(1);

        assertEquals("テストブログ1", actual.getTitle());
        assertEquals("TEST_BLOG:1", actual.getEnglishTitle());
        assertEquals("AAAA BBB CC 1", actual.getBlogBody());
    }

    @Test
    public void getBlogByEnglishTitle() {
        BlogEntity entity = getTestBlogEntity();
        when(blogRepository.findBlogEntityByEnglishTitleEquals(any(String.class))).thenReturn(java.util.Optional.ofNullable(entity));
        BlogEntity actual = blogService.getBlogByEnglishTitle("TEST_BLOG:1");

        assertEquals("テストブログ1", actual.getTitle());
        assertEquals("TEST_BLOG:1", actual.getEnglishTitle());
        assertEquals("AAAA BBB CC 1", actual.getBlogBody());
    }

    @Test
    public void getAllBlogEntity() {
        List<BlogEntity> blogEntityList = getTestBlogEntityList();
        when(blogRepository.findAll(new Sort(Sort.Direction.DESC, "publishedDate"))).thenReturn(blogEntityList);
        List<BlogEntity> actualBlogEntityList = blogService.getAllBlogEntity();

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

    @Test
    public void getBlogByIDThrowNotFound() {
        when(blogRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(null));
        try {
            BlogEntity actual = blogService.getBlogByID(new Integer(1));
        } catch (NotFoundException e) {
            assertEquals("Not Found", e.getMessage());
        }
    }

    @Test
    public void getBlogByEnglishTitleThrowNotFound() {
        when(blogRepository.findBlogEntityByEnglishTitleEquals(any(String.class))).thenReturn(java.util.Optional.ofNullable(null));
        try {
            BlogEntity actual = blogService.getBlogByEnglishTitle("TEST_BLOG:1");
        } catch (NotFoundException e) {
            assertEquals("Not Found", e.getMessage());
        }
    }

}
