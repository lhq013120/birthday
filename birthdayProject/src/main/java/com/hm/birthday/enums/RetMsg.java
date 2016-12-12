package com.hm.birthday.enums;

public enum RetMsg {
	
	SUCCESS("0000","操作成功"),
	USER_ANME_NULL("1001","用户名为空"),
	USER_NOT_EXIST("1002","用户不存在"),
	PASSWORD_NULL("1101","密码为空"),
	PASSWORD_ERROR("1102","密码错误"),
	PHONENUM_ERROR("1201","手机号格式不正确"),
	USER_PASSWORD_ERROR("1103","用户名或密码错误"),
	ILLEGALITY_OPERATION("9000","非法操作"),
	SYSTEM_ERROR("9999","系统异常");
	
	
	public String code() {
		return code;
	}

	public String value() {
		return value;
	}

	private String code;
	private String value;
	
	private RetMsg(String code,String value){
		this.code = code;
		this.value = value;
	}
}
