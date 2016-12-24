package com.hm.birthday.enums;

public enum PraiseEnum {
	
	TYPE_ACTIVE("01"), // 活动形式
	TYPE_PRIZE("02"), // 奖品形式
	ENDORSE("01"), // 赞同
	OPPOSE("02"); // 不赞同
	
	private String value;

	public String value() {
		return value;
	}
	
	private PraiseEnum(String value) {
		this.value = value;
	}

}
