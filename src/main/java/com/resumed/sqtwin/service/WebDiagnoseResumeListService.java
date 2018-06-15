package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebDiagnoseResumeList;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebIndustryListBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/27.
 */
public interface WebDiagnoseResumeListService extends Service<WebDiagnoseResumeList> {

    List<WebIndustryListBean> selecIndustryList(Integer gid);
}
