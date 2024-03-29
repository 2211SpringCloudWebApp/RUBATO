package com.rubato.manager.service;

import java.util.List;

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

public interface ManagerService {
	
	/**
	 * 관리자- 회원 리스트 Service
	 * @return List<Member>
	 */
	public List<Member> selectMembers(PageInfo pi);
	
	/**
	 * 관리자- 회원 삭제 Service
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(String memberId);

	public int getListCount();

	/**
	 * 회원 검색 Service
	 * @param pi 
	 * @param searchMember
	 * @return List<Member>
	 */
	public List<Member> selectListByKeyword(PageInfo pi, SearchMember searchMember);

	/**
	 * 검색 게시물 전체 개수 Service
	 * @param searchMember
	 * @return
	 */
	public int getListCount(SearchMember searchMember);

	/**
	 * 회원 활성화 Service
	 * @param memberId
	 * @return int
	 */
	public int updateStatus(String memberId);

	// 레슨게시판
	/**
	 * 레슨 게시판 리스트 Service
	 * @param pi
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessonBoard(PageInfo pi);

	/**
	 * 레슨 게시판 삭제 Service
	 * @param lessonNo
	 * @return int
	 */
	public int deleteLessonBoard(Integer lessonNo);

	/**
	 * 레슨 게시물 전체 개수 Service 
	 * @return
	 */
	public int getLessonListCount();
	/**
	 * 레슨 게시물 전체 개수 Service (검색했을때)
	 * @return
	 */
	public int getLessonListCount(SearchLesson searchLesson);

	/**
	 * 레슨게시판 검색 Service
	 * @param pi
	 * @param searchLesson
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessonListByKeyword(PageInfo pi, SearchLesson searchLesson);

	// 자유게시판
	/**
	 * 자유게시판 전체 개수 Service
	 * @return int
	 */
	public int getBoardListCount();

	/**
	 * 자유 게시판 리스트 Service
	 * @param pi
	 * @return List<Board>
	 */
	public List<Board> selectBoard(PageInfo pi);

	/**
	 * 자유게시판 게시글 삭제 Service
	 * @param boardNo
	 * @return int
	 */
	public int deleteBoard(Integer boardNo);

	/**
	 * 자유 게시판 전체 개수 Service (검색했을때)
	 * @param searchBoard
	 * @return int
	 */
	public int getBoardListCount(SearchBoard searchBoard);

	/**
	 * 자유게시판 검색 Service
	 * @param pi
	 * @param searchBoard
	 * @return List<Board>
	 */
	public List<Board> selectBoardListByKeyword(PageInfo pi, SearchBoard searchBoard);

	/**
	 * 마켓 게시물 전체 개수 Service
	 * @return int
	 */
	public int getMarketListCount();

	/**
	 * 마켓 게시판 리스트 Service
	 * @param pi
	 * @return List<MarketSell>
	 */
	public List<MarketSell> selectMarketBoard(PageInfo pi);

	/**
	 * 마켓 게시판 게시글 삭제 Service
	 * @param sellNo
	 * @return int
	 */
	public int deleteMarketBoard(Integer sellNo);

	/**
	 * 마켓 게시판 전체 개수 Service(검색했을때)
	 * @param searchMarket
	 * @return int
	 */
	public int getMarketListCount(SearchMarket searchMarket);

	/**
	 * 마켓 게시판 검색 Service
	 * @param pi
	 * @param searchMarket
	 * @return List<MarketSell>
	 */
	public List<MarketSell> selectMarketListByKeyword(PageInfo pi, SearchMarket searchMarket);

	public List<MarketImage> selectImage(PageInfo pi);

	/**
	 * 신고 게시물 전체 개수 Service
	 * @return int
	 */
	public int getReportListCount();

	/**
	 * 신고 게시판 리스트 Service
	 * @param pi
	 * @return List<Report>
	 */
	public List<Report> selectReportBoard(PageInfo pi);

	/**
	 * 신고 게시판 전체 개수 Service(검색했을때)
	 * @param searchReport
	 * @return int
	 */
	public int getReportListCount(SearchReport searchReport);

	/**
	 * 신고 게시판 검색 Service
	 * @param pi
	 * @param searchReport
	 * @return List<Report>
	 */
	public List<Report> selectReportListByKeyword(PageInfo pi, SearchReport searchReport);



	

}
