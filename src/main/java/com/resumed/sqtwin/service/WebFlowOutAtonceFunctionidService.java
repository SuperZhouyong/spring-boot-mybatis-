package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowOutAtonceFunctionid;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceFunctionBean;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceIndustryBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
public interface WebFlowOutAtonceFunctionidService extends Service<WebFlowOutAtonceFunctionid> {


    List<WebFlowOutAtonceFunctionBean> selectPostionLocaltop(Integer cityId,Integer limit);

    List<WebFlowOutAtonceFunctionBean> selectPostionLocaltopTwo(Integer cityId, Integer tplLevel,Integer limit);
}
