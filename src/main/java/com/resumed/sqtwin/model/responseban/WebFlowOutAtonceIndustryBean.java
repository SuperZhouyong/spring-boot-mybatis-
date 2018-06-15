package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/14 0014
 * @time 下午 15:37
 */
public class WebFlowOutAtonceIndustryBean {
    private Integer industryId;
    private String name ;
    private BigDecimal count ;

    public WebFlowOutAtonceIndustryBean(Integer industryId, String name, BigDecimal count) {
        this.industryId = industryId;
        this.name = name;
        this.count = count;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
