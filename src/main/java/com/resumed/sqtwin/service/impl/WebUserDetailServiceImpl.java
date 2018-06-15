package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebUserDetailMapper;
import com.resumed.sqtwin.model.WebUserDetail;
import com.resumed.sqtwin.service.WebUserDetailService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by CodeGenerator on 2018/04/13.
 */
@Service
@Transactional
public class WebUserDetailServiceImpl extends AbstractService<WebUserDetail> implements WebUserDetailService {
    @Resource
    private WebUserDetailMapper webUserDetailMapper;

    @Override
    public void UpdateIconImage(String gid, String icon_image, Date update_date) {
        webUserDetailMapper.UpdateIconImage(gid, icon_image,update_date);
    }
}
