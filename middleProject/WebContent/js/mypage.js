

// Instantiate the Bootstrap carousel
$('.multi-item-carousel').carousel({
    interval: false
  });

$('#myCarousel').carousel({
	interval : false
});

  
  // for every slide in carousel, copy the next slide's item in the slide.
  // Do the same for the next, next item.
  $('.multi-item-carousel .item').each(function(){
    var next = $(this).next();
    if (!next.length) {
      next = $(this).siblings(':first');
    }
    next.children(':first-child').clone().appendTo($(this));
    
    if (next.next().length>0) {
      next.next().children(':first-child').clone().appendTo($(this));
    } else {
        $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
    }
  });
  
  

$('#infosave').on('click', function() {
	email = $('#email').attr('value');
	
	$.ajax({
		url : '/middleProject/member/infoUpdate',
		type : 'post',
		data : {
			'memId' : memId,
			'email' : $('#email').val(),
			'tel' : $('#tel').val(),
			'birth' : $('#birth').val(),
			'location' : $('#location').val()
		},
		success : function(res) {
			if(res == 1) alert('회원정보 수정 완료');
			else alert('수정실패');
		},
		error: function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
});

$('#accountnav').on('click', function() {
	$.ajax({
		url : '/middleProject/member/getInfo',
		data : {'memId' : memId},
		success: function(res) {
			$('#id').attr('value',res.mem_id);
			$('#name').attr('value', res.mem_name);
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});

$('#passsave').on('click', function() {
	pass = $('#pass').val();
	repass = $('#repass').val();
	if(pass != repass){
		str = '비밀번호를 확인해주세요'
		alert(str);
		return false;
	}
	$.ajax({
		url : '/middleProject/member/passUpdate',
		data : {'memId' : memId,
				'memPass' : pass},
		type : 'post',
		
		success : function(res) {
			if(res == '1') alert('정보 수정 완료');
			else alert('입력 정보를 다시 확인해주세요')
		},
		error: function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
});


deorder = function(url) {
	window.open(url, "상세주문내역", "width=700px,height=800px,scrollbars=yes");
}

$('.wish_cart').on('click', function() {
	var prodId = $(this).siblings('.wishProd').val();
	console.log(prodId);
	$.ajax({
		url	: '/middleProject/interest/insertCart',
		type : 'post',
		data : {'prod_id' : $(this).siblings('.wishProd').val()},
		success: function() {
			alert('추가 성공');
		},
		error: function(xhr) {
			alert(xhr.status);
		}
	})
	
})

$('.wish_delete').on('click', function() {
	var prodId = $(this).siblings('.wishProd').val();
	console.log(prodId);
	$.ajax({
		url : '/middleProject/interest/delete',
		type : 'post',
		data : {'prod_id' : $(this).siblings('.wishProd').val()},
		success: function() {
			alert('삭제 성공');
			location.reload();
		},
		error: function(xhr) {
			alert(xhr.status);
		}
	})
	
})
