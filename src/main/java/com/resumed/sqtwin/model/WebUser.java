package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_user")
public class WebUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户唯一ID
     */
    private Integer gid;

    /**
     * 用户名，个人用户昵称
     */
    private String phone;

    private String password;

    @Column(name = "create_at")
    private Date createAt;

    /**
     * 0：未激活 1: 已经激活 2：锁定 用户状态
     */
    private Integer status;

    /**
     * 1:本站2:360
     */
    private Byte type;

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
     * 获取用户唯一ID
     *
     * @return gid - 用户唯一ID
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * 设置用户唯一ID
     *
     * @param gid 用户唯一ID
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取用户名，个人用户昵称
     *
     * @return phone - 用户名，个人用户昵称
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户名，个人用户昵称
     *
     * @param phone 用户名，个人用户昵称
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return create_at
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 获取0：未激活 1: 已经激活 2：锁定 用户状态
     *
     * @return status - 0：未激活 1: 已经激活 2：锁定 用户状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：未激活 1: 已经激活 2：锁定 用户状态
     *
     * @param status 0：未激活 1: 已经激活 2：锁定 用户状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取1:本站2:360
     *
     * @return type - 1:本站2:360
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置1:本站2:360
     *
     * @param type 1:本站2:360
     */
    public void setType(Byte type) {
        this.type = type;
    }
}