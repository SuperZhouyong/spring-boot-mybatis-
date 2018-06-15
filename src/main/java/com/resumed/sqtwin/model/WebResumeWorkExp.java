package com.resumed.sqtwin.model;

import com.resumed.sqtwin.utils.DataUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Table(name = "web_resume_work_exp")
public class WebResumeWorkExp {
    @Id
    @Column(name = "work_exp_id")
    private Integer workExpId;

    private Integer gid;

    private String rid;




    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 企业全名
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 企业id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 企业类型
     */
    @Column(name = "company_type_id")
    private Byte companyTypeId;

    // 企业类型Id
    @Transient
    private String companyTypeIdName ;

    public String getCompanyTypeIdName() {
        return companyTypeIdName;
    }

    public void setCompanyTypeIdName(String companyTypeIdName) {
        this.companyTypeIdName = companyTypeIdName;
    }

    public String getScaleIdName() {
        return scaleIdName;
    }

    public void setScaleIdName(String scaleIdName) {
        this.scaleIdName = scaleIdName;
    }

    /**
     * 行业Id
     */
    @Column(name = "industry_id")
    private Integer industryId;

    @Column(name = "industry_name")
    private String industryName;

    /**
     * 模板id
     */
    @Column(name = "tpl_id")
    private Integer tplId;

    /**
     * 模板名称
     */
    @Column(name = "tpl_name")
    private String tplName;

    /**
     * 职位名称
     */
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "salary_start")
    private Integer salaryStart;

    @Column(name = "salary_end")
    private Integer salaryEnd;

    /**
     * 排序位置
     */
    private Integer rank;

    /**
     * 企业规模
     */
    @Column(name = "scale_id")
    private Byte scaleId;

    // 规模名字
    @Transient
    private String scaleIdName ;

    /**
     * 1 没有标准职位或有标准职位且加载 0 有标准职位且加载
     */
