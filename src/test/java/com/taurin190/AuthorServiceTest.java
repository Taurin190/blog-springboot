package com.taurin190;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.repository.AuthorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAuthorEntityById() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(1)
                .authorName("Koichi Taura")
                .selfIntroduction("Nice to meet you")
                .githubAccount("https://github.com/Taurin190")
                .twitterAccount("https://twitter.com/Tauitter51")
                .isValid(true)
                .build();
        when(authorRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(authorEntity));
        Optional<AuthorEntity> actual = authorRepository.findById(new Integer(1));

        assertEquals("Koichi Taura", actual.get().getAuthorName());
        assertEquals("Nice to meet you", actual.get().getSelfIntroduction());
        assertEquals("https://github.com/Taurin190", actual.get().getGithubAccount());
        assertEquals("https://twitter.com/Tauitter51", actual.get().getTwitterAccount());
        assertTrue(actual.get().isValid());
    }
}
