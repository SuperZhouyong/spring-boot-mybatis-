package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebFlowOutAtonceIndustryidMapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceIndustryid;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceIndustryBean;
import com.resumed.sqtwin.service.WebFlowOutAtonceIndustryidService;
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
public class WebFlowOutAtonceIndustryidServiceImpl extends AbstractService<WebFlowOutAtonceIndustryid> implements WebFlowOutAtonceIndustryidService {
    @Resource
    private WebFlowOutAtonceIndustryidMapper webFlowOutAtonceIndustryidMapper;

    @Override
    public List<WebFlowOutAtonceIndustryBean> selectIndustryLocaltop(Integer cityId,Integer limit) {
        return webFlowOutAtonceIndustryidMapper.selectIndustryLocaltop(cityId,limit);
    }

    @Override
    public List<WebFlowOutAtonceIndustryBean> selectIndustryLocaltopTwo(Integer cityId, Integer tplLevel,Integer limit) {
        return webFlowOutAtonceIndustryidMapper.selectIndustryLocaltopTwo(cityId, tplLevel,limit);
    }
}
