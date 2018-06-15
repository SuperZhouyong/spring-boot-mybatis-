package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowOutAtonceIndustryid;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceIndustryBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
public interface WebFlowOutAtonceIndustryidService extends Service<WebFlowOutAtonceIndustryid> {

    List<WebFlowOutAtonceIndustryBean> selectIndustryLocaltop(Integer cityId,Integer limit);


    List<WebFlowOutAtonceIndustryBean> selectIndustryLocaltopTwo(Integer cityId,Integer tplLevel,Integer limit);
}
