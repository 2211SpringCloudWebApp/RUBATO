package com.rubato.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.domain.Search;
import com.rubato.board.service.BoardService;
import com.rubato.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardStore bStore;
	@Autowired
	private SqlSession session;

	@Override
	public int insertBoard(Board board) {
		return bStore.insertBoard(session, board);
	}
	
	@Override
	public int getListCount() {
		int result = bStore.getListCount(session);
		return result;
	}
	
	@Override
	public int getListCount(Search search) {
		int totalCount = bStore.getListCount(session, search);
		return totalCount;
	}

	@Override
	public List<Board> selectBoardList(PageInfo pi) {
		List<Board> bList = bStore.selectBoardList(session, pi);
		return bList;
	}

	@Override
	public List<Board> selectListByKeyword(PageInfo pi, Search search) {
		List<Board> searchList = bStore.selectListByKeyword(session, pi, search);
		return searchList;
	}

	@Override
	public Board selectOneByNo(int boardNo) {
		Board board = bStore.selectOneByNo(session, boardNo);
		return board;
	}

	@Override
	public int updateBoard(Board board) {
		return bStore.updateBoard(session, board);
	}

	@Override
	public int deleteBoard(int boardNo) {
		int result = bStore.deleteBoard(session, boardNo);
		return result;
	}

	@Override
	public int updateViewCount(int boardNo) {
		return bStore.updateViewCount(session, boardNo);
	}

	@Override
	public int selectBoardCommentCount(int boardNo) {
		return bStore.selectBoardCommentCount(session, boardNo);
	}



}
