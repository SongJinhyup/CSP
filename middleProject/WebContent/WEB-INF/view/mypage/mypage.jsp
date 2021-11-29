<%@page import="cosmetic.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" >
<head>
  <meta charset="UTF-8">
  <title>my page</title>
  <script src="https://use.typekit.net/lkh0ago.js"></script>
<script>try{Typekit.load({ async: true });}catch(e){}</script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage.css">
<script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<script defer src="<%=request.getContextPath()%>/js/mypage.js"></script>
<script type="text/javascript">
	var memId = '<%=session.getAttribute("mem_id")%>';
$(function() {
	$.ajax({
		url : '/middleProject/member/getInfo',
		data : {'memId' : memId},
		success: function(res) {
			$('#email').attr('value', res.mem_email);
			$('#tel').attr('value', res.mem_tel);
			birth = res.mem_birth.substr(0,11);
			$('#birth').attr('value', birth);
			$('#location').attr('value', res.mem_blocation);
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	});
	$.ajax({
		url : '/middleProject/memOrder/view',
		data : {'mem_id' : memId},
		type : 'post',
		success : function(res) {
			if(Object.keys(res).length == 0){
			code = '<div id = "nullInterest">No Your Order</div>';
			}else{
			code = '<div class="container">';
			code +=	'<h1>My Order List</h1>';  
			code += '<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false">';
		    code += '<!-- Indicators -->';
		    code += '<ol class="carousel-indicators">';
		    	code += '<li data-target="#myCarousel" data-slide-to="0" class="active"></li>';
		    	if(Object.keys(res).length > 1){
		    		for(i = 1; i < Object.keys(res).length; i++){
		    			code += '<li data-target="#myCarousel" data-slide-to="'+i+'"></li>';
		    		}
		    	}
		    	code += '</ol>'
		    	code += '<div class="carousel-inner">';
		    	code += '<div class="item active">';
		    	code += '<span class="sp">';
		    	code += '<ol>';
				code += '<li>';
				date = res[0].del_date.substr(0, 11);
		    	code += '<span class = "info">'
				code += 'Order Date';
		    	code += '</span>'
		    	code += ' : '+date;
		    	code += '<span class="openPop info">';
		    	code += '<a href="javascript:deorder('+'\''+'order?order_id='+res[0].order_id+'\''+')">';
		    	code += '<span class="box"></span>Order Info >'
		    	code += "</a>";
		    	code += '</span>';
				code += '</li>';
				code += '<li>';
		    	code += '<span class = "info">';
		    	code += res[0].order_status+'<span class = "status"></span>';
		    	code += '</span>';
		    	code += '</li>';
		    	code += '<li>';
		    	code += '<span class = "info">';
		    	code += "Total Price"
		    	code += '</span>'
		    	code += ' : '+res[0].total_price.toLocaleString()+'<span class = "price"></span>';
		    	code += '</li>';
		    	code += '</ol>';
		    	code += '</span>';
		    	code += '</div>';
		    	for(i = 1; i < Object.keys(res).length; i++){
		    		code += '<div class="item">';
		    		code += '<span class="sp">';
		    		code += '<ol>';
					code += '<li>';
					date = res[i].del_date.substr(0, 11);
			    	code += '<span class = "info">'
					code += 'Order Date';
			    	code += '</span>'
			    	code += ' : '+date;
			    	code += '<span class="openPop info">';
			    	code += '<a href="javascript:deorder('+'\''+'order?order_id='+res[i].order_id+'\''+')">';
			    	code += '<span class="box"></span>Order Info >'
			    	code += "</a>";
			    	code += '</span>';
					code += '</li>';
			    	code += '<li>';
			    	code += '<span class = "info">';
			    	code += res[i].order_status+'<span class = "status"></span>';
			    	code += '</span>';
			    	code += '</li>';
			    	code += '<li>';
			    	code += '<span class = "info">';
			    	code += "Total Price"
			    	code += '</span>'
			    	code += ' : '+res[i].total_price.toLocaleString()+'<span class = "price"></span>';
			    	code += '</li>';
			    	code += '</ol>';
		    		code += '</span>';
		    		code += '</div>';
		    	};
		    	code += '<!-- Left and right controls -->';
		    	code += '<a style ="background : white;" class="left carousel-control" href="#myCarousel" data-slide="prev">';
		    	code += '<span class="glyphicon glyphicon-chevron-left" style = "color:black;"></span>';
		    	code += '<span class="sr-only">Previous</span>';
		    	code += '</a>';
		    	code += '<a style ="background : white;" class="right carousel-control" href="#myCarousel" data-slide="next">';
		    	code += '<span class="glyphicon glyphicon-chevron-right" style = "color:black;"></span>';
		    	code += '<span class="sr-only">Next</span>';
		    	code += '</a>';
		    	code += '</div>';
		    	code += '</div>';
			}
		    	
		    	$('#privacy').html(code);
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
})
</script>
</head>
<script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<body>
<!-- add sidebar -->
<nav class="main-menu">
  <div>
     <a class="logo" href="#">
     </a> 
   </div> 
 <div class="settings"></div>
 <div class="scrollbar" id="style-1">
       
 <ul>
   
 <li>                                   
 <a href="<%=request.getContextPath()%>/ShowMainServlet">
  <i class="fa fas fa-home"></i>
 <span class="nav-text">Home</span>
 </a>
 </li>   
    
 <%
 if(session.getAttribute("mem_id") != null){
%>
 <li>                                 
 <a href="<%=request.getContextPath()%>/logout">
 <i class="fa fa-user fa-lg"></i>
 <span class="nav-text">Logout</span>
 </a>
 </li> 
<%
 }else{
 %>
 <li>                                 
 <a href="../login/login.html">
 <i class="fa fa-user fa-lg"></i>
 <span class="nav-text">Login</span>
 </a>
 </li>   
 <%
 }
 %>
 
     
 <li>                                 
 <a href="<%=request.getContextPath()%>/view/cart">
  <i class="fa fa-shopping-cart"></i>
  <span class="nav-text">Cart</span>
 </a>
 </li>   
   
 
 
  
 <li>
  <a href="#">
    <i class="fa fas fa-cog"></i>
    <span class="nav-text">Settings</span>
    </a>
    <br>
 </li>
                             
 
   
   
 </li>
 <li class="darkerlishadow">
   <br>
 <a href="#">
 <i class="fa fas fa-search"></i>
 <span class="nav-text">search</span>
 </a>
 </li>
   
 
   
 <li class="darkerli">
 <a href="<%=request.getContextPath()%>/view/product">
  <i class="fa fas fa-leaf"></i>
 <span class="nav-text">Store</span>
 </a>
 </li>
 
 <li class="darkerli">
 <a href="#">
  <i class="fa fas fa-rss"></i>
 <span class="nav-text">News</span>
 </a>
 </li>
   
 <li class="darkerli">
 <a href="../notice/notice.html">
  <i class="fa fas fa-exclamation-circle"></i>
 <span class="nav-text">notice</span>
 </a>
 </li>
   
 <li class="darkerli">
 <a href="../QnA/QnA.html">
  <i class="fa fas fa-question-circle"></i>
  <span class="nav-text">QnA</span>
 </a>
 </li>
   
 <li class="darkerlishadowdown">
 <a href="../review/review.html">
  <i class="fa fas fa-volume-up"></i>
 <span class="nav-text">review</span>
 </a>
 <br>
 </li>
   
 </ul>

   
 <li>
                               
 <a href="#">
  <i class="fa fas fa-store-alt"></i>
 <span class="nav-text">store</span>
 </a>
 </li>   
     
   
 <ul class="logout">
 <li>
<a href="#">
<i class="fa far fa-envelope"></i>
<span class="nav-text">mail</span>
</a>
 </li>  

 <li>
  <a href="#">
    <i class="fa fas fa-phone"></i>
  <span class="nav-text">call</span>
  </a>
   </li> 

 </ul>
         </nav>

<%
List<ProductVO> list = (List<ProductVO>)request.getAttribute("interest");
%>
<!-- partial:index.partial.html -->
<div id='settings' ontouchstart>
  <input checked class='nav' name='nav' type='radio' id="profilenav">
  <span class='nav'>Profile</span>
  <input class='nav' name='nav' type='radio' id="accountnav">
  <span class='nav'>Account</span>
  <input class='nav' name='nav' type='radio' id="ordernav">
  <span class='nav'>Order</span>
  <input class='nav' name='nav' type='radio' id="wishnav">
  <span class='nav'>Wish</span>
  <main class='content'>
    <section id='profile'>
      <form>
        <ul>
          <li class='large padding avatar'>
            <span style=" background-image: url('./imgs/avartar.png');"></span>
            <div>
              <fieldset class='material-checkbox'>
                <div>
                  <input checked type='checkbox'>
                  <div class='check'>
                    <span>
                      <svg viewBox='0 0 24 24'>
                        <g>
                          <line x1='4.5' x2='9.24' y1='12.5' y2='17.24'></line>
                          <line x1='9.24' x2='19.76' y1='17.24' y2='6.73'></line>
                        </g>
                        <g>
                          <line x1='4.5' x2='9.24' y1='12.5' y2='17.24'></line>
                          <line x1='9.24' x2='19.76' y1='17.24' y2='6.73'></line>
                        </g>
                      </svg>
                    </span>
                    <label>Use Gravatar</label>
                  </div>
                </div>
              </fieldset>
              <fieldset class='material-button'>
                <div>
                  <button>Select File</button>
                </div>
              </fieldset>
            </div>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='text' id="email">
                <label>Email</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='text' id="tel">
                <label>Tel</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='text' id="birth">
                <label>Birth</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='text' id="location">
                <label>Basic Location</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li class='large padding'>
            <fieldset class='material-button center'>
              <div>
                <input class='save' type='submit' value='Save' id="infosave">
              </div>
             
            </fieldset>
          </li>
        </ul>
      </form>
    </section>
    <section id='account'>
      <form>
        <ul>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='text' id="id">
                <label>ID</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='text' id="name">
                <label>Username</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='password' id="pass">
                <label>Password</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li>
            <fieldset class='material'>
              <div>
                <input required type='password' id="repass">
                <label>Confirm Password</label>
                <hr>
              </div>
            </fieldset>
          </li>
          <li class='padding'>
            <fieldset class='material-button'>
              <div>
                <button class='connect gh connected'>
                  <span>Unlink Github Account</span>
                </button>
              </div>
            </fieldset>
          </li>
          <li class='padding'>
            <fieldset class='material-button'>
              <div>
                <button class='connect tw'>
                  <span>Link Twitter Account</span>
                </button>
              </div>
            </fieldset>
          </li>
          <li class='padding'>
            <fieldset class='material-button'>
              <div>
                <button class='connect fb'>
                  <span>Link Facebook Account</span>
                </button>
              </div>
            </fieldset>
          </li>
          <li class='padding'>
            <fieldset class='material-button'>
              <div>
                <button class='connect li'>
                  <span>Link LinkedIn Account</span>
                </button>
              </div>
            </fieldset>
          </li>
          <li class='large padding'>
            <fieldset class='material-button center'>
              <div>
                <input class='save' type='submit' value='Save' id="passsave">
              </div>
              
              <p class="withdraw">Don`t use membership?</p>
            
            </fieldset>
          </li>
        </ul>
      </form>
    </section>

    <section class='upcoming' id='privacy'>
    </section>

    <section class='upcoming' id='advanced'>
     <div class="container">	
      <h1>My Wish List</h1>
      <%
      	if(list.size() == 0){
      %>
		<div id = "nullInterest">
		  <div>
		    No Interested Items
		  </div>
		</div> 
      <%
      	}else{
      %>
 	     <div class="row">
          <div class="col-md-12">
            <div class="carousel slide multi-item-carousel" id="theCarousel">
              <div class="carousel-inner">
     		 <%
      		if(list.size() == 1){
      		%>
      			<div class="item active">
                  <div class="col-xs-4">
                    <a href="#1">
                      <img src="<%=list.get(0).getProd_img()%>" class="img-responsive" style="width:330px; height:150px;">
                	  <div class="wish_description">
                	  	<input type="hidden" value="<%=list.get(0).getProd_id()%>" class="wishProd">
                        <button class="wish_cart"><i class="fas fa-cart-plus"></i></button>
                        <button class="wish_delete"><i class="fas fa-trash-alt"></i></button>
                  	  </div>
                    </a>
                  </div>
                </div>
      		<%
      		}else{
      			for(int i = 0; i < list.size(); i++){
      			  if(i == 0){
      				 %>
      			<div class="item active">
      				 <%
      			  }else{
      				  %>
      			<div class="item">
      				  <%
      			  }
      		    %>
                  <div class="col-xs-4">
                    <a href="#1">
                      <img src="<%=list.get(i).getProd_img()%>" class="img-responsive" style="width:300px; height:150px;">
                	  <div class="wish_description">
                	  	<input type="hidden" value="<%=list.get(i).getProd_id()%>" class="wishProd">
                        <button class="wish_cart"><i class="fas fa-cart-plus"></i></button>
                        <button class="wish_delete"><i class="fas fa-trash-alt"></i></button>
                  	  </div>
                    </a>
                  </div>
                </div>
      			<%
      			}
      			%>
      			</div>
	              <a style ="background : none;" class="left carousel-control" href="#theCarousel" data-slide="prev"><i class="glyphicon glyphicon-chevron-left" style="color : black;"></i></a>
	              <a style ="background : none;" class="right carousel-control" href="#theCarousel" data-slide="next"><i class="glyphicon glyphicon-chevron-right" style="color : black;"></i></a>
	            </div>
	          </div>
	        </div>
      			<%
      		}
      %>
      
      <%
      	}
      
      %>
          </div>
    </section>
  </main>
</div>

</body>
</html>
