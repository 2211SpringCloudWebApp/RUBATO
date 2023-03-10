package com.rubato.lesson.service;

import java.util.List;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.Apply;

public interface LessonService {

	/**
	 * 레슨글 등록 Service
	 * @param lesson
	 * @return int
	 */
	public int createLesson(Lesson lesson);

	/**
	 * 레슨글 삭제 Service
	 * @param lessonNo
	 * @return int
	 */
	public int removeLesson(int lessonNo);

	/**
	 * 레슨글 번호로 찾기 Service
	 * @param lessonNo
	 * @return
	 */
	public Lesson selectOneByNo(int lessonNo);

	/**
	 * 레슨글 수정 Service
	 * @param lesson
	 * @return int
	 */
	public int modifyLesson(Lesson lesson);

	/**
	 * 레슨글 목록 Service
	 * @return
	 */
	public List<Lesson> selectLessons();

/*----------------------------------------------------------------------*/
	
	/**
	 * 신청글 등록 Service
	 * @param apply
	 * @return int
	 */
	public int createApply(Apply apply);

	/**
	 * 신청글 삭제 Service
	 * @param apply
	 * @return int
	 */
	public int removeApply(Apply apply);

	/**
	 * 신청글 찾기 Service
	 * @param user
	 * @return
	 */
	public Apply selectOneApply(Apply user);

	/**
	 * 신청글 목록 Service
	 * @return List<Apply>
	 */
	public List<Apply> selectApplys(String memberId);

}