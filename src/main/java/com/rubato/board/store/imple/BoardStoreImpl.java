package com.rubato.board.store.imple;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.domain.Search;
import com.rubato.board.store.BoardStore;

@Repository
public class BoardStoreImpl implements BoardStore {

	@Override
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("BoardMapper.getListCount");
		return result;
	}

	@Override
	public List<Board> selectBoardList(SqlSession session, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage -1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> bList = session.selectList("BoardMapper.selectBoardList", null, rowBounds);
		return bList;
	}

	@Override
	public int getListCount(SqlSession session, Search search) {
		int result = session.selectOne("BoardMapper.searchListCount", search);
		return result;
	}

	@Override
	public List<Board> selectListByKeyword(SqlSession session, PageInfo pi, Search search) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> searchList = session.selectList("BoardMapper.selectListByKeyword", search, rowBounds);
		return searchList;
	}

	@Override
	public Board selectOneByNo(SqlSession session, int boardNo) {
		Board board = session.selectOne("BoardMapper.selectOneByNo", boardNo);
		return board;
	}

	@Override
	public int updateBoard(SqlSession session, Board board) {
		int result = session.update("BoardMapper.updateBoard", board);
		return result;
	}

	@Override
	public int deleteBoard(SqlSession session, int boardNo) {
		int result = session.delete("BoardMapper.deleteBoard", boardNo);
		return result;
	}

	@Override
	public int updateViewCount(SqlSession session, int boardNo) {
		int result = session.update("BoardMapper.updateViewCount", boardNo);
		return result;
	}

	@Override
	public int selectBoardCommentCount(SqlSession session, int boardNo) {
		int result = session.selectOne("BoardMapper.selectBoardCommentCount", boardNo);
		return result;
	}

}
