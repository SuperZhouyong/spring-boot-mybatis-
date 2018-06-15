package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "da_doc_gender_distribution")
public class DaDocGenderDistribution {

    @Transient
    private Integer sum ;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "tplId")
    private Integer tplid;

    @Column(name = "functionId")
    private Integer functionid;

    @Column(name = "tplLevel")
    private Integer tpllevel;

    private Integer gender;

    @Column(name = "industryId")
    private Integer industryid;

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
     * @return tplId
     */
    public Integer getTplid() {
        return tplid;
    }

    /**
     * @param tplid
     */
    public void setTplid(Integer tplid) {
        this.tplid = tplid;
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
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
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
}