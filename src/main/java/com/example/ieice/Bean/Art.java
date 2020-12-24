package com.example.ieice.Bean;

public class Art {
    private String id;
    private String title;
    private String page;
    private String href;
    private boolean overLength;
    public Art(){};
    public Art(String id,String title,String page,String href,boolean overLength){
        this.id=id;
        this.title=title;
        this.page=page;
        this.href=href;
        this.overLength=overLength;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean getOverLength() {
        return overLength;
    }

    public void setOverLength(boolean overLength) {
        this.overLength = overLength;
    }
}
