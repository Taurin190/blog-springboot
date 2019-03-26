package com.taurin190.service;

import com.taurin190.BaseTest;
import com.taurin190.entity.WorkEntity;
import com.taurin190.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class WorkServiceTest extends BaseTest {
    @Mock
    WorkRepository workRepository;

    @InjectMocks
    WorkService workService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllWorkEntity() {
        List<WorkEntity> workEntityList = getTestWorkEntityList();
        when(workRepository.findAll()).thenReturn(workEntityList);
        List<WorkEntity> actual = workService.getAllWorkEntity();

        assertEquals(10, actual.size());
        assertEquals(new Integer(1), actual.get(0).getId());
        assertEquals("work:1", actual.get(0).getName());
        assertEquals("このようなもの作りました。", actual.get(0).getSummary());
        assertEquals("http://taurin190.com", actual.get(0).getUrl());
        assertEquals("http://hogehoge.com/1", actual.get(0).getImgUrl());
        assertEquals("2019/01/01", actual.get(0).getPublishedDate());

        assertEquals(new Integer(5), actual.get(4).getId());
        assertEquals("work:5", actual.get(4).getName());
        assertEquals("このようなもの作りました。", actual.get(4).getSummary());
        assertEquals("http://taurin190.com", actual.get(4).getUrl());
        assertEquals("http://hogehoge.com/5", actual.get(4).getImgUrl());
        assertEquals("2019/01/01", actual.get(4).getPublishedDate());

        assertEquals(new Integer(10), actual.get(9).getId());
        assertEquals("work:10", actual.get(9).getName());
        assertEquals("このようなもの作りました。", actual.get(9).getSummary());
        assertEquals("http://taurin190.com", actual.get(9).getUrl());
        assertEquals("http://hogehoge.com/10", actual.get(9).getImgUrl());
        assertEquals("2019/01/01", actual.get(9).getPublishedDate());
    }
}
