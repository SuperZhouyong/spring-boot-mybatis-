package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowAtonceSchool;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceNativeBean;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceSchoolBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowAtonceSchoolMapper extends Mapper<WebFlowAtonceSchool> {
    @Select("  Select SUM(m.count) as count from web_flow_atonce_school as m inner join sqtcom.web_region r on m.schoolProvinceId=r.id where m.provinceId=#{cityId}   ")
    Integer slectSumNum(Integer cityId);

    @Select(" Select SUM(m.count) as count from web_flow_atonce_school as m inner join sqtcom.web_region r on m.schoolProvinceId=r.id where m.provinceId=#{cityId} and m.tplLevel=#{tplLevel} ")
    Integer slectSumNumTwo(@Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel);
    // Select SUM(m.count) as sum,m.schoolProvinceId as id,r.name from web_flow_atonce_school as m inner join sqtcom.web_region r on m.schoolProvinceId=r.id where m.provinceId=110000 and m.tplLevel=1 group by m.schoolProvinceId order by sum desc
    @Select("SELECT schoolProvinceId AS reCityId,r.name,ROUND(sum(count)/#{sumNum}*100,1) AS reValue,sum(count) AS reCount FROM web_flow_atonce_school as f inner join sqtcom.web_region as r on f.schoolProvinceId=r.id WHERE f.provinceId =#{cityId}  GROUP BY f.provinceId ORDER BY sum(count)/#{sumNum} DESC  limit #{limit}")
    List<WebFlowAtonceSchoolBean> selectRevalueOne(@Param("sumNum") Integer sumNum, @Param("cityId") Integer cityId,@Param("limit") Integer limit);

    @Select("SELECT schoolProvinceId AS reCityId,r.name,ROUND(sum(count)/#{sumNum}*100,1) AS reValue,sum(count) AS reCount FROM web_flow_atonce_school as f inner join sqtcom.web_region as r on f.schoolProvinceId=r.id WHERE f.provinceId =#{cityId} AND f.tplLevel =#{tplLevel} GROUP BY f.provinceId ORDER BY sum(count)/#{sumNum} DESC  limit #{limit}")
    List<WebFlowAtonceSchoolBean> selectRevalueTwo(@Param("sumNum") Integer sumNum, @Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel, @Param("limit") Integer limit);
}