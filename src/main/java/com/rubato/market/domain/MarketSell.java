package com.rubato.market.domain;

import java.sql.Timestamp;

public class MarketSell {
	private int sellNo;
	private String sellTitle;
	private String sellContent;
	private int sellPrice;
	private String sellArea;
	private String productCondition;
	private String memberId;
	private Timestamp wirteDate;
	private Timestamp modDate;
	private String sellCondition;
	private int viewCount;
	
	public MarketSell() {}
	
	public MarketSell(String sellTitle, String sellContent, int sellPrice, String sellArea, String productCondition,
			String memberId) {
		super();
		this.sellTitle = sellTitle;
		this.sellContent = sellContent;
		this.sellPrice = sellPrice;
		this.sellArea = sellArea;
		this.productCondition = productCondition;
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "MarketSell [판매글번호=" + sellNo + ", 판매글제목=" + sellTitle + ", 판매글내용=" + sellContent
				+ ", 판매가격=" + sellPrice + ", 판매지역=" + sellArea + ", 제품상태=" + productCondition
				+ ", 판매자ID=" + memberId + ", 등록일=" + wirteDate + ", 수정일=" + modDate + ", 거래상태="
				+ sellCondition + ", 조회수=" + viewCount + "]";
	}

	// getter setter
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

	public String getSellContent() {
		return sellContent;
	}

	public void setSellContent(String sellContent) {
		this.sellContent = sellContent;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellArea() {
		return sellArea;
	}

	public void setSellArea(String sellArea) {
		this.sellArea = sellArea;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Timestamp getWirteDate() {
		return wirteDate;
	}

	public void setWirteDate(Timestamp wirteDate) {
		this.wirteDate = wirteDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

	public String getSellCondition() {
		return sellCondition;
	}

	public void setSellCondition(String sellCondition) {
		this.sellCondition = sellCondition;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
