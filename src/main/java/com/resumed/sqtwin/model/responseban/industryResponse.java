package com.resumed.sqtwin.model.responseban;

import com.resumed.sqtwin.model.WebIndustry;

import java.util.List;

/**
 * @auther Super
 * @data 2018/4/17 0017
 * @time 下午 18:06
 */
public class industryResponse {
    private List<WebIndustry> industriesList;
//    private List<filterResponse.Bean> regionList;

    public List<WebIndustry> getIndustriesList() {
        return industriesList;
    }

    public void setIndustriesList(List<WebIndustry> industriesList) {
        this.industriesList = industriesList;
    }

  /*  public List<filterResponse.Bean> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<filterResponse.Bean> regionList) {
        this.regionList = regionList;
    }*/
}
