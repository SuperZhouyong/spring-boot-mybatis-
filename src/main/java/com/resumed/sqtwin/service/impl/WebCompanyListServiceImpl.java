package com.resumed.sqtwin.service.impl;


import com.resumed.sqtwin.dao.mappertwo.WebCompanyListMapper;
import com.resumed.sqtwin.model.WebCompanyList;
import com.resumed.sqtwin.service.WebCompanyListService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/18.
 */
@Service
@Transactional
public class WebCompanyListServiceImpl extends AbstractService<WebCompanyList> implements WebCompanyListService {
    @Resource
    private WebCompanyListMapper webCompanyListMapper;

}
