package com.hm.birthday.entity;

import java.util.Date;

public class WinPrizeInfo {
    private Integer id;

    private String phoneNum;

    private String workName;

    private String prizeNo;

    private String prizeGrade;

    private String prizeName;

    private String workAddress;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getPrizeNo() {
        return prizeNo;
    }

    public void setPrizeNo(String prizeNo) {
        this.prizeNo = prizeNo == null ? null : prizeNo.trim();
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

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
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