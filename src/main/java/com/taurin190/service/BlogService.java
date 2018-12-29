package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.BlogRepository;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public BlogEntity getBlogByID(int id) {
        BlogEntity entity = blogRepository.findById(new Integer(id)).orElseThrow(NotFoundException::new);
        return entity;
    }

    public List<BlogEntity> getAllBlogEntity() {
        List<BlogEntity> blogEntities = new ArrayList<>();
        blogEntities = blogRepository.findAll(new Sort(Sort.Direction.DESC, "publishedDate"));
        return blogEntities;
    }
}
