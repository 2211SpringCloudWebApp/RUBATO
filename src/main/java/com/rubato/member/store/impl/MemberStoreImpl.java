package com.rubato.member.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.member.domain.Member;
import com.rubato.member.store.MemberStore;

@Repository
public class MemberStoreImpl implements MemberStore{

	@Override
	public Member selectIdPw(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectIdPw", member);
		return mOne;
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public Member selectMemberById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectMemberById", memberId);
		return member;
	}

	@Override
	public Member selectMemberByNickname(SqlSession session, String memberNickname) {
		Member member = session.selectOne("MemberMapper.selectMemberByNickname", memberNickname);
		return member;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public Member findId(SqlSession session, Member mParam) {
		Member member = session.selectOne("MemberMapper.findId", mParam);
		return member;
	}

	@Override
	public Member findPwd(SqlSession session, Member mParam) {
		Member member = session.selectOne("MemberMapper.findPwd" , mParam);
		return member;
	}

	@Override
	public int boardWriterCount(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.boardWriterCount", memberId);
		return result;
	}

	@Override
	public int boardCommentCount(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.boardCommentCount", memberId);
		return result;
	}

	@Override
	public int lessonWriteCount(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.lessonWriteCount", memberId);
		return result;
	}

	@Override
	public int lessonApplyCount(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.lessonApplyCount", memberId);
		return result;
	}

	@Override
	public int sellWriteCount(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.sellWriteCount", memberId);
		return result;
	}

	@Override
	public int buyApplyCount(SqlSession session, String memberId) {
		int result = session.selectOne("MemberMapper.buyApplyCount", memberId);
		return result;
	}

	
}
