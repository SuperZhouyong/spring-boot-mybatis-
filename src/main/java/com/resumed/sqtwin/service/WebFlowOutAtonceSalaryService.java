package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowOutAtonceSalary;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowSalaryBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
public interface WebFlowOutAtonceSalaryService extends Service<WebFlowOutAtonceSalary> {

    List<WebFlowSalaryBean> selectSalaryLocal(Integer cityId, Integer year);
}
