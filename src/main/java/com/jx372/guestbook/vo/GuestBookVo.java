package com.jx372.guestbook.vo;

public class GuestBookVo {
	private Long no;
	private String name;
	private String message;
	private String passwd;
	private String regDate;
	
	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", name=" + name + ", message=" + message + ", passwd=" + passwd + ", regDate="
				+ regDate + "]";
	}
	public final Long getNo() {
		return no;
	}
	public final void setNo(Long no) {
		this.no = no;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getMessage() {
		return message;
	}
	public final void setMessage(String message) {
		this.message = message;
	}
	public final String getPasswd() {
		return passwd;
	}
	public final void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public final String getRegDate() {
		return regDate;
	}
	public final void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
