package com.rubato.manager.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.lesson.domain.Lesson;
import com.rubato.member.domain.Member;
import com.rubato.manager.domain.PageInfo;
import com.rubato.manager.domain.SearchMember;

public interface ManagerStore {

	/**
	 * 관리자- 회원 리스트 Store
	 * @return List<Member>
	 */
	public List<Member> selectMembers(PageInfo pi);

	/**
	 * 관리자- 회원 삭제 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(SqlSession session, String memberId);

	public int getListCount(SqlSession session);

	/**
	 * 회원 삭제 Store
	 * @param pi 
	 * @param searchMember
	 * @return List<Member>
	 */
	public List<Member> selectListByKeyword(SqlSession session, PageInfo pi, SearchMember searchMember);
	/**
	 * 회원 검색 게시물 전체 개수 Store
	 * @param session
	 * @param searchMember
	 * @return
	 */
	public int getListCount(SqlSession session, SearchMember searchMember);

	/**
	 * 레슨 게시판 관리 Store
	 * @param pi
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessonBoard(PageInfo pi);

	/**
	 * 레슨 게시물 삭제 Store
	 * @param session
	 * @param lessonNo
	 * @return int
	 */
	public int deleteLessonBoard(SqlSession session, Integer lessonNo);

	/**
	 * 레슨 게시물 리스트 Store
	 * @param session
	 * @return
	 */
	public int getLessonListCount(SqlSession session);
	

}
