package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebDocJobDistributionMapper;
import com.resumed.sqtwin.model.WebDocJobDistribution;
import com.resumed.sqtwin.model.responseban.WebDocJobDistrBean;
import com.resumed.sqtwin.service.WebDocJobDistributionService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/11.
 */
@Service
@Transactional
public class WebDocJobDistributionServiceImpl extends AbstractService<WebDocJobDistribution> implements WebDocJobDistributionService {
    @Resource
    private WebDocJobDistributionMapper webDocJobDistributionMapper;


    @Override
    public List<WebDocJobDistrBean> selecIndustryList(Integer industryId, int i) {
        return webDocJobDistributionMapper.selecIndustryList(industryId, i);
    }
}
