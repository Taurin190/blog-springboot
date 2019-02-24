package com.taurin190.service;

import com.taurin190.BaseTest;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class HeadServiceTest extends BaseTest {
    @InjectMocks
    private HeadService headService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void topHead() {
        HeadEntity actual = headService.getHeadEntity("top");

        assertEquals("Lighting up a Corner - Koichi Taura's Page", actual.getTitle());
        assertEquals("Portfolio site of Engineer - Koichi Taura", actual.getDescription());
        assertEquals("http://www.taurin190.com", actual.getShareUrl());
        assertEquals("blog, portfolio", actual.getKeyword());
    }

    @Test
    public void detailHead() {
        BlogEntity blogEntity = getTestBlogEntity();
        HeadEntity actual = headService.getDetailHeadEntity("detail", blogEntity);

        assertEquals("テストブログ1 - Lighting up a Corner", actual.getTitle());
        assertEquals("テストブログ1のまとめ", actual.getDescription());
        assertEquals("http://www.taurin190.com/TEST_BLOG:1", actual.getShareUrl());
        assertEquals("blog, portfolio", actual.getKeyword());
    }

    @Test
    public void invalidHead() {
        HeadEntity actual = headService.getHeadEntity("aaa");

        assertEquals("", actual.getTitle());
        assertEquals("", actual.getDescription());
        assertEquals("", actual.getShareUrl());
        assertEquals("", actual.getKeyword());
    }
}
