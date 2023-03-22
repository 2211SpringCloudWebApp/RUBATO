package com.rubato.chatting.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubato.chatting.domain.Chatting;
import com.rubato.member.domain.Member;

public interface ChattingStore {
	/**
	 * 채팅 목록 출력 Store
	 * @param session
	 * @param receiverId
	 * @return List<Chatting>
	 */
	public List<Chatting> selectChattingById(SqlSession session, String loginId);

	/**
	 * 닉네임 검색 Store
	 * @param session
	 * @param memberNickname
	 * @return Member
	 */
	public List<Member> selectMemberByNick(SqlSession session, String memberNickname);

	/**
	 * 아이디로 닉네임 검색 Store
	 * @param session
	 * @param receiverId
	 * @return String
	 */
	public String getNicknameById(SqlSession session, String receiverId);

	/**
	 * 메시지 목록 출력 Store
	 * @param session
	 * @param map
	 * @return List<Chatting>
	 */
	public List<Chatting> selectAllChatting(SqlSession session, Map<String, String> map);

	/**
	 * 메시지 전송 Store
	 * @param session
	 * @param sendInfo
	 * @return int
	 */
	public int insertChatting(SqlSession session, Map<String, String> sendInfo);

	/**
	 * 닉네임으로 아이디 검색 Store
	 * @param session
	 * @param opponentNickname
	 * @return String
	 */
	public String getIdByNickname(SqlSession session, String opponentNickname);


}
