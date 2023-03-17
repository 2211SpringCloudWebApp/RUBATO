package com.rubato.lesson.service;

import java.util.List;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.PageInfo;
import com.rubato.lesson.domain.Search;
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
	public List<Lesson> selectLessons(PageInfo pi);
	
	/**
	 * 나의 레슨글 목록 Service
	 * @param memberId
	 * @return List<Lesson>
	 */
	public List<Lesson> selectMyLessons(String memberId, PageInfo pi);

	/**
	 * 레슨글 전체 개수 Service
	 * @return int
	 */
	public int getListCount();
	
	/**
	 * 회원 별 레슨 개수 Service
	 * @param memberId
	 * @return int
	 */
	public int getListCount(String memberId);
	
	/**
	 * 검색된 레슨 개수 Service
	 * @param search
	 * @return int
	 */
	public int getListCount(Search search);
	
	/**
	 * 레슨글 검색
	 * @param pi
	 * @param search
	 * @return List<Lesson>
	 */
	public List<Lesson> selectListByKeyword(PageInfo pi, Search search);



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
	 * 회원별 신청글 목록 Service
	 * @return List<Apply>
	 */
	public List<Apply> selectApplys(String memberId, PageInfo pi);
	
	/**
	 * 레슨별 신청글 목록 Service
	 * @param lessonNo
	 * @return List<Apply>
	 */
	public List<Apply> selectByLesson(int lessonNo, PageInfo pi);

	/**
	 * 레슨별 신청글 개수 Service
	 * @param lessonNo
	 * @return int
	 */
	public int getListCount(int lessonNo);

	/**
	 * 회원별 신청글 개수 Service
	 * @param memberId
	 * @return int
	 */
	public int getApplyCount(String memberId);

	
	


	
	
}
