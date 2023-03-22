package com.rubato.chatting.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubato.chatting.domain.Chatting;
import com.rubato.chatting.service.ChattingService;
import com.rubato.chatting.store.ChattingStore;
import com.rubato.member.domain.Member;


@Service
public class ChattingServiceImpl implements ChattingService {
	@Autowired
	private SqlSession session;
	@Autowired
	private ChattingStore chatStore;
	
	
	@Override
	public List<Chatting> selectChattingById(String loginId) {
		return chatStore.selectChattingById(session, loginId);
	}
	
	@Override
	public List<Member> selectMemberByNick(String memberNickname) {
		return chatStore.selectMemberByNick(session, memberNickname);
	}

	@Override
	public String getNicknameById(String receiverId) {
		return chatStore.getNicknameById(session, receiverId);
	}

	@Override
	public List<Chatting> selectAllChatting(Map<String, String> map) {
		return chatStore.selectAllChatting(session, map);
	}

	@Override
	public int insertChatting(Map<String, String> sendInfo) {
		return chatStore.insertChatting(session, sendInfo);
	}

	@Override
	public String getIdByNickname(String opponentNickname) {
		return chatStore.getIdByNickname(session, opponentNickname);
	}



}
