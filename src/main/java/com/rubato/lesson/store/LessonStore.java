package com.rubato.lesson.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.lesson.domain.Lesson;
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
	public List<Lesson> selectLessons(SqlSession session);
	
	/**
	 * 나의 레슨글 목록
	 * @param session
	 * @param memberId Store
	 * @return List<Lesson>
	 */
	public List<Lesson> selectMyLessons(SqlSession session, String memberId);

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
	 * @return
	 */
	public int removeApply(SqlSession session, Apply apply);

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
	public List<Apply> selectApplys(SqlSession session, String memberId);

	



}
