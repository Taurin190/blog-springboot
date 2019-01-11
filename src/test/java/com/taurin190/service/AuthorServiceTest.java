package com.taurin190.service;

import com.taurin190.BaseTest;
import com.taurin190.entity.AuthorEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.AuthorRepository;
import com.taurin190.service.AuthorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthorServiceTest extends BaseTest {
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAuthorEntityById() {
        AuthorEntity authorEntity = getTestAuthorEntity();
        when(authorRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(authorEntity));
        AuthorEntity actual = authorService.getAuthorEntityById(new Integer(1));

        assertEquals("Koichi Taura", actual.getAuthorName());
        assertEquals("Nice to meet you", actual.getSelfIntroduction());
        assertEquals("https://github.com/Taurin190", actual.getGithubAccount());
        assertEquals("https://twitter.com/Tauitter51", actual.getTwitterAccount());
        assertTrue(actual.isValid());
    }

    @Test
    public void getAuthorEntityByIdThroughNotFound() {
        when(authorRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(null));
        try {
            AuthorEntity actual = authorService.getAuthorEntityById(new Integer(1));
        } catch (NotFoundException e) {
            assertEquals("Not Found", e.getMessage());
        }
    }
}
