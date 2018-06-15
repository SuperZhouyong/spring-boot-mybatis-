package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_certificate")
public class WebCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoryId")
    private Integer categoryid;

    @Column(name = "agencyId")
    private Integer agencyid;

    private String name;

    private Byte status;

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
     * @return categoryId
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * @return agencyId
     */
    public Integer getAgencyid() {
        return agencyid;
    }

    /**
     * @param agencyid
     */
    public void setAgencyid(Integer agencyid) {
        this.agencyid = agencyid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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