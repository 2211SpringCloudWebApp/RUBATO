package com.rubato.lesson.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.lesson.domain.Lesson;
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

	@Override
	public List<Lesson> selectLessons() {
		List<Lesson> lList = lStore.selectLessons(session);
		return lList;
	}

}
