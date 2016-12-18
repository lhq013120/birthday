package com.hm.birthday.master.blessing.vo;

import java.util.ArrayList;
import java.util.List;

public class BlessingLimitVo {
	
	/**
	 * 手机号
	 */
	private String phoneNum;
	/**
	 * 姓名
	 */
	private String workName;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 权限
	 */
	private String workerRole;
	/**
	 * 员工头像
	 */
	private String workerImg;
	/**
	 * 员工缩略图
	 */
	private String shrinkImg;
	/**
	 * 星座
	 */
	private String workerConstellation;
	/**
	 * 血型
	 */
	private String bloodType;
	/**
	 * 爱好
	 */
	private String workerHobby;
	/**
	 * 前两条留言
	 */
	private List<BlessingVo> limit2Blessing = new ArrayList<BlessingVo>();
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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
	public String getShrinkImg() {
		return shrinkImg;
	}
	public void setShrinkImg(String shrinkImg) {
		this.shrinkImg = shrinkImg;
	}
	public String getWorkerConstellation() {
		return workerConstellation;
	}
	public void setWorkerConstellation(String workerConstellation) {
		this.workerConstellation = workerConstellation;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getWorkerHobby() {
		return workerHobby;
	}
	public void setWorkerHobby(String workerHobby) {
		this.workerHobby = workerHobby;
	}
	public List<BlessingVo> getLimit2Blessing() {
		return limit2Blessing;
	}
	public void setLimit2Blessing(List<BlessingVo> limit2Blessing) {
		this.limit2Blessing = limit2Blessing;
	}
}
