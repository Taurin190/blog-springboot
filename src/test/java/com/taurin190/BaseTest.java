package com.taurin190;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected BlogEntity getTestBlogEntity() {
        return BlogEntity.builder()
                .id(1)
                .blogBody("AAAA BBB CC 1")
                .englishTitle("TEST_BLOG:1")
                .title("テストブログ1")
                .authorId(1)
                .isValid(true)
                .build();
    }

    protected List<BlogEntity> getTestBlogEntityList() {
        List<BlogEntity> blogEntityList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BlogEntity blogEntity = BlogEntity.builder()
                    .id(i)
                    .blogBody("AAAA BBB CC " + String.valueOf(i))
                    .englishTitle("TEST_BLOG:" + String.valueOf(i))
                    .title("テストブログ" + String.valueOf(i))
                    .authorId(1)
                    .isValid(true)
                    .build();
            blogEntityList.add(blogEntity);
        }
        return blogEntityList;
    }

    protected AuthorEntity getTestAuthorEntity() {
        return AuthorEntity.builder()
                .id(1)
                .authorName("Koichi Taura")
                .selfIntroduction("Nice to meet you")
                .githubAccount("https://github.com/Taurin190")
                .twitterAccount("https://twitter.com/Tauitter51")
                .isValid(true)
                .build();
    }

    protected HeadEntity getTestHeadEntity() {
        return HeadEntity.builder()
                .title("BLOG TEST - Title")
                .description("This is test page")
                .keyword("test")
                .shareUrl("http://taurin190.com")
                .build();
    }
}
