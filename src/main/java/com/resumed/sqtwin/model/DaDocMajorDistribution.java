package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "da_doc_major_distribution")
public class DaDocMajorDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "majorId")
    private Integer majorid;

    @Column(name = "majorName")
    private String majorname;

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
     * @return majorId
     */
    public Integer getMajorid() {
        return majorid;
    }

    /**
     * @param majorid
     */
    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    /**
     * @return majorName
     */
    public String getMajorname() {
        return majorname;
    }

    /**
     * @param majorname
     */
    public void setMajorname(String majorname) {
        this.majorname = majorname;
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