
zoneCode = "";

$('#myBtn').on('click', function() {
	var cupon = $('#textPromo').val();
	if(cupon.length != 19){
		$('#textPromo').val('')
	}
});

$('.cupon').on('click', function() {
	var cupon = $(this).text();
	$('#textPromo').val('Apply Cupon');
	span.onclick();
	var total = $('.totalPrice').text();
	total = total.replace(',', '');
	var price = parseInt(total)*0.95;
	price = price.toLocaleString();
	$('.totalPrice').html(price);
});


//Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var mybtn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
mybtn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}



// Remove Items From Cart
$('a.remove').click(function(){
  event.preventDefault();
  $( this ).parent().parent().parent().hide( 400 );
 
})

//// Just for testing, show all items
//  $('a.btn.continue').click(function(){
//    $('li.items').show(400);
//  })
//  
// Remove Items From DataBase(detail_order)
$('.remove').on('click',function() {
	var orderId = $(this).siblings('.orderId').val();
	var prodId = $(this).siblings('.prodId').val();
	var price = $(this).siblings('.price').val();
	console.log(orderId);
	console.log(prodId);
	$.ajax({
		url :'/middleProject/cart/delete',
		type :'post',
		data : {'order_id' : orderId,
				'prod_id' : prodId},
		success: function(res) {
			location.reload();
		},
		error: function(xhr) {
			alert(xhr.status);
		}
	})
});

//$('.qty').on('input', function() {
$('.qty').change(function() {
	var orderId = $(this).parents('.cartSection').siblings('.removeWrap').find('.orderId').val();
	console.log(orderId);
	var qty = $(this).val();
	console.log(qty);
	var prodId = $(this).parents('.cartSection').siblings('.removeWrap').find('.prodId').val();
	console.log(prodId);   
	$.ajax({
		url : '/middleProject/cart/update',
		type : 'post',
		data : {'del_qty' : qty,
				'mem_id' : $('#mem_id').val(),
				'prod_id' : prodId,	
				'order_id' : orderId},
		success: function() {
			location.reload();
			console.log(prodId);
		},
		error: function(xhr) {
			alert(xhr.status);
		}
	})
})


IMP.init('imp31355581');

$('.checkout').on('click', function() {
	var total = $('.totalPrice').text();
	total = total.replace(',', '');
	var price = parseInt(total);
	
	IMP.request_pay({
    pg : 'inicis', // version 1.1.0부터 지원.
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : $('#orderName').val(),
    amount : price, //판매 가격
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자이름',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456'
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '결제 금액 : ' + rsp.paid_amount + '\n';
        msg += '카드 승인번호 : ' + rsp.apply_num;
        var add = $('#address1').val() + ' ' +$('#address2').val();
        $.ajax({
        	url : '/middleProject/payment/insert',
        	type : 'post',
        	data : {'order_id' : $('#orderId').val(),
        			'total_price' : $('#payPrice').val(),
        			'address' : add,
        			'zoneCode' : zoneCode,
        			'cupon' : $('#textPromo').val()},
        			success :  function() {
				location.href = 'myPage';
			},
			error : function() {
			}
        });
        
        
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }
    alert(msg);
	});
});

$('#addBtn').on('click', function(){
    new daum.Postcode({
       oncomplete : function(data) {
    	   $('#address1').attr('value', data.address);
    	   zoneCode = data.zonecode;
       }
    }).open();
 })


//})