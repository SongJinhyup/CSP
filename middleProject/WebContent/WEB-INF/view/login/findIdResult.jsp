<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.idsearch{
 	text-align: center;
}




</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <form class="idsearch" name="idsearch" method="post">
      <%
      String mem_id = (String)request.getAttribute("mem_id");
      	if (mem_id != null) {
      		
      %>
      
      <div class = "container">
      	<div class = "found-success">
	      <h4>  회원님의 아이디는 </h4>  
	      <div class ="found-id"><%=mem_id%></div>
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
	      <h4>  등록된 정보가 없습니다 </h4>  
	     </div>
	     <div class = "found-login">
 		    <input type="button" id="btnback" value="다시 찾기" onClick ="location='<%=request.getContextPath()%>/findIDControllerServlet'"/>
 		    <input type="button" id="btnjoin" value="회원가입" onClick ="location='<%=request.getContextPath()%>/showlogin'"/>
       	</div>
       </div>
       
       <%
  }
 %> 
      </form>

</body>
</html>