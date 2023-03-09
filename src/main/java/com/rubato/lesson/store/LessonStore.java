package com.rubato.lesson.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.lesson.domain.Lesson;

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
	 * @return
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
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessons(SqlSession session);

}
