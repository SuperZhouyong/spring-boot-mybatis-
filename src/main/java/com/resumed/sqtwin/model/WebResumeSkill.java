package com.resumed.sqtwin.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "web_resume_skill")
public class WebResumeSkill {
    @Id
    @Column(name = "resume_skill_id")
    private Integer resumeSkillId;

    private Integer gid;

    private String rid;

    /**
     * 技能Id
     */
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skill_name")
    private String skillName;

    /**
     * 使用时间
     */
    private String time;

    /**
     * 排序位置
     */
    private Integer rank;

    /**
     * 1 了解 2熟悉 3熟练 4精通
     */
    private Byte level;
    @Transient
    private String levelName ;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * @return resume_skill_id
     */
    public Integer getResumeSkillId() {
        return resumeSkillId;
    }

    /**
     * @param resumeSkillId
     */
    public void setResumeSkillId(Integer resumeSkillId) {
        this.resumeSkillId = resumeSkillId;
    }

    /**
     * @return gid
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * @param gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * 获取技能Id
     *
     * @return skill_id - 技能Id
     */
    public Integer getSkillId() {
        return skillId;
    }

    /**
     * 设置技能Id
     *
     * @param skillId 技能Id
     */
    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    /**
     * @return skill_name
     */
    public String getSkillName() {
        return skillName;
    }

    /**
     * @param skillName
     */
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    /**
     * 获取使用时间
     *
     * @return time - 使用时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置使用时间
     *
     * @param time 使用时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取排序位置
     *
     * @return rank - 排序位置
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置排序位置
     *
     * @param rank 排序位置
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取1 了解 2熟悉 3熟练 4精通
     *
     * @return level - 1 了解 2熟悉 3熟练 4精通
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * 设置1 了解 2熟悉 3熟练 4精通
     *
     * @param level 1 了解 2熟悉 3熟练 4精通
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebResumeSkill that = (WebResumeSkill) o;
        return Objects.equals(skillName, that.skillName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(skillName);
    }
}