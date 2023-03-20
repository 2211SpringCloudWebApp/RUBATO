package com.rubato.board.service;

import java.util.List;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.domain.Search;

public interface BoardService {

	/**
	 * 게시판 글 등록 Service
	 * @param board
	 * @return int
	 */
	public int insertBoard(Board board);

	/**
	 * 게시판 게시물 전체 개수 Service
	 * @param search 
	 * @return int
	 */
	public int getListCount(Search search);

	/**
	 * 게시판 목록 조회 Service
	 * @param pi
	 * @return List<Board>
	 */
	public List<Board> selectBoardList(PageInfo pi);

	int getListCount();
	/**
	 * 게시판 검색 Service
	 * @param pi
	 * @param search
	 * @return List<Board>
	 */
	public List<Board> selectListByKeyword(PageInfo pi, Search search);

	/**
	 * 게시판 상세 조회 Service
	 * @param boardNo
	 * @return Board
	 */
	public Board selectOneByNo(int boardNo);

	/**
	 * 게시판 수정 Service
	 * @param board
	 * @return int
	 */
	public int updateBoard(Board board);

	/**
	 * 게시판 삭제 Service
	 * @param boardNo
	 * @return int
	 */
	public int deleteBoard(int boardNo);

	/**
	 * 조회수 증가 Service
	 * @param boardNo
	 * @return int
	 */
	public int updateViewCount(int boardNo);

}
