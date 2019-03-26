package com.taurin190;

import com.taurin190.entity.*;
import com.taurin190.form.ContactForm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseTest {
    protected BlogEntity getTestBlogEntity() {
        return BlogEntity.builder()
                .id(1)
                .blogBody("AAAA BBB CC 1")
                .englishTitle("TEST_BLOG:1")
                .title("テストブログ1")
                .summary("テストブログ1のまとめ")
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

    protected TagEntity getTestTagEntity() {
        Set<BlogEntity> testBlogEntityList = new HashSet<>(getTestBlogEntityList());
        return TagEntity.builder()
                .id(1)
                .name("test")
                .blogList(testBlogEntityList)
                .build();
    }

    protected List<WorkEntity> getTestWorkEntityList() {
        List<WorkEntity> testWorkEntityList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            WorkEntity entity =
                    WorkEntity.builder()
                    .id(i)
                    .name("work:" + i)
                    .imgUrl("http://hogehoge.com/" + i)
                    .summary("このようなもの作りました。")
                    .publishedDate("2019/01/01")
                    .url("http://taurin190.com")
                    .build();
            testWorkEntityList.add(entity);
        }
        return testWorkEntityList;
    }

    protected ContactForm getTestContactForm() {
        ContactForm contactForm = new ContactForm();
        contactForm.setName("aaa");
        contactForm.setEmail("hogehoge@gmail.com");
        contactForm.setMessage("aaaaa");
        contactForm.setPhone("080-1234-5678");
        return contactForm;
    }
}
