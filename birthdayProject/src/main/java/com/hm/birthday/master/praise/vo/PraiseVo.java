package com.hm.birthday.master.praise.vo;

public class PraiseVo {
	/**
	 * 活动赞同数
	 * 
	 */
	private int activeEndorse;
	/**
	 * 活动反对数
	 * 
	 */
	private int activeOppose;
	/**
	 * 奖品赞同数
	 * 
	 */
	private int prizeEndorse;
	/**
	 * 奖品反对数
	 * 
	 */
	private int prizeOppose;
	
	public PraiseVo() {
		super();
	}
	public PraiseVo(int activeEndorse, int activeOppose, int prizeEndorse, int prizeOppose) {
		super();
		this.activeEndorse = activeEndorse;
		this.activeOppose = activeOppose;
		this.prizeEndorse = prizeEndorse;
		this.prizeOppose = prizeOppose;
	}
	public int getActiveEndorse() {
		return activeEndorse;
	}
	public void setActiveEndorse(int activeEndorse) {
		this.activeEndorse = activeEndorse;
	}
	public int getActiveOppose() {
		return activeOppose;
	}
	public void setActiveOppose(int activeOppose) {
		this.activeOppose = activeOppose;
	}
	public int getPrizeEndorse() {
		return prizeEndorse;
	}
	public void setPrizeEndorse(int prizeEndorse) {
		this.prizeEndorse = prizeEndorse;
	}
	public int getPrizeOppose() {
		return prizeOppose;
	}
	public void setPrizeOppose(int prizeOppose) {
		this.prizeOppose = prizeOppose;
	}
}
