package com.resumed.sqtwin.service;

import com.resumed.sqtwin.model.WebGid;
import com.resumed.sqtwin.model.WebUser;
import com.resumed.sqtwin.core.Service;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
public interface WebUserService extends Service<WebUser> {
    WebUser checkPhoneNum(String mPhoneNum);

    Integer InsertWebGid(WebGid webGid);

    WebUser isLoginUser(String mPhoneNum, String passWord);

    WebUser isSmsLoginUser(String mPhoneNum, String smsCode);
}
