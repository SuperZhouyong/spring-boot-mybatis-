package com.resumed.sqtwin.model.responseban;

import java.util.Objects;

/**
 * @auther Super
 * @data 2018/6/14 0014
 * @time 下午 16:28
 */
public class WebIndustryListBean {
    private Integer id;
    private String name;
    private Long shine;
    private boolean CanLook;

    public WebIndustryListBean(Integer id, String name, Long shine) {
        this.id = id;
        this.name = name;
        this.shine = shine;
    }

    public WebIndustryListBean(Integer id, String name, Long shine, boolean canLook) {
        this.id = id;
        this.name = name;
        this.shine = shine;
        CanLook = canLook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebIndustryListBean that = (WebIndustryListBean) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getShine() {
        return shine;
    }

    public void setShine(Long shine) {
        this.shine = shine;
    }

    public boolean isCanLook() {
        return CanLook;
    }

    public void setCanLook(boolean canLook) {
        CanLook = canLook;
    }
}

