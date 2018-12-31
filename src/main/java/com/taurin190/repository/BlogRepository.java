package com.taurin190.repository;

import com.taurin190.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
    public Optional<BlogEntity> findBlogEntityByEnglishTitleEquals(String englishTitle);
}
