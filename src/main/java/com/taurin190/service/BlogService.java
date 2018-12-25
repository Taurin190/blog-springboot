package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public BlogEntity getBlogByID(int id) {
        BlogEntity entity = blogRepository.findById(new Integer(id)).orElseThrow(NotFoundException::new);
        return entity;
    }
}
