package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_job_tpl")
public class SysJobTpl {
    @Id
    @Column(name = "job_tpl_id")
    private Integer jobTplId;

    private Integer no;

    private String title;

    private String name;

    /**
     * 职业 职能
     */
    @Column(name = "functionId")
    private Integer functionid;

    /**
     * 招聘人数
     */
    @Column(name = "people_number")
    private Integer peopleNumber;

    /**
     * 1是 2否
     */
    @Column(name = "is_numbers_some")
    private Byte isNumbersSome;

    /**
     * 工作性质全职 兼职 实习
     */
    @Column(name = "work_nature")
    private Byte workNature;

    /**
     * 博士 MBA/EMBA 硕士 本科 大专  职高/中专 高中 初中及以下 不限
     */
    private Byte education;

    /**
     * 工作经验 在读学生 应届生 1年 2年 3年 4年 5年 6年 7年 8年 9年 10年 10年以上 不限 自定义经验要求
     */
    @Column(name = "job_exp")
    private Byte jobExp;

    /**
     * 同职位工作经验 应届生 1-2年 3-4年 5-7 8-10年 10年以上 不限 自定义经验要求
     */
    @Column(name = "same_job_exp")
    private Byte sameJobExp;

    /**
     * 管理经验
     */
    @Column(name = "manage_exp")
    private Byte manageExp;

    /**
     * 海外经验
     */
    @Column(name = "overseas_exp")
    private Byte overseasExp;

    /**
     * 薪水最低
     */
    @Column(name = "salary_start")
    private Integer salaryStart;

    /**
     * 薪水最高
     */
    @Column(name = "salary_end")
    private Integer salaryEnd;

    @Column(name = "salary_level")
    private Integer salaryLevel;

    /**
     * 薪水面议
     */
    @Column(name = "salary_discuss")
    private Byte salaryDiscuss;

    private Byte status;

    @Column(name = "publish_at")
    private Date publishAt;

    @Column(name = "last_edit_at")
    private Date lastEditAt;

    /**
     * 性别要求 男 女 不限
     */
    private Byte sex;

    /**
     * 自定义工作经验
     */
    @Column(name = "custom_job_exp")
    private String customJobExp;

    /**
     * 自定义同职位工作经验
     */
    @Column(name = "custom_same_job_exp")
    private String customSameJobExp;

    /**
     * 最低工作经验年限
     */
    @Column(name = "job_exp_start")
    private String jobExpStart;

    /**
     * 最高工作经验年限
     */
    @Column(name = "job_exp_end")
    private String jobExpEnd;

    /**
     * 最低同职位工作经验年限
     */
    @Column(name = "same_job_exp_start")
    private String sameJobExpStart;

    /**
     * 最高同职位工作经验年限
     */
    @Column(name = "same_job_exp_end")
    private String sameJobExpEnd;

    @Column(name = "need_handle")
    private Byte needHandle;

    /**
     * 标签
     */
    @Column(name = "tagId")
    private Integer tagid;

    private Integer level;

    /**
     * 模板能否在merge页面被搜到( 1能 0不能）
     */
    private Byte merge;

    /**
     * 标识模板是否是管理岗位( 1是 0不是）
     */
    @Column(name = "is_manager")
    private Byte isManager;

    @Column(name = "mapping_to")
    private Integer mappingTo;

    /**
     * 不限  1:是  0:否  level＜4--是 level>＝4--否
     */
    private Byte unlimited;

    /**
     * 行业(暂仅做记录用,与其他无关)
     */
    @Column(name = "industry_list")
    private String industryList;

    private String description;

    /**
     * @return job_tpl_id
     */
    public Integer getJobTplId() {
        return jobTplId;
    }

    /**
     * @param jobTplId
     */
    public void setJobTplId(Integer jobTplId) {
        this.jobTplId = jobTplId;
    }

    /**
     * @return no
     */
    public Integer getNo() {
        return no;
    }

    /**
     * @param no
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取职业 职能
     *
     * @return functionId - 职业 职能
     */
    public Integer getFunctionid() {
        return functionid;
    }

    /**
     * 设置职业 职能
     *
     * @param functionid 职业 职能
     */
    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    /**
     * 获取招聘人数
     *
     * @return people_number - 招聘人数
     */
    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    /**
     * 设置招聘人数
     *
     * @param peopleNumber 招聘人数
     */
    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    /**
     * 获取1是 2否
     *
     * @return is_numbers_some - 1是 2否
     */
    public Byte getIsNumbersSome() {
        return isNumbersSome;
    }

    /**
     * 设置1是 2否
     *
     * @param isNumbersSome 1是 2否
     */
    public void setIsNumbersSome(Byte isNumbersSome) {
        this.isNumbersSome = isNumbersSome;
    }

    /**
     * 获取工作性质全职 兼职 实习
     *
     * @return work_nature - 工作性质全职 兼职 实习
     */
    public Byte getWorkNature() {
        return workNature;
    }

    /**
     * 设置工作性质全职 兼职 实习
     *
     * @param workNature 工作性质全职 兼职 实习
     */
    public void setWorkNature(Byte workNature) {
        this.workNature = workNature;
    }

