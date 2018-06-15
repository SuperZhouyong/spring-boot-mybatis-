package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebTplLowestYearMapper;
import com.resumed.sqtwin.model.WebTplLowestYear;
import com.resumed.sqtwin.service.WebTplLowestYearService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/09.
 */
@Service
@Transactional
public class WebTplLowestYearServiceImpl extends AbstractService<WebTplLowestYear> implements WebTplLowestYearService {
    @Resource
    private WebTplLowestYearMapper webTplLowestYearMapper;

}
