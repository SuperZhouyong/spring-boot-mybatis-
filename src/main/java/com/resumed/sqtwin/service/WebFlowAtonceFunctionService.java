package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowAtonceFunction;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceFunctionBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/15.
 */
public interface WebFlowAtonceFunctionService extends Service<WebFlowAtonceFunction> {

    List<WebFlowAtonceFunctionBean> selectRevalueOne(int i, Integer cityId);

    List<WebFlowAtonceFunctionBean> selectRevalueTwo(int i, Integer cityId, Integer tplLevel);
}
