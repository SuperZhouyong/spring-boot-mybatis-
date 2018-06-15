package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_flow_out_atonce_functionId")
public class WebFlowOutAtonceFunctionid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * region id
     */
    @Column(name = "cityId")
    private Integer cityid;

    /**
     * 职能等级
     */
    @Column(name = "tplLevel")
    private Integer tpllevel;

    /**
     * 职能id
     */
    @Column(name = "functionId")
    private Integer functionid;

    /**
     * 人数
     */
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
     * 获取region id
     *
     * @return cityId - region id
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * 设置region id
     *
     * @param cityid region id
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * 获取职能等级
     *
     * @return tplLevel - 职能等级
     */
    public Integer getTpllevel() {
        return tpllevel;
    }

    /**
     * 设置职能等级
     *
     * @param tpllevel 职能等级
     */
    public void setTpllevel(Integer tpllevel) {
        this.tpllevel = tpllevel;
    }

    /**
     * 获取职能id
     *
     * @return functionId - 职能id
     */
    public Integer getFunctionid() {
        return functionid;
    }

    /**
     * 设置职能id
     *
     * @param functionid 职能id
     */
    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    /**
     * 获取人数
     *
     * @return count - 人数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置人数
     *
     * @param count 人数
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}