package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebIndustry;
import com.resumed.sqtwin.model.WebResumeWorkExp;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebIndustryListBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
public interface WebResumeWorkExpService extends Service<WebResumeWorkExp> {

    List<WebIndustryListBean> selectIndustryList(Integer gid);
}
