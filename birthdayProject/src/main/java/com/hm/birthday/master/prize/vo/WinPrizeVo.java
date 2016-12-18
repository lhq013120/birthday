package com.hm.birthday.master.prize.vo;

public class WinPrizeVo {

	private Integer id;

	private String phoneNum;

	private String workName;

	private String prizeNo;

	private String prizeGrade;

	private String prizeName;

	private String workAddress;

	private String updateTime;

	private String createTime;

	public WinPrizeVo() {
		super();
	}

	public WinPrizeVo(Integer id, String phoneNum, String workName, String prizeNo, String prizeGrade, String prizeName,
			String workAddress, String updateTime, String createTime) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.workName = workName;
		this.prizeNo = prizeNo;
		this.prizeGrade = prizeGrade;
		this.prizeName = prizeName;
		this.workAddress = workAddress;
		this.updateTime = updateTime;
		this.createTime = createTime;
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
		this.phoneNum = phoneNum;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getPrizeNo() {
		return prizeNo;
	}

	public void setPrizeNo(String prizeNo) {
		this.prizeNo = prizeNo;
	}

	public String getPrizeGrade() {
		return prizeGrade;
	}

	public void setPrizeGrade(String prizeGrade) {
		this.prizeGrade = prizeGrade;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
