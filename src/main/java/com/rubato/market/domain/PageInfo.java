package com.rubato.market.domain;

public class PageInfo {
	private int totalCount;
	private int recordCountPerPage;
	private int currentPage;
	private int startNavi;
	private int endNavi;
	private int naviCountPerPage;
	private int maxPage;
	
	public PageInfo(int currentPage, int totalCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.recordCountPerPage = 10;
		this.naviCountPerPage = 5;
		this.maxPage = (int)((double)totalCount/recordCountPerPage+0.9);
		this.startNavi = (((int)Math.ceil((double)currentPage/naviCountPerPage))-1)*naviCountPerPage+1;
		this.endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi>maxPage) {
			endNavi = maxPage;
		}
	}
	
	
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNavi() {
		return startNavi;
	}
	public void setStartNavi(int startNavi) {
		this.startNavi = startNavi;
	}
	public int getEndNavi() {
		return endNavi;
	}
	public void setEndNavi(int endNavi) {
		this.endNavi = endNavi;
	}
	public int getNaviCountPerPage() {
		return naviCountPerPage;
	}
	public void setNaviCountPerPage(int naviCountPerPage) {
		this.naviCountPerPage = naviCountPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	
}
