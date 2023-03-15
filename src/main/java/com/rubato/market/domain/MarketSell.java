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
	private Timestamp writeDate;
	private Timestamp modDate;
	private String sellCondition;
	private int viewCount;
	private String img1;
	private String img2;
	private String img3;
	private String memberNickname;
	
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



	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
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

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
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
