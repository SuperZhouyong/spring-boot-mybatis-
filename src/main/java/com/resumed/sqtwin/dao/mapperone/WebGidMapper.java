package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebGid;

import java.util.List;

public interface WebGidMapper extends Mapper<WebGid> {
    // 关联表处理

    List<WebGid> queryList(Integer gid);
    Integer InsertWebGid(WebGid webGid);
}