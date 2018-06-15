package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowOutAtonceNativecityid;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceNativecityidBean;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
public interface WebFlowOutAtonceNativecityidService extends Service<WebFlowOutAtonceNativecityid> {

    Integer slectSumNum(Integer cityId);

    Integer slectSumNumTwo(Integer cityId,Integer tplLevel);

    List<WebFlowOutAtonceNativecityidBean> selectRevalueOne(Integer sumNum, Integer cityId,Integer limit);

    List<WebFlowOutAtonceNativecityidBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel,Integer limit);
}
