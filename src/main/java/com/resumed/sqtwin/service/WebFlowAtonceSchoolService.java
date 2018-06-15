package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowAtonceSchool;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceSchoolBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/15.
 */
public interface WebFlowAtonceSchoolService extends Service<WebFlowAtonceSchool> {

    Integer slectSumNum(Integer cityId);

    List<WebFlowAtonceSchoolBean> selectRevalueOne(Integer sumNum, Integer cityId,Integer limit);

    Integer slectSumNumTwo(Integer cityId, Integer tplLevel);

    List<WebFlowAtonceSchoolBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel,Integer limit);
}
