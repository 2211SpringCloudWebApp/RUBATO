package com.rubato.chatting.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rubato.chatting.domain.Chatting;
import com.rubato.chatting.store.ChattingStore;
import com.rubato.member.domain.Member;

@Repository
public class ChattingStoreImpl implements ChattingStore{
	
	@Override
	public List<Chatting> selectChattingById(SqlSession session, String loginId) {
		List<Chatting> chattingList = session.selectList("ChattingMapper.selectChattingById", loginId);
		return chattingList;
	}

	@Override
	public List<Member> selectMemberByNick(SqlSession session, String memberNickname) {
		List<Member> memList = session.selectList("ChattingMapper.selectMemberByNick", memberNickname);
		return memList;
	}

	@Override
	public String getNicknameById(SqlSession session, String receiverId) {
		String receiverNickname = session.selectOne("ChattingMapper.getNicknameById", receiverId);
		return receiverNickname;
	}

	@Override
	public List<Chatting> selectAllChatting(SqlSession session, Map<String, String> map) {
		List<Chatting> msgList = session.selectList("ChattingMapper.selectAllChatting", map);
		return msgList;
	}

	@Override
	public int insertChatting(SqlSession session, Map<String, String> sendInfo) {
		int result = session.insert("ChattingMapper.insertChatting", sendInfo);
		return result;
	}

	@Override
	public String getIdByNickname(SqlSession session, String opponentNickname) {
		String result = session.selectOne("ChattingMapper.getIdByNickname", opponentNickname);
		return result;
	}


}
