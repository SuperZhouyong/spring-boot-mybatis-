package com.resumed.sqtwin.model.responseban;

/**
 * @auther Super
 * @data 2018/4/13 0013
 * @time 下午 16:09
 */
public class SmsResponse {
    private String phoneNum ;
    private String smsCode ;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
