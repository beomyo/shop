package com.article.sys.service.impl;

import com.article.sys.bean.Region;
import com.article.sys.dao.RegionDao;
import com.article.sys.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService implements IRegionService {
    @Autowired
    private RegionDao regionDao;

    @Override
    public List<Region> getProvinces() {
        return regionDao.getProvinces();
    }

    @Override
    public List<Region> getChildrenByParentId(int parentId) {
        return regionDao.getChildrenByParentId(parentId);
    }
}