//    private Byte load;

    @Column(name = "p_work_exp_id")
    private Integer pWorkExpId;

    /**
     * 工作职责
     */
    @Column(name = "work_resp")
    private String workResp;

    /**
     * @return work_exp_id
     */
    public Integer getWorkExpId() {
        return workExpId;
    }

    /**
     * @param workExpId
     */
    public void setWorkExpId(Integer workExpId) {
        this.workExpId = workExpId;
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
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
        if (StringUtils.isEmpty(startTimeDay))
            setStartTimeDay(startTime);
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }


    @Transient
    private String startTimeDay;
    // 默认为 “”
    @Transient
    private String endTimeDay;

    public String getStartTimeDay() {
        return startTimeDay;
    }

    public void setStartTimeDay(Date startTimeDay) {
        this.startTimeDay = DataUtil.dfDate.get().format(startTimeDay);
    }

    public String getEndTimeDay() {
        return endTimeDay;
    }

    public void setEndTimeDay(Date endTimeDay) {
        this.endTimeDay = DataUtil.dfDate.get().format(endTimeDay);
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
        if (StringUtils.isEmpty(endTimeDay))
            setEndTimeDay(endTime);
    }

    /**
     * 获取企业全名
     *
     * @return company_name - 企业全名
     */
    public String getCompanyName() {
        return companyName;
    }

    public void setStartTimeDay(String startTimeDay) {
        this.startTimeDay = startTimeDay;
    }

    public void setEndTimeDay(String endTimeDay) {
        this.endTimeDay = endTimeDay;
    }

    /**
     * 设置企业全名
     *
     * @param companyName 企业全名
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取企业id
     *
     * @return company_id - 企业id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置企业id
     *
     * @param companyId 企业id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取企业类型
     *
     * @return company_type_id - 企业类型
     */
    public Byte getCompanyTypeId() {
        return companyTypeId;
    }

    /**
     * 设置企业类型
     *
     * @param companyTypeId 企业类型
     */
    public void setCompanyTypeId(Byte companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    /**
     * 获取行业Id
     *
     * @return industry_id - 行业Id
     */
    public Integer getIndustryId() {
        return industryId;
    }

    /**
     * 设置行业Id
     *
     * @param industryId 行业Id
     */
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    /**
     * @return industry_name
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * @param industryName
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * 获取模板id
     *
     * @return tpl_id - 模板id
     */
    public Integer getTplId() {
        return tplId;
    }

    /**
     * 设置模板id
     *
     * @param tplId 模板id
     */
    public void setTplId(Integer tplId) {
        this.tplId = tplId;
    }

    /**
     * 获取模板名称
     *
     * @return tpl_name - 模板名称
     */
    public String getTplName() {
        return tplName;
    }

    /**
     * 设置模板名称
     *
     * @param tplName 模板名称
     */
    public void setTplName(String tplName) {
        this.tplName = tplName;
    }

    /**
     * 获取职位名称
     *
     * @return job_title - 职位名称
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * 设置职位名称
     *
     * @param jobTitle 职位名称
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return salary_start
     */
    public Integer getSalaryStart() {
        return salaryStart;
    }

    /**
     * @param salaryStart
     */
    public void setSalaryStart(Integer salaryStart) {
        this.salaryStart = salaryStart;
    }

    /**
     * @return salary_end
     */
    public Integer getSalaryEnd() {
        return salaryEnd;
    }

    /**
     * @param salaryEnd
     */
    public void setSalaryEnd(Integer salaryEnd) {
        this.salaryEnd = salaryEnd;
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

    /**
     * 获取企业规模
     *
     * @return scale_id - 企业规模
     */
    public Byte getScaleId() {
        return scaleId;
    }

    /**
     * 设置企业规模
     *
     * @param scaleId 企业规模
     */
    public void setScaleId(Byte scaleId) {
        this.scaleId = scaleId;
    }

    /**
     * 获取1 没有标准职位或有标准职位且加载 0 有标准职位且加载
     *
     * @return load - 1 没有标准职位或有标准职位且加载 0 有标准职位且加载
     */
  /*  public Byte getLoad() {
        return load;
    }*/

    /**
     * 设置1 没有标准职位或有标准职位且加载 0 有标准职位且加载
     *
     * @param load 1 没有标准职位或有标准职位且加载 0 有标准职位且加载
     */
    /*public void setLoad(Byte load) {
        this.load = load;
    }*/

    /**
     * @return p_work_exp_id
     */
    public Integer getpWorkExpId() {
        return pWorkExpId;
    }

    /**
     * @param pWorkExpId
     */
    public void setpWorkExpId(Integer pWorkExpId) {
        this.pWorkExpId = pWorkExpId;
    }

    /**
     * 获取工作职责
     *
     * @return work_resp - 工作职责
     */
    public String getWorkResp() {
        return workResp;
    }

    /**
     * 设置工作职责
     *
     * @param workResp 工作职责
     */
    public void setWorkResp(String workResp) {
        this.workResp = workResp;
    }

 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebResumeWorkExp that = (WebResumeWorkExp) o;
        return startTime.equals(that.startTime) &&
                endTime.equals(that.endTime) &&
                companyName.equals( that.companyName) &&
                Objects.equals(jobTitle, that.jobTitle) &&
                startTimeDay.equals( that.startTimeDay) &&
                endTimeDay.equals(that.endTimeDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startTime, endTime, companyName, jobTitle, startTimeDay, endTimeDay);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebResumeWorkExp that = (WebResumeWorkExp) o;
     /*   boolean equals = Objects.equals(startTime, that.startTime);
        boolean equals1 = Objects.equals(endTime, that.endTime);
        boolean equals2 = Objects.equals(companyName, that.companyName);
        boolean equals3 = Objects.equals(jobTitle, that.jobTitle);*/
        return Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(jobTitle, that.jobTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startTime, endTime, companyName, jobTitle);
    }
}