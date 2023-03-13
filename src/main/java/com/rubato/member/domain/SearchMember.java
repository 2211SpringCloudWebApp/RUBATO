package com.rubato.member.domain;

public class SearchMember {
	private String searchValue;
	private String searchMemberCondition;
	
	public SearchMember() {}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchMemberCondition() {
		return searchMemberCondition;
	}

	public void setSearchMemberCondition(String searchMemberCondition) {
		this.searchMemberCondition = searchMemberCondition;
	}

	
}
