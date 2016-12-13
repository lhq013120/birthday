package com.hm.birthday.entity;

import java.util.Date;

public class PrizeInfo {
    private Integer id;

    private String prizeGrade;

    private String prizeName;

    private Date updateTime;

    private Date creteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrizeGrade() {
        return prizeGrade;
    }

    public void setPrizeGrade(String prizeGrade) {
        this.prizeGrade = prizeGrade == null ? null : prizeGrade.trim();
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreteTime() {
        return creteTime;
    }

    public void setCreteTime(Date creteTime) {
        this.creteTime = creteTime;
    }
}