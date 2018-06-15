package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_doc_tpl_salary")
public class WebDocTplSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tplLevel")
    private Integer tpllevel;

    private Integer salary;

    @Column(name = "industryId")
    private Integer industryid;

    @Column(name = "provinceId")
    private Integer provinceid;

    /**
     * 省名称
     */
    @Column(name = "provinceName")
    private String provincename;

    private Integer count;

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

    /**
     * @return industryId
     */
    public Integer getIndustryid() {
        return industryid;
    }

    /**
     * @param industryid
     */
    public void setIndustryid(Integer industryid) {
        this.industryid = industryid;
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
     * 获取省名称
     *
     * @return provinceName - 省名称
     */
    public String getProvincename() {
        return provincename;
    }

    /**
     * 设置省名称
     *
     * @param provincename 省名称
     */
    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}