package com.rubato.board.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.board.domain.BoardComment;
import com.rubato.board.service.BoardCommentService;
import com.rubato.board.store.BoardCommentStore;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	
	@Autowired
	private BoardCommentStore bcStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertComment(int commentNo) {
		return bcStore.insertComment(session, commentNo);
	}

	@Override
	public int deleteComment(int commentNo) {
		return bcStore.deleteComment(session, commentNo);
	}

	
	
}
