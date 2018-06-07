package com.resumed.sqtwin.model.responseban;

/**
 * @auther Super
 * @data 2018/4/17 0017
 * @time 下午 14:35
 */
public class UpdaeResumeResponse {
    private String rid ;

    private String dataTime ;

    private Boolean isCanAdd ;

    public Boolean getCanAdd() {
        return isCanAdd;
    }

    public void setCanAdd(Boolean canAdd) {
        isCanAdd = canAdd;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
