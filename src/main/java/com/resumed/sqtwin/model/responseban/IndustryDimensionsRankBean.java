package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/11 0011
 * @time 下午 18:15
 */
public class IndustryDimensionsRankBean {
    private Integer Id ;
    private String Name ;
    private Boolean Interested ;
    private BigDecimal count ;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getInterested() {
        return Interested;
    }

    public void setInterested(Boolean interested) {
        Interested = interested;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public IndustryDimensionsRankBean(Integer id, String name, Boolean interested, BigDecimal count) {
        Id = id;
        Name = name;
        Interested = interested;
        this.count = count;
    }
}
