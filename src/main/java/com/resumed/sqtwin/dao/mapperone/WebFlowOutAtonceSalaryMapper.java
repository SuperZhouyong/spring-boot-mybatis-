package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceSalary;
import com.resumed.sqtwin.model.responseban.WebFlowSalaryBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowOutAtonceSalaryMapper extends Mapper<WebFlowOutAtonceSalary> {
    @Select("SELECT workDate,ceil((sum(salary)/count(id))/100)*100 AS salary FROM web_flow_out_atonce_salary WHERE cityId =#{cityId} AND workDate < #{year} GROUP BY workDate")
    List<WebFlowSalaryBean> selectSalaryLocal(@Param("cityId") Integer cityId, @Param("year") Integer year);
}