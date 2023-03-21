package com.rubato.manager.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.board.domain.Board;
import com.rubato.lesson.domain.Lesson;
import com.rubato.manager.service.ManagerService;
import com.rubato.manager.store.ManagerStore;
import com.rubato.market.domain.MarketImage;
import com.rubato.market.domain.MarketSell;
import com.rubato.member.domain.Member;
import com.rubato.report.domain.Report;
import com.rubato.manager.domain.PageInfo;
import com.rubato.manager.domain.SearchBoard;
import com.rubato.manager.domain.SearchLesson;
import com.rubato.manager.domain.SearchMarket;
import com.rubato.manager.domain.SearchMember;

@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private SqlSession session;
	@Autowired
	private ManagerStore managerStore;

	// 회원 리스트
	@Override
	public List<Member> selectMembers(PageInfo pi) {
		List<Member> mList = managerStore.selectMembers(pi);
		return mList;
	}

	// 회원 삭제
	@Override
	public int deleteMember(String memberId) {
		int result = managerStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public int updateStatus(String memberId) {
		int result = managerStore.updateStatus(session, memberId);
		return result;
	}

	@Override
	public int getListCount() {
		int result = managerStore.getListCount(session);
		return result;
	}

	//회원 검색
	@Override
	public List<Member> selectListByKeyword(PageInfo pi, SearchMember searchMember) {
		List<Member> searchList = managerStore.selectListByKeyword(session, pi, searchMember);
		return searchList;
	}

	@Override
	public int getListCount(SearchMember searchMember) {
		int totalCount = managerStore.getListCount(session, searchMember);
		return totalCount;
	}

	// 레슨게시판
	@Override
	public List<Lesson> selectLessonBoard(PageInfo pi) {
		List<Lesson> lbList = managerStore.selectLessonBoard(pi);
		return lbList;
	}

	@Override
	public int deleteLessonBoard(Integer lessonNo) {
		int result = managerStore.deleteLessonBoard(session, lessonNo);
		return result;
	}

	@Override
	public int getLessonListCount() {
		int result = managerStore.getLessonListCount(session);
		return result;
	}
	
	@Override
	public int getLessonListCount(SearchLesson searchLesson) {
		int result = managerStore.getLessonListCount(session, searchLesson);
		return result;
	}

	@Override
	public List<Lesson> selectLessonListByKeyword(PageInfo pi, SearchLesson searchLesson) {
		List<Lesson> searchLessonList = managerStore.selectLessonListByKeyword(session, pi, searchLesson);
		return searchLessonList;
	}

	// 자유게시판
	@Override
	public int getBoardListCount() {
		int result = managerStore.getBoardListCount(session);
		return result;
	}

	@Override
	public List<Board> selectBoard(PageInfo pi) {
		List<Board> boardList = managerStore.selectBoard(pi);
		return boardList;
	}

	@Override
	public int deleteBoard(Integer boardNo) {
		int result = managerStore.deleteBoard(session, boardNo);
		return result;
	}

	@Override
	public int getBoardListCount(SearchBoard searchBoard) {
		int result = managerStore.getBoardListCount(session, searchBoard);
		return result;
	}

	@Override
	public List<Board> selectBoardListByKeyword(PageInfo pi, SearchBoard searchBoard) {
		List<Board> searchBoardList = managerStore.selectBoardListByKeyword(session, pi, searchBoard);
		return searchBoardList;
	}

	@Override
	public int getMarketListCount() {
		int result = managerStore.getMarketListCount(session);
		return result;
	}

	@Override
	public List<MarketSell> selectMarketBoard(PageInfo pi) {
		List<MarketSell> marketList = managerStore.selectMarketBoard(pi);
		return marketList;
	}

	@Override
	public int deleteMarketBoard(Integer sellNo) {
		int result = managerStore.deleteMarketBoard(session, sellNo);
		return result;
	}

	@Override
	public int getMarketListCount(SearchMarket searchMarket) {
		int result = managerStore.getMarketListCount(session, searchMarket);
		return result;
	}

	@Override
	public List<MarketSell> selectMarketListByKeyword(PageInfo pi, SearchMarket searchMarket) {
		List<MarketSell> searchMarketList = managerStore.selectMarketListByKeyword(session, pi, searchMarket);
		return searchMarketList;
	}

	@Override
	public List<MarketImage> selectImage(PageInfo pi) {
		List<MarketImage> imageList = managerStore.selectImage(pi);
		return imageList;
	}

	@Override
	public int getReportListCount() {
		int result = managerStore.getReportListCount(session);
		return result;
	}

	@Override
	public List<Report> selectReportBoard(PageInfo pi) {
		List<Report> reportList = managerStore.selectReportBoard(pi);
		return reportList;
	}


}
