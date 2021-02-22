package com.orderapp.model;

import java.util.Date;

public class Coupon {
	private int id;
	private String couponCode;
	private int discount;
	private Date expiry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public Coupon(int id, String couponCode, int discount, Date expiry) {
		this.id = id;
		this.couponCode = couponCode;
		this.discount = discount;
		this.expiry = expiry;
	}
	public Coupon() {}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponCode=" + couponCode + ", discount=" + discount + ", expiry=" + expiry
				+ "]";
	}
	
	
}



