package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowAtonceSalaryMapper;
import com.resumed.sqtwin.model.WebFlowAtonceSalary;
import com.resumed.sqtwin.service.WebFlowAtonceSalaryService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/15.
 */
@Service
@Transactional
public class WebFlowAtonceSalaryServiceImpl extends AbstractService<WebFlowAtonceSalary> implements WebFlowAtonceSalaryService {
    @Resource
    private WebFlowAtonceSalaryMapper webFlowAtonceSalaryMapper;

}
