package com.rubato.market.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubato.market.domain.MarketImage;
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

	/**
	 * 게시물 번호로 상세조회 Store
	 * @param session, sellNo
	 * @return MarketSell
	 */
	public MarketSell selectOneByNo(SqlSession session, Integer sellNo);

	/**
	 * 판매글 삭제 Store
	 * @param session
	 * @param deleter
	 * @return int
	 */
	public int deleteMarketSell(SqlSession session, Map<String, Object> deleter);

}
