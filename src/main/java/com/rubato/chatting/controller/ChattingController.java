package com.rubato.chatting.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rubato.chatting.domain.Chatting;
import com.rubato.chatting.service.ChattingService;
import com.rubato.member.domain.Member;

@Controller
public class ChattingController {
	@Autowired
	private ChattingService chatService;
	
	// [채팅] 채팅방 목록
	@GetMapping("/chatting/chattinglist")
	@ResponseBody
	public List<Chatting> chattingList(HttpSession session){
		String loginId = ((Member) session.getAttribute("loginUser")).getMemberId();
		List<Chatting> chatList = chatService.selectChattingById(loginId);
		for(Chatting chatting : chatList) {
			if(chatting.getSenderNickname() == null) {
				chatting.setSenderNickname(chatting.getReceiverNickname());
			}
		}
		Set<String> senderNicknameSet = new HashSet<>(); // senderNickname 값을 저장할 HashSet
		List<Chatting> distinctChatList = new ArrayList<>(); // 중복된 Chatting 객체를 제거한 리스트
		
		for (Chatting chatting : chatList) {
		    if (senderNicknameSet.add(chatting.getSenderNickname())) {
		        distinctChatList.add(chatting);
		    }
		}
		
		return distinctChatList;
	}
	
	// [채팅] 채팅방 입장
	@GetMapping("/chatting/room")
	@ResponseBody
	public List<Chatting> messageList(HttpSession session, String opponentNickname){
		if(session.getAttribute("loginUser")!=null) {
			String loginId = ((Member) session.getAttribute("loginUser")).getMemberId();
			Map<String, String> map = new HashMap<String, String>();
			map.put("opponentNickname", opponentNickname);
			map.put("loginId", loginId);
			List<Chatting> msgList = chatService.selectAllChatting(map);
			return msgList;
		}
		else {
			return null;
		}
	}
	
	// [채팅] 닉네임 검색
	@GetMapping("/chatting/searchNickname")
	@ResponseBody
	public List<Member> searchNickname(String memberNickname) {
		if(memberNickname=="") {
			List<Member> memList = null;
			return memList;
		}
		List<Member> memList = chatService.selectMemberByNick(memberNickname);
		return memList;
	}
	
	// [채팅] 메시지 전송
	@PostMapping("chatting/send")
	@ResponseBody
	public List<Chatting> sendMsg(@RequestBody Map<String, String> map, HttpSession session) {
		String loginId = ((Member) session.getAttribute("loginUser")).getMemberId();
		String loginNickname = ((Member) session.getAttribute("loginUser")).getMemberNickname();
		String opponentNickname = map.get("opponentNickname");
		// 상대방 닉네임의 아이디 추출
		String opponentId = chatService.getIdByNickname(opponentNickname);
		String msgContent = map.get("msgContent");
		System.out.println("로그인ID: "+loginId);
		System.out.println("로그인닉네임: "+loginNickname);
		System.out.println("수신자ID: "+opponentId);
		System.out.println("수신자닉네임: "+opponentNickname);
		System.out.println("메시지 내용: "+msgContent);
		Map<String, String> sendInfo = new HashMap<String, String>();
		sendInfo.put("loginId", loginId);
		sendInfo.put("loginNickname", loginNickname);
		sendInfo.put("opponentNickname", opponentNickname);
		sendInfo.put("opponentId", opponentId);
		sendInfo.put("msgContent", msgContent);
		int result = chatService.insertChatting(sendInfo);
		if(result>0) {
			List<Chatting> msgList = chatService.selectAllChatting(sendInfo);
			for(Chatting chatting : msgList) {
				System.out.println(chatting.toString());
			}
			return msgList;
		}
		else {
			return null;
		}
	}

}
