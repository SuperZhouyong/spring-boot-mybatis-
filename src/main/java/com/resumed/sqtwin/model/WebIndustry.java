package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_industry")
public class WebIndustry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 行业
     */
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
     * 获取行业
     *
     * @return status - 行业
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置行业
     *
     * @param status 行业
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}