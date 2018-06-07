package com.resumed.sqtwin.dao;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebGid;
import com.resumed.sqtwin.model.WebUser;

import org.apache.ibatis.annotations.Param;


public interface WebUserMapper extends Mapper<WebUser> {


    WebUser checkPhoneNum(String mPhoneNum);

    Integer InsertWebGid(WebGid webGid);

    WebUser isLoginUser(@Param(value = "mPhoneNum") String mPhoneNum, @Param(value = "passWord") String passWord);

    WebUser isSmsLoginUser(@Param(value = "mPhoneNum")String mPhoneNum, String smsCode);
}