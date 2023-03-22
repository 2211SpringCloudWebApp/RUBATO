package com.rubato.chatting.domain;

import java.sql.Timestamp;

public class Chatting {
	private int chatNo;
	private String senderId;
	private String senderNickname;
	private String receiverId;
	private String receiverNickname;
	private String msgContent;
	private Timestamp sendDate;
	
	
	@Override
	public String toString() {
		return "Chatting [chatNo=" + chatNo + ", senderId=" + senderId + ", senderNickname=" + senderNickname
				+ ", receiverId=" + receiverId + ", receiverNickname=" + receiverNickname + ", msgContent=" + msgContent
				+ ", sendDate=" + sendDate + "]";
	}


	public int getChatNo() {
		return chatNo;
	}


	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}


	public String getSenderId() {
		return senderId;
	}


	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}


	public String getSenderNickname() {
		return senderNickname;
	}


	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}


	public String getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}


	public String getReceiverNickname() {
		return receiverNickname;
	}


	public void setReceiverNickname(String receiverNickname) {
		this.receiverNickname = receiverNickname;
	}


	public String getMsgContent() {
		return msgContent;
	}


	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public Timestamp getSendDate() {
		return sendDate;
	}


	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}
	
	
}
