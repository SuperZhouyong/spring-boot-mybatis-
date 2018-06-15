package com.resumed.sqtwin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_tpl_visit_num")
public class WebTplVisitNum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String host;

    private String code;

    @Column(name = "tplId")
    private Integer tplid;

    private Byte num;

    private Date at;

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
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return tplId
     */
    public Integer getTplid() {
        return tplid;
    }

    /**
     * @param tplid
     */
    public void setTplid(Integer tplid) {
        this.tplid = tplid;
    }

    /**
     * @return num
     */
    public Byte getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Byte num) {
        this.num = num;
    }

    /**
     * @return at
     */
    public Date getAt() {
        return at;
    }

    /**
     * @param at
     */
    public void setAt(Date at) {
        this.at = at;
    }
}