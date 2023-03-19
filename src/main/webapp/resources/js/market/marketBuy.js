// 수정 버튼
var modify = ()=>{
    location.href = "/member/modify?memberId=";
}

//결제 API (포트원)
function payment(){
    const sellNo = document.querySelector("[name=sellNo]").value;
    const buyerId = document.querySelector("[name=buyerId").value;
    const productName = document.querySelector(".product-area1 h4:nth-child(1)").innerHTML;
    const totalPrice = document.querySelector("#total_price").value;
    const buyerEmail = document.querySelector("#buyer-area h5:nth-child(3)").innerHTML;
    const buyerName = document.querySelector("#buyer-area h4").innerHTML;
    const buyerTel = document.querySelector("#phone-num").innerHTML;
    const buyerAddr = document.querySelector("#delivery-area h5:nth-child(3)").innerHTML;
    const deliveryMsg = document.querySelector("[name=deliveryMsg]").value;
    //가맹점 식별코드
    IMP.init('imp64784275');
    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : productName, //결제창에서 보여질 이름
        amount : totalPrice, //실제 결제되는 가격
        buyer_email : buyerEmail,
        buyer_name : buyerName,
        buyer_tel : buyerTel,
        buyer_addr : buyerAddr,
        // buyer_postcode : '123-456'
    }, function(rsp) {
        //결제 검증
        $.ajax({
            type: "POST",
            url: "/vertifyIamport/" + rsp.imp_uid
        }).done(function(data){
            if(rsp.paid_amount == data.response.amount){
                alert("결제가 완료되었습니다.");
                // ajax로 결제정보 저장
                $.ajax({
                    type : "POST",
                    url: "/market/payment",
                    contentType: 'application/json',
                    data: JSON.stringify({
                        "sellNo": sellNo,
                        "sellTitle": productName,
                        "paymentPrice": totalPrice,
                        "buyerId": buyerId,
                        "deliveryMsg": deliveryMsg
                    }),
                    success: function(response){
                        if(response==="true"){
                            location.href="/market/list";
                        }
                        else{
                            alert("서버측 오류가 발생했습니다.");
                        }
                    }
                })
            }
            else{
                alert("결제가 취소되었습니다.");
            }
        });
    });
}