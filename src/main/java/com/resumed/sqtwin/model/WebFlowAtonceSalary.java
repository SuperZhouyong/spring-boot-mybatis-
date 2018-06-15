package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_flow_atonce_salary")
public class WebFlowAtonceSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provinceId")
    private Integer provinceid;

    @Column(name = "tplLevel")
    private Integer tpllevel;

    @Column(name = "workDate")
    private Integer workdate;

    private Integer salary;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return provinceId
     */
    public Integer getProvinceid() {
        return provinceid;
    }

    /**
     * @param provinceid
     */
    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    /**
     * @return tplLevel
     */
    public Integer getTpllevel() {
        return tpllevel;
    }

    /**
     * @param tpllevel
     */
    public void setTpllevel(Integer tpllevel) {
        this.tpllevel = tpllevel;
    }

    /**
     * @return workDate
     */
    public Integer getWorkdate() {
        return workdate;
    }

    /**
     * @param workdate
     */
    public void setWorkdate(Integer workdate) {
        this.workdate = workdate;
    }

    /**
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}