package com.rubato.market.service;

import java.util.List;
import java.util.Map;

import com.rubato.market.domain.MarketComment;
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

	/**
	 * 게시물 번호로 상세조회 Service
	 * @param sellNo
	 * @return MarketSell
	 */
	public MarketSell selectOneByNo(Integer sellNo);
	
	/**
	 * 조회수 증가 Service
	 * @param sellNo
	 * @return int
	 */
	public int updateViewCount(Integer sellNo);

	/**
	 * 판매글 삭제 Service
	 * @param deleter
	 * @return int
	 */
	public int deleteMarketSell(Map<String, Object> deleter);

	/**
	 * 결제정보 저장 Service
	 * @param map
	 * @return int
	 */
	public int insertMarketPayment(Map<String, Object> map);

	/**
	 * 판매완료로 변경 Service
	 * @param sellNo
	 * @return int
	 */
	public int updateSellCondition(int sellNo);

	/**
	 * 판매금액 적립 Service
	 * @param seller
	 * @return int
	 */
	public int updateMemberPoint(Map<String, Object> seller);

	/**
	 * 수정 시 존재하는 이미지 삭제 Service
	 * @param sellNo
	 * @return int
	 */
	public int deleteMarketImage(Integer sellNo);

	/**
	 * 판매글 수정 Service
	 * @param marketImg
	 * @param marketSell
	 * @return int
	 */
	public int updateMarketSell(MarketImage marketImg, MarketSell marketSell);

	/**
	 * 댓글 작성 Service
	 * @param comment
	 * @return int
	 */
	public int insertComment(Map<String, Object> comment);

	/**
	 * 댓글 전체 개수 출력 Service
	 * @param sellNo
	 * @return int
	 */
	public int getCmtTotalCount(int sellNo);

	/**
	 * 댓글 목록 출력 Service
	 * @param pi
	 * @return List<MarketComment>
	 */
	public List<MarketComment> selectAllComment(Map<String, Object> commentMap);

	/**
	 * 댓글 삭제 Service
	 * @param comment
	 * @return int
	 */
	public int deleteComment(Map<String, Object> comment);

	/**
	 * 댓글 수정 Service
	 * @param comment
	 * @return int
	 */
	public int updateComment(Map<String, Object> comment);



}
