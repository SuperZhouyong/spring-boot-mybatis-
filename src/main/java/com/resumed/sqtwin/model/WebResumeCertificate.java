package com.resumed.sqtwin.model;

import com.resumed.sqtwin.utils.DataUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Table(name = "web_resume_certificate")
public class WebResumeCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    private String rid;

    @Column(name = "certificate_id")
    private Integer certificateId;

    @Column(name = "certificate_name")
    private String certificateName;

    /**
     * 获得时间
     */
    @Column(name = "getTime")
    private Date gettime;


    /**
     * 排序顺序
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
     * @return certificate_id
     */
    public Integer getCertificateId() {
        return certificateId;
    }

    /**
     * @param certificateId
     */
    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    /**
     * @return certificate_name
     */
    public String getCertificateName() {
        return certificateName;
    }

    /**
     * @param certificateName
     */
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    /**
     * 获取获得时间
     *
     * @return getTime - 获得时间
     */
    public Date getGettime() {
        return gettime;
    }

    @Transient
    private String gettimeDay;

    public String getGettimeDay() {
        return gettimeDay;
    }

    public void setGettimeDay(Date gettimeDay) {
        this.gettimeDay = DataUtil.dfDate.get().format(gettimeDay);
    }

    /**
     * 设置获得时间
     *
     * @param gettime 获得时间
     */
    public void setGettime(Date gettime) {
        this.gettime = gettime;
        if (StringUtils.isEmpty(gettimeDay))
            setGettimeDay(gettime);
    }

    public void setGettimeDay(String gettimeDay) {
        this.gettimeDay = gettimeDay;
    }

    /**
     * 获取排序顺序
     *
     * @return rank - 排序顺序
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置排序顺序
     *
     * @param rank 排序顺序
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebResumeCertificate that = (WebResumeCertificate) o;
        return Objects.equals(certificateId, that.certificateId) &&
                Objects.equals(certificateName, that.certificateName) &&
                Objects.equals(gettime, that.gettime) &&
                Objects.equals(gettimeDay, that.gettimeDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(certificateId, certificateName, gettime, gettimeDay);
    }
}