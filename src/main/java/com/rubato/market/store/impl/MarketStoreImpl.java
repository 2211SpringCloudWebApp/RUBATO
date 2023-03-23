package com.rubato.market.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.market.domain.MarketComment;
import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketPayment;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.domain.PageInfo;
import com.rubato.market.domain.SearchInfo;
import com.rubato.market.store.MarketStore;

@Repository
public class MarketStoreImpl implements MarketStore{

	@Override
	public List<MarketSell> selectAllSell(SearchInfo searchInfo, SqlSession session, PageInfo pageInfo) {
		int limit = pageInfo.getRecordCountPerPage();
		int currentPage = pageInfo.getCurrentPage();
		int offset = (currentPage-1) * limit;
		RowBounds rb = new RowBounds(offset, limit);
		List<MarketSell> sellList = session.selectList("MarketMapper.selectAllSell", searchInfo, rb);
		return sellList;
	}

	@Override
	public int insertMarketSell(SqlSession session, MarketImage marketImg, MarketSell marketSell) {
		int result = 0;
		int result1 = session.insert("MarketMapper.insertMarketSell", marketSell);
		int result2 = insertMarketImage(session, marketImg);
		if((result1+result2)>1)
			result = result1+result2;
		return result;
	}
	
	public int insertMarketImage(SqlSession session, MarketImage marketImg) {
		int result = session.insert("MarketMapper.insertMarketImage", marketImg);
		return result;
	}

	@Override
	public int getTotalCount(SqlSession session, SearchInfo searchInfo) {
		int result = session.selectOne("MarketMapper.getTotalCount", searchInfo);
		return result;
	}
	
	// 민우 추가
	@Override
	public List<MarketSell> searchsellListById(SqlSession session, String memberId) {
		List<MarketSell> sList = session.selectList("MarketMapper.searchsellListById", memberId);
		return sList;
	}

	@Override
	public List<MarketPayment> searchbuyListById(SqlSession session, String memberId) {
		List<MarketPayment> paymentList = session.selectList("MarketMapper.searchbuyListById", memberId);
		return paymentList;
	}


	@Override
	public MarketSell selectOneByNo(SqlSession session, Integer sellNo) {
		MarketSell sell = session.selectOne("MarketMapper.selectOneByNo", sellNo);
		return sell;
	}
	
	@Override
	public int updateViewCount(SqlSession session, Integer sellNo) {
		int result = session.update("MarketMapper.updateViewCount", sellNo);
		return result;
	}

	@Override
	public int deleteMarketSell(SqlSession session, Map<String, Object> deleter) {
		int result = session.delete("MarketMapper.deleteMarketSell", deleter);
		return result;
	}

	@Override
	public int insertMarketPayment(SqlSession session, Map<String, Object> map) {
		int result = session.insert("MarketMapper.insertMarketPayment", map);
		return result;
	}

	@Override
	public int updateSellCondition(SqlSession session, int sellNo) {
		int result = session.update("MarketMapper.updateSellCondition", sellNo);
		return result;
	}

	@Override
	public int updateMemberPoint(SqlSession session, Map<String, Object> seller) {
		int result = session.update("MarketMapper.updateMemberPoint", seller);
		return result;
	}

	@Override
	public int deleteMarketImage(SqlSession session, Integer sellNo) {
		int result = session.delete("MarketMapper.deleteMarketImage", sellNo);
		return result;
	}

	@Override
	public int updateMarketSell(SqlSession session, MarketImage marketImg, MarketSell marketSell) {
		int result = 0;
		int result1 = session.insert("MarketMapper.updateMarketSell", marketSell);
		int result2 = insertMarketImage(session, marketImg);
		if((result1+result2)>1)
			result = result1+result2;
		return result;
	}

	@Override
	public int insertComment(SqlSession session, Map<String, Object> comment) {
		int result = session.insert("MarketMapper.insertComment", comment);
		return result;
	}

	@Override
	public int getCmtTotalCount(SqlSession session, int sellNo) {
		int result = session.selectOne("MarketMapper.getCmtTotalCount", sellNo);
		return result;
	}

	@Override
	public List<MarketComment> selectAllComment(SqlSession session, Map<String, Object> commentMap) {
		PageInfo pi = (PageInfo) commentMap.get("pi");
		int sellNo = Double.valueOf(String.valueOf(commentMap.get("sellNo"))).intValue();
		int limit = pi.getRecordCountPerPage();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage-1)*limit;
		RowBounds rb = new RowBounds(offset, limit);
		List<MarketComment> commentList = session.selectList("MarketMapper.selectAllComment", sellNo, rb);
		return commentList;
	}

	@Override
	public int deleteComment(SqlSession session, Map<String, Object> comment) {
		int result = session.delete("MarketMapper.deleteComment", comment);
		return result;
	}

	@Override
	public int updateComment(SqlSession session, Map<String, Object> comment) {
		int result = session.update("MarketMapper.updateComment", comment);
		return result;
	}
}
