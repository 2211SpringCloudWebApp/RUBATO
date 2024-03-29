package com.rubato.lesson.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.PageInfo;
import com.rubato.lesson.domain.Search;
import com.rubato.lesson.domain.Apply;
import com.rubato.lesson.service.LessonService;
import com.rubato.lesson.store.LessonStore;

@Service
public class LessonServiceImpl implements LessonService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private LessonStore lStore;
	
	
	@Override //레슨글 등록
	public int createLesson(Lesson lesson) {
		return lStore.createLesson(session, lesson);
	}

	@Override //레슨글 삭제
	public int removeLesson(int lessonNo) {
		return lStore.removeLesson(session, lessonNo);
	}

	@Override //레슨글 번호로 찾기
	public Lesson selectOneByNo(int lessonNo) {
		return lStore.selectOneByNo(session, lessonNo);
	}

	@Override //레슨글 수정
	public int modifyLesson(Lesson lesson) {
		return lStore.modifyLesson(session, lesson);
	}

	@Override //레슨글 목록
	public List<Lesson> selectLessons(PageInfo pi) {
		return lStore.selectLessons(session, pi);
	}

	@Override //나의 레슨 목록
	public List<Lesson> selectMyLessons(String memberId, PageInfo pi) {
		return lStore.selectMyLessons(session, memberId, pi);
	}
	
	@Override //레슨글 전체 개수
	public int getListCount() {
		return lStore.getListCount(session);
	}
	
	@Override //회원별 레슨 개수
	public int getListCount(String memberId) {
		return lStore.getListCount(session, memberId);
	}

	@Override //검색된 레슨 개수
	public int getListCount(Search search) {
		return lStore.getListCount(session, search);
	}

	@Override //레슨글 검색
	public List<Lesson> selectListByKeyword(PageInfo pi, Search search) {
		return lStore.selectListByKeyword(session, pi, search);
	}

	
/*--------------------------------------------------------------------------*/
	

	@Override //신청글 등록
	public int createApply(Apply apply) {
		return lStore.createApply(session, apply);
	}

	@Override //신청글 삭제
	public int removeApply(Apply apply) {
		return lStore.removeApply(session, apply);
	}
	
	@Override //신청글 수정
	public int modifyApply(Apply apply) {
		return lStore.modifyApply(session, apply);
	}

	@Override //신청글 찾기
	public Apply selectOneApply(Apply user) {
		return lStore.selectOneApply(session, user);
	}

	@Override //신청글 목록
	public List<Apply> selectApplys(String memberId, PageInfo pi) {
		return lStore.selectApplys(session, memberId, pi);
	}
	
	@Override //레슨별 신청글 목록
	public List<Apply> selectByLesson(int lessonNo, PageInfo pi) {
		return lStore.selectByLesson(session, lessonNo, pi);
	}

	@Override //레슨별 신청 개수
	public int getListCount(int lessonNo) {
		return lStore.getListCount(session, lessonNo);
	}

	@Override //회원별 신청 개수
	public int getApplyCount(String memberId) {
		return lStore.getApplyCount(session, memberId);
	}



	


	


}
