package com.rubato.market.store;

import org.apache.ibatis.session.SqlSession;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;

public interface MarketStore {

	/**
	 * 마켓 판매글 등록
	 * @param session
	 * @param marketImg
	 * @param marketSell
	 * @return int
	 */
	int insertMarketSell(SqlSession session, MarketImage marketImg, MarketSell marketSell);

}
