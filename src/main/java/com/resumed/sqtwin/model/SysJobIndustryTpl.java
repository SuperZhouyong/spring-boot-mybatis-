package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "sys_job_industry_tpl")
public class SysJobIndustryTpl {
    @Id
    @Column(name = "job_industry_tpl_id")
    private Integer jobIndustryTplId;

    @Column(name = "job_tpl_id")
    private Integer jobTplId;

    @Column(name = "industryId")
    private Integer industryid;

    private Byte status;

    /**
     * @return job_industry_tpl_id
     */
    public Integer getJobIndustryTplId() {
        return jobIndustryTplId;
    }

    /**
     * @param jobIndustryTplId
     */
    public void setJobIndustryTplId(Integer jobIndustryTplId) {
        this.jobIndustryTplId = jobIndustryTplId;
    }

    /**
     * @return job_tpl_id
     */
    public Integer getJobTplId() {
        return jobTplId;
    }

    /**
     * @param jobTplId
     */
    public void setJobTplId(Integer jobTplId) {
        this.jobTplId = jobTplId;
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
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}