package com.rubato.manager.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.lesson.domain.Lesson;
import com.rubato.manager.service.ManagerService;
import com.rubato.manager.store.ManagerStore;
import com.rubato.member.domain.Member;
import com.rubato.manager.domain.PageInfo;
import com.rubato.manager.domain.SearchLesson;
import com.rubato.manager.domain.SearchMember;

@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private SqlSession session;
	@Autowired
	private ManagerStore managerStore;

	// 회원 리스트
	@Override
	public List<Member> selectMembers(PageInfo pi) {
		List<Member> mList = managerStore.selectMembers(pi);
		return mList;
	}

	// 회원 삭제
	@Override
	public int deleteMember(String memberId) {
		int result = managerStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public int getListCount() {
		int result = managerStore.getListCount(session);
		return result;
	}

	//회원 검색
	@Override
	public List<Member> selectListByKeyword(PageInfo pi, SearchMember searchMember) {
		List<Member> searchList = managerStore.selectListByKeyword(session, pi, searchMember);
		return searchList;
	}

	@Override
	public int getListCount(SearchMember searchMember) {
		int totalCount = managerStore.getListCount(session, searchMember);
		return totalCount;
	}

	@Override
	public List<Lesson> selectLessonBoard(PageInfo pi) {
		List<Lesson> lbList = managerStore.selectLessonBoard(pi);
		return lbList;
	}

	@Override
	public int deleteLessonBoard(Integer lessonNo) {
		int result = managerStore.deleteLessonBoard(session, lessonNo);
		return result;
	}

	@Override
	public int getLessonListCount() {
		int result = managerStore.getLessonListCount(session);
		return result;
	}
	
	@Override
	public int getLessonListCount(SearchLesson searchLesson) {
		int result = managerStore.getLessonListCount(session, searchLesson);
		return result;
	}

	@Override
	public List<Lesson> selectLessonListByKeyword(PageInfo pi, SearchLesson searchLesson) {
		List<Lesson> searchLessonList = managerStore.selectLessonListByKeyword(session, pi, searchLesson);
		return searchLessonList;
	}


}
