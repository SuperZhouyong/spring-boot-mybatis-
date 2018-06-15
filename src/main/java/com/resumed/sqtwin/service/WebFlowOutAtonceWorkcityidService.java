package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebFlowOutAtonceWorkcityid;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebFlowOutBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
public interface WebFlowOutAtonceWorkcityidService extends Service<WebFlowOutAtonceWorkcityid> {

    Double selectNumCountOne(Integer cityId, Integer tplLevel);
    Double selectNumCountTwo(Integer cityId);

    List<WebFlowOutBean> selecRevalueOne(Double sum,Integer cityId ,Integer limit);

    List<WebFlowOutBean> slectRevalueTwo(Double sum,Integer cityId ,Integer tplLevel,Integer limit);
}
