package com.rubato.market.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketPayment;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.PageInfo;
import com.rubato.market.domain.SearchInfo;
import com.rubato.market.service.MarketService;
import com.rubato.market.store.MarketStore;

@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	private SqlSession session;
	@Autowired
	private MarketStore marketStore;
	
	
	@Override
	public List<MarketSell> selectAllSell(SearchInfo searchInfo, PageInfo pageInfo) {
		List<MarketSell> sellList = marketStore.selectAllSell(searchInfo, session, pageInfo);
		return sellList;
	}


	@Override
	public int insertMarketSell(MarketImage marketImg, MarketSell marketSell) {
		return marketStore.insertMarketSell(session, marketImg, marketSell);
	}


	@Override
	public int getTotalCount(SearchInfo searchInfo) {
		return marketStore.getTotalCount(session, searchInfo);
	}

	// 민우추가
	@Override
	public List<MarketSell> searchsellListById(String memberId) {
		List<MarketSell> sList = marketStore.searchsellListById(session, memberId);
		return sList;
	}


	@Override
	public List<MarketPayment> searchbuyListById(String memberId) {
		List<MarketPayment> paymentList = marketStore.searchbuyListById(session, memberId);
		return paymentList;
	}
}
