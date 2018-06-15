package com.resumed.sqtwin.model;

import com.resumed.sqtwin.utils.DataUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Table(name = "web_resume_honor")
public class WebResumeHonor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    private String rid;

    /**
     * 时间
     */
    @Column(name = "honor_time")
    private Date honorTime;

    /**
     * 奖项
     */
    @Column(name = "honor_name")
    private String honorName;

    /**
     * 获奖所属单位
     */
    @Column(name = "org_name")
    private String orgName;

    @Column(name = "org_id")
    private Integer orgId;

    /**
     * 排序位置
     */
    private Integer rank;

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
     * @return gid
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * @param gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * 获取时间
     *
     * @return honor_time - 时间
     */
    public Date getHonorTime() {
        return honorTime;
    }

    @Transient
    private String honorTimeDay;

    public String getHonorTimeDay() {
        return honorTimeDay;
    }

    public void setHonorTimeDay(Date honorTim) {
        this.honorTimeDay = DataUtil.dfDate.get().format(honorTime);
    }

    public void setHonorTimeDay(String honorTimeDay) {
        this.honorTimeDay = honorTimeDay;
    }

    /**
     * 设置时间
     *
     * @param honorTime 时间
     */
    public void setHonorTime(Date honorTime) {
        this.honorTime = honorTime;
        if (StringUtils.isEmpty(honorTimeDay))
            setHonorTimeDay(honorTime);
    }

    /**
     * 获取奖项
     *
     * @return honor_name - 奖项
     */
    public String getHonorName() {
        return honorName;
    }

    /**
     * 设置奖项
     *
     * @param honorName 奖项
     */
    public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

    /**
     * 获取获奖所属单位
     *
     * @return org_name - 获奖所属单位
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置获奖所属单位
     *
     * @param orgName 获奖所属单位
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return org_id
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * @param orgId
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取排序位置
     *
     * @return rank - 排序位置
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置排序位置
     *
     * @param rank 排序位置
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebResumeHonor that = (WebResumeHonor) o;
        return Objects.equals(honorTime, that.honorTime) &&
                Objects.equals(honorName, that.honorName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(honorTime, honorName);
    }
}