package com.article.sys.util;

public class Page {
    private int page;
    private int limit;
    private int start;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        return (page-1)*limit;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
