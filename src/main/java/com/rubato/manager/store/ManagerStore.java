package com.rubato.manager.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubato.member.domain.Member;

public interface ManagerStore {

	/**
	 * 관리자- 회원 리스트 Store
	 * @return List<Member>
	 */
	public List<Member> selectMembers();

	/**
	 * 관리자- 회원 삭제 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(SqlSession session, String memberId);
	

}
