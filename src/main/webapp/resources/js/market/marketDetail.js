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
