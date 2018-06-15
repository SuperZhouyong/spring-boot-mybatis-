package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeWorkExpMapper;
import com.resumed.sqtwin.model.WebResumeWorkExp;
import com.resumed.sqtwin.model.responseban.WebIndustryListBean;
import com.resumed.sqtwin.service.WebResumeWorkExpService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
@Service
@Transactional
public class WebResumeWorkExpServiceImpl extends AbstractService<WebResumeWorkExp> implements WebResumeWorkExpService {
    @Resource
    private WebResumeWorkExpMapper webResumeWorkExpMapper;

    @Override
    public List<WebIndustryListBean> selectIndustryList(Integer gid) {
        return webResumeWorkExpMapper.selectIndustryList(gid);
    }
}
