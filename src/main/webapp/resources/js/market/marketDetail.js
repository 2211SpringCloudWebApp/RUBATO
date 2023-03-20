let currentIdx = 1; //현재 슬라이드 index


var hiddenPhotos = () =>{
    document.querySelector(".uploadImg:nth-child(1)").style.display = "none";
    document.querySelector(".uploadImg:nth-child(2)").style.display = "none";
    document.querySelector(".uploadImg:nth-child(3)").style.display = "none";
}

document.querySelector(".prev").addEventListener("click", ()=>{
    if(currentIdx === 1){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(2)").style.display = "block";
        currentIdx += 1;
        return;
    }
    if(currentIdx === 2){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(3)").style.display = "block";
        currentIdx += 1;
        return;
    }
    if(currentIdx === 3){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(1)").style.display = "block";
        currentIdx += 1;
        return;
    }
    if(currentIdx === 4){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(2)").style.display = "block";
        currentIdx = 2;
        return;
    }
})


document.querySelector(".next").addEventListener("click", ()=>{
    if(currentIdx === 1){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(2)").style.display = "block";
        currentIdx += 1;
        return;
    }
    if(currentIdx === 2){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(3)").style.display = "block";
        currentIdx += 1;
        return;
    }
    if(currentIdx === 3){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(1)").style.display = "block";
        currentIdx += 1;
        return;
    }
    if(currentIdx === 4){
        hiddenPhotos();
        document.querySelector(".uploadImg:nth-child(2)").style.display = "block";
        currentIdx = 2;
        return;
    }
})


// 삭제 확인
var deleteCheck = ()=> {
    if(!confirm("게시물을 삭제하시겠습니까?")){
        return false;
    }
}


//댓글작성
var commentWrite = (sellNo)=>{
	var commentContent = document.querySelector("#commentContent").value;
	$.ajax({
		type: 'POST',
		url: '/market/detail/comment',
		contentType: 'application/json',
		data: JSON.stringify({
			'sellNo': sellNo,
			'commentContent': commentContent
		}),
		success: function(response){
			if(response==="true"){
				location.reload();
			}
			else{
				alert("로그인 후 이용할 수 있습니다.");
			}
		}
	});
}


//댓글 삭제
var commentDelete = (sellNo, commentNo)=> {
    if(confirm("게시물을 삭제하시겠습니까?")){
        $.ajax({
        	type: 'POST',
        	url: '/market/detail/comment/delete',
        	contentType: 'application/json',
        	data: JSON.stringify({
        		'sellNo': sellNo,
        		'commentNo': commentNo
        	}),
        	success: function(response){
        		if(response==="true"){
        			location.reload();
        		}
        		else{
        			alert("잘못된 접근입니다.");
        		}
        	}
        });
    }
}

//댓글 수정창 띄우기
var commentModify = (statusCount, commentContent, commentNo)=> {
	const pTag = document.querySelector("#ptag"+statusCount);
	//textarea 태그 생성
	const textarea = document.createElement('textarea');
	textarea.innerText = commentContent;
	textarea.id = "commentContent";
	textarea.name = "modifyContent"+statusCount;
	textarea.cols = 30;
	textarea.rows = 10;
	textarea.placeholder = "부적절한 댓글을 작성할 시 관련 법령에 의거 처벌될 수 있습니다.";
	
	//button 태그 생성
	const button = document.createElement('button');
	button.id = "enroll-btn";
	button.innerText = "수정하기";
	button.setAttribute("onclick", "commentModify2("+statusCount+","+commentNo+")");
	pTag.insertAdjacentElement('beforebegin', textarea);
	pTag.insertAdjacentElement('beforebegin', button);
	pTag.remove();
}


//댓글 수정
var commentModify2 = (statusCount, commentNo)=>{
	var commentContent = document.querySelector("[name=modifyContent"+statusCount+"]").value;
	$.ajax({
		type: 'POST',
		url: '/market/detail/comment/modify',
		contentType: 'application/json',
		data: JSON.stringify({
			'commentNo': commentNo,
			'commentContent': commentContent
		}),
		success: function(response){
			if(response==="true"){
				location.reload();
			}
			else{
				alert("잘못된 접근입니다.");
			}
		}
	});
}