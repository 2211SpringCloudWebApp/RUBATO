package com.rubato.manager.store.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.board.domain.Board;
import com.rubato.lesson.domain.Lesson;
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
import com.rubato.manager.domain.SearchReport;

@Repository
public class ManagerStoreLogic implements ManagerStore{
	@Autowired
	private SqlSession session;

	// 회원 리스트
	@Override
	public List<Member> selectMembers(PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> mList = session.selectList("ManagerMapper.selectMembers", null, rowBounds);
		return mList;
	}

	// 회원 삭제
	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("ManagerMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public int updateStatus(SqlSession session, String memberId) {
		int result = session.update("ManagerMapper.updateStatus", memberId);
		return result;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("ManagerMapper.getListCount");
		return result;
	}

	// 회원 검색
	@Override
	public List<Member> selectListByKeyword(SqlSession session,PageInfo pi, SearchMember searchMember) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> searchList = session.selectList("ManagerMapper.selectListByKeyword",searchMember, rowBounds );
		return searchList;
	}

	@Override
	public int getListCount(SqlSession session, SearchMember searchMember) {
		int result = session.selectOne("ManagerMapper.getSearchListCount", searchMember);
		return result;
	}

	// 레슨게시판
	@Override
	public List<Lesson> selectLessonBoard(PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Lesson> lbList = session.selectList("ManagerMapper.selectLessonBoard", null, rowBounds);
		return lbList;
	}

	@Override
	public int deleteLessonBoard(SqlSession session, Integer lessonNo) {
		int result = session.delete("ManagerMapper.deleteLessonBoard", lessonNo);
		return result;
	}

	
	public int getLessonListCount(SqlSession session) {
		int result = session.selectOne("ManagerMapper.getLessonListCount");
		return result;
	}
	
	@Override
	public int getLessonListCount(SqlSession session, SearchLesson searchLesson) {
		int result = session.selectOne("ManagerMapper.getLessonListCount", searchLesson);
		return result;
	}

	@Override
	public List<Lesson> selectLessonListByKeyword(SqlSession session, PageInfo pi, SearchLesson searchLesson) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Lesson> searchLessonList = session.selectList("ManagerMapper.selectLessonListByKeyword",searchLesson, rowBounds);
		return searchLessonList;
	}

	// 자유게시판
	@Override
	public int getBoardListCount(SqlSession session) {
		int result = session.selectOne("ManagerMapper.getBoardListCount");
		return result;
	}

	@Override
	public List<Board> selectBoard(PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> boardList = session.selectList("ManagerMapper.selectBoard", null, rowBounds);
		return boardList;
	}

	@Override
	public int deleteBoard(SqlSession session, Integer boardNo) {
		int result = session.delete("ManagerMapper.deleteBoard", boardNo);
		return result;
	}

	@Override
	public int getBoardListCount(SqlSession session, SearchBoard searchBoard) {
		int result = session.selectOne("ManagerMapper.getBoardListCount", searchBoard);
		return result;
	}

	@Override
	public List<Board> selectBoardListByKeyword(SqlSession session, PageInfo pi, SearchBoard searchBoard) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> searchBoardList = session.selectList("ManagerMapper.selectBoardListByKeyword", searchBoard, rowBounds);
		return searchBoardList;
	}

	@Override
	public int getMarketListCount(SqlSession session) {
		int result = session.selectOne("ManagerMapper.getMarketListCount");
		return result;
	}

	@Override
	public List<MarketSell> selectMarketBoard(PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MarketSell> marketList = session.selectList("ManagerMapper.selectMarketBoard", null, rowBounds);
		return marketList;
	}

	@Override
	public int deleteMarketBoard(SqlSession session, Integer sellNo) {
		int result = session.delete("ManagerMapper.deleteMarketBoard", sellNo);
		return result;
	}

	@Override
	public int getMarketListCount(SqlSession session, SearchMarket searchMarket) {
		int result = session.selectOne("ManagerMapper.getMarketListCount", searchMarket);
		return result;
	}

	@Override
	public List<MarketSell> selectMarketListByKeyword(SqlSession session, PageInfo pi, SearchMarket searchMarket) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MarketSell> searchMarketList = session.selectList("ManagerMapper.selectMarketListByKeyword", searchMarket,rowBounds );
		return searchMarketList;
	}

	@Override
	public List<MarketImage> selectImage(PageInfo pi) {
		List<MarketImage> imageList = session.selectList("ManagerMapper.selectImage");
		return imageList;
	}

	@Override
	public int getReportListCount(SqlSession session) {
		int result = session.selectOne("ReportMapper.getReportListCount");
		return result;
	}

	@Override
	public List<Report> selectReportBoard(PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Report> reportList = session.selectList("ReportMapper.selectReportBoard", null, rowBounds);
		return reportList;
	}

	@Override
	public int getReportListCount(SqlSession session, SearchReport searchReport) {
		int result = session.selectOne("ReportMapper.getReportListCount", searchReport);
		return result;
	}

	@Override
	public List<Report> selectReportListByKeyword(SqlSession session, PageInfo pi, SearchReport searchReport) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Report> searchReportList = session.selectList("ReportMapper.selectReportListByKeyword", searchReport, rowBounds);
		return searchReportList;
	}

	


}
