package com.rubato.lesson.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.PageInfo;
import com.rubato.lesson.domain.Apply;

public interface LessonStore {

	/**
	 * 레슨글 등록 Store
	 * @param session
	 * @param lesson
	 * @return int
	 */
	public int createLesson(SqlSession session, Lesson lesson);

	/**
	 * 레슨글 삭제 Store
	 * @param session
	 * @param noticeNo
	 * @return int
	 */
	public int removeLesson(SqlSession session, int lessonNo);

	/**
	 * 레슨글 번호로 찾기 Store
	 * @param session
	 * @param lessonNo
	 * @return Lesson
	 */
	public Lesson selectOneByNo(SqlSession session, int lessonNo);

	/**
	 * 레슨글 수정 Store
	 * @param session
	 * @param lesson
	 * @return int
	 */
	public int modifyLesson(SqlSession session, Lesson lesson);

	/**
	 * 레슨글 목록 Store
	 * @param session
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessons(SqlSession session, PageInfo pi);
	
	/** 
	 * 나의 레슨글 목록 Store
	 * @param session
	 * @param memberId Store
	 * @return List<Lesson>
	 */
	public List<Lesson> selectMyLessons(SqlSession session, String memberId, PageInfo pi);

	/**
	 * 레슨글 전체 개수 Store
	 * @param session
	 * @return int
	 */
	public int getListCount(SqlSession session);
	
	/**
	 * 회원별 레슨 개수 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int getListCount(SqlSession session, String memberId);

/*---------------------------------------------------------------------------*/
	
	/**
	 * 신청글 등록 Store
	 * @param session
	 * @param apply
	 * @return int
	 */
	public int createApply(SqlSession session, Apply apply);
	
	/**
	 * 신청글 삭제 Store
	 * @param session
	 * @param lessonNo
	 * @param memberId
	 * @return int
	 */
	public int removeApply(SqlSession session, Apply apply);

	/**
	 * 신청글 수정 Store
	 * @param session
	 * @param apply
	 * @return int
	 */
	public int modifyApply(SqlSession session, Apply apply);

	/**
	 * 신청글 찾기 Store
	 * @param session
	 * @param user
	 * @return Apply
	 */
	public Apply selectOneApply(SqlSession session, Apply user);

	/**
	 * 신청글 목록 Store
	 * @param session
	 * @param memberId
	 * @return List<Apply>
	 */
	public List<Apply> selectApplys(SqlSession session, String memberId, PageInfo pi);
	
	/**
	 * 레슨별 신청글 목록 Store
	 * @param session
	 * @param lessonNo
	 * @return List<Apply>
	 */
	public List<Apply> selectByLesson(SqlSession session, int lessonNo, PageInfo pi);

	/**
	 * 레슨별 신청글 개수 Store
	 * @param session
	 * @param lessonNo
	 * @return int
	 */
	public int getListCount(SqlSession session, int lessonNo);

	/**
	 * 회원별 신청글 개수 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int getApplyCount(SqlSession session, String memberId);

	


	
	

	



}
