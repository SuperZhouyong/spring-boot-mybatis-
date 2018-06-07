package com.resumed.sqtwin.model.bean;

/**
 * @auther Super
 * @data 2018/5/9 0009
 * @time 上午 10:46
 */
public class YearBean {
    // 当前id
    private int id;
    // 最低年限
    private int year;
    // 职位名字
    private String name;
    // 当前工作结束时间
    private Long endYear ;

    public YearBean(int id, int year, String name, Long endYear) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.endYear = endYear;
    }

    public Long getEndYear() {
        return endYear;
    }

    public void setEndYear(Long endYear) {
        this.endYear = endYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
