package com.article.sys.dao;

import com.article.sys.bean.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionDao {
    @Select("SELECT * FROM region WHERE level = 1")
    List<Region> getProvinces();

    @Select("SELECT * FROM region WHERE parentid = #{parentId}")
    List<Region> getChildrenByParentId(int parentId);
}