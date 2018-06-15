package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.configurer.DS;
import com.resumed.sqtwin.configurer.DataSourceContextHolder;
import com.resumed.sqtwin.core.AbstractService;
import com.resumed.sqtwin.dao.mapperone.WebGidMapper;
import com.resumed.sqtwin.model.WebGid;
import com.resumed.sqtwin.service.WebGidService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/09.
 */
@Service
@Transactional
public class WebGidServiceImpl extends AbstractService<WebGid> implements WebGidService {
    @Resource
    WebGidMapper webGidMapper ;
    @DS(DataSourceContextHolder.One)
    @Override
    public List<WebGid> queryList(Integer gid) {
        return webGidMapper.queryList(gid);
    }
    @DS(DataSourceContextHolder.Two)
    @Override
    public Integer InsertWebGid(WebGid webGid) {
        return webGidMapper.InsertWebGid(webGid);
    }



  /*  public List<WebGid> queryList(WebGid webGid){
        return webGidMapper.queryList(webGid.getGid());
    }*/

    // 连表查询

//    public List<WebGid> queryList(Integer gid) {
//        return ((WebGidMapper) mapper).queryList(gid);
//    }
}
