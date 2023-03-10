// 가격 콤마 메소드
document.querySelector("#price").addEventListener("input", (event) =>{
    var price = document.querySelector("#price").value;
    price = price.replace(/[^0-9]/g, '');
    price = parseInt(price); 
    if(!isNaN(price)){ 
        document.querySelector("#price").value = price.toLocaleString();
    }
    if(price>999999999){
        document.querySelector("#price").value = "999,999,999";
    }
});

var placeholder = "- 구매시기\n- 제품의 상태 (사용감, 하자 유무 등)\n- 제품명\n* 서로가 믿고 거래할 수 있도록, 자세한 정보와 다양한 각도의 상품 사진을 올려주세요.\n* 개인 간의 거래는 전자상거래 법에 따른 보호 및 피해 구제가 어렵습니다.";
document.querySelector("[name=sellContent]").setAttribute("placeholder", placeholder);


//이미지 업로드 메소드
let cnt = 1;
const thumbnails = document.getElementById('thumbnails');
var filenames = [];
var imageUpload = () => {
    if(cnt<4){
        const input = document.createElement('input');
        input.type = 'file';
        input.id = 'input-file' + cnt;
        //input.name = 'uploadFile' + cnt;
        input.name = 'uploadFile';
        //input.style.display = "none";
        document.querySelector("#file-tag").appendChild(input);
        input.addEventListener('change', (event) => {
            const files = event.target.files;
            const file = files[0];
            if (file) {
                if(filenames.includes(file.name)){
                    alert("이미 업로드된 파일입니다.");
                    document.querySelector("#input-file"+cnt+":last-child").remove();
                    return;
                }
                filenames[cnt - 1] = file.name;
                const reader = new FileReader();
                reader.addEventListener('load', (event) => {
                    const img = new Image();
                    img.src = event.target.result;
                    img.width = 150;
                    img.height = 150;
                    img.id = "image"+(cnt-1);
                    img.style.borderRadius = "10%";
                    img.setAttribute("onclick", "deleteImage"+(cnt-1)+"()");
                    thumbnails.appendChild(img);
                });
                reader.readAsDataURL(file);
                document.querySelector("#uploadLimit").innerHTML = cnt+"/3";
                cnt += 1;
            }
        });
        input.click();
    }
    else{
        alert("이미지는 최대 3개까지만 업로드 할 수 있습니다.");
    }
};



// 이미지 삭제
var deleteImage1 = ()=>{
    var resp = confirm("삭제 하시겠습니까?");
    if(resp===true){
        var filename = filenames[0];
        filenames[0] = null; 
        document.querySelector("#input-file1").remove();
        document.querySelector("#image1").remove();
        cnt -= 1;
        document.querySelector("#uploadLimit").innerHTML = (cnt-1)+"/3";
    }

}
var deleteImage2 = ()=>{
    var resp = confirm("삭제 하시겠습니까?");
    if(resp===true){
        var filename = filenames[1];
        filenames[1] = null;
        document.querySelector("#input-file2").remove();
        document.querySelector("#image2").remove();
        cnt -= 1;
        document.querySelector("#uploadLimit").innerHTML = (cnt-1)+"/3";
    }

}
var deleteImage3 = ()=>{
    var resp = confirm("삭제 하시겠습니까?");
    if(resp===true){
        var filename = filenames[2];
        filenames[2] = null;
        document.querySelector("#input-file3").remove();
        document.querySelector("#image3").remove();
        cnt -= 1;
        document.querySelector("#uploadLimit").innerHTML = (cnt-1)+"/3";
    }
}