    /**
     * 获取博士 MBA/EMBA 硕士 本科 大专  职高/中专 高中 初中及以下 不限
     *
     * @return education - 博士 MBA/EMBA 硕士 本科 大专  职高/中专 高中 初中及以下 不限
     */
    public Byte getEducation() {
        return education;
    }

    /**
     * 设置博士 MBA/EMBA 硕士 本科 大专  职高/中专 高中 初中及以下 不限
     *
     * @param education 博士 MBA/EMBA 硕士 本科 大专  职高/中专 高中 初中及以下 不限
     */
    public void setEducation(Byte education) {
        this.education = education;
    }

    /**
     * 获取工作经验 在读学生 应届生 1年 2年 3年 4年 5年 6年 7年 8年 9年 10年 10年以上 不限 自定义经验要求
     *
     * @return job_exp - 工作经验 在读学生 应届生 1年 2年 3年 4年 5年 6年 7年 8年 9年 10年 10年以上 不限 自定义经验要求
     */
    public Byte getJobExp() {
        return jobExp;
    }

    /**
     * 设置工作经验 在读学生 应届生 1年 2年 3年 4年 5年 6年 7年 8年 9年 10年 10年以上 不限 自定义经验要求
     *
     * @param jobExp 工作经验 在读学生 应届生 1年 2年 3年 4年 5年 6年 7年 8年 9年 10年 10年以上 不限 自定义经验要求
     */
    public void setJobExp(Byte jobExp) {
        this.jobExp = jobExp;
    }

    /**
     * 获取同职位工作经验 应届生 1-2年 3-4年 5-7 8-10年 10年以上 不限 自定义经验要求
     *
     * @return same_job_exp - 同职位工作经验 应届生 1-2年 3-4年 5-7 8-10年 10年以上 不限 自定义经验要求
     */
    public Byte getSameJobExp() {
        return sameJobExp;
    }

    /**
     * 设置同职位工作经验 应届生 1-2年 3-4年 5-7 8-10年 10年以上 不限 自定义经验要求
     *
     * @param sameJobExp 同职位工作经验 应届生 1-2年 3-4年 5-7 8-10年 10年以上 不限 自定义经验要求
     */
    public void setSameJobExp(Byte sameJobExp) {
        this.sameJobExp = sameJobExp;
    }

    /**
     * 获取管理经验
     *
     * @return manage_exp - 管理经验
     */
    public Byte getManageExp() {
        return manageExp;
    }

    /**
     * 设置管理经验
     *
     * @param manageExp 管理经验
     */
    public void setManageExp(Byte manageExp) {
        this.manageExp = manageExp;
    }

    /**
     * 获取海外经验
     *
     * @return overseas_exp - 海外经验
     */
    public Byte getOverseasExp() {
        return overseasExp;
    }

    /**
     * 设置海外经验
     *
     * @param overseasExp 海外经验
     */
    public void setOverseasExp(Byte overseasExp) {
        this.overseasExp = overseasExp;
    }

    /**
     * 获取薪水最低
     *
     * @return salary_start - 薪水最低
     */
    public Integer getSalaryStart() {
        return salaryStart;
    }

    /**
     * 设置薪水最低
     *
     * @param salaryStart 薪水最低
     */
    public void setSalaryStart(Integer salaryStart) {
        this.salaryStart = salaryStart;
    }

    /**
     * 获取薪水最高
     *
     * @return salary_end - 薪水最高
     */
    public Integer getSalaryEnd() {
        return salaryEnd;
    }

    /**
     * 设置薪水最高
     *
     * @param salaryEnd 薪水最高
     */
    public void setSalaryEnd(Integer salaryEnd) {
        this.salaryEnd = salaryEnd;
    }

    /**
     * @return salary_level
     */
    public Integer getSalaryLevel() {
        return salaryLevel;
    }

