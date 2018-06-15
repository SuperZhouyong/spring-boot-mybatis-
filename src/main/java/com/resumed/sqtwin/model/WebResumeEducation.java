package com.resumed.sqtwin.model;

import com.resumed.sqtwin.utils.DataUtil;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;


@Table(name = "web_resume_education")
public class WebResumeEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    private String rid;
    @Transient
    private String degreeName ;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 学历 1博士 2硕士 3 本科 4大专 6职高/中专 7高中 8初中及以下
     */
    private Byte degree;

    /**
     * 专业类型
     */
    @Column(name = "major_id")
    private Integer majorId;

    /**
     * 专业名称
     */
    @Column(name = "major_name")
    private String majorName;

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
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return school_id
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取学历 1博士 2硕士 3 本科 4大专 6职高/中专 7高中 8初中及以下
     *
     * @return degree - 学历 1博士 2硕士 3 本科 4大专 6职高/中专 7高中 8初中及以下
     */
    public Byte getDegree() {
        return degree;
    }

    /**
     * 设置学历 1博士 2硕士 3 本科 4大专 6职高/中专 7高中 8初中及以下
     *
     * @param degree 学历 1博士 2硕士 3 本科 4大专 6职高/中专 7高中 8初中及以下
     */
    public void setDegree(Byte degree) {
        this.degree = degree;
    }

    /**
     * 获取专业类型
     *
     * @return major_id - 专业类型
     */
    public Integer getMajorId() {
        return majorId;
    }

    /**
     * 设置专业类型
     *
     * @param majorId 专业类型
     */
    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    /**
     * 获取专业名称
     *
     * @return major_name - 专业名称
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 设置专业名称
     *
     * @param majorName 专业名称
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
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
        setStartTimeDay(startTime);
    }

    @Transient
    private String startTimeDay;

  /*  @Transient
    private String endTimeDay ;*/

    public String getStartTimeDay() {
        return startTimeDay;
    }

    public void setStartTimeDay(Date data) {
        if (startTimeDay == null)
            this.startTimeDay = DataUtil.dfDate.get().format(data);
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
        setEndTimeDay(endTime);
    }

    @Transient
    private String endTimeDay;

    public String getEndTimeDay() {
        return endTimeDay;
    }

    public void setStartTimeDay(String startTimeDay) {
        this.startTimeDay = startTimeDay;
    }

    public void setEndTimeDay(String endTimeDay) {
        this.endTimeDay = endTimeDay;
    }

    public void setEndTimeDay(Date endTime) {
        if (endTimeDay == null)
            this.endTimeDay = DataUtil.dfDate.get().format(endTime);
    }
    /*  public String getEndTimeDay() {
        return startTimeDay;
    }

    public void setStartTimeDay(Date data) {
        this.startTimeDay = DataUtil.dfDate.get().format(data);
    }*/


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
    public String toString() {
        return "WebResumeEducation{" +
                "id=" + id +
                ", gid=" + gid +
                ", rid='" + rid + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolId=" + schoolId +
                ", degree=" + degree +
                ", majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", startTime=" + DataUtil.dfDate.get().format(startTime) +
                ", endTime=" + DataUtil.dfDate.get().format(endTime) +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebResumeEducation that = (WebResumeEducation) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(majorName, that.majorName) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(startTimeDay, that.startTimeDay) &&
                Objects.equals(endTimeDay, that.endTimeDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(schoolName, majorName, startTime, endTime, startTimeDay, endTimeDay);
    }
}