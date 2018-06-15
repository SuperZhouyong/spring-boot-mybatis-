package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowAtonceIndustry;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceIndustryBean;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceSchoolBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/15.
 */
public interface WebFlowAtonceIndustryService extends Service<WebFlowAtonceIndustry> {

//    Integer slectSumNum(Integer cityId);

    List<WebFlowAtonceIndustryBean> selectRevalueOne(Integer sumNum, Integer cityId);

//    Integer slectSumNumTwo(Integer cityId, Integer tplLevel);

    List<WebFlowAtonceIndustryBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel);
}
