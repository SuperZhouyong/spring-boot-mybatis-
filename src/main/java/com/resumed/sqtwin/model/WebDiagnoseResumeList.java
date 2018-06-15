package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_diagnose_resume_list")
public class WebDiagnoseResumeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    private String rid;

    @Column(name = "createAt")
    private Date createat;

    /**
     * 是否关联职位
     */
    @Column(name = "is_associate_job")
    private Byte isAssociateJob;

    /**
     * 意向行业
     */
    @Column(name = "intension_industry")
    private Integer intensionIndustry;

    /**
     * 意向职位id
     */
    @Column(name = "intension_function_id")
    private Integer intensionFunctionId;

    /**
     * 意向职位name
     */
    @Column(name = "intension_function_name")
    private String intensionFunctionName;

    /**
     * 0: 社招  1校招
     */
    @Column(name = "recruit_type")
    private Byte recruitType;

    /**
     * 0 未研究的职位
     */
    @Column(name = "is_merge")
    private Byte isMerge;

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
     * @return gid
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * @param gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * @return createAt
     */
    public Date getCreateat() {
        return createat;
    }

    /**
     * @param createat
     */
    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    /**
     * 获取是否关联职位
     *
     * @return is_associate_job - 是否关联职位
     */
    public Byte getIsAssociateJob() {
        return isAssociateJob;
    }

    /**
     * 设置是否关联职位
     *
     * @param isAssociateJob 是否关联职位
     */
    public void setIsAssociateJob(Byte isAssociateJob) {
        this.isAssociateJob = isAssociateJob;
    }

    /**
     * 获取意向行业
     *
     * @return intension_industry - 意向行业
     */
    public Integer getIntensionIndustry() {
        return intensionIndustry;
    }

    /**
     * 设置意向行业
     *
     * @param intensionIndustry 意向行业
     */
    public void setIntensionIndustry(Integer intensionIndustry) {
        this.intensionIndustry = intensionIndustry;
    }

    /**
     * 获取意向职位id
     *
     * @return intension_function_id - 意向职位id
     */
    public Integer getIntensionFunctionId() {
        return intensionFunctionId;
    }

    /**
     * 设置意向职位id
     *
     * @param intensionFunctionId 意向职位id
     */
    public void setIntensionFunctionId(Integer intensionFunctionId) {
        this.intensionFunctionId = intensionFunctionId;
    }

    /**
     * 获取意向职位name
     *
     * @return intension_function_name - 意向职位name
     */
    public String getIntensionFunctionName() {
        return intensionFunctionName;
    }

    /**
     * 设置意向职位name
     *
     * @param intensionFunctionName 意向职位name
     */
    public void setIntensionFunctionName(String intensionFunctionName) {
        this.intensionFunctionName = intensionFunctionName;
    }

    /**
     * 获取0: 社招  1校招
     *
     * @return recruit_type - 0: 社招  1校招
     */
    public Byte getRecruitType() {
        return recruitType;
    }

    /**
     * 设置0: 社招  1校招
     *
     * @param recruitType 0: 社招  1校招
     */
    public void setRecruitType(Byte recruitType) {
        this.recruitType = recruitType;
    }

    /**
     * 获取0 未研究的职位
     *
     * @return is_merge - 0 未研究的职位
     */
    public Byte getIsMerge() {
        return isMerge;
    }

    /**
     * 设置0 未研究的职位
     *
     * @param isMerge 0 未研究的职位
     */
    public void setIsMerge(Byte isMerge) {
        this.isMerge = isMerge;
    }
}