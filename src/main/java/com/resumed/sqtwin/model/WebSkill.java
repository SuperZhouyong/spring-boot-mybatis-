package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_skill")
public class WebSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Byte level;

    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 1参与计算2不参与计算
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
     * @return level
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * @return parentId
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取1参与计算2不参与计算
     *
     * @return status - 1参与计算2不参与计算
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置1参与计算2不参与计算
     *
     * @param status 1参与计算2不参与计算
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}