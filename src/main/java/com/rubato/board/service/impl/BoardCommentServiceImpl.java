package com.rubato.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.board.domain.BoardComment;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.service.BoardCommentService;
import com.rubato.board.store.BoardCommentStore;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	
	@Autowired
	private BoardCommentStore bcStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertComment(BoardComment boardComment) {
		return bcStore.insertComment(session, boardComment);
	}

	@Override
	public int deleteComment(int commentNo) {
		return bcStore.deleteComment(session, commentNo);
	}

	@Override
	public List<BoardComment> selectCommentList(int boardNo) {
		List<BoardComment> bcList = bcStore.selectCommentList(session, boardNo);
		return bcList;
	}
	
	//민우추가
	@Override
	public List<BoardComment> searchListByComment(PageInfo pi, String memberId) {
		List<BoardComment> cList = bcStore.searchListByComment(session, pi,  memberId);
		return cList;
	}

	@Override
	public int getBoardCommentListCount(String memberId) {
		int result = bcStore.getBoardCommentListCount(session, memberId);
		return result;
	}

	
	
}
