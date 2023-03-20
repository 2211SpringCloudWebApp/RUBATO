var uploadImgTags = document.querySelectorAll(".uploadImg");
let count = uploadImgTags.length;
var thumbnailsDelete = (data)=>{
	if(data =='1'){
		var resp = confirm("삭제 하시겠습니까?");
	    if(resp===true){
	        document.querySelector("#uploadImg1").remove();
	        document.querySelector("#uploadLimit").innerHTML = (count-1)+"/3";
	        count -= 1;
	    }
	}
	if(data =='2'){
		var resp = confirm("삭제 하시겠습니까?");
	    if(resp===true){
	        document.querySelector("#uploadImg2").remove();
	        document.querySelector("#uploadLimit").innerHTML = (count-1)+"/3";
	        count -= 1;
	    }
	}
	if(data =='3'){
		var resp = confirm("삭제 하시겠습니까?");
	    if(resp===true){
	        document.querySelector("#uploadImg3").remove();
	        document.querySelector("#uploadLimit").innerHTML = (count-1)+"/3";
	        count -= 1;
	    }
	}
}