package com.taurin190.service;

import com.taurin190.entity.TagEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public TagEntity getTagEntityById(int id) {
        return tagRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
