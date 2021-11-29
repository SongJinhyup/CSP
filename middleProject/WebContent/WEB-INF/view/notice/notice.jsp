<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cosmetic.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>NOTICE & FAQ</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/notice.css">
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script defer src="<%=request.getContextPath()%>/js/notice.js"></script>
<script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<script>
$(function(){
	//게시글 삭제
	$(".delete_btn").on('click', function(){
		var boardId = $(this).attr('name');
		console.log(boardId);
		$.ajax({
			url : '/middleProject/noticeDelete',
			data : { 'boardId' : boardId },
			success : function(res){
				alert("삭제됨")
			},
			dataType : 'json'		
		})
	})
// 	location.reload();
	
	
	
})
</script>
<script type="text/javascript">
 function popup(url) { window.open(url, "게시글 등록", "width=460px, height=425px, left=100, top=50"); }
</script>
<script>
$(function(){
	$('.send').on('click', function(){
		if ($('select').val == '6'){
			alert("게시판을 선택해주세요");
			return false;
		}
		$('.boardForm').submit();
	})
	
	$(".modify_btn").on('click', function(){
		var val = $('.board_id', $(this).parent()).val(); // this(즉 수정버튼의 부모에서 보드아이디를 찾고 그것의 값을 가져와라) 
		$.ajax({
			url : '/middleProject/noticeView',
			data : { 'board_id' : val},  
			success : function(data){
			popup("<%=request.getContextPath()%>/board/boardUpdateForm?board_title="+data.board_title+"&board_id="+data.board_id+"&board_content="+data.board_content);
			},
			dataType : 'json'
		});
	})
})
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<body>
<header>
	<h1>NOTICE & FAQ</h1>
</header>
<%
String memId = (String) session.getAttribute("mem_id");
List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
Map<Integer,String> boardMap = new HashMap<>();
boardMap.put(7, "NOTICE");
boardMap.put(8, "POLICY");
boardMap.put(9, "LOGIN");
boardMap.put(10, "MYPAGE");
boardMap.put(11, "PAYMENT");
boardMap.put(12, "DELIVERY"); 
String n = "n";
int	boardTypeNum = 0;
%>	

<section class="faq">
	<ul class="categories">
		<li><a class="selected" href="#basics">NOTICE</a></li>
		<li><a href="#mobile">POLICY</a></li>
		<li><a href="#account">LOG IN</a></li>
		<li><a href="#payments">MY PAGE</a></li>
		<li><a href="#privacy">PAYMENT</a></li>
		<li><a href="#delivery">DELIVERY</a></li>
	</ul> <!-- categories -->
	

	<div class="faq-items">
	<%if (memId.equals("admin")) {%>
		<br><div class="box" style="width: 100%; height: 10%;"><!--search-->
				<div class="user_btn" style="width: 99%;">
<!-- 게시판입력창 띄우기 --><button class="plus_btn" onclick="popup('<%=request.getContextPath()%>/board/boardInsertForm?memId=<%=memId%>&n=<%=n%>')"><i class="fas fa-plus"></i></button>
				</div>
			</div>
<%}

	for (int i = 7; i < 13 ; i++){
%>
	<ul id="<%=boardMap.get(i)%>" class="faq-group">
			<li class="faq-title"><h2><%=boardMap.get(i)%></h2></li>
<%
		for (BoardVO vo : boardList) {
			if (Integer.parseInt(vo.getBoard_index()) == i){
				//관리자 
				if (vo.getMem_id().equals("admin")) {
%>
			<li>
				<a class="trigger" href="#0"><%=vo.getBoard_title() %></a>
				<div class="faq-content">
								<P><%=vo.getBoard_content() %></P>
<%if (memId.equals("admin")) {%>
					<form class="boardForm">
					<br><div class="manager_btn">
						<input type="hidden" class="board_id" name="board_id" value="<%=vo.getBoard_id() %>"><!-- 게시글을 수정하기 위한 보드아이디값 받기 -->
						<i class="fas fa-eraser"></i><input type="button" class="modify_btn" value="modify">
						<i class="far fa-trash-alt"></i><input type="button" class="delete_btn" name="<%=vo.getBoard_id()%>" value="delete"> 
						</div>
					</form>
				</div> <!-- faq-content -->
			</li>
<%}%>		
<%				
				//관리자 아님
				} else if (!vo.getMem_id().equals(memId)) {
%>
			<li>
				<a class="trigger" href="#0"><%=vo.getBoard_title() %></a>
				<div class="faq-content">
						<div>
								<span><%=vo.getBoard_content() %></span>
						</div>
				</div> <!-- faq-content -->
			</li>
<%				
				} 
			}
		}
%>
			</ul> <!-- faq-group -->
<%
	}
%>		
	</div> <!-- faq-items -->
	<a href="#0" class="cd-close-panel">CLOSE</a>
</section> <!-- faq -->




</body>
</html>
