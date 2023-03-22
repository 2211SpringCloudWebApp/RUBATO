<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<div id="header-w">
        <div id="header-container">
            <a href="/"><div id="logo-img"></div></a>
            <ul id="navigator">
                <li class="item"><a href="/lesson/list">레슨매칭</a></li>
                <li class="item"><a href="/market/list">마켓</a></li>
                <li class="item"><a href="/board/list">커뮤니티</a></li>
            </ul>
			<c:if test="${sessionScope.loginUser.memberId eq null }">
				<div id="login-wrapper">
					<button id="login-btn" onclick="location.href='/member/login'">로그인</button>
					<button id="join-btn" onclick="location.href='/member/register'">회원가입</button>
				</div>
			</c:if>
			<div id="login-wrapper">
				<c:if test="${sessionScope.loginUser.memberId ne null }">
					<div id="login-success">
						<input type="hidden" id="member-id" value="${sessionScope.loginUser.memberId }">
					</div>
					<div id="login-success2">
						<button id="login-btn" onclick="location.href='/member/mypage?member-id=${sessionScope.loginUser.memberId }'">마이페이지</button>
						<button id="join-btn" onclick="location.href='/member/logout'">로그아웃</button>
						<img alt="" src="/resources/images/common/messenger.png" id="chatting-logo">
					</div>
				</c:if>
			</div>
        </div>
    </div>

    <!-- 모달창 -->
    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <h2>채팅</h2>
            </div>
            <div class="close-area">X</div>
            <div class="content">
                <input type="text" id="m-searchNickname" placeholder="닉네임을 검색하세요">
                <button id="m-searchBtn"></button>
            </div>
            <div id="m-listArea">
				<div id="m-prev">＜</div>
	            <table id="m-nickNameList">
	            </table>
	            <table id="m-chattingList">
	            	<tr>
	            		<th>채팅방 목록</th>
	            	</tr>
	            </table>
		        <div id="m-msgList">
		        </div>
            </div>
            <div id="m-inputArea">
            	<textarea rows="" cols="" id="m-sendContent" placeholder="메시지 보내기"></textarea>
            	<button id="m-sendBtn"></button>
            </div>
        </div>
    </div>
<!-- 원래 header.js 파일로 따로 뺴두려 했지만, 다른 사람들 모든 코드에 js를 추가해야 하므로 일단 여기에 구현합니다. -->
<script>
// 모달창 띄우기
	const modal = document.querySelector("#modal");
	const btnModal = document.querySelector("#chatting-logo");
	btnModal.addEventListener("click", e => {
		let cnt = 1;
		$.ajax({
			type: 'GET',
			url: '/chatting/chattinglist',
			success: function(response){
				$(response).each(function(index, member){
					let list = "<tr><td id='existedChatting"+cnt+"' onclick='existedChatting("+cnt+")'>"+member.senderNickname+"</td></tr>";
					$("#m-chattingList").append(list);
					cnt++;
				});
			}
		});
		modal.style.display = "flex";
	});
	
	const closeBtn = modal.querySelector(".close-area")
	closeBtn.addEventListener("click", e => {
	    modal.style.display = "none";
	});
	
	modal.addEventListener("click", e => {
	    const evTarget = e.target
	    if(evTarget.classList.contains("modal-overlay")) {
	        modal.style.display = "none"
	    }
	});

// 상대방 닉네임 저장 변수
var opponentNickname = "";
// 닉네임 검색 ajax
	document.querySelector("#m-searchBtn").addEventListener("click", function(){
		let cnt = 1;
		document.querySelector('#m-nickNameList').innerHTML = '';
		var memberNickname = document.querySelector("#m-searchNickname").value;
		$.ajax({
			type: 'GET',
			url: '/chatting/searchNickname?memberNickname='+memberNickname,
			success: function(response){
				if(response.length ===0){
					document.querySelector('#m-nickNameList').style.display = "none";
				}
				$(response).each(function(index, member){
					let list = "<tr><td>"+member.memberNickname+"</td><td><button id='m-chattingBtn"+cnt+"' class='m-chattingBtn' onclick='chattingStart("+cnt+")'>채팅하기</button></td></tr>";
	            	$("#m-nickNameList").append(list);
	            	cnt++;
				});
			}
		});
		document.querySelector('#m-nickNameList').style.display = "block";
	});
	document.querySelector("#m-searchNickname").addEventListener("keyup", function(event){
		let cnt = 1;
		if(event.keyCode === 13){
			document.querySelector('#m-nickNameList').innerHTML = '';
			var memberNickname = document.querySelector("#m-searchNickname").value;
			$.ajax({
				type: 'GET',
				url: '/chatting/searchNickname?memberNickname='+memberNickname,
				success: function(response){
					if(response.length ===0){
						document.querySelector('#m-nickNameList').style.display = "none";
					}
					$(response).each(function(index, member){
						let list = "<tr><td id='memberNickname"+cnt+"'>"+member.memberNickname+"</td><td><button class='m-chattingBtn' onclick='chattingStart("+cnt+")'>채팅하기</button></td></tr>";
		            	$("#m-nickNameList").append(list);
		            	cnt++;
					});
				}
			});
			document.querySelector('#m-nickNameList').style.display = "block";
		}
	});
	
