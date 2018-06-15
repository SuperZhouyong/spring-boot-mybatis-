package com.resumed.sqtwin.model.responseban;

import java.math.BigDecimal;

/**
 * @auther Super
 * @data 2018/6/14 0014
 * @time 下午 16:17
 */
public class WebFlowSalaryBean {
    private Integer workDate ;
    private BigDecimal salary ;

    public WebFlowSalaryBean(Integer workDate, BigDecimal salary) {
        this.workDate = workDate;
        this.salary = salary;
    }

    public Integer getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Integer workDate) {
        this.workDate = workDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
