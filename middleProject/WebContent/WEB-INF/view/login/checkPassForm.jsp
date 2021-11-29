<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit], select {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;]
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

input[type=reset] {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;]
  cursor: pointer;
}

input[type=reset]:hover {
  background-color: #45a049;
}

.btnSearch{
 	text-align: center;
}

 #passfindscreen { 
   border-radius: 5px; 
   background-color: #f2f2f2; 
  padding: 20px; 
 } 

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/login2.js"></script>
<script type="text/javascript">
	
	function pass_search() {
		var frm = document.idfindscreen;
		var mem_name = document.getElementById("mem_name").value;
		var mem_id = document.getElementById("mem_id").value;  
		var mem_tel = document.getElementById("mem_tel").value;
		
		
	 	if (mem_name.length < 1) {
		  alert("이름을 입력해주세요");
		  return false;
		 }
		if(mem_id.length <1){
		  alert("아이디를 입력해주세요");
		  return false;
			
		}
		

		 if (mem_tel.length != 13) {
			  alert("핸드폰번호를 정확하게 입력해주세요");
			  return false;
	 
		 }


	 frm.method = "post";
	 frm.submit();  
	 
	 
	 }


</script>

<title>Insert title here</title>

</head>
<body>
<form id="passfindscreen" name="passfindscreen" method = "POST" action="<%=request.getContextPath()%>/SearchPwServlet">
			<div class = "search-title">
				<h3>비밀번호 찾기</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>이름</label>
				<input type="text" id="mem_name" name="mem_name" class = "btn-name" placeholder = "등록한 이름">
			</div>
			<br>
			<div class = "find-id">
				<label>아이디</label>
				<input type="text" id="mem_id" name="mem_id" class = "btn-phone" placeholder = "아이디">
			</div>
			<br>
			<div class = "find-phone">
				<label>휴대폰번호</label>
				<input type="text" id="mem_tel" name="mem_tel" class = "btn-phone" placeholder = "휴대폰번호 '-'포함해서 입력">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="submit" name="enter" value="찾기"  onClick="pass_search()">
		<input type="reset" name="cancle" value="취소" >
 	</div>
 </form>
  </body>
  </html>