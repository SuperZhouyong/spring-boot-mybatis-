package com.resumed.sqtwin.service;

import com.resumed.sqtwin.model.WebFlowAtonceNative;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceNativeBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/15.
 */
public interface WebFlowAtonceNativeService extends Service<WebFlowAtonceNative> {

    Integer slectSumNum(Integer cityId);

    List<WebFlowAtonceNativeBean> selectRevalueOne(Integer sumNum, Integer cityId,Integer limit);

    Integer slectSumNumTwo(Integer cityId, Integer tplLevel);

    List<WebFlowAtonceNativeBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel,Integer limit);
}