// 채팅방 목록에서 채팅방 입장
	var existedChatting = (cnt) =>{
		document.querySelector("#m-msgList").innerHTML = "";
		document.querySelector("#m-chattingList").style.display = "none";
		opponentNickname = document.querySelector("#existedChatting"+cnt).innerHTML;
		time = setInterval(function(){
		$.ajax({
			type: 'GET',
			url: '/chatting/room?opponentNickname='+opponentNickname,
			success: function(response){
				document.querySelector("#m-msgList").innerHTML = "";
				$(response).each(function(index, chatting){
					var transferDate = new Date(chatting.sendDate);
					var sendDate = transferDate.toLocaleString('ko-KR', {
						month: 'numeric',
						day: 'numeric',
		                hour: 'numeric',
		                minute: 'numeric',
					}).replace(/(\d+). (\d+)./, "$1.$2");
					if(chatting.senderNickname === opponentNickname){
						let list = "<div class='m-recvMsgArea'><span class='senderNickname'>"+chatting.senderNickname+"</span><br><span class='recvMsg'>"+chatting.msgContent+"</span><span class='m-date'>"+sendDate+"</span></div>";
						$("#m-msgList").append(list);
					}
					else if(chatting.senderNickname !== opponentNickname){
						let list = "<div class='m-sendMsgArea'><span class='m-date'>"+sendDate+"</span><span class='sendMsg'>"+chatting.msgContent+"</span></div>";
						$("#m-msgList").append(list);
					}
				});
		document.querySelector("#m-msgList").style.display = "flex";
			}
		});
		},1000);
	}
	
// 닉네임 검색에서 채팅방 입장
	var chattingStart = (cnt) =>{
		document.querySelector("#m-msgList").innerHTML = "";
		document.querySelector('#m-nickNameList').style.display = "none";
		document.querySelector("#m-chattingList").style.display = "none";
		opponentNickname = document.querySelector("#memberNickname"+cnt).innerHTML;
		time = setInterval(function(){
		$.ajax({
			type: 'GET',
			url: '/chatting/room?opponentNickname='+opponentNickname,
			success: function(response){
				document.querySelector("#m-msgList").innerHTML = "";
				$(response).each(function(index, chatting){
					var transferDate = new Date(chatting.sendDate);
					var sendDate = transferDate.toLocaleString('ko-KR', {
						month: 'numeric',
						day: 'numeric',
		                hour: 'numeric',
		                minute: 'numeric',
					}).replace(/(\d+). (\d+)./, "$1.$2");
					if(chatting.senderNickname === opponentNickname){
						let list = "<div class='m-recvMsgArea'><span class='senderNickname'>"+chatting.senderNickname+"</span><br><span class='recvMsg'>"+chatting.msgContent+"</span><span class='m-date'>"+sendDate+"</span></div>";
						$("#m-msgList").append(list);
					}
					else if(chatting.senderNickname !== opponentNickname){
						let list = "<div class='m-sendMsgArea'><span class='m-date'>"+sendDate+"</span><span class='sendMsg'>"+chatting.msgContent+"</span></div>";
						$("#m-msgList").append(list);
					}
				});
			
		document.querySelector("#m-msgList").style.display = "flex";
			}
		});
		},1000);
	}
	
// 채팅방 나가기
	document.querySelector("#m-prev").addEventListener("click", function(){
		clearInterval(time);
		document.querySelector("#m-msgList").innerHTML = "";
		document.querySelector("#m-msgList").style.display = "none";
		document.querySelector("#m-nickNameList").style.display = "none";
// 		document.querySelector("#m-chattingList").style.display = "";
	});

	
// 메시지 전송
	document.querySelector("#m-sendBtn").addEventListener("click", function(){
		var msgTags = document.querySelector("#m-msgList");
		var computedStyle = window.getComputedStyle(msgTags);
		var msgContent = document.querySelector("#m-sendContent").value;
		if(computedStyle.display !== "none"){
				if(msgContent==""){
					alert("메시지를 입력해주세요.");
				}
				else{
					$.ajax({
						type: 'POST',
						url: '/chatting/send',
						contentType: 'application/json',
						data: JSON.stringify({
							'msgContent': msgContent,
							'opponentNickname': opponentNickname
						}),
						success: function(response){
							document.querySelector("#m-msgList").innerHTML = "";
							$(response).each(function(index, chatting){
								var transferDate = new Date(chatting.sendDate);
								var sendDate = transferDate.toLocaleString('ko-KR', {
									month: 'numeric',
									day: 'numeric',
					                hour: 'numeric',
					                minute: 'numeric',
								}).replace(/(\d+). (\d+)./, "$1.$2");
								if(chatting.senderNickname === opponentNickname){
									let list = "<div class='m-recvMsgArea'><span class='senderNickname'>"+chatting.senderNickname+"</span><br><span class='recvMsg'>"+chatting.msgContent+"</span><span class='m-date'>"+sendDate+"</span></div>";
									$("#m-msgList").append(list);
								}
								else if(chatting.senderNickname !== opponentNickname){
									let list = "<div class='m-sendMsgArea'><span class='m-date'>"+sendDate+"</span><span class='sendMsg'>"+chatting.msgContent+"</span></div>";
									$("#m-msgList").append(list);
								}
								var result = document.querySelector("#m-msgList").innerHTML;
								$("#m-msgList").html(result);
								
							});
						}
					});
				}
		}
		else{
			alert("채팅방에 입장한 후에 시도해주세요.")
		}
	});
</script>