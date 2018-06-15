package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.WebCertificateMapper;
import com.resumed.sqtwin.model.WebCertificate;
import com.resumed.sqtwin.service.WebCertificateService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/18.
 */
@Service
@Transactional
public class WebCertificateServiceImpl extends AbstractService<WebCertificate> implements WebCertificateService {
    @Resource
    private WebCertificateMapper webCertificateMapper;

}
