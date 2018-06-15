package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_flow_atonce_industry")
public class WebFlowAtonceIndustry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provinceId")
    private Integer provinceid;

    @Column(name = "tplLevel")
    private Integer tpllevel;

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