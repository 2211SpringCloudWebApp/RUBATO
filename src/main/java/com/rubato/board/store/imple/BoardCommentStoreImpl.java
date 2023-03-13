package com.rubato.board.store.imple;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.board.domain.BoardComment;
import com.rubato.board.store.BoardCommentStore;

@Repository
public class BoardCommentStoreImpl implements BoardCommentStore {
	@Autowired
	private SqlSession session;

	@Override
	public int insertComment(SqlSession session, int commentNo) {
		return session.insert("BoardCommentMapper.insertComment", commentNo);
	}

	@Override
	public int deleteComment(SqlSession session, int commentNo) {
		return session.delete("BoardCommentMapper.deleteComment", commentNo);
	}
}
