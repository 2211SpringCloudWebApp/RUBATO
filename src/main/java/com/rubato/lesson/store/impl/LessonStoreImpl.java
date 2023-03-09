package com.rubato.lesson.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.store.LessonStore;

@Repository
public class LessonStoreImpl implements LessonStore{

	@Override //레슨글 작성
	public int createLesson(SqlSession session, Lesson lesson) {
		int result = session.insert("LessonMapper.insertLesson", lesson);
		return result;
	}

	@Override //레슨글 삭제
	public int removeLesson(SqlSession session, int lessonNo) {
		int result = session.delete("LessonMapper.deleteLesson", lessonNo);
		return result;
	}

	@Override //레슨글 번호로 찾기
	public Lesson selectOneByNo(SqlSession session, int lessonNo) {
		Lesson lesson = session.selectOne("LessonMapper.selectOneByNo", lessonNo);
		return lesson;
	}

	@Override //레슨글 수정
	public int modifyLesson(SqlSession session, Lesson lesson) {
		int result = session.update("LessonMapper.updateLesson", lesson);
		return result;
	}

	@Override //레슨글 목록
	public List<Lesson> selectLessons(SqlSession session) {
		List<Lesson> lList = session.selectList("LessonMapper.selectLessons");
		return lList;
	}

}
