package com.resumed.sqtwin.model.responseban;

/**
 * @auther Super
 * @data 2018/6/13 0013
 * @time 下午 15:21
 */
public class specialtydistributionBean {
    private Integer id ;
    private String name ;
    private Integer vaule ;

    public specialtydistributionBean(Integer id, String name, Integer vaule) {
        this.id = id;
        this.name = name;
        this.vaule = vaule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVaule() {
        return vaule;
    }

    public void setVaule(Integer vaule) {
        this.vaule = vaule;
    }


}
