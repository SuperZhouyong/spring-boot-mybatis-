package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/15 0015
 * @time 上午 11:31
 */
public class WebFlowAtonceFunctionBean {
    private BigDecimal sum ;
    private Integer id ;
    private String name ;

    public WebFlowAtonceFunctionBean(BigDecimal sum, Integer id, String name) {
        this.sum = sum;
        this.id = id;
        this.name = name;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
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
}
