package com.rubato.board.service;

import com.rubato.board.domain.BoardComment;

public interface BoardCommentService {

	/**
	 * 댓글 등록 Service
	 * @param boardComment
	 * @return int
	 */
	public int insertComment(int commentNo);

	/**
	 * 댓글 삭제 Service
	 * @param commentNo
	 * @return int
	 */
	public int deleteComment(int commentNo);
	
	
}
