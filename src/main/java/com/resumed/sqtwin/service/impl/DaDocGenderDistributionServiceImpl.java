package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.DaDocGenderDistributionMapper;
import com.resumed.sqtwin.model.DaDocGenderDistribution;
import com.resumed.sqtwin.service.DaDocGenderDistributionService;
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
public class DaDocGenderDistributionServiceImpl extends AbstractService<DaDocGenderDistribution> implements DaDocGenderDistributionService {
    @Resource
    private DaDocGenderDistributionMapper daDocGenderDistributionMapper;

    @Override
    public List<DaDocGenderDistribution> getSexNum(Integer industryId) {
        return daDocGenderDistributionMapper.getSexNum(industryId);
    }
}
