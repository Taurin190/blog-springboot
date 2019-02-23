package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.HeadEntity;
import com.taurin190.util.HeadUtil;
import org.springframework.stereotype.Service;

@Service
public class HeadService {
    public HeadEntity getHeadEntity(String pageName) {
        HeadEntity entity = new HeadEntity();
        entity.setTitle(HeadUtil.getProperty(pageName + ".title"));
        entity.setDescription(HeadUtil.getProperty(pageName + ".description"));
        entity.setShareUrl(HeadUtil.getProperty(pageName + ".url"));
        entity.setKeyword(HeadUtil.getProperty(pageName + ".keyword"));
        return entity;
    }

    public HeadEntity getDetailHeadEntity(String pageName, BlogEntity blogEntity) {
        HeadEntity entity = new HeadEntity();
        entity.setTitle(blogEntity.getTitle() + " " + HeadUtil.getProperty(pageName + ".title"));
        entity.setDescription(blogEntity.getSummary());
        entity.setShareUrl(HeadUtil.getProperty(pageName + ".url") + blogEntity.getEnglishTitle());
        entity.setKeyword(HeadUtil.getProperty(pageName + ".keyword"));
        return entity;
    }
}
