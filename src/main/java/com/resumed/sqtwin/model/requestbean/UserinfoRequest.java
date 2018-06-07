package com.resumed.sqtwin.model.requestbean;

/**
 * @auther Super
 * @data 2018/4/17 0017
 * @time 上午 10:01
 */
public class UserinfoRequest {
    /*  "address":"",// 详细地址
           "birthday":"", // 生日
           "cityNmae" :"" // 城市Id  居住地
           "cityId" :"" // 城市Id
           "workStatus":"" //目前工作状态 0.离职，正在找工作 1.在职，正在找工作 2.在职，有好的机会才考虑 3.暂无跳槽打算
           "avatar_url":"" // 头像路径
           "describe":""			// 自我秒速
           "email":"",				// 邮箱
           "hoseholdId" 		// 户籍城市id
           "householdName":"",//户籍地城市
           "marrStatu:"",// 婚姻状态  1-未婚 2-已婚  3-保密
           "name":"",   // 名字
           "phone":"",		//电话
           "salary":""		// 非面议 2000- 6000 ， 面议为 1

           "sexId":""  //性别Id 1,男，2女 */

    private String address;//详细地址
    private String birthday;//生日
    private String cityNmae;// 城市Id  居住地
    private int cityId; // 城市Id
    private int workStatus;
    private String avatar_url;
    private String describe;
    private String email;
    private int hoseholdId;
    private String householdName;
    private int marrStatu;
    private String name;
    private String phone;
    private String salary;
    private int sexId;



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCityNmae() {
        return cityNmae;
    }

    public void setCityNmae(String cityNmae) {
        this.cityNmae = cityNmae;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(int workStatus) {
        this.workStatus = workStatus;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHoseholdId() {
        return hoseholdId;
    }

    public void setHoseholdId(int hoseholdId) {
        this.hoseholdId = hoseholdId;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public int getMarrStatu() {
        return marrStatu;
    }

    public void setMarrStatu(int marrStatu) {
        this.marrStatu = marrStatu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

}
