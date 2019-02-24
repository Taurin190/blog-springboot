package com.taurin190.service;

import com.taurin190.BaseTest;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.repository.TagRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TagServiceTest extends BaseTest {
    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagService tagService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTagEntityById() {
        TagEntity tagEntity = getTestTagEntity();

        when(tagRepository.findById(any(Integer.class))).thenReturn(Optional.of(tagEntity));
        TagEntity actual = tagService.getTagEntityById(1);
        Set<BlogEntity> blogEntitySet = actual.getBlogList();

        assertEquals(new Integer(1), actual.getId());
        assertEquals("test", actual.getName());
        assertNotNull(blogEntitySet);
        assertEquals(10, blogEntitySet.size());
    }
}
