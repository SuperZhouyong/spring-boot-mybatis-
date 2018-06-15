package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_major_ex")
public class WebMajorEx {
    private String name;
    // 手动指定了主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer degree;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return degree
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * @param degree
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}