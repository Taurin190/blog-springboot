package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.BlogRepository;
import com.taurin190.repository.TagRepository;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private TagRepository tagRepository;

    public BlogEntity getBlogByID(int id) {
        BlogEntity entity = blogRepository.findById(new Integer(id)).orElseThrow(NotFoundException::new);
        return entity;
    }

    public BlogEntity getBlogByEnglishTitle(String englishTitle) {
        BlogEntity entity = blogRepository.findBlogEntityByEnglishTitleEquals(englishTitle).orElseThrow(NotFoundException::new);
        return entity;
    }

    public List<BlogEntity> getAllBlogEntity() {
        List<BlogEntity> blogEntities = new ArrayList<>();
        blogEntities = blogRepository.findAll(new Sort(Sort.Direction.DESC, "publishedDate"));
        return blogEntities;
    }

    public List<BlogEntity> getAllBlogByTagId(int tagId) {
        TagEntity tagEntity = tagRepository.findById(tagId).orElseThrow(NotFoundException::new);
        List<BlogEntity> blogEntities = new ArrayList<>(tagEntity.getBlogList());
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, YYYY");
            blogEntities.sort((a, b) -> {
                int isABefore = -1;
                try {
                    isABefore = sdf.parse(a.getPublishedDate()).before(sdf.parse(b.getPublishedDate())) ? -1: 1;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return isABefore;
            });
        return blogEntities;
    }
}
