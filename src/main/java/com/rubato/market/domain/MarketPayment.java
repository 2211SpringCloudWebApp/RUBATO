package com.rubato.market.domain;

import java.sql.Timestamp;

public class MarketPayment {
	
	private int paymentNo;
	private int sellNo;
	private String sellTitle;
	private String sellerId;
	private String buyerId;
	private int paymentPrice;
	private String deleveryMsg;
	private Timestamp paymentDate;
	
	
	public MarketPayment(int paymentNo, int sellNo, String sellTitle, String sellerId, String buyerId, int paymentPrice,
			String deleveryMsg, Timestamp paymentDate) {
		super();
		this.paymentNo = paymentNo;
		this.sellNo = sellNo;
		this.sellTitle = sellTitle;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.paymentPrice = paymentPrice;
		this.deleveryMsg = deleveryMsg;
		this.paymentDate = paymentDate;
	}


	public int getPaymentNo() {
		return paymentNo;
	}


	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}


	public int getSellNo() {
		return sellNo;
	}


	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}


	public String getSellTitle() {
		return sellTitle;
	}


	public void setSellTitle(String sellTitle) {
		this.sellTitle = sellTitle;
	}


	public String getSellerId() {
		return sellerId;
	}


	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}


	public String getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}


	public int getPaymentPrice() {
		return paymentPrice;
	}


	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}


	public String getDeleveryMsg() {
		return deleveryMsg;
	}


	public void setDeleveryMsg(String deleveryMsg) {
		this.deleveryMsg = deleveryMsg;
	}


	public Timestamp getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}


	@Override
	public String toString() {
		return "MarketPayment [paymentNo=" + paymentNo + ", sellNo=" + sellNo + ", sellTitle=" + sellTitle
				+ ", sellerId=" + sellerId + ", buyerId=" + buyerId + ", paymentPrice=" + paymentPrice
				+ ", deleveryMsg=" + deleveryMsg + ", paymentDate=" + paymentDate + "]";
	}
	
	
	
}
