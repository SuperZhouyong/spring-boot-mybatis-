package com.resumed.sqtwin.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Table(name = "da_i_tpl")
public class DaITpl {
    @Id
    @Column(name = "tplId")
    private Integer tplid;

    @Column(name = "tplName")
    private String tplname;

    @Column(name = "tplIdOriginal")
    private Integer tplidoriginal;

    @Column(name = "relatedTpl")
    private String relatedtpl;

    @Column(name = "relatedTpl30")
    private String relatedtpl30;

    /**
     * 0: 社招   1:校招
     */
    private Byte type;

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
     * @return tplName
     */
    public String getTplname() {
        return tplname;
    }

    /**
     * @param tplname
     */
    public void setTplname(String tplname) {
        this.tplname = tplname;
    }

    /**
     * @return tplIdOriginal
     */
    public Integer getTplidoriginal() {
        return tplidoriginal;
    }

    /**
     * @param tplidoriginal
     */
    public void setTplidoriginal(Integer tplidoriginal) {
        this.tplidoriginal = tplidoriginal;
    }

    /**
     * @return relatedTpl
     */
    public String getRelatedtpl() {
        return relatedtpl;
    }

    /**
     * @param relatedtpl
     */
    public void setRelatedtpl(String relatedtpl) {
        this.relatedtpl = relatedtpl;
    }

    /**
     * @return relatedTpl30
     */
    public String getRelatedtpl30() {
        return relatedtpl30;
    }

    /**
     * @param relatedtpl30
     */
    public void setRelatedtpl30(String relatedtpl30) {
        this.relatedtpl30 = relatedtpl30;
    }

    /**
     * 获取0: 社招   1:校招
     *
     * @return type - 0: 社招   1:校招
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置0: 社招   1:校招
     *
     * @param type 0: 社招   1:校招
     */
    public void setType(Byte type) {
        this.type = type;
    }
}