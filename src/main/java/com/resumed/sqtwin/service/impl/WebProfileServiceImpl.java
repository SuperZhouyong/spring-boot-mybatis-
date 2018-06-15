package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebProfileMapper;
import com.resumed.sqtwin.model.WebProfile;
import com.resumed.sqtwin.service.WebProfileService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
@Service
@Transactional
public class WebProfileServiceImpl extends AbstractService<WebProfile> implements WebProfileService {
    @Resource
    private WebProfileMapper webProfileMapper;

    @Override
    public WebProfile InsertResume() {
        return null;
    }

    @Override
    public List<WebProfile> selectRegionalList(Integer gid) {
        return webProfileMapper.selectRegionalList(gid);
    }
}
