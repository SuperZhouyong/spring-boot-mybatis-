package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_flow_atonce_school")
public class WebFlowAtonceSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tplLevel")
    private Integer tpllevel;

    @Column(name = "schoolProvinceId")
    private Integer schoolprovinceid;

    private Integer count;

    @Column(name = "provinceId")
    private Integer provinceid;

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
     * @return schoolProvinceId
     */
    public Integer getSchoolprovinceid() {
        return schoolprovinceid;
    }

    /**
     * @param schoolprovinceid
     */
    public void setSchoolprovinceid(Integer schoolprovinceid) {
        this.schoolprovinceid = schoolprovinceid;
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
}