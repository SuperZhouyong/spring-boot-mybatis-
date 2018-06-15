package com.resumed.sqtwin.model.responseban;

import java.util.Objects;

/**
 * @auther Super
 * @data 2018/6/11 0011
 * @time 下午 16:41
 */
public class IndustryDimensionsBean {
    private Integer id ;
    private String name ;
    private Boolean hasLook ;

    public IndustryDimensionsBean(Integer id, String name, Boolean hasLook) {
        this.id = id;
        this.name = name;
        this.hasLook = hasLook;
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

    public Boolean getHasLook() {
        return hasLook;
    }

    public void setHasLook(Boolean hasLook) {
        this.hasLook = hasLook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndustryDimensionsBean that = (IndustryDimensionsBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
