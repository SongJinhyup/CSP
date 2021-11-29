<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Log-in</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
<script defer src="<%=request.getContextPath()%>/js/login.js"></script>
<script src="https://kit.fontawesome.com/20c5a1496b.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bona+Nova&family=Playfair+Display:wght@400;500&display=swap"
	rel="stylesheet">

<script src="<%=request.getContextPath()%>/js/login2.js"></script>
<script>

$(function(){

	$('#mem_id').on('keyup',function(){
		
		idValue = $('#mem_id').val().trim();
		
		//입력확인
		if(idValue.length<1) {
			nopro(this,"아이디를 입력하세요");
			$('#res').text('');
			
			return false;
		}
		
		// 정규식 설정 : 아이디는 영문 대소문자와 숫자 조합으로 4~8자리 사이로
		regid = /^[a-zA-Z][a-zA-Z0-9]{3,7}$/;
		
		if(regid.test(idValue)){
			okpro(this,"success");
			$('#res').text('');
		}else{
			nopro(this, "영문+숫자만 입력가능합니다(4~8자리)"); 
			$('#res').text('');	
			return false;		
			}
		
		$.ajax({
			url : '/middleProject/IdCheck',
			data : {'mem_id' : $('#mem_id').val()},
			type : 'post',
			success : function(res){
				if(res != null && res != ''){
				if(res == "ok"){
						$('#res').text("success").css('color','green');
					}else{
						$('#res').text("이미 존재하는 아이디입니다").css('color','red');
						return false;
					}
				}else{
					alert("아이디를 입력하세요");
					return false;
				}
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json'
		
		})

	})
	
	
	//실시간체크 -이름
			$('#mem_name').on('keyup',function(){
				
				
				nameValue= $('#mem_name').val().trim();

				// 입력확인
				if(nameValue.length<1) {
					nopro(this,"이름을 입력하세요");
					return false;
				}
				
				// 글자수 체크 
				if (nameValue.length<2 || nameValue.length>5) {
					nopro(this,"2~5자 사이로 입력하세요");
					return false;
				}
				
				// 정규식 - 한글만 , 2자에서 5자 사이
				regName = /^[가-힣]{2,5}$/; 
				
				if(regName.test(nameValue)){
					okpro(this,"success");
				}else{
					nopro(this, "한글만 입력가능합니다(2~5자리)");
					return false;
				}
				
			})
	

	// 실시간 체크 - 비밀번호
		$('#mem_pass').on('keyup',function(){
				
				
		passValue= $('#mem_pass').val().trim();
		
				
		// 입력확인
		if(passValue.length<1) {
		nopro(this,"비밀번호를 입력하세요");
		return false;			
		}
	
		// 비밀번호 정규식
		regPass = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$/;

		
		if(regPass.test(passValue)){
			okpro(this,"success");
		}else{
			nopro(this, "숫자,문자 1자리씩 포함 4자리 이상 입력하세요");
			return false;
		}
	
		
	})
	
	$('#signUpBtn').on('click', function(){
		if($("span#sp").html()!="success"){
			alert("이름을 다시 입력하세요.");
			return false;
		}
		if($("span#res").html()!="success"){
			alert("아이디를 다시 입력하세요.");
			return false;
		}
		if($("span.sp").html()!= "success"){
			alert("비밀번호를 다시 입력하세요.");
			return false;
		}
		
		$('form[name="singup"]').submit();
	})

	
})
</script>

</head>
<body>
	<!-- partial:index.partial.html -->
	<h1>
		Make Own forest for U <i class="fas fa-leaf"></i>
	</h1>
	<br>
	<br>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="<%=request.getContextPath()%>/SignServlet" name="singup" method="post" >
				<h1>JOIN</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your email for registration</span> 
				<input type="text" name="mem_name" id="mem_name" placeholder="Name" /> 
				<span id="sp"></span>

				<input type="text" name="mem_id" id="mem_id" placeholder="ID" /> 
				<span id="res"></span>

				<input type="password" name="mem_pass" id="mem_pass" placeholder="Password" /> 
				<span class="sp"></span><br> 
				<button type="button" id="signUpBtn">Sign up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
				<h1>LOG IN</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your order number</span> 
				<input type="text" name="mem_id" placeholder="ID" /> 
				<input type="password" name="mem_pass"  placeholder="Password"/>
				
 				<a href="javascript:openModal('<%=request.getContextPath()%>/findIDControllerServlet')">Forgot your ID?</a> 
 				<a href="javascript:openModal('<%=request.getContextPath()%>/findPassControllerSevlet')">Forgot your password?</a>
				<button>Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>WELCOME</h1>
					<p>CLICK ME</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<div class="block">
						<h1>JOIN US</h1>
						<p>CLICK ME</p>
						<button class="ghost" id="signUp">JOIN</button>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
