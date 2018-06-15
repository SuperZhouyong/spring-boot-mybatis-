package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/14 0014
 * @time 下午 18:36
 */
public class WebFlowOutAtonceNativecityidBean {

    private Integer reCityId ;
    private String name ;
    private BigDecimal reValue ;
    private BigDecimal reCount ;

    public Integer getReCityId() {
        return reCityId;
    }

    public void setReCityId(Integer reCityId) {
        this.reCityId = reCityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getReValue() {
        return reValue;
    }

    public void setReValue(BigDecimal reValue) {
        this.reValue = reValue;
    }

    public BigDecimal getReCount() {
        return reCount;
    }

    public void setReCount(BigDecimal reCount) {
        this.reCount = reCount;
    }

    public WebFlowOutAtonceNativecityidBean(Integer reCityId, String name, BigDecimal reValue, BigDecimal reCount) {
        this.reCityId = reCityId;
        this.name = name;
        this.reValue = reValue;
        this.reCount = reCount;
    }
}
