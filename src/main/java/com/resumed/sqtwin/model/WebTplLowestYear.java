package com.resumed.sqtwin.model;

import javax.persistence.*;

@Table(name = "web_tpl_lowest_year")
public class WebTplLowestYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 职位名称开头
     */
    private String head;

    /**
     * 职位名称结尾
     */
    private String tail;

    /**
     * 最低年限
     */
    @Column(name = "lowest_year")
    private Byte lowestYear;

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
     * 获取职位名称开头
     *
     * @return head - 职位名称开头
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置职位名称开头
     *
     * @param head 职位名称开头
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取职位名称结尾
     *
     * @return tail - 职位名称结尾
     */
    public String getTail() {
        return tail;
    }

    /**
     * 设置职位名称结尾
     *
     * @param tail 职位名称结尾
     */
    public void setTail(String tail) {
        this.tail = tail;
    }

    /**
     * 获取最低年限
     *
     * @return lowest_year - 最低年限
     */
    public Byte getLowestYear() {
        return lowestYear;
    }

    /**
     * 设置最低年限
     *
     * @param lowestYear 最低年限
     */
    public void setLowestYear(Byte lowestYear) {
        this.lowestYear = lowestYear;
    }
}