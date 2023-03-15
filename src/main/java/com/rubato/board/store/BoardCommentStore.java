package com.rubato.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.board.domain.BoardComment;

public interface BoardCommentStore {

	/**
	 * 댓글 등록 Store
	 * @param session
	 * @param boardComment
	 * @return int
	 */
	public int insertComment(SqlSession session, BoardComment boardComment);

	/**
	 * 댓글 삭제 Store
	 * @param session
	 * @param commentNo
	 * @return int
	 */
	public int deleteComment(SqlSession session, int commentNo);

	/**
	 * 댓글 목록 조회 Store
	 * @param session
	 * @param boardNo
	 * @return List<BoardComment>
	 */
	public List<BoardComment> selectCommentList(SqlSession session, int boardNo);
	

}
