package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebDocCityDistributionMapper;
import com.resumed.sqtwin.model.WebDocCityDistribution;
import com.resumed.sqtwin.service.WebDocCityDistributionService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
@Service
@Transactional
public class WebDocCityDistributionServiceImpl extends AbstractService<WebDocCityDistribution> implements WebDocCityDistributionService {
    @Resource
    private WebDocCityDistributionMapper webDocCityDistributionMapper;

    @Override
    public List<WebDocCityDistribution> selectEmployarea(Integer industryid, int i) {
        return webDocCityDistributionMapper.selectEmployarea(industryid,i);
    }
}