    /**
     * @param salaryLevel
     */
    public void setSalaryLevel(Integer salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    /**
     * 获取薪水面议
     *
     * @return salary_discuss - 薪水面议
     */
    public Byte getSalaryDiscuss() {
        return salaryDiscuss;
    }

    /**
     * 设置薪水面议
     *
     * @param salaryDiscuss 薪水面议
     */
    public void setSalaryDiscuss(Byte salaryDiscuss) {
        this.salaryDiscuss = salaryDiscuss;
    }

    /**
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return publish_at
     */
    public Date getPublishAt() {
        return publishAt;
    }

    /**
     * @param publishAt
     */
    public void setPublishAt(Date publishAt) {
        this.publishAt = publishAt;
    }

    /**
     * @return last_edit_at
     */
    public Date getLastEditAt() {
        return lastEditAt;
    }

    /**
     * @param lastEditAt
     */
    public void setLastEditAt(Date lastEditAt) {
        this.lastEditAt = lastEditAt;
    }

    /**
     * 获取性别要求 男 女 不限
     *
     * @return sex - 性别要求 男 女 不限
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别要求 男 女 不限
     *
     * @param sex 性别要求 男 女 不限
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取自定义工作经验
     *
     * @return custom_job_exp - 自定义工作经验
     */
    public String getCustomJobExp() {
        return customJobExp;
    }

    /**
     * 设置自定义工作经验
     *
     * @param customJobExp 自定义工作经验
     */
    public void setCustomJobExp(String customJobExp) {
        this.customJobExp = customJobExp;
    }

    /**
     * 获取自定义同职位工作经验
     *
     * @return custom_same_job_exp - 自定义同职位工作经验
     */
    public String getCustomSameJobExp() {
        return customSameJobExp;
    }

    /**
     * 设置自定义同职位工作经验
     *
     * @param customSameJobExp 自定义同职位工作经验
     */
    public void setCustomSameJobExp(String customSameJobExp) {
        this.customSameJobExp = customSameJobExp;
    }

    /**
     * 获取最低工作经验年限
     *
     * @return job_exp_start - 最低工作经验年限
     */
    public String getJobExpStart() {
        return jobExpStart;
    }

    /**
     * 设置最低工作经验年限
     *
     * @param jobExpStart 最低工作经验年限
     */
    public void setJobExpStart(String jobExpStart) {
        this.jobExpStart = jobExpStart;
    }

    /**
     * 获取最高工作经验年限
     *
     * @return job_exp_end - 最高工作经验年限
     */
    public String getJobExpEnd() {
        return jobExpEnd;
    }

    /**
     * 设置最高工作经验年限
     *
     * @param jobExpEnd 最高工作经验年限
     */
    public void setJobExpEnd(String jobExpEnd) {
        this.jobExpEnd = jobExpEnd;
    }

    /**
     * 获取最低同职位工作经验年限
     *
     * @return same_job_exp_start - 最低同职位工作经验年限
     */
    public String getSameJobExpStart() {
        return sameJobExpStart;
    }

    /**
     * 设置最低同职位工作经验年限
     *
     * @param sameJobExpStart 最低同职位工作经验年限
     */
    public void setSameJobExpStart(String sameJobExpStart) {
        this.sameJobExpStart = sameJobExpStart;
    }

    /**
     * 获取最高同职位工作经验年限
     *
     * @return same_job_exp_end - 最高同职位工作经验年限
     */
    public String getSameJobExpEnd() {
        return sameJobExpEnd;
    }

    /**
     * 设置最高同职位工作经验年限
     *
     * @param sameJobExpEnd 最高同职位工作经验年限
     */
    public void setSameJobExpEnd(String sameJobExpEnd) {
        this.sameJobExpEnd = sameJobExpEnd;
    }

    /**
     * @return need_handle
     */
    public Byte getNeedHandle() {
        return needHandle;
    }

    /**
     * @param needHandle
     */
    public void setNeedHandle(Byte needHandle) {
        this.needHandle = needHandle;
    }

    /**
     * 获取标签
     *
     * @return tagId - 标签
     */
    public Integer getTagid() {
        return tagid;
    }

    /**
     * 设置标签
     *
     * @param tagid 标签
     */
    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取模板能否在merge页面被搜到( 1能 0不能）
     *
     * @return merge - 模板能否在merge页面被搜到( 1能 0不能）
     */
    public Byte getMerge() {
        return merge;
    }

    /**
     * 设置模板能否在merge页面被搜到( 1能 0不能）
     *
     * @param merge 模板能否在merge页面被搜到( 1能 0不能）
     */
    public void setMerge(Byte merge) {
        this.merge = merge;
    }

    /**
     * 获取标识模板是否是管理岗位( 1是 0不是）
     *
     * @return is_manager - 标识模板是否是管理岗位( 1是 0不是）
     */
    public Byte getIsManager() {
        return isManager;
    }

    /**
     * 设置标识模板是否是管理岗位( 1是 0不是）
     *
     * @param isManager 标识模板是否是管理岗位( 1是 0不是）
     */
    public void setIsManager(Byte isManager) {
        this.isManager = isManager;
    }

    /**
     * @return mapping_to
     */
    public Integer getMappingTo() {
        return mappingTo;
    }

    /**
     * @param mappingTo
     */
    public void setMappingTo(Integer mappingTo) {
        this.mappingTo = mappingTo;
    }

    /**
     * 获取不限  1:是  0:否  level＜4--是 level>＝4--否
     *
     * @return unlimited - 不限  1:是  0:否  level＜4--是 level>＝4--否
     */
    public Byte getUnlimited() {
        return unlimited;
    }

    /**
     * 设置不限  1:是  0:否  level＜4--是 level>＝4--否
     *
     * @param unlimited 不限  1:是  0:否  level＜4--是 level>＝4--否
     */
    public void setUnlimited(Byte unlimited) {
        this.unlimited = unlimited;
    }

    /**
     * 获取行业(暂仅做记录用,与其他无关)
     *
     * @return industry_list - 行业(暂仅做记录用,与其他无关)
     */
    public String getIndustryList() {
        return industryList;
    }

    /**
     * 设置行业(暂仅做记录用,与其他无关)
     *
     * @param industryList 行业(暂仅做记录用,与其他无关)
     */
    public void setIndustryList(String industryList) {
        this.industryList = industryList;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}