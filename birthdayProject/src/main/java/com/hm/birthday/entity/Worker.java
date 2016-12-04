package com.hm.birthday.entity;

import java.util.Date;

public class Worker {
	
	public Worker() {
	}
	
	public Worker(Integer id, String phoneNum, String workName, String password, Date birthday, String workerRole,
			String workerImg, Date updateTime, Date creteTime) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.workName = workName;
		this.password = password;
		this.birthday = birthday;
		this.workerRole = workerRole;
		this.workerImg = workerImg;
		this.updateTime = updateTime;
		this.creteTime = creteTime;
	}

	private Integer id;
	
	/**
	 *  电话 
	 */
	private String phoneNum;
	/**
	 * 职工姓名
	 */
	private String workName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 生日
	 */
	private Date birthday;
	
	/**
	 * 权限
	 */
	private String workerRole;
	/**
	 * 头像
	 */
	private String workerImg;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date creteTime;
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
		this.phoneNum = phoneNum;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		this.workerRole = workerRole;
	}

	public String getWorkerImg() {
		return workerImg;
	}

	public void setWorkerImg(String workerImg) {
		this.workerImg = workerImg;
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
