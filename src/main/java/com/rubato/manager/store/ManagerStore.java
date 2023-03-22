package com.rubato.manager.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.board.domain.Board;
import com.rubato.lesson.domain.Lesson;
import com.rubato.member.domain.Member;
import com.rubato.report.domain.Report;
import com.rubato.manager.domain.PageInfo;
import com.rubato.manager.domain.SearchBoard;
import com.rubato.manager.domain.SearchLesson;
import com.rubato.manager.domain.SearchMarket;
import com.rubato.manager.domain.SearchMember;
import com.rubato.manager.domain.SearchReport;
import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;

public interface ManagerStore {

	/**
	 * 관리자- 회원 리스트 Store
	 * @return List<Member>
	 */
	public List<Member> selectMembers(PageInfo pi);

	/**
	 * 관리자- 회원 삭제 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(SqlSession session, String memberId);

	/**
	 * 회원 활성화 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int updateStatus(SqlSession session, String memberId);

	public int getListCount(SqlSession session);

	/**
	 * 회원 검색 Store
	 * @param pi 
	 * @param searchMember
	 * @return List<Member>
	 */
	public List<Member> selectListByKeyword(SqlSession session, PageInfo pi, SearchMember searchMember);
	/**
	 * 회원 검색 게시물 전체 개수 Store
	 * @param session
	 * @param searchMember
	 * @return int
	 */
	public int getListCount(SqlSession session, SearchMember searchMember);

	// 레슨게시판
	/**
	 * 레슨 게시판 관리 Store
	 * @param pi
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessonBoard(PageInfo pi);

	/**
	 * 레슨 게시물 삭제 Store
	 * @param session
	 * @param lessonNo
	 * @return int
	 */
	public int deleteLessonBoard(SqlSession session, Integer lessonNo);

	public int getLessonListCount(SqlSession session);
	/**
	 * 레슨 게시물 리스트 Store
	 * @param session
	 * @return int
	 */
	public int getLessonListCount(SqlSession session, SearchLesson searchLesson);

	/**
	 * 레슨게시판 검색 Store
	 * @param session
	 * @param pi
	 * @param searchLesson
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessonListByKeyword(SqlSession session, PageInfo pi, SearchLesson searchLesson);

	// 자유게시판
	/**
	 * 자유게시판 게시물 리스트 Store
	 * @param session
	 * @return int
	 */
	public int getBoardListCount(SqlSession session);

	/**
	 * 자유 게시판 리스트 Store
	 * @param pi
	 * @return List<Board>
	 */
	public List<Board> selectBoard(PageInfo pi);

	/**
	 * 자유 게시판 게시글 삭제 Store
	 * @param session
	 * @param boardNo
	 * @return int
	 */
	public int deleteBoard(SqlSession session, Integer boardNo);

	/**
	 * 자유 게시판 게시글 Store - 검색했을때
	 * @param session
	 * @param searchBoard
	 * @return int
	 */
	public int getBoardListCount(SqlSession session, SearchBoard searchBoard);

	/**
	 * 자유 게시판 검색 Store
	 * @param session
	 * @param pi
	 * @param searchBoard
	 * @return List<Board>
	 */
	public List<Board> selectBoardListByKeyword(SqlSession session, PageInfo pi, SearchBoard searchBoard);

	/**
	 * 마켓 게시물 전체 개수 Store
	 * @param session
	 * @return int
	 */
	public int getMarketListCount(SqlSession session);

	/**
	 * 마켓 게시판 리스트 Store
	 * @param pi
	 * @return List<MarketSell>
	 */
	public List<MarketSell> selectMarketBoard(PageInfo pi);

	/**
	 * 마켓 게시판 게시글 삭제 Store
	 * @param session
	 * @param sellNo
	 * @return int
	 */
	public int deleteMarketBoard(SqlSession session, Integer sellNo);

	/**
	 * 마켓 게시판 전체 개수 Store(검색했을때)
	 * @param searchMarket
	 * @return int
	 */
	public int getMarketListCount(SqlSession session, SearchMarket searchMarket);

	/**
	 * 마켓 게시판 검색 Store
	 * @param session
	 * @param pi
	 * @param searchMarket
	 * @return List<MarketSell>
	 */
	public List<MarketSell> selectMarketListByKeyword(SqlSession session, PageInfo pi, SearchMarket searchMarket);

	public List<MarketImage> selectImage(PageInfo pi);

	/**
	 * 신고 게시물 전체 개수 Store
	 * @param session
	 * @return int
	 */
	public int getReportListCount(SqlSession session);

	/**
	 * 신고 게시판 리스트 Store
	 * @param pi
	 * @return List<Report>
	 */
	public List<Report> selectReportBoard(PageInfo pi);

	/**
	 * 신고 게시판 전체 개수 Store(검색했을때)
	 * @param session
	 * @param searchReport
	 * @return int
	 */
	public int getReportListCount(SqlSession session, SearchReport searchReport);

	/**
	 * 신고 게시판 검색 Store
	 * @param session
	 * @param pi
	 * @param searchReport
	 * @return List<Report>
	 */
	public List<Report> selectReportListByKeyword(SqlSession session, PageInfo pi, SearchReport searchReport);
	

}
