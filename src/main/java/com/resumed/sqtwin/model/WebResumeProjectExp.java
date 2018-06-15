package com.resumed.sqtwin.model;

import com.alibaba.druid.util.StringUtils;
import com.resumed.sqtwin.utils.DataUtil;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_resume_project_exp")
public class WebResumeProjectExp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    private String rid;

    /**
     * 项目名称
     */
    private String name;

    @Column(name = "job_name")
    private String jobName;

    /**
     * 开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    @Transient
    private String beginTimeDay;

    public String getBeginTimeDay() {
        return beginTimeDay;
    }

    public void setBeginTimeDay(Date beginTime) {
        this.beginTimeDay = DataUtil.dfDate.get().format(beginTime);
    }
    public String getEndTimeDay() {
        return endTimeDay;
    }

    public void setEndTimeDay(Date endTime) {
        this.endTimeDay = DataUtil.dfDate.get().format(endTime);
    }

    @Transient
    private String endTimeDay;

    /**
     * 排序位置
     */
    private Integer rank;

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
     * 项目内容
     */
    private String content;

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
     * 获取项目名称
     *
     * @return name - 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目名称
     *
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return job_name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取开始时间
     *
     * @return begin_time - 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        if (StringUtils.isEmpty(beginTimeDay))
            setBeginTimeDay(beginTime);
    }

    public void setBeginTimeDay(String beginTimeDay) {
        this.beginTimeDay = beginTimeDay;
    }
    public void setEndTimeDay(String endTimeDay) {
        this.endTimeDay = endTimeDay;
    }
        /**
         * 获取结束时间
         *
         * @return end_time - 结束时间
         */
        public Date getEndTime () {
            return endTime;
        }

        /**
         * 设置结束时间
         *
         * @param endTime 结束时间
         */
        public void setEndTime (Date endTime){
            this.endTime = endTime;
            if (StringUtils.isEmpty(endTimeDay))
                setEndTimeDay(endTime);
        }

        /**
         * 获取排序位置
         *
         * @return rank - 排序位置
         */
        public Integer getRank () {
            return rank;
        }

        /**
         * 设置排序位置
         *
         * @param rank 排序位置
         */
        public void setRank (Integer rank){
            this.rank = rank;
        }

        /**
         * 获取行业Id
         *
         * @return industry_id - 行业Id
         */
        public Integer getIndustryId () {
            return industryId;
        }

        /**
         * 设置行业Id
         *
         * @param industryId 行业Id
         */
        public void setIndustryId (Integer industryId){
            this.industryId = industryId;
        }

        /**
         * @return industry_name
         */
        public String getIndustryName () {
            return industryName;
        }

        /**
         * @param industryName
         */
        public void setIndustryName (String industryName){
            this.industryName = industryName;
        }

        /**
         * 获取模板id
         *
         * @return tpl_id - 模板id
         */
        public Integer getTplId () {
            return tplId;
        }

        /**
         * 设置模板id
         *
         * @param tplId 模板id
         */
        public void setTplId (Integer tplId){
            this.tplId = tplId;
        }

        /**
         * 获取项目内容
         *
         * @return content - 项目内容
         */
        public String getContent () {
            return content;
        }

        /**
         * 设置项目内容
         *
         * @param content 项目内容
         */
        public void setContent (String content){
            this.content = content;
        }
    }