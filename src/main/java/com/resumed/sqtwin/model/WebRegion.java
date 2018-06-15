package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_region")
public class WebRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String language;

    @Column(name = "parent_id")
    private Integer parentId;

    private String path;

    private Integer grade;

    private String name;

    private String fullname;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "fPy")
    private String fpy;

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
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
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
     * @return fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return province_id
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return fPy
     */
    public String getFpy() {
        return fpy;
    }

    /**
     * @param fpy
     */
    public void setFpy(String fpy) {
        this.fpy = fpy;
    }
}