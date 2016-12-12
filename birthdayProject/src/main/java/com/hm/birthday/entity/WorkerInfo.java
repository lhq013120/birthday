package com.hm.birthday.entity;

import java.util.Date;

public class WorkerInfo {
    private Integer id;

    private String phoneNum;

    private String workName;

    private String password;

    private Date birthday;

    private String workerRole;

    private String workerImg;

    private String shrinkImg;

    private String workerConstellation;

    private String bloodType;

    private String workerHobby;

    private String isfirstLogin;

    private Date updateTime;

    private Date creteTime;

    public WorkerInfo() {
	}

	public WorkerInfo(String phoneNum, String workName, String password, Date birthday, String workerRole,
			String workerImg, String shrinkImg, String workerConstellation, String bloodType, String workerHobby,
			String isfirstLogin, Date updateTime, Date creteTime) {
		super();
		this.phoneNum = phoneNum;
		this.workName = workName;
		this.password = password;
		this.birthday = birthday;
		this.workerRole = workerRole;
		this.workerImg = workerImg;
		this.shrinkImg = shrinkImg;
		this.workerConstellation = workerConstellation;
		this.bloodType = bloodType;
		this.workerHobby = workerHobby;
		this.isfirstLogin = isfirstLogin;
		this.updateTime = updateTime;
		this.creteTime = creteTime;
	}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(String workerRole) {
        this.workerRole = workerRole == null ? null : workerRole.trim();
    }

    public String getWorkerImg() {
        return workerImg;
    }

    public void setWorkerImg(String workerImg) {
        this.workerImg = workerImg == null ? null : workerImg.trim();
    }

    public String getShrinkImg() {
        return shrinkImg;
    }

    public void setShrinkImg(String shrinkImg) {
        this.shrinkImg = shrinkImg == null ? null : shrinkImg.trim();
    }

    public String getWorkerConstellation() {
        return workerConstellation;
    }

    public void setWorkerConstellation(String workerConstellation) {
        this.workerConstellation = workerConstellation == null ? null : workerConstellation.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getWorkerHobby() {
        return workerHobby;
    }

    public void setWorkerHobby(String workerHobby) {
        this.workerHobby = workerHobby == null ? null : workerHobby.trim();
    }

    public String getIsfirstLogin() {
        return isfirstLogin;
    }

    public void setIsfirstLogin(String isfirstLogin) {
        this.isfirstLogin = isfirstLogin == null ? null : isfirstLogin.trim();
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