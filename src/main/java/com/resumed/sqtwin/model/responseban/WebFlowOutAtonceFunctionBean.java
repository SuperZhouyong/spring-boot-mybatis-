package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/14 0014
 * @time 下午 15:49
 */
public class WebFlowOutAtonceFunctionBean {
    private Integer functionId ;
    private String name ;
    private BigDecimal count ;

    public WebFlowOutAtonceFunctionBean(Integer functionId, String name, BigDecimal count) {
        this.functionId = functionId;
        this.name = name;
        this.count = count;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
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
