package com.example.demo.vo;

/**
 * 帳戶的vo
 */
public class Member {

	/**鍵值*/
	private Integer memberId;
	
	/**帳號*/
	private String username;
	
	/**密碼*/
	private String password;
	
	/**暱稱*/
	private String name;
	
	/**信箱*/
	private String email;
	
	/**電話*/
	private String phone;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String username, String password, String name, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
