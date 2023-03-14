package com.rubato.lesson.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.Apply;
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
	
	@Override //나의 레슨 목록
	public List<Lesson> selectMyLessons(SqlSession session, String memberId) {
		List<Lesson> lList = session.selectList("LessonMapper.selectMyLessons", memberId);
		return lList;
	}

	
/*---------------------------------------------------------------------------*/
	
	@Override //신청글 등록
	public int createApply(SqlSession session, Apply apply) {
		int result = session.insert("ApplyMapper.insertApply", apply);
		return result;
	}
	
	@Override //신청글 삭제
	public int removeApply(SqlSession session, Apply apply) {
		int result = session.delete("ApplyMapper.deleteApply", apply);
		return result;
	}

	@Override //신청글 찾기
	public Apply selectOneApply(SqlSession session, Apply user) {
		Apply apply = session.selectOne("ApplyMapper.selectOneApply", user);
		return apply;
	}

	@Override //나의 신청글 목록
	public List<Apply> selectApplys(SqlSession session, String memberId) {
		List<Apply> aList = session.selectList("ApplyMapper.selectApplys", memberId);
		return aList;
	}
	
	@Override //레슨별 신청글 목록
	public List<Apply> selectByLesson(SqlSession session, int lessonNo) {
		List<Apply> aList = session.selectList("ApplyMapper.selectByLesson", lessonNo);
		return aList;
	}



	


}
