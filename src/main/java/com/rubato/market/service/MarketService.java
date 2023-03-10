package com.rubato.market.service;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;

public interface MarketService {

	/**
	 * 마켓 판매글 등록
	 * @param marketImg
	 * @param marketSell
	 * @return int
	 */
	int insertMarketSell(MarketImage marketImg, MarketSell marketSell);

}
