package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowAtonceIndustry;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceIndustryBean;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceSchoolBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowAtonceIndustryMapper extends Mapper<WebFlowAtonceIndustry> {

 /*   @Select("  Select SUM(m.count) as count from web_flow_atonce_school as m inner join sqtcom.web_region r on m.schoolProvinceId=r.id where m.provinceId=#{cityId}   ")
    Integer slectSumNum(Integer cityId);

    @Select(" Select SUM(m.count) as count from web_flow_atonce_school as m inner join sqtcom.web_region r on m.schoolProvinceId=r.id where m.provinceId=#{cityId} and m.tplLevel=#{tplLevel} ")
    Integer slectSumNumTwo(@Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel);*/
   // Select SUM(m.count) as sum,m.industryId as id,gt.name from web_flow_atonce_industry as m inner join sqtcom.web_industry gt on m.industryId=gt.id where m.provinceId=110000 and m.tplLevel=1 group by m.industryId order by sum desc limit 10
    @Select("Select SUM(m.count) as sum,m.industryId as id,gt.name from web_flow_atonce_industry as m inner join sqtcom.web_industry gt on m.industryId=gt.id where m.provinceId=#{cityId}   group by m.industryId order by sum desc limit #{limit}")
    List<WebFlowAtonceIndustryBean> selectRevalueOne(@Param("limit") Integer limit , @Param("cityId") Integer cityId);
           //Select SUM(m.count) as sum,m.industryId as id,gt.name from web_flow_atonce_industry as m inner join sqtcom.web_industry gt on m.industryId=gt.id where m.provinceId=110000 and m.tplLevel=1 group by m.industryId order by sum desc limit 10
    @Select("Select SUM(m.count) as sum,m.industryId as id,gt.name from web_flow_atonce_industry as m inner join sqtcom.web_industry gt on m.industryId=gt.id where m.provinceId=#{cityId} and m.tplLevel=#{tplLevel} group by m.industryId order by sum desc limit #{limit}")
    List<WebFlowAtonceIndustryBean> selectRevalueTwo( @Param("limit") Integer limit ,@Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel);
}