package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowAtonceSchoolMapper;
import com.resumed.sqtwin.model.WebFlowAtonceSchool;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceSchoolBean;
import com.resumed.sqtwin.service.WebFlowAtonceSchoolService;
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
public class WebFlowAtonceSchoolServiceImpl extends AbstractService<WebFlowAtonceSchool> implements WebFlowAtonceSchoolService {
    @Resource
    private WebFlowAtonceSchoolMapper webFlowAtonceSchoolMapper;

    @Override
    public Integer slectSumNum(Integer cityId) {
        return webFlowAtonceSchoolMapper.slectSumNum(cityId);
    }



    @Override
    public List<WebFlowAtonceSchoolBean> selectRevalueOne(Integer sumNum, Integer cityId, Integer limit) {
        return webFlowAtonceSchoolMapper.selectRevalueOne(sumNum, cityId,limit);
    }

    @Override
    public Integer slectSumNumTwo(Integer cityId, Integer tplLevel) {
        return webFlowAtonceSchoolMapper.slectSumNumTwo(cityId, tplLevel);
    }



    @Override
    public List<WebFlowAtonceSchoolBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel, Integer limit) {
        return webFlowAtonceSchoolMapper.selectRevalueTwo(sumNum, cityId, tplLevel,limit);
    }
}
