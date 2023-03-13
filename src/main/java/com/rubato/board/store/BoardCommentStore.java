package com.rubato.board.store;

import org.apache.ibatis.session.SqlSession;

import com.rubato.board.domain.BoardComment;

public interface BoardCommentStore {

	/**
	 * 댓글 등록 Store
	 * @param session
	 * @param boardComment
	 * @return int
	 */
	public int insertComment(SqlSession session, int commentNo);

	/**
	 * 댓글 삭제 Store
	 * @param session
	 * @param commentNo
	 * @return int
	 */
	public int deleteComment(SqlSession session, int commentNo);
	

}
