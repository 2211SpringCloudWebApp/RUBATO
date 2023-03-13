package com.rubato.manager.service;

import java.util.List;

import com.rubato.member.domain.Member;
import com.rubato.member.domain.PageInfo;

public interface ManagerService {
	
	/**
	 * 관리자- 회원 리스트 Service
	 * @return List<Member>
	 */
	public List<Member> selectMembers(PageInfo pi);
	
	/**
	 * 관리자- 회원 삭제 Service
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(String memberId);

	public int getListCount();

	

}
