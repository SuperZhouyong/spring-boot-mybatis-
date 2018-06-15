package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_major")
public class WebMajor {
    @Id
    @Column(name = "majorId")
    private Integer majorid;

    /**
     * 专业名称
     */
    private String name;

    /**
     * 父ID
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 层级
     */
    private Byte level;

    /**
     * 技术类型还是非技术类型
     */
    private Byte type;

    /**
     * 相关组
     */
    @Column(name = "relate_group")
    private Byte relateGroup;

    /**
     * 学历;1:硕士及已上，2:本科，3:专科;
     */
    private String degree;

    /**
     * 编码
     */
    @Column(name = "major_code")
    private String majorCode;

    /**
     * 产生的年份
     */
    private String year;

    /**
     * 专业组id，用于前端显示
     */
    @Column(name = "front_major_id")
    private Integer frontMajorId;

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
     * 获取专业名称
     *
     * @return name - 专业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专业名称
     *
     * @param name 专业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父ID
     *
     * @return parentId - 父ID
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父ID
     *
     * @param parentid 父ID
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取层级
     *
     * @return level - 层级
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * 设置层级
     *
     * @param level 层级
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * 获取技术类型还是非技术类型
     *
     * @return type - 技术类型还是非技术类型
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置技术类型还是非技术类型
     *
     * @param type 技术类型还是非技术类型
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取相关组
     *
     * @return relate_group - 相关组
     */
    public Byte getRelateGroup() {
        return relateGroup;
    }

    /**
     * 设置相关组
     *
     * @param relateGroup 相关组
     */
    public void setRelateGroup(Byte relateGroup) {
        this.relateGroup = relateGroup;
    }

    /**
     * 获取学历;1:硕士及已上，2:本科，3:专科;
     *
     * @return degree - 学历;1:硕士及已上，2:本科，3:专科;
     */
    public String getDegree() {
        return degree;
    }

    /**
     * 设置学历;1:硕士及已上，2:本科，3:专科;
     *
     * @param degree 学历;1:硕士及已上，2:本科，3:专科;
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * 获取编码
     *
     * @return major_code - 编码
     */
    public String getMajorCode() {
        return majorCode;
    }

    /**
     * 设置编码
     *
     * @param majorCode 编码
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    /**
     * 获取产生的年份
     *
     * @return year - 产生的年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置产生的年份
     *
     * @param year 产生的年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取专业组id，用于前端显示
     *
     * @return front_major_id - 专业组id，用于前端显示
     */
    public Integer getFrontMajorId() {
        return frontMajorId;
    }

    /**
     * 设置专业组id，用于前端显示
     *
     * @param frontMajorId 专业组id，用于前端显示
     */
    public void setFrontMajorId(Integer frontMajorId) {
        this.frontMajorId = frontMajorId;
    }
}