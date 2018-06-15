package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebDocJobhoppingTimeMapper;
import com.resumed.sqtwin.model.WebDocJobhoppingTime;
import com.resumed.sqtwin.service.WebDocJobhoppingTimeService;
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
public class WebDocJobhoppingTimeServiceImpl extends AbstractService<WebDocJobhoppingTime> implements WebDocJobhoppingTimeService {
    @Resource
    private WebDocJobhoppingTimeMapper webDocJobhoppingTimeMapper;

    @Override
    public List<WebDocJobhoppingTime> getWebDocJobTimeList( Integer industryid,Integer limit) {
        return webDocJobhoppingTimeMapper.getWebDocJobTimeList(industryid,limit);
    }
}
