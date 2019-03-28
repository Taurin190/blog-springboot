package com.taurin190.controller;

import com.taurin190.BaseTest;
import com.taurin190.entity.HeadEntity;
import com.taurin190.entity.WorkEntity;
import com.taurin190.service.HeadService;
import com.taurin190.service.WorkService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class WorkControllerTest extends BaseTest {
    @Mock
    HeadService headService;
    @Mock
    WorkService workService;
    @InjectMocks
    WorkController workController;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void work() {
        HeadEntity headEntity = getTestHeadEntity();
        List<WorkEntity> workEntityList = getTestWorkEntityList();
        when(headService.getHeadEntity("work")).thenReturn(headEntity);
        when(workService.getAllWorkEntity()).thenReturn(workEntityList);

        ModelAndView mav = new ModelAndView();
        ModelAndView actual = workController.work(null, mav);
        ModelMap map = actual.getModelMap();

        assertEquals("work.html", actual.getViewName());
        assertTrue(map.containsKey("head_object"));
        HeadEntity actualHeadEntity = (HeadEntity) map.get("head_object");
        assertTrue(map.containsKey("work_list"));
        List<WorkEntity> actualWorkEntityList = (List<WorkEntity>) map.get("work_list");

        // assert HeadEntity
        assertEquals("BLOG TEST - Title", actualHeadEntity.getTitle());
        assertEquals("This is test page", actualHeadEntity.getDescription());
        assertEquals("test", actualHeadEntity.getKeyword());
        assertEquals("http://taurin190.com", actualHeadEntity.getShareUrl());

        // assert List<BlogEntity>
        assertEquals(10, actualWorkEntityList.size());
        assertEquals(new Integer(1), actualWorkEntityList.get(0).getId());
        assertEquals("work:1", actualWorkEntityList.get(0).getName());
        assertEquals("このようなもの作りました。", actualWorkEntityList.get(0).getSummary());
        assertEquals("http://taurin190.com", actualWorkEntityList.get(0).getUrl());
        assertEquals("http://hogehoge.com/1", actualWorkEntityList.get(0).getImgUrl());
        assertEquals("2019/01/01", actualWorkEntityList.get(0).getPublishedDate());

        assertEquals(new Integer(5), actualWorkEntityList.get(4).getId());
        assertEquals("work:5", actualWorkEntityList.get(4).getName());
        assertEquals("このようなもの作りました。", actualWorkEntityList.get(4).getSummary());
        assertEquals("http://taurin190.com", actualWorkEntityList.get(4).getUrl());
        assertEquals("http://hogehoge.com/5", actualWorkEntityList.get(4).getImgUrl());
        assertEquals("2019/01/01", actualWorkEntityList.get(4).getPublishedDate());

        assertEquals(new Integer(10), actualWorkEntityList.get(9).getId());
        assertEquals("work:10", actualWorkEntityList.get(9).getName());
        assertEquals("このようなもの作りました。", actualWorkEntityList.get(9).getSummary());
        assertEquals("http://taurin190.com", actualWorkEntityList.get(9).getUrl());
        assertEquals("http://hogehoge.com/10", actualWorkEntityList.get(9).getImgUrl());
        assertEquals("2019/01/01", actualWorkEntityList.get(9).getPublishedDate());
    }
}
