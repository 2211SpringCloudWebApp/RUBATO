package com.rubato.manager.store.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.board.domain.Board;
import com.rubato.lesson.domain.Lesson;
import com.rubato.manager.store.ManagerStore;
import com.rubato.member.domain.Member;
import com.rubato.manager.domain.PageInfo;
import com.rubato.manager.domain.SearchBoard;
import com.rubato.manager.domain.SearchLesson;
import com.rubato.manager.domain.SearchMember;

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

	


}
