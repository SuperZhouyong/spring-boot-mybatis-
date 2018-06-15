package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowOutAtonceNativecityidMapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceNativecityid;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceNativecityidBean;
import com.resumed.sqtwin.service.WebFlowOutAtonceNativecityidService;
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
public class WebFlowOutAtonceNativecityidServiceImpl extends AbstractService<WebFlowOutAtonceNativecityid> implements WebFlowOutAtonceNativecityidService {
    @Resource
    private WebFlowOutAtonceNativecityidMapper webFlowOutAtonceNativecityidMapper;

    @Override
    public Integer slectSumNum(Integer cityId) {
        return webFlowOutAtonceNativecityidMapper.slectSumNum(cityId);
    }

    @Override
    public Integer slectSumNumTwo(Integer cityId, Integer tplLevel) {
        return webFlowOutAtonceNativecityidMapper.selectSumNumTwo(cityId, tplLevel);
    }

    @Override
    public List<WebFlowOutAtonceNativecityidBean> selectRevalueOne(Integer sumNum, Integer cityId, Integer limit) {
        return webFlowOutAtonceNativecityidMapper.selectRevalueOne(sumNum,cityId,limit);
    }

    @Override
    public List<WebFlowOutAtonceNativecityidBean> selectRevalueTwo(Integer sumNum, Integer cityId, Integer tplLevel,Integer limit) {
        return webFlowOutAtonceNativecityidMapper.selectRevalueTwo(sumNum,cityId,tplLevel,limit);
    }
}
