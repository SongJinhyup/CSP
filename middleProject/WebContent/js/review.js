//리스트 출력
var prod_id = $('#prod_id').val();
var page = $('#page').val();
var params = "prod_id=" + prod_id +"&page" + page;
console.log(params);


listServer = function(page){
	$.ajax({
		url : '/middleProject/review/reviewCount',
		type : 'post',
		data : {'page':page},
		success:function(res){
			//페이지 리스트 - BS_pagination pager 활용
			pager = '<div class="container">';
			//이전버튼(Prev)
			if(res.sp>1){
				pager += '<ul class="pager">';
				pager += '<li><a class="prev" href="#">Prev</a></li></ul>';
			}
			//페이지 번호 출력
			pager += '<ul class="pagination pager">';
			for(i=res.sp; i<=res.ep;i++){
				if(currentPage == i){
					pager += '<li class="active"><a class="paging" href="#">'+ i +'</a></li>';
				}else{
					pager += '<li><a class="paging" href="#">'+ i +'</a></li>';
				}
			}
			pager += '</ul>';
			//다음버튼(Next)
			if(res.ep < res.tp){
				pager += '<ul class="pager">';
				pager += '<li><a class="next" href="#">Next</a></li></ul>';
			}
			pager += '</div>';
			$('#pagelist').html(pager);
		},
		error:function(xhr){
			alert(xhr.status);
		},
		dataType:'json'
	})
}