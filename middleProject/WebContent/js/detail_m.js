const activeImage = document.querySelector(".product-image .active");
//const productImages = document.querySelectorAll(".image-list img");
const navItem = document.querySelector('a.toggle-nav');

function changeImage(e) {
  activeImage.src = e.target.src;
}

function toggleNavigation(){
  this.nextElementSibling.classList.toggle('active');
}

productImages.forEach(image => image.addEventListener("click", changeImage));
navItem.addEventListener('click', toggleNavigation);

$(function(){
	$(document).on('click', '.like-review', function(e) {
		console.log($('#prodId').val());
		if($(this).find('.fa-heart').hasClass('animate-like')){
			$.ajax({
				url : '/middleProject/interest/delete',
				type : 'post',
				data : {"prodId" : $('#prodId').val()},
				success : function() {
				},
				error : function(xhr) {
					alert(xhr.status);
				}
			});
			$(this).html('<i class="fa fa-heart" aria-hidden="true"></i> Like');
			$(this).children('.fa-heart').removeClass('animate-like');
			return false;
		}else{
			$.ajax({
				url : '/middleProject/interest/insert',
				type : 'post',
				data : {"prodId" : $('#prodId').val()},
				success : function(res) {
				},
				error : function(xhr) {
					alert(xhr.status);
				}
			});

			$(this).html('<i class="fa fa-heart" aria-hidden="true"></i> You liked this');
			$(this).children('.fa-heart').addClass('animate-like');
			return false;
		}
	});
	
	$('.add-to-cart').on('click', function() {
		var price = parseInt($('#price').text().replace("'",'').trim());
		console.log($('#prodId').val);
		console.log($('#orderId').val);
		$.ajax({
			url : '/middleProject/cart/insertDetail',
			type : 'post',
			data : {'prod_id' : $('#prodId').val(),
					'order_id' : $('#orderId').val(),
					'del_price' : price},
			success : function() {
				alert('장바구니에 담겼습니다');
			},
			error : function() {
				alert('실패');
			}
		});
	})
});