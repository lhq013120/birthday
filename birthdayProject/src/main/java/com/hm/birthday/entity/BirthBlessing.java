package com.hm.birthday.entity;

import java.util.Date;

public class BirthBlessing {
    private Integer id;

    private String birthPerson;

    private String birthPersonPnum;

    private String blePerson;

    private String blePersonPnum;

    private String bleContent;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBirthPerson() {
        return birthPerson;
    }

    public void setBirthPerson(String birthPerson) {
        this.birthPerson = birthPerson == null ? null : birthPerson.trim();
    }

    public String getBirthPersonPnum() {
        return birthPersonPnum;
    }

    public void setBirthPersonPnum(String birthPersonPnum) {
        this.birthPersonPnum = birthPersonPnum == null ? null : birthPersonPnum.trim();
    }

    public String getBlePerson() {
        return blePerson;
    }

    public void setBlePerson(String blePerson) {
        this.blePerson = blePerson == null ? null : blePerson.trim();
    }

    public String getBlePersonPnum() {
        return blePersonPnum;
    }

    public void setBlePersonPnum(String blePersonPnum) {
        this.blePersonPnum = blePersonPnum == null ? null : blePersonPnum.trim();
    }

    public String getBleContent() {
        return bleContent;
    }

    public void setBleContent(String bleContent) {
        this.bleContent = bleContent == null ? null : bleContent.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}