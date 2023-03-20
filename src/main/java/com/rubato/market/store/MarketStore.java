package com.rubato.market.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketPayment;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.PageInfo;
import com.rubato.market.domain.SearchInfo;

public interface MarketStore {

	/**
	 * 마켓 판매글 목록
	 * @param session
	 * @return List<MarketSell>
	 */
	public List<MarketSell> selectAllSell(SearchInfo searchInfo, SqlSession session, PageInfo pageInfo);

	/**
	 * 마켓 판매글 등록
	 * @param session
	 * @param marketImg
	 * @param marketSell
	 * @return int
	 */
	public int insertMarketSell(SqlSession session, MarketImage marketImg, MarketSell marketSell);
	
	/**
	 * 전체 게시물 or 필터링된 게시물 개수 조회 Store
	 * @param session, searchInfo
	 * @return int
	 */
	public int getTotalCount(SqlSession session, SearchInfo searchInfo);
	
//	민우추가
	/**
	 * 마이페이지 나의 판매 내역 Store
	 * @param session
	 * @param memberId
	 * @return List<MarketSell>
	 */
	public List<MarketSell> searchsellListById (SqlSession session, String memberId);
	
	/**
	 * 마이페이지 구매 신청 내역 Store
	 * @param session
	 * @param memberId
	 * @return List<MarketPayment>
	 */
	public List<MarketPayment> searchbuyListById(SqlSession session, String memberId);
	
}
