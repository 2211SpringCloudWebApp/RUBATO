package com.rubato.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.board.domain.Board;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.domain.Search;

public interface BoardStore {

	/**
	 * 게시판 글 등록 Store
	 * @param session
	 * @param board
	 * @return int
	 */
	public int insertBoard(SqlSession session, Board board);

	/**
	 * 게시판 전체 게시물 개수 Store
	 * @param session
	 * @return int
	 */
	public int getListCount(SqlSession session);
	
	/**
	 * 게시판 검색 게시물 전체 개수 Store
	 * @param session
	 * @param search
	 * @return int
	 */
	public int getListCount(SqlSession session, Search search);

	/**
	 * 게시판 목록 조회 Store
	 * @param session
	 * @param pi
	 * @return List<Board>
	 */
	public List<Board> selectBoardList(SqlSession session, PageInfo pi);

	/**
	 * 게시판 검색 Store
	 * @param session
	 * @param pi
	 * @param search
	 * @return List<Board>
	 */
	public List<Board> selectListByKeyword(SqlSession session, PageInfo pi, Search search);

	/**
	 * 게시판 상세 Store
	 * @param session
	 * @param boardNo
	 * @return Board
	 */
	public Board selectOneByNo(SqlSession session, int boardNo);

	/**
	 * 게시판 수정 Store
	 * @param session
	 * @param board
	 * @return int
	 */
	public int updateBoard(SqlSession session, Board board);

	/**
	 * 게시판 삭제
	 * @param session
	 * @param boardNo
	 * @return int
	 */
	public int deleteBoard(SqlSession session, int boardNo);

	/**
	 * 조회수 증가 Store
	 * @param session
	 * @param boardNo
	 * @return int
	 */
	public int updateViewCount(SqlSession session, int boardNo);

	/**
	 * 댓글 개수 Store
	 * @param session
	 * @param boardNo
	 * @return int
	 */
	public int selectBoardCommentCount(SqlSession session, int boardNo);


}
