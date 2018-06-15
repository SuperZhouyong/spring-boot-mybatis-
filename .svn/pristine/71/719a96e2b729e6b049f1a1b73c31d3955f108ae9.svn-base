package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_user_detail")
public class WebUserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gid;

    /**
     * 姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 生日
     */
    private Date birthday;

    @Transient
    private String birthdata ;

    @Transient
    private String phoneNum ;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBirthdata() {
        return birthdata;
    }

    public void setBirthdata(String birthdata) {
        this.birthdata = birthdata;
    }

    /**
     * 性别1男/2女
     */
    private Byte sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 1-未婚 2-已婚  3-保密
     */
    private Byte marital;


    @Transient
    private String maritalName ;

    @Transient
    private String selfDesc ;

    public String getSelfDesc() {
        return selfDesc;
    }

    public void setSelfDesc(String selfDesc) {
        this.selfDesc = selfDesc;
    }

    public String getMaritalName() {
        return maritalName;
    }

    public void setMaritalName(String maritalName) {
        this.maritalName = maritalName;
    }

    /**
     * 居住地
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 居住城市
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 户籍城市
     */
    @Column(name = "household_city_name")
    private String householdCityName;

    /**
     * 户籍城市
     */
    @Column(name = "household_city_id")
    private Integer householdCityId;

    @Column(name = "work_status")
    private Byte workStatus;

    @Transient
    private String workStatusName ;

    public String getWorkStatusName() {
        return workStatusName;
    }

    public void setWorkStatusName(String workStatusName) {
        this.workStatusName = workStatusName;
    }

    /**
     * 期望月薪
     */
    @Column(name = "salary_start")
    private Integer salaryStart;

    /**
     * 期望月薪
     */
    @Column(name = "salary_end")
    private Integer salaryEnd;

    /**
     * 1 面议
     */
    @Column(name = "salary_discuss")
    private Byte salaryDiscuss;

    /**
     * qq
     */
    private Long qq;

    /**
     * 微信
     */
    @Column(name = "weChat")
    private String wechat;

    /**
     * 新浪微博
     */
    private String sina;

    /**
     * 审核过的头像地址
     */
    @Column(name = "head_ture_img")
    private String headTureImg;

    /**
     * 未审核头像
     */
    @Column(name = "head_img")
    private String headImg;

    /**
     * 图片审批状态：0 待审核 1:通过,,99未通过
     */
    @Column(name = "head_img_status")
    private Byte headImgStatus;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 创建时间
     */
    @Column(name = "create_at")
    private Date createAt;

    /**
     * 更新时间
     */
    @Column(name = "update_at")
    private Date updateAt;

    /**
     * 个人自述
     */
    private String readme;

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
     * 获取姓名
     *
     * @return real_name - 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置姓名
     *
     * @param realName 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取性别1男/2女
     *
     * @return sex - 性别1男/2女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别1男/2女
     *
     * @param sex 性别1男/2女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取1-未婚 2-已婚  3-保密
     *
     * @return marital - 1-未婚 2-已婚  3-保密
     */
    public Byte getMarital() {
        return marital;
    }

    /**
     * 设置1-未婚 2-已婚  3-保密
     *
     * @param marital 1-未婚 2-已婚  3-保密
     */
    public void setMarital(Byte marital) {
        this.marital = marital;
    }

    /**
     * 获取居住地
     *
     * @return city_name - 居住地
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置居住地
     *
     * @param cityName 居住地
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取居住城市
     *
     * @return city_id - 居住城市
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置居住城市
     *
     * @param cityId 居住城市
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取户籍城市
     *
     * @return household_city_name - 户籍城市
     */
    public String getHouseholdCityName() {
        return householdCityName;
    }

    /**
     * 设置户籍城市
     *
     * @param householdCityName 户籍城市
     */
    public void setHouseholdCityName(String householdCityName) {
        this.householdCityName = householdCityName;
    }

    /**
     * 获取户籍城市
     *
     * @return household_city_id - 户籍城市
     */
    public Integer getHouseholdCityId() {
        return householdCityId;
    }

    /**
     * 设置户籍城市
     *
     * @param householdCityId 户籍城市
     */
    public void setHouseholdCityId(Integer householdCityId) {
        this.householdCityId = householdCityId;
    }

    /**
     * @return work_status
     */
    public Byte getWorkStatus() {
        return workStatus;
    }

    /**
     * @param workStatus
     */
    public void setWorkStatus(Byte workStatus) {
        this.workStatus = workStatus;
    }

    /**
     * 获取期望月薪
     *
     * @return salary_start - 期望月薪
     */
    public Integer getSalaryStart() {
        return salaryStart;
    }

    /**
     * 设置期望月薪
     *
     * @param salaryStart 期望月薪
     */
    public void setSalaryStart(Integer salaryStart) {
        this.salaryStart = salaryStart;
    }

    /**
     * 获取期望月薪
     *
     * @return salary_end - 期望月薪
     */
    public Integer getSalaryEnd() {
        return salaryEnd;
    }

    /**
     * 设置期望月薪
     *
     * @param salaryEnd 期望月薪
     */
    public void setSalaryEnd(Integer salaryEnd) {
        this.salaryEnd = salaryEnd;
    }

    /**
     * 获取1 面议
     *
     * @return salary_discuss - 1 面议
     */
    public Byte getSalaryDiscuss() {
        return salaryDiscuss;
    }

    /**
     * 设置1 面议
     *
     * @param salaryDiscuss 1 面议
     */
    public void setSalaryDiscuss(Byte salaryDiscuss) {
        this.salaryDiscuss = salaryDiscuss;
    }

    /**
     * 获取qq
     *
     * @return qq - qq
     */
    public Long getQq() {
        return qq;
    }

    /**
     * 设置qq
     *
     * @param qq qq
     */
    public void setQq(Long qq) {
        this.qq = qq;
    }

    /**
     * 获取微信
     *
     * @return weChat - 微信
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信
     *
     * @param wechat 微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取新浪微博
     *
     * @return sina - 新浪微博
     */
    public String getSina() {
        return sina;
    }

    /**
     * 设置新浪微博
     *
     * @param sina 新浪微博
     */
    public void setSina(String sina) {
        this.sina = sina;
    }

    /**
     * 获取审核过的头像地址
     *
     * @return head_ture_img - 审核过的头像地址
     */
    public String getHeadTureImg() {
        return headTureImg;
    }

    /**
     * 设置审核过的头像地址
     *
     * @param headTureImg 审核过的头像地址
     */
    public void setHeadTureImg(String headTureImg) {
        this.headTureImg = headTureImg;
    }

    /**
     * 获取未审核头像
     *
     * @return head_img - 未审核头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置未审核头像
     *
     * @param headImg 未审核头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取图片审批状态：0 待审核 1:通过,,99未通过
     *
     * @return head_img_status - 图片审批状态：0 待审核 1:通过,,99未通过
     */
    public Byte getHeadImgStatus() {
        return headImgStatus;
    }

    /**
     * 设置图片审批状态：0 待审核 1:通过,,99未通过
     *
     * @param headImgStatus 图片审批状态：0 待审核 1:通过,,99未通过
     */
    public void setHeadImgStatus(Byte headImgStatus) {
        this.headImgStatus = headImgStatus;
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取创建时间
     *
     * @return create_at - 创建时间
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * 设置创建时间
     *
     * @param createAt 创建时间
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 获取更新时间
     *
     * @return update_at - 更新时间
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * 设置更新时间
     *
     * @param updateAt 更新时间
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 获取个人自述
     *
     * @return readme - 个人自述
     */
    public String getReadme() {
        return readme;
    }

    /**
     * 设置个人自述
     *
     * @param readme 个人自述
     */
    public void setReadme(String readme) {
        this.readme = readme;
    }
}