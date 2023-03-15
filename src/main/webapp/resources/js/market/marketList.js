document.querySelector("#selectCondition").addEventListener("change", function(){
    var value = document.querySelector("#selectCondition").value;
    var sellArea = document.querySelector("#sellAreaValue").value;
    var search = document.querySelector("#searchValue").value;
    if(value==="all"){
        location.href ="/market/list";
    }
    else if(value==="selling"){
        location.href ="/market/list?sellArea="+sellArea+"&sellCondition=selling&search="+search;
    }
    else{
        location.href ="/market/list?sellArea="+sellArea+"&sellCondition=soldout&search="+search;
    }
})

//판매등록 링크
var enroll = ()=>{
	location.href ="/market/write";
}

