package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowAtonceNativeMapper;
import com.resumed.sqtwin.model.WebFlowAtonceNative;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceNativeBean;
import com.resumed.sqtwin.service.WebFlowAtonceNativeService;
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
public class WebFlowAtonceNativeServiceImpl extends AbstractService<WebFlowAtonceNative> implements WebFlowAtonceNativeService {

    @Resource
    private WebFlowAtonceNativeMapper webFlowAtonceNativeMapper;


    @Override
    public Integer slectSumNum(Integer cityId) {
        return webFlowAtonceNativeMapper.slectSumNum(cityId);
    }

    @Override
    public List<WebFlowAtonceNativeBean> selectRevalueOne(Integer sumNum, Integer cityId, Integer limit) {
        return webFlowAtonceNativeMapper.selectRevalueOne(sumNum, cityId,limit);
    }

    @Override
    public Integer slectSumNumTwo(Integer cityId, Integer tplLevel) {
        return webFlowAtonceNativeMapper.slectSumNumTwo(cityId, tplLevel);
    }

    @Override
    public List<WebFlowAtonceNativeBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel, Integer limit) {
        return webFlowAtonceNativeMapper.selectRevalueTwo(sumNum, cityId, tplLevel,limit);
    }
}
