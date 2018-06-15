package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_resume")
public class WebResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    private String rid;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

    @Column(name = "is_upload")
    private Integer isUpload;

    /**
     * 简历的完整度
     */
    @Column(name = "resume_integrity")
    private Integer resumeIntegrity;

    /**
     * 简历标题
     */
    @Column(name = "resume_title")
    private String resumeTitle;

    /**
     * 0:草稿;1:保存;99 删除;9 研究用历史数据;8 诊断用数据
     */
    private Integer status;

    @Column(name = "is_merged")
    private Integer isMerged;

    @Column(name = "merge_time")
    private Date mergeTime;

    /**
     * 父简历rid
     */
    private String prid;

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
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return is_upload
     */
    public Integer getIsUpload() {
        return isUpload;
    }

    /**
     * @param isUpload
     */
    public void setIsUpload(Integer isUpload) {
        this.isUpload = isUpload;
    }

    /**
     * 获取简历的完整度
     *
     * @return resume_integrity - 简历的完整度
     */
    public Integer getResumeIntegrity() {
        return resumeIntegrity;
    }

    /**
     * 设置简历的完整度
     *
     * @param resumeIntegrity 简历的完整度
     */
    public void setResumeIntegrity(Integer resumeIntegrity) {
        this.resumeIntegrity = resumeIntegrity;
    }

    /**
     * 获取简历标题
     *
     * @return resume_title - 简历标题
     */
    public String getResumeTitle() {
        return resumeTitle;
    }

    /**
     * 设置简历标题
     *
     * @param resumeTitle 简历标题
     */
    public void setResumeTitle(String resumeTitle) {
        this.resumeTitle = resumeTitle;
    }

    /**
     * 获取0:草稿;1:保存;99 删除;9 研究用历史数据;8 诊断用数据
     *
     * @return status - 0:草稿;1:保存;99 删除;9 研究用历史数据;8 诊断用数据
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:草稿;1:保存;99 删除;9 研究用历史数据;8 诊断用数据
     *
     * @param status 0:草稿;1:保存;99 删除;9 研究用历史数据;8 诊断用数据
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return is_merged
     */
    public Integer getIsMerged() {
        return isMerged;
    }

    /**
     * @param isMerged
     */
    public void setIsMerged(Integer isMerged) {
        this.isMerged = isMerged;
    }

    /**
     * @return merge_time
     */
    public Date getMergeTime() {
        return mergeTime;
    }

    /**
     * @param mergeTime
     */
    public void setMergeTime(Date mergeTime) {
        this.mergeTime = mergeTime;
    }

    /**
     * 获取父简历rid
     *
     * @return prid - 父简历rid
     */
    public String getPrid() {
        return prid;
    }

    /**
     * 设置父简历rid
     *
     * @param prid 父简历rid
     */
    public void setPrid(String prid) {
        this.prid = prid;
    }
}