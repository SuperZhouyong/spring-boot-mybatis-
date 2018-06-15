package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_flow_out_atonce_salary")
public class WebFlowOutAtonceSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * region id
     */
    @Column(name = "cityId")
    private Integer cityid;

    /**
     * 职位等级
     */
    @Column(name = "tplLevel")
    private Integer tpllevel;

    /**
     * 工作年份
     */
    @Column(name = "workDate")
    private Integer workdate;

    /**
     * 平均薪资
     */
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
     * 获取region id
     *
     * @return cityId - region id
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * 设置region id
     *
     * @param cityid region id
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * 获取职位等级
     *
     * @return tplLevel - 职位等级
     */
    public Integer getTpllevel() {
        return tpllevel;
    }

    /**
     * 设置职位等级
     *
     * @param tpllevel 职位等级
     */
    public void setTpllevel(Integer tpllevel) {
        this.tpllevel = tpllevel;
    }

    /**
     * 获取工作年份
     *
     * @return workDate - 工作年份
     */
    public Integer getWorkdate() {
        return workdate;
    }

    /**
     * 设置工作年份
     *
     * @param workdate 工作年份
     */
    public void setWorkdate(Integer workdate) {
        this.workdate = workdate;
    }

    /**
     * 获取平均薪资
     *
     * @return salary - 平均薪资
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置平均薪资
     *
     * @param salary 平均薪资
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}