package com.sirun.common.utils;

public enum LoginEnum {
	
	//登陆ID
	LONGIN_USER_ID("LONGIN_USER_ID"), 
		
	//登陆名
	LONGIN_USER_NAME("LONGIN_USER_NAME"),
	
	//用户信息
	LONGIN_USER_INFO("LONGIN_USER_INFO"),
	
	//登录时间
	LONGIN_DATE("LONGIN_DATE");
	
	private String loginInfo;
	
	LoginEnum(String loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	public String getloginInfo() {
		return loginInfo;
	}
}
