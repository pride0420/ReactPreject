package com.example.demo.vo;

/***商品的vo***/
public class Porder {

	private Integer porderId;
	private String product;
	private String porderNo;
	private Integer amount;
	private String imgNo;
	private String mode;
	private String items;

	public Porder(String product, String porderNo, Integer amount, String imgNo, String mode, String items) {
		super();
		this.product = product;
		this.porderNo = porderNo;
		this.amount = amount;
		this.imgNo = imgNo;
		this.mode = mode;
		this.items = items;
	}

	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getPorderId() {
		return porderId;
	}

	public void setPorderId(Integer porderId) {
		this.porderId = porderId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(String porderNo) {
		this.porderNo = porderNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getImgNo() {
		return imgNo;
	}

	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

}
