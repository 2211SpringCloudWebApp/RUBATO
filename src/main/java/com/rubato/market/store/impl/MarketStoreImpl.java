package com.rubato.market.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;
import com.rubato.market.store.MarketStore;

@Repository
public class MarketStoreImpl implements MarketStore{

	@Override
	public int insertMarketSell(SqlSession session, MarketImage marketImg, MarketSell marketSell) {
		int result = 0;
		int result1 = session.insert("MarketMapper.insertMarketSell", marketSell);
		int result2 = insertMarketImage(session, marketImg);
		if((result1+result2)>0)
			result = result1+result2;
		System.out.println(result);
		return result;
	}
	
	public int insertMarketImage(SqlSession session, MarketImage marketImg) {
		int result = session.insert("MarketMapper.insertMarketImage", marketImg);
		return result;
	}

}
