package com.rubato.market.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.market.domain.MarketComment;
import com.rubato.market.domain.MarketImage;
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


	@Override
	public MarketSell selectOneByNo(Integer sellNo) {
		return marketStore.selectOneByNo(session, sellNo);
	}
	
	
	@Override
	public int updateViewCount(Integer sellNo) {
		return marketStore.updateViewCount(session, sellNo);
	}


	@Override
	public int deleteMarketSell(Map<String, Object> deleter) {
		return marketStore.deleteMarketSell(session, deleter);
	}


	@Override
	public int insertMarketPayment(Map<String, Object> map) {
		return marketStore.insertMarketPayment(session, map);
	}


	@Override
	public int updateSellCondition(int sellNo) {
		return marketStore.updateSellCondition(session, sellNo);
	}


	@Override
	public int updateMemberPoint(Map<String, Object> seller) {
		return marketStore.updateMemberPoint(session, seller);
	}


	@Override
	public int deleteMarketImage(Integer sellNo) {
		return marketStore.deleteMarketImage(session, sellNo);
	}


	@Override
	public int updateMarketSell(MarketImage marketImg, MarketSell marketSell) {
		return marketStore.updateMarketSell(session, marketImg, marketSell);
	}


	@Override
	public int insertComment(Map<String, Object> comment) {
		return marketStore.insertComment(session, comment);
	}


	@Override
	public int getCmtTotalCount(int sellNo) {
		return marketStore.getCmtTotalCount(session, sellNo);
	}


	@Override
	public List<MarketComment> selectAllComment(Map<String, Object> commentMap) {
		return marketStore.selectAllComment(session, commentMap);
	}


	@Override
	public int deleteComment(Map<String, Object> comment) {
		return marketStore.deleteComment(session, comment);
	}


	@Override
	public int updateComment(Map<String, Object> comment) {
		return marketStore.updateComment(session, comment);
	}


}
