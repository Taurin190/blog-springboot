package com.taurin190.service;

import com.taurin190.entity.WorkEntity;
import com.taurin190.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    public List<WorkEntity> getAllWorkEntity() {
        List<WorkEntity> workEntityList = workRepository.findAll();
        return workEntityList;
    }
}
