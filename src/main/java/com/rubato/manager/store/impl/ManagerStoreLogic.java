package com.rubato.manager.store.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.manager.store.ManagerStore;
import com.rubato.member.domain.Member;
import com.rubato.member.domain.PageInfo;
import com.rubato.member.domain.SearchMember;

@Repository
public class ManagerStoreLogic implements ManagerStore{
	@Autowired
	private SqlSession session;

	// 회원 리스트
	@Override
	public List<Member> selectMembers(PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> mList = session.selectList("ManagerMapper.selectMembers", null, rowBounds);
		return mList;
	}

	// 회원 삭제
	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("ManagerMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("ManagerMapper.getListCount");
		return result;
	}

	// 회원 검색
	@Override
	public List<Member> selectListByKeyword(SqlSession session,PageInfo pi, SearchMember searchMember) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> searchList = session.selectList("ManagerMapper.selectListByKeyword",searchMember, rowBounds );
		return searchList;
	}

	@Override
	public int getListCount(SqlSession session, SearchMember searchMember) {
		int result = session.selectOne("ManagerMapper.getSearchListCount", searchMember);
		return result;
	}

	


}
