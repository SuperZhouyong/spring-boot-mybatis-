package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "da_doc_working_hours_distribution")
public class DaDocWorkingHoursDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tplId")
    private Integer tplid;

    @Column(name = "functionId")
    private Integer functionid;

    @Column(name = "tplLevel")
    private Integer tpllevel;

    /**
     * 1 : 0到6个月、2:6个月到1年、3: 1年到1年6个月、4:1年6个月及以上
     */
    @Column(name = "workingHours")
    private Integer workinghours;

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
     * @return tplId
     */
    public Integer getTplid() {
        return tplid;
    }

    /**
     * @param tplid
     */
    public void setTplid(Integer tplid) {
        this.tplid = tplid;
    }

    /**
     * @return functionId
     */
    public Integer getFunctionid() {
        return functionid;
    }

    /**
     * @param functionid
     */
    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
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
     * 获取1 : 0到6个月、2:6个月到1年、3: 1年到1年6个月、4:1年6个月及以上
     *
     * @return workingHours - 1 : 0到6个月、2:6个月到1年、3: 1年到1年6个月、4:1年6个月及以上
     */
    public Integer getWorkinghours() {
        return workinghours;
    }

    /**
     * 设置1 : 0到6个月、2:6个月到1年、3: 1年到1年6个月、4:1年6个月及以上
     *
     * @param workinghours 1 : 0到6个月、2:6个月到1年、3: 1年到1年6个月、4:1年6个月及以上
     */
    public void setWorkinghours(Integer workinghours) {
        this.workinghours = workinghours;
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