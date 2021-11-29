<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">


input[type=button], select {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;]
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}


.passsearch{
 	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <form id="passsearch" name="passsearch" method="post">
      <%
      String mem_pass = (String)request.getAttribute("mem_pass");
      	if (mem_pass != null) {
      		
      %>
      
      <div class = "container">
      	<div class = "found-success">
	      <h4>  회원님의 비밀번호는 </h4>  
	      <div class ="found-id"><%=mem_pass%></div>
	      <h4>  입니다 </h4>
	     </div>
	     <div class = "found-login">
 		    <input type="button" id="btnLogin" value="로그인"  onClick ="location='<%=request.getContextPath()%>/showlogin'"/>
       	</div>
       </div>
      <%
  } else {
	  
	  
 %>
        <div class = "container">
      	<div class = "found-fail">
	      <h4> 비밀번호를 찾지 못했습니다</h4>  
	     </div>
	     <div class = "found-login">
 		    <input type="button" id="btnback" value="다시 찾기" onClick ="location='<%=request.getContextPath()%>/findPassControllerSevlet'"/>
 		    <input type="button" id="btnjoin" value="회원가입" onClick ="location='<%=request.getContextPath()%>/showlogin'"/>
       	</div>
       </div>
       
       <%
  }
 %> 
      </form>

</body>
</html>