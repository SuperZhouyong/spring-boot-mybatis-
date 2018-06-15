package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/14 0014
 * @time 下午 17:34
 */
public class WebDocJobDistrBean {
    private BigDecimal count;
    private Integer tplId ;
    private String tplName ;

    public WebDocJobDistrBean(BigDecimal count, Integer tplId, String tplName) {
        this.count = count;
        this.tplId = tplId;
        this.tplName = tplName;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Integer getTplId() {
        return tplId;
    }

    public void setTplId(Integer tplId) {
        this.tplId = tplId;
    }

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
    }
}
