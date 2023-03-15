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
	 * @return List<Lesson>
	 */
	public List<Lesson> selectLessons();
	
	/**
	 * 나의 레슨글 목록 Service
	 * @param memberId
	 * @return List<Lesson>
	 */
	public List<Lesson> selectMyLessons(String memberId);
	

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
	 * 신청글 수정 Service
	 * @param apply
	 * @return int
	 */
	public int modifyApply(Apply apply);
	
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
	
	/**
	 * 레슨별 신청글 목록 Service
	 * @param lessonNo
	 * @return List<Apply>
	 */
	public List<Apply> selectByLesson(int lessonNo);

	
	
}
