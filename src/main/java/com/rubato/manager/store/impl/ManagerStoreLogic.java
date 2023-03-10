package com.rubato.manager.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.manager.store.ManagerStore;
import com.rubato.member.domain.Member;

@Repository
public class ManagerStoreLogic implements ManagerStore{
	@Autowired
	private SqlSession session;

	// 회원 리스트
	@Override
	public List<Member> selectMembers() {
		List<Member> mList = session.selectList("ManagerMapper.selectMembers");
		return mList;
	}

	// 회원 삭제
	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("ManagerMapper.deleteMember", memberId);
		return result;
	}

	


}
