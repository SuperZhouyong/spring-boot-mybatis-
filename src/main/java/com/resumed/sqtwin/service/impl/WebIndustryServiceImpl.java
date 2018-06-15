package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.WebIndustryMapper;
import com.resumed.sqtwin.model.WebIndustry;
import com.resumed.sqtwin.service.WebIndustryService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/17.
 */
@Service
@Transactional
public class WebIndustryServiceImpl extends AbstractService<WebIndustry> implements WebIndustryService {
    @Resource
    private WebIndustryMapper webIndustryMapper;

}
