package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebDocTplSalaryMapper;
import com.resumed.sqtwin.model.WebDocTplSalary;
import com.resumed.sqtwin.service.WebDocTplSalaryService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
@Service
@Transactional
public class WebDocTplSalaryServiceImpl extends AbstractService<WebDocTplSalary> implements WebDocTplSalaryService {
    @Resource
    private WebDocTplSalaryMapper webDocTplSalaryMapper;

}
