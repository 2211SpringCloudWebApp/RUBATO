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
	public int getListCount(SqlSession session , String memberId);
	
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

	//	민우 추가
	/**
	 * 아이디로 내가 쓴 글 Id로목록 조회 Store
	 * @param session
	 * @param memberId
	 * @return List<Board>
	 */
	List<Board> selectListById(SqlSession session, PageInfo pi, String memberId);

	/**
	 * 마이페이지 내가 쓴 글 목록 카운트
	 * @param session
	 * @param memberId
	 * @return int
	 */
	
	public int getBoardListCount(SqlSession session,String memberId);
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
	 * 마이페이지 목록 조회
	 * @param session
	 * @param memberId
	 * @return List<Board>
	 */
	public List<Board> selectListById(SqlSession session, String memberId);

	



}
