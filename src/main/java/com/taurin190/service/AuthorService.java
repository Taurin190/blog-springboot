package com.taurin190.service;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.exception.NotFoundException;
import com.taurin190.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorEntity getAuthorEntityById(Integer id) {
        AuthorEntity entity = authorRepository.findById(id).orElseThrow(NotFoundException::new);
        return entity;
    }
}
