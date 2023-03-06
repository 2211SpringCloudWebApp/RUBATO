package com.rubato.member.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.member.domain.Member;
import com.rubato.member.store.MemberStore;

@Repository
public class MemberStoreImpl implements MemberStore{

	@Override
	public Member selectIdPw(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

}
