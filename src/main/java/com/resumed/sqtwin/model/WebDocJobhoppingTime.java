package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_doc_jobhopping_time")
public class WebDocJobhoppingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "functionId")
    private Integer functionid;

    @Column(name = "tplLevel")
    private Integer tpllevel;

    @Column(name = "jobHoppingTime")
    private Integer jobhoppingtime;

    @Column(name = "industryId")
    private Integer industryid;

    private Integer count;

    @Column(name = "functionName")
    private String functionname;

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
     * @return functionId
     */
    public Integer getFunctionid() {
        return functionid;
    }

    /**
     * @param functionid
     */
    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
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
     * @return jobHoppingTime
     */
    public Integer getJobhoppingtime() {
        return jobhoppingtime;
    }

    /**
     * @param jobhoppingtime
     */
    public void setJobhoppingtime(Integer jobhoppingtime) {
        this.jobhoppingtime = jobhoppingtime;
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

    /**
     * @return functionName
     */
    public String getFunctionname() {
        return functionname;
    }

    /**
     * @param functionname
     */
    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }
}