package com.article.sys.service;

import com.article.sys.bean.Region;

import java.util.List;

public interface IRegionService {
    List<Region> getProvinces();
    List<Region> getChildrenByParentId(int parentId);
}