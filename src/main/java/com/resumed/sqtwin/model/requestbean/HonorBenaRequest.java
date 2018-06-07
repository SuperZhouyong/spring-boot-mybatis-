package com.resumed.sqtwin.model.requestbean;

/**
 * @auther Super
 * @data 2018/4/17 0017
 * @time 上午 10:15
 */
public class HonorBenaRequest {
    /*
    * "honorName"：""，//荣誉名字
						"time":""		// 获取时间
						"orgName":"" //组织名字
						"orgId":""	// 组织Id
						"rank":"1" // 先忽略
    *
    * */
    private String honorName;
    private String time;
    private String orgName;
    private String orgId;
    private String rank;

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
