package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowOutAtonceWorkcityidMapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceWorkcityid;
import com.resumed.sqtwin.model.responseban.WebFlowOutBean;
import com.resumed.sqtwin.service.WebFlowOutAtonceWorkcityidService;
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
public class WebFlowOutAtonceWorkcityidServiceImpl extends AbstractService<WebFlowOutAtonceWorkcityid> implements WebFlowOutAtonceWorkcityidService {
    @Resource
    private WebFlowOutAtonceWorkcityidMapper webFlowOutAtonceWorkcityidMapper;

    @Override
    public Double selectNumCountOne(Integer cityId, Integer tplLevel) {
        return webFlowOutAtonceWorkcityidMapper.selectNumCountOne( cityId,  tplLevel);
    }

    @Override
    public Double selectNumCountTwo(Integer cityId) {
        return webFlowOutAtonceWorkcityidMapper.selectNumCountTwo( cityId);
    }

    @Override
    public List<WebFlowOutBean> selecRevalueOne(Double sum, Integer cityId,Integer limit) {
        return webFlowOutAtonceWorkcityidMapper.selectRevalueOne(sum, cityId,sum,limit);
    }

    @Override
    public List<WebFlowOutBean> slectRevalueTwo(Double sum, Integer cityId, Integer tplLevel,Integer limit) {
        return webFlowOutAtonceWorkcityidMapper.selectRevalueTwo(sum, cityId, tplLevel,sum,limit);
    }


}
