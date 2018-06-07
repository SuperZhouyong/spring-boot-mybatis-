package com.resumed.sqtwin.model.responseban;

import java.util.List;

/**
 * @auther Super
 * @data 2018/4/18 0018
 * @time 上午 10:05
 */
public class householdResponse {
    private List<householdCity> householdprovince;
    private List<Bean> hotCity;

    public List<householdCity> getHouseholdCity() {
        return householdprovince;
    }

    public void setHouseholdCity(List<householdCity> householdCity) {
        this.householdprovince = householdCity;
    }

    public List<Bean> getHotCity() {
        return hotCity;
    }

    public void setHotCity(List<Bean> hotCity) {
        this.hotCity = hotCity;
    }

    public static class householdCity {
        private int id;
        private String name;
        private List<Bean> cityList;

        public householdCity(int id, String name, List<Bean> cityList) {
            this.id = id;
            this.name = name;
            this.cityList = cityList;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Bean> getCityList() {
            return cityList;
        }

        public void setCityList(List<Bean> cityList) {
            this.cityList = cityList;
        }
    }
}
