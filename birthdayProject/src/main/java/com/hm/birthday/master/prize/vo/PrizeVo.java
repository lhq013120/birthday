package com.hm.birthday.master.prize.vo;

public class PrizeVo {
	
	private Integer id;

	private String prizeNo;
	
	private String prizeGrade;
	
	private String prizeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PrizeVo [id=" + id + ", prizeNo=" + prizeNo + ", prizeGrade=" + prizeGrade + ", prizeName=" + prizeName
				+ "]";
	}
}
