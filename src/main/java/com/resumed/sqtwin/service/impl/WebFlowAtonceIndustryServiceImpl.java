package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowAtonceIndustryMapper;
import com.resumed.sqtwin.model.WebFlowAtonceIndustry;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceIndustryBean;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceSchoolBean;
import com.resumed.sqtwin.service.WebFlowAtonceIndustryService;
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
public class WebFlowAtonceIndustryServiceImpl extends AbstractService<WebFlowAtonceIndustry> implements WebFlowAtonceIndustryService {
    @Resource
    private WebFlowAtonceIndustryMapper webFlowAtonceIndustryMapper;

  /*  @Override
    public Integer slectSumNum(Integer cityId) {
        return webFlowAtonceIndustryMapper.slectSumNum(cityId);
    }*/

    @Override
    public List<WebFlowAtonceIndustryBean> selectRevalueOne(Integer sumNum, Integer cityId) {
        return webFlowAtonceIndustryMapper.selectRevalueOne( 10,cityId);
    }

  /*  @Override
    public Integer slectSumNumTwo(Integer cityId, Integer tplLevel) {
        return webFlowAtonceIndustryMapper.slectSumNumTwo(cityId, tplLevel);
    }*/

    @Override
    public List<WebFlowAtonceIndustryBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel) {
        return webFlowAtonceIndustryMapper.selectRevalueTwo(10,cityId, tplLevel);
    }
}
