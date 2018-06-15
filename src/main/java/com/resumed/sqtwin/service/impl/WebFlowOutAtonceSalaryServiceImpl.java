package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowOutAtonceSalaryMapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceSalary;
import com.resumed.sqtwin.model.responseban.WebFlowSalaryBean;
import com.resumed.sqtwin.service.WebFlowOutAtonceSalaryService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
@Service
@Transactional
public class WebFlowOutAtonceSalaryServiceImpl extends AbstractService<WebFlowOutAtonceSalary> implements WebFlowOutAtonceSalaryService {
    @Resource
    private WebFlowOutAtonceSalaryMapper webFlowOutAtonceSalaryMapper;

    @Override
    public List<WebFlowSalaryBean> selectSalaryLocal(Integer cityId, Integer year) {
        return webFlowOutAtonceSalaryMapper.selectSalaryLocal(cityId,year);
    }
}
