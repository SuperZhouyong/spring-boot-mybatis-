package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebUserMapper;
import com.resumed.sqtwin.model.WebGid;
import com.resumed.sqtwin.model.WebUser;
import com.resumed.sqtwin.service.WebUserService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
@Service
@Transactional
public class WebUserServiceImpl extends AbstractService<WebUser> implements WebUserService {
    @Resource
    WebUserMapper webUserMapper ;

    @Override
    public WebUser checkPhoneNum(String mPhoneNum) {
        return webUserMapper.checkPhoneNum(mPhoneNum);
    }

    @Override
    public Integer InsertWebGid(WebGid webGid) {
        return webUserMapper.InsertWebGid(webGid);
    }

    @Override
    public WebUser isLoginUser(String mPhoneNum, String passWord) {
        return webUserMapper.isLoginUser(mPhoneNum,passWord);
    }

    @Override
    public WebUser isSmsLoginUser(String mPhoneNum, String smsCode) {
        return webUserMapper.isSmsLoginUser(mPhoneNum,smsCode);
    }


//    @Override
//    public Boolean checkPhoneNum(String mPhonNum){
//        return ((WebUserMapper)mapper).checkPhoneNum(mPhonNum);
//    }
}
