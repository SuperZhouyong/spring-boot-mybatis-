package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowAtonceFunctionMapper;
import com.resumed.sqtwin.model.WebFlowAtonceFunction;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceFunctionBean;
import com.resumed.sqtwin.service.WebFlowAtonceFunctionService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/15.
 */
@Service
@Transactional
public class WebFlowAtonceFunctionServiceImpl extends AbstractService<WebFlowAtonceFunction> implements WebFlowAtonceFunctionService {
    @Resource
    private WebFlowAtonceFunctionMapper webFlowAtonceFunctionMapper;

    @Override
    public List<WebFlowAtonceFunctionBean> selectRevalueOne(int i, Integer cityId) {
        return webFlowAtonceFunctionMapper.selectRevalueOne(i,cityId);
    }

    @Override
    public List<WebFlowAtonceFunctionBean> selectRevalueTwo(int i, Integer cityId, Integer tplLevel) {
        return webFlowAtonceFunctionMapper.selectRevalueTwo(i,cityId,tplLevel);
    }
}
