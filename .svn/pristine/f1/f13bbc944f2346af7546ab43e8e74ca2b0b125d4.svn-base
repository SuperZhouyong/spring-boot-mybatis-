package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_electronic_resume")
public class WebElectronicResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户gid
     */
    private Integer gid;

    /**
     * 简历rid
     */
    private String rid;

    /**
     * 电子简历唯一标识
     */
    private String share;

    /**
     * 是否正常显示名称：默认1。1/显示，2/匿名
     */
    @Column(name = "showName")
    private Byte showname;

    /**
     * 是否正常显示手机：默认1。1/显示，2/匿名
     */
    @Column(name = "showPhone")
    private Byte showphone;

    /**
     * 创建时间
     */
    @Column(name = "createAt")
    private Date createat;

    /**
     * 电子简历状态：默认1。1/正常，99/失效
     */
    private Byte status;

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
     * 获取用户gid
     *
     * @return gid - 用户gid
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * 设置用户gid
     *
     * @param gid 用户gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取简历rid
     *
     * @return rid - 简历rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * 设置简历rid
     *
     * @param rid 简历rid
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * 获取电子简历唯一标识
     *
     * @return share - 电子简历唯一标识
     */
    public String getShare() {
        return share;
    }

    /**
     * 设置电子简历唯一标识
     *
     * @param share 电子简历唯一标识
     */
    public void setShare(String share) {
        this.share = share;
    }

    /**
     * 获取是否正常显示名称：默认1。1/显示，2/匿名
     *
     * @return showName - 是否正常显示名称：默认1。1/显示，2/匿名
     */
    public Byte getShowname() {
        return showname;
    }

    /**
     * 设置是否正常显示名称：默认1。1/显示，2/匿名
     *
     * @param showname 是否正常显示名称：默认1。1/显示，2/匿名
     */
    public void setShowname(Byte showname) {
        this.showname = showname;
    }

    /**
     * 获取是否正常显示手机：默认1。1/显示，2/匿名
     *
     * @return showPhone - 是否正常显示手机：默认1。1/显示，2/匿名
     */
    public Byte getShowphone() {
        return showphone;
    }

    /**
     * 设置是否正常显示手机：默认1。1/显示，2/匿名
     *
     * @param showphone 是否正常显示手机：默认1。1/显示，2/匿名
     */
    public void setShowphone(Byte showphone) {
        this.showphone = showphone;
    }

    /**
     * 获取创建时间
     *
     * @return createAt - 创建时间
     */
    public Date getCreateat() {
        return createat;
    }

    /**
     * 设置创建时间
     *
     * @param createat 创建时间
     */
    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    /**
     * 获取电子简历状态：默认1。1/正常，99/失效
     *
     * @return status - 电子简历状态：默认1。1/正常，99/失效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置电子简历状态：默认1。1/正常，99/失效
     *
     * @param status 电子简历状态：默认1。1/正常，99/失效
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}