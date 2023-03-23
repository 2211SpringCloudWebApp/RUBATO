package com.rubato.market.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubato.market.domain.MarketComment;
import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketPayment;
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
	 * 조회수 증가 Store
	 * @param session
	 * @param sellNo
	 * @return int
	 */
	public int updateViewCount(SqlSession session, Integer sellNo);
	
	/**
	 * 판매글 삭제 Store
	 * @param session
	 * @param deleter
	 * @return int
	 */
	public int deleteMarketSell(SqlSession session, Map<String, Object> deleter);

	/**
	 * 결제 정보 저장 Store
	 * @param session
	 * @param map
	 * @return int
	 */
	public int insertMarketPayment(SqlSession session, Map<String, Object> map);

	/**
	 * 판매완료로 변경 Store
	 * @param session, sellNo
	 * @return int
	 */
	public int updateSellCondition(SqlSession session, int sellNo);

	/**
	 * 판매금액 적립 Store
	 * @param session
	 * @param seller
	 * @return int
	 */
	public int updateMemberPoint(SqlSession session, Map<String, Object> seller);

	/**
	 * 수정 시 존재하는 이미지 삭제 Store
	 * @param session, sellNo
	 * @return int
	 */
	public int deleteMarketImage(SqlSession session, Integer sellNo);

	/**
	 * 판매글 수정 Store
	 * @param session
	 * @param marketImg
	 * @param marketSell
	 * @return int
	 */
	public int updateMarketSell(SqlSession session, MarketImage marketImg, MarketSell marketSell);

	/**
	 * 댓글 작성 Store
	 * @param session
	 * @param comment
	 * @return int
	 */
	public int insertComment(SqlSession session, Map<String, Object> comment);

	/**
	 * 댓글 전체 개수 조회 Store
	 * @param session, sellNo
	 * @return int
	 */
	public int getCmtTotalCount(SqlSession session, int sellNo);

	/**
	 * 댓글 목록 출력 Store
	 * @param session, pi
	 * @param pi
	 * @return List<MarketComment>
	 */
	public List<MarketComment> selectAllComment(SqlSession session, Map<String, Object> commentMap);

	/**
	 * 댓글 삭제 Store
	 * @param session
	 * @param comment
	 * @return int
	 */
	public int deleteComment(SqlSession session, Map<String, Object> comment);

	/**
	 * 댓글 수정 Store
	 * @param session
	 * @param comment
	 * @return int
	 */
	public int updateComment(SqlSession session, Map<String, Object> comment);


	
//	민우추가
	/**
	 * 마이페이지 나의 판매 내역 Store
	 * @param session
	 * @param memberId
	 * @return List<MarketSell>
	 */
	public List<MarketSell> searchsellListById (SqlSession session, String memberId);
	
	/**
	 * 마이페이지 구매 신청 내역 Store
	 * @param session
	 * @param memberId
	 * @return List<MarketPayment>
	 */
	public List<MarketPayment> searchbuyListById(SqlSession session, String memberId);
	
}
