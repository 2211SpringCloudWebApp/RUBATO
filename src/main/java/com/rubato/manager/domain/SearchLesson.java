package com.rubato.manager.domain;

public class SearchLesson {
	private String searchValue;
	private String searchCondition;
	
	public SearchLesson() {}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

}
