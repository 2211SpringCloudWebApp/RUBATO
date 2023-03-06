//이메일 select
document.querySelector("select").addEventListener("change", function(){
    var domain = document.querySelector("option:checked").value;
    if(domain==""){
        document.querySelector("[name=memberEmail2]").removeAttribute("readonly");
        document.querySelector("[name=memberEmail2]").value = domain;
        document.querySelector("[name=memberEmail2]").focus();
    }
    else{
        document.querySelector("[name=memberEmail2]").setAttribute("readonly", true);
        document.querySelector("[name=memberEmail2]").value = domain;

    }
})

// 주소API
var searchAddr = function(){
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            }
            document.querySelector("[name=memberAddr1]").value = data.address + extraAddr;
            document.querySelector("[name=memberAddr2]").focus();
        }
    }).open();
}