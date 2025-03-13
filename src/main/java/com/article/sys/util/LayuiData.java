package com.article.sys.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LayuiData {
    private int code=0;
    private String msg="";
    private int count=0;
    private List data;

    public LayuiData(int count, List data) {
        this.count = count;
        this.data = data;
    }
    public LayuiData() {
    }
    public LayuiData(String imgurl) {
        this.data=new ArrayList<>();
        HashMap map=new HashMap();
        map.put("src",imgurl);
        this.data.add(map);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
