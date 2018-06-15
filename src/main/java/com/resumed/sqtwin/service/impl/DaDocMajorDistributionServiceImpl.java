package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.DaDocMajorDistributionMapper;
import com.resumed.sqtwin.model.DaDocMajorDistribution;
import com.resumed.sqtwin.service.DaDocMajorDistributionService;
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
public class DaDocMajorDistributionServiceImpl extends AbstractService<DaDocMajorDistribution> implements DaDocMajorDistributionService {
    @Resource
    private DaDocMajorDistributionMapper daDocMajorDistributionMapper;


    @Override
    public Integer selectNum() {
        return daDocMajorDistributionMapper.selecNum();
    }

    @Override
    public List<DaDocMajorDistribution> selecTenDaDoc(Integer industry,Integer limit) {
        return daDocMajorDistributionMapper.selecTenDaDoc(industry,limit);
    }
}
