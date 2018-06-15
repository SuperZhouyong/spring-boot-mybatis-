package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_report_history")
public class WebReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    @Column(name = "reportId")
    private Integer reportid;

    /**
     * 1行业2职位,3公共专业4个性专业5地区6生活7职业视频
     */
    private Byte type;

    @Column(name = "createAt")
    private Date createat;

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
     * @return reportId
     */
    public Integer getReportid() {
        return reportid;
    }

    /**
     * @param reportid
     */
    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    /**
     * 获取1行业2职位,3公共专业4个性专业5地区6生活7职业视频
     *
     * @return type - 1行业2职位,3公共专业4个性专业5地区6生活7职业视频
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置1行业2职位,3公共专业4个性专业5地区6生活7职业视频
     *
     * @param type 1行业2职位,3公共专业4个性专业5地区6生活7职业视频
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * @return createAt
     */
    public Date getCreateat() {
        return createat;
    }

    /**
     * @param createat
     */
    public void setCreateat(Date createat) {
        this.createat = createat;
    }
}