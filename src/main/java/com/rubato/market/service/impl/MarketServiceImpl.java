package com.rubato.market.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.service.MarketService;
import com.rubato.market.store.MarketStore;

@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	private SqlSession session;
	@Autowired
	private MarketStore marketStore;
	
	
	@Override
	public int insertMarketSell(MarketImage marketImg, MarketSell marketSell) {
		return marketStore.insertMarketSell(session, marketImg, marketSell);
	}
}
