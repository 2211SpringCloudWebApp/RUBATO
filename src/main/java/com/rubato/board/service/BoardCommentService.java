package com.rubato.board.service;

import java.util.List;

import com.rubato.board.domain.BoardComment;
import com.rubato.board.domain.PageInfo;

public interface BoardCommentService {

	/**
	 * 댓글 등록 Service
	 * @param boardComment
	 * @return int
	 */
	public int insertComment(BoardComment boardComment);

	/**
	 * 댓글 삭제 Service
	 * @param commentNo
	 * @return int
	 */
	public int deleteComment(int commentNo);

	/**
	 * 댓글 목록 조회 Service 
	 * @param boardNo
	 * @return List<BoardComment>
	 */
	public List<BoardComment> selectCommentList(int boardNo);
	
	//민우 추가
	/**
	 * 마이페이지 내가 쓴 댓글 Service
	 * return List<BoardComment>
	 */
	
	public List<BoardComment> searchListByComment(PageInfo pi, String memberId);
	
	/**
	 * 마이페이지 내가 쓴 댓글 카운트 Service
	 * return int
	 */
	public int getBoardCommentListCount(String memberId);
	
	
}
