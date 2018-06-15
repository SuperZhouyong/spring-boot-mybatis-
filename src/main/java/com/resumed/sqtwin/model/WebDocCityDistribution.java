package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_doc_city_distribution")
public class WebDocCityDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provinceId")
    private Integer provinceid;

    @Column(name = "industryId")
    private Integer industryid;

    private Integer count;

    @Column(name = "provinceName")
    private String provincename;

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
     * @return provinceName
     */
    public String getProvincename() {
        return provincename;
    }

    /**
     * @param provincename
     */
    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
}