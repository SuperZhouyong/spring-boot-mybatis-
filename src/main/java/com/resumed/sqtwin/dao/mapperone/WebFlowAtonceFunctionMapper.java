package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowAtonceFunction;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceFunctionBean;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceIndustryBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowAtonceFunctionMapper extends Mapper<WebFlowAtonceFunction> {

    @Select("Select SUM(m.count) as sum,m.functionId as id,gt.name as name from web_flow_atonce_function as m inner join sqtcom.sys_proflib_function gt on m.functionId=gt.id where m.provinceId=#{cityId}   group by m.functionId order by sum desc limit #{limit}")
    List<WebFlowAtonceFunctionBean> selectRevalueOne(@Param("limit") Integer limit, @Param("cityId") Integer cityId);
    //Select SUM(m.count) as sum,m.functionId as id,gt.name as name from web_flow_atonce_function as m inner join sqtcom.sys_proflib_function gt on m.functionId=gt.id where m.provinceId=110000  and m.tplLevel=1 group by m.functionId order by sum desc limit 10
    @Select("Select SUM(m.count) as sum,m.functionId as id,gt.name as name from web_flow_atonce_function as m inner join sqtcom.sys_proflib_function gt on m.functionId=gt.id where m.provinceId=#{cityId}  and m.tplLevel=#{tplLevel} group by m.functionId order by sum desc limit #{limit}")
    List<WebFlowAtonceFunctionBean> selectRevalueTwo(@Param("limit") Integer limit , @Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel);
}