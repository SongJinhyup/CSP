<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
  <head>
    <meta charset="UTF-8">
    <title>detail_man</title>
    <link rel='stylesheet' href='https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/detail_m.css">
    <script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
    <!-- partial -->
      <script defer src="<%=request.getContextPath() %>/js/detail.js"></script>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
      <script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<script type="text/javascript">
function popup() { window.open('<%=request.getContextPath()%>/imgSelect', "이미지를 선택하세요", "width=460px, height=125px, left=100, top=50"); }
$(function(){
	$('.image-item').on('click', function(){
		imgsrc = jQuery('#mainimg').attr("src");
		console.log(imgsrc);
	})
	
	function prodImgSel(){
		$.ajax({
			url : '/middleProject/imgView',
			data : 
		})
	}
})
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<nav class="flex-nav">
  <div class="container">
    <div class="grid menu">
      <div class="column-xs-8 column-md-6">
        <p id="highlight"><a href="../main/main.html"><img src="../imgs/logo.PNG" alt=""></a></p>
      </div>
      <div class="column-xs-4 column-md-6">
        <a href="#" class="toggle-nav">Menu <i class="ion-navicon-round"></i></a>
        <ul>
          <li class="nav-item"><a href="/product/product_m1.html">Products</a></li>
          <li class="nav-item"><a href="#">Contact</a></li>
          <li class="nav-item"><a href="/mypage/mypage.html">My page</a></li>
          <li class="nav-item"><a href="../cart/cart.html">Cart</a></li>
        </ul>
      </div>
    </div>
  </div>
</nav>
<main>
  <div class="container">
    <div class="grid second-nav">
      <div class="column-xs-12">
        <nav>
          <ol class="breadcrumb-list">
            <li class="breadcrumb-item"><a href="#">Skin Care</a></li>
            <li class="breadcrumb-item"><a href="#">Tea Tree</a></li>
            <li class="breadcrumb-item active">tea tree Skin</li>
          </ol>
        </nav>
      </div>
    </div>
   <form id="update" style="width: 100%;">
    <div class="grid product">
      <div class="column-xs-12 column-md-7">
        <div class="product-gallery">
          <div class="product-image">
            <img onclick="popup()" id="mainimg" class="active" src="https://images.unsplash.com/photo-1612198692294-c7a12ce17770?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80">
          </div>
          <ul class="image-list">
            <li class="image-item" onclick="popup()"><img id="firstimg" src="https://images.unsplash.com/photo-1617289009388-a94de7f87ff0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2624&q=80"></li>
            <li class="image-item" onclick="popup()"><img id="secondimg" src="https://images.unsplash.com/photo-1621719455668-fba909ae1b58?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2500&q=80"></li>
            <li class="image-item" onclick="popup()"><img id="thirdimg" src="https://images.unsplash.com/photo-1620946418692-125ec66d5339?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2603&q=80"></li>
          </ul>
        </div>
      </div>
      <div class="column-xs-12 column-md-5">
        <input type="text" name="prod_name" value="Tea tree Skin"><br><br>
        <input type="text" name="prod_price" value="12000"> <i class="fas fa-won-sign"></i>
        <a href="/review/review1.html"><span class="review">review  <i class="fas fa-arrow-right"></i></span></a>
        <div class="description">
          <textarea style="font-size: 1.1em; font-family: 'Pontano Sans', sans-serif;" name="prod_detail" id="prod_detail" cols="38" rows="8">Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis sit beatae dolore! Corrupti perspiciatis eum dicta? Sunt explicabo beatae debitis fugiat cupiditate aliquam, non maxime fuga labore, esse optio soluta?</textarea>
        </div>
        <!-- <button class="add-to-cart">Save</button> -->

        <!-- button -->
        <div class="like-content">
          <button class="btn-secondary like-review">
            <i class="fa fa-heart" aria-hidden="true"></i> save
          </button>
        </div>
        <!--  -->
<!--  -->
      	</div>
   	</div>
   </form>
    <div class="grid related-products">
      <div class="column-xs-12">
        <h3>You may also like</h3>
       
      </div>
      <div class="column-xs-12 column-md-4">
        <a href="/detail/detail3_m.html"><img class="image_recomendation" src="https://images.unsplash.com/photo-1609097164673-7cfafb51b926?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=668&q=80"></a>
        <a href="/detail/detail3_m.html"><h4>Tea tree Suncare</h4></a>
        <p class="price">6'000 <i class="fas fa-won-sign"></i></p>
      </div>
      <div class="column-xs-12 column-md-4">
        <a href="/detail/detail2_m.html"><img class="image_recomendation" src="https://images.unsplash.com/photo-1608571423902-eed4a5ad8108?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=668&q=80"></a>
        <a href="/detail/detail2_m.html"><h4>Tea tree ample</h4></a>
        <p class="price">10'000 <i class="fas fa-won-sign"></i></p>
      </div>
      <div class="column-xs-12 column-md-4">
        <img class="image_recomendation" src="https://images.unsplash.com/photo-1610733867869-bd60674ca8b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80">
        <h4>Trea tree serum</h4>
        <p class="price">9'000 <i class="fas fa-won-sign"></i></p>
      </div>
    </div>
  </div>
</main>
<br>
<br>
<br>
<br>
</body>
</html>
