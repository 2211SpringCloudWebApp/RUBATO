package com.rubato.market.service;

import java.util.List;
import java.util.Map;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.PageInfo;
import com.rubato.market.domain.SearchInfo;

public interface MarketService {

	/**
	 * 마켓 판매글 목록
	 * @return List<MarketSell>
	 */
	public List<MarketSell> selectAllSell(SearchInfo searchInfo, PageInfo pageInfo);

	/**
	 * 마켓 판매글 등록
	 * @param marketImg
	 * @param marketSell
	 * @return int
	 */
	public int insertMarketSell(MarketImage marketImg, MarketSell marketSell);

	/**
	 * 전체 게시물 or 필터링된 게시물 개수 조회 Service
	 * @param searchInfo
	 * @return int
	 */
	public int getTotalCount(SearchInfo searchInfo);

}
