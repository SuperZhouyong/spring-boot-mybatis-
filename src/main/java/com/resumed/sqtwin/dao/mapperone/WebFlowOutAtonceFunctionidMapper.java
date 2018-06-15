package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceFunctionid;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceFunctionBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowOutAtonceFunctionidMapper extends Mapper<WebFlowOutAtonceFunctionid> {

    @Select("SELECT functionId,s.name,sum(count) AS count FROM web_flow_out_atonce_functionId as f inner join sqtcom.sys_proflib_function as s on f.functionId=s.id WHERE cityId =#{cityId} GROUP BY functionId ORDER BY sum(count) DESC LIMIT #{limit}")
    List<WebFlowOutAtonceFunctionBean> selectPostionLocaltop(Integer cityId,@Param("limit") Integer limit);
    @Select("SELECT functionId,s.name,sum(count) AS count FROM web_flow_out_atonce_functionId as f inner join sqtcom.sys_proflib_function as s on f.functionId=s.id WHERE cityId =#{cityId} and tplLevel = #{tplLevel} GROUP BY functionId ORDER BY sum(count) DESC LIMIT #{limit}")
    List<WebFlowOutAtonceFunctionBean> selectPostionLocaltopTwo(@Param("cityId") Integer cityId,@Param("tplLevel") Integer tplLevel,@Param("limit") Integer limit);
}