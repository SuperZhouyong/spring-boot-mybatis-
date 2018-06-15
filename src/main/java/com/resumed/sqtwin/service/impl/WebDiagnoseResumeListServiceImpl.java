package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebDiagnoseResumeListMapper;
import com.resumed.sqtwin.model.WebDiagnoseResumeList;
import com.resumed.sqtwin.model.responseban.WebIndustryListBean;
import com.resumed.sqtwin.service.WebDiagnoseResumeListService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/27.
 */
@Service
@Transactional
public class WebDiagnoseResumeListServiceImpl extends AbstractService<WebDiagnoseResumeList> implements WebDiagnoseResumeListService {
    @Resource
    private WebDiagnoseResumeListMapper webDiagnoseResumeListMapper;

    @Override
    public List<WebIndustryListBean> selecIndustryList(Integer gid) {
        return webDiagnoseResumeListMapper.selecIndustryList(gid);
    }
}
