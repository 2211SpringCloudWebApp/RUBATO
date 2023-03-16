package com.rubato.lesson.store.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.lesson.domain.Lesson;
import com.rubato.lesson.domain.PageInfo;
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
	public List<Lesson> selectLessons(SqlSession session, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage -1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Lesson> lList = session.selectList("LessonMapper.selectLessons", null, rowBounds);
		return lList;
	}
	
	@Override //나의 레슨 목록
	public List<Lesson> selectMyLessons(SqlSession session, String memberId, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Lesson> lList = session.selectList("LessonMapper.selectMyLessons", memberId, rowBounds);
		return lList;
	}
	
	@Override //레슨글 전체 개수
	public int getListCount(SqlSession session) {
		int result = session.selectOne("LessonMapper.getListcount");
		return result;
	}

	@Override //회원별 레슨 개수
	public int getListCount(SqlSession session, String memberId) {
		int result = session.selectOne("LessonMapper.countByMember", memberId);
		return result;
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
	
	@Override //신청글 수정
	public int modifyApply(SqlSession session, Apply apply) {
		int result = session.update("ApplyMapper.modifyApply", apply);
		return result;
	}

	@Override //신청글 찾기
	public Apply selectOneApply(SqlSession session, Apply user) {
		Apply apply = session.selectOne("ApplyMapper.selectOneApply", user);
		return apply;
	}

	@Override //나의 신청글 목록
	public List<Apply> selectApplys(SqlSession session, String memberId, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Apply> aList = session.selectList("ApplyMapper.selectApplys", memberId, rowBounds);
		return aList;
	}
	
	@Override //레슨별 신청글 목록
	public List<Apply> selectByLesson(SqlSession session, int lessonNo, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Apply> aList = session.selectList("ApplyMapper.selectByLesson", lessonNo, rowBounds);
		return aList;
	}

	@Override //레슨별 신청글 개수
	public int getListCount(SqlSession session, int lessonNo) {
		int result = session.selectOne("ApplyMapper.countByLesson", lessonNo);
		return result;
	}

	@Override //회원별 신청글 개수
	public int getApplyCount(SqlSession session, String memberId) {
		int result = session.selectOne("ApplyMapper.countByMember", memberId);
		return result;
	}

	



	


}
