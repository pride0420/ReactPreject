package com.example.demo.vo;

public class Shop {

	private Integer id;
	private Integer memberId;
	private Integer porderId;
	private Integer num;
	private Integer sum;

	public Shop(Integer memberId, Integer porderId, Integer num, Integer sum) {
		super();
		this.memberId = memberId;
		this.porderId = porderId;
		this.num = num;
		this.sum = sum;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPorderId() {
		return porderId;
	}

	public void setPorderId(Integer porderId) {
		this.porderId = porderId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

}
