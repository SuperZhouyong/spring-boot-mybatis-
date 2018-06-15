package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebTplVisitNumMapper;
import com.resumed.sqtwin.model.WebTplVisitNum;
import com.resumed.sqtwin.service.WebTplVisitNumService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/04.
 */
@Service
@Transactional
public class WebTplVisitNumServiceImpl extends AbstractService<WebTplVisitNum> implements WebTplVisitNumService {
    @Resource
    private WebTplVisitNumMapper webTplVisitNumMapper;

}
