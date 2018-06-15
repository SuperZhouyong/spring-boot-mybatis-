package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebDocCityDistribution;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebDocCityDistributionMapper extends Mapper<WebDocCityDistribution> {
    @Select("SELECT * FROM web_doc_city_distribution WHERE industryId =#{industryid} ORDER BY count LIMIT #{limit}")
    List<WebDocCityDistribution> selectEmployarea(@Param("industryid") Integer industryid, @Param("limit") int i);
}