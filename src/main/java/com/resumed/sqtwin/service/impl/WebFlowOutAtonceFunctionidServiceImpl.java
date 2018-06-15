package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowOutAtonceFunctionidMapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceFunctionid;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceFunctionBean;
import com.resumed.sqtwin.service.WebFlowOutAtonceFunctionidService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
@Service
@Transactional
public class WebFlowOutAtonceFunctionidServiceImpl extends AbstractService<WebFlowOutAtonceFunctionid> implements WebFlowOutAtonceFunctionidService {
    @Resource
    private WebFlowOutAtonceFunctionidMapper webFlowOutAtonceFunctionidMapper;



    @Override
    public List<WebFlowOutAtonceFunctionBean> selectPostionLocaltop(Integer cityId, Integer limit) {
        return webFlowOutAtonceFunctionidMapper.selectPostionLocaltop(cityId,limit);
    }

    @Override
    public List<WebFlowOutAtonceFunctionBean> selectPostionLocaltopTwo(Integer cityId, Integer tplLevel,Integer limit) {
        return webFlowOutAtonceFunctionidMapper.selectPostionLocaltopTwo(cityId,tplLevel,limit);
    }
}
