package com.taurin190.repository;

import com.taurin190.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<WorkEntity, Integer> {
}
