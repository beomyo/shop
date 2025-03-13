package com.article.sys.controller;

import com.article.sys.bean.Region;
import com.article.sys.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("region")
public class RegionController {
    @Autowired
    private IRegionService regionService;

    @RequestMapping("getProvinces")
    @ResponseBody
    public List<Region> getProvinces() {
        return regionService.getProvinces();
    }

    @RequestMapping("getChildrenByParentId")
    @ResponseBody
    public List<Region> getChildrenByParentId(@RequestParam("parentId") int parentId) {
        return regionService.getChildrenByParentId(parentId);
    }
}