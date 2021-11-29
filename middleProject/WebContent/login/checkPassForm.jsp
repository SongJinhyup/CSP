<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"></style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/login2.js"></script>
<script type="text/javascript">
	
	function pass_search() {
		var frm = document.idfindscreen;
		var mem_id = document.getElementById("mem_id").value;  
		var mem_name = document.getElementById("mem_name").value;
		var mem_tel = document.getElementById("mem_tel").value;
		
		if(mem_id.length <1){
		  alert("아이디를 입력해주세요");
		  return;
			
		}
		
		
	 	if (mem_name.length < 1) {
		  alert("이름을 입력해주세요");
		  return;
		 }

		 if (mem_tel.length != 13) {
			  alert("핸드폰번호를 정확하게 입력해주세요");
			  return;
	 
		 }


	 frm.method = "post";
	 frm.submit();  
	 
	 
	 }


</script>

<title>Insert title here</title>

</head>
<body>
<form name="idfindscreen" method = "POST" action="<%=request.getContextPath()%>/SearchPwServlet">
			<div class = "search-title">
				<h3>비밀번호 찾기</h3>
			</div>
		<section class = "form-search">
			<div class = "find-id">
				<label>아이디</label>
				<input type="text" id="mem_id" name="mem_id" class = "btn-phone" placeholder = "아이디">
			</div>
			<br>
			<div class = "find-name">
				<label>이름</label>
				<input type="text" id="mem_name" name="mem_name" class = "btn-name" placeholder = "등록한 이름">
			</div>
			<br>
			<div class = "find-phone">
				<label>번호</label>
				<input type="text" id="mem_tel" name="mem_tel" class = "btn-phone" placeholder = "휴대폰번호 '-'포함해서 입력">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="button" name="enter" value="찾기"  onClick="pass_search()">
		<input type="button" name="cancle" value="취소" onClick="history.back">
 	</div>
 </form>
  </body>
  </html>