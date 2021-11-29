<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cosmetic.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>QnA_user</title>
  		<meta charset="UTF-8">
		<title>QnA_user</title>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400;600&display=swap" rel="stylesheet">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/qna_u.css">
	  <!-- partial -->
	  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	  <script defer src="<%=request.getContextPath() %>/js/comment.js"></script>
	  <script defer src="<%=request.getContextPath() %>/js/qna.js"></script>
	  <script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<script>
$(function(){
	//게시글 삭제
	$(".delete_btn").on('click', function(){
		var boardId = $(this).attr('name');
		console.log(boardId);
		$.ajax({
			url : '/middleProject/board/boardDelete',
			data : { 'boardId' : boardId },
			success : function(res){
				alert("삭제됨")
			},
			dataType : 'json'			
		})
// 		location.reload();

	})

	//게시글 수정
	$(".modify_btn").on('click', function(){
		var val = $('.board_id', $(this).parent()).val(); // this(즉 수정버튼의 부모에서 보드아이디를 찾고 그것의 값을 가져와라) 
		$.ajax({
			url : '/middleProject/board/boardView',
			data : { 'board_id' : val},  
			success : function(data){
				popup("<%=request.getContextPath()%>/board/boardUpdateForm?board_title="+data.board_title+"&board_id="+data.board_id+"&board_index="+data.board_index+"&board_content="+data.board_content+"&board_sectrete="+data.board_secrete+"&prod_id="+data.prod_id)
			},
			dataType : 'json'
		})
	});
	
	//게시글 검색
	$(".search_btn").on('click', function(){
		$('.boardForm').attr('action', '<%=request.getContextPath()%>/board/searchBoard?serachData');
		$('.boardForm').submit();
	})
})

</script>
<script type="text/javascript">
 function popup(url) { window.open(url, "게시글 등록", "width=460px, height=425px, left=100, top=50"); }
</script>
</head>
<!-- partial:index.partial.html -->
<body>
<header>
	<h1>QnA</h1>
</header>
<%
String memId = (String) session.getAttribute("mem_id");
List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
Map<Integer,String> boardMap = new HashMap<>();
boardMap.put(0, "basics");
boardMap.put(1, "mobile");
boardMap.put(2, "account");
boardMap.put(3, "payments");
boardMap.put(4, "privacy");
boardMap.put(5, "delivery"); 
boardMap.put(6, "SHIPPING"); 
boardMap.put(7, "EXCHANGE"); 
boardMap.put(8, "REFUND"); 
boardMap.put(9, "PAYMENT"); 
boardMap.put(10, "FREEBOARD"); 
int checkNum = 0;
int	boardTypeNum = 0;
%>		
<section class="faq">
	<ul class="categories">
		<li><a class="selected" href="#basics">SHIPPING</a></li>
		<li><a href="#mobile">EXCHANGE</a></li>
		<li><a href="#account">REFUND</a></li>
		<li><a href="#payments">PAYMENT</a></li>
		<li><a href="#privacy">PRODUCT</a></li>
		<li><a href="#delivery">FREEBOARD</a></li>
	</ul> <!-- categories -->

	<div class="faq-items">
		
		
		<br><div class="box" style="width: 100%; height: 20%;"><!--search-->
			<div class="user_btn" >
<!-- 게시판입력창 띄우기 --><button class="plus_btn" onclick="popup('<%=request.getContextPath()%>/board/boardInsertForm?memId=<%=memId%>')"><i class="fas fa-plus"></i></button>
					<form action="<%=request.getContextPath() %>/board/boardSearch" method="get">
					<div class="container-2" >      <!--  style="width: 19%;" -->
						<input type="search" id="search" name="searchData" placeholder="Search...">
						<input type="hidden" name="searchmenid" value="<%=memId%>">
						<button type="submit" onclick="Searching()" class="search_btn"> <i class='fa fa-search'></i></button>
					</div>
				</form>
			</div>
		</div>

<%

	for (int i = 0; i < 6 ; i++){
%>
	<ul id="<%=boardMap.get(i)%>" class="faq-group">
			<li class="faq-title"><h2><%=boardMap.get(i+6)%></h2></li>
<%
		checkNum = 0;
		for (BoardVO vo : boardList) {
			if (Integer.parseInt(vo.getBoard_index()) == i){
				//비밀글 + 관리자 or 글쓴이
				if (vo.getBoard_secrete().equals("1") && (vo.getMem_id().equals(memId) || vo.getMem_id().equals("admin"))) {
					String boarId = vo.getBoard_id();
%>
			<li>
				<a class="trigger" href="#0"><%=vo.getBoard_title() %></a>
				<div class="faq-content">
								<P>writer : <%=vo.getMem_id()%>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P> 
								<P>date : <%=vo.getBoard_date() %>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P> 
								<P>product : <%=vo.getProd_id() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P><br><br>
								<P style="color: black;">content : </P><br>
								<P><%=vo.getBoard_content() %></P>
					<form class="boardForm">
					<br><div class="manager_btn">
						<input type="hidden" class="board_id" name="board_id" value=<%=vo.getBoard_id() %>>
						<i class="fas fa-eraser"></i><input type="button" class="modify_btn" value="modify" >
						<i class="far fa-trash-alt"></i><input type="button" class="delete_btn" value="delete" name="<%=vo.getBoard_id() %>"> 
						</div>
					</form>	
						<!-- reply -->
								<br>
					<div class="comments-container">
						<h1>Comments</h1>
			
						<div class="container">
			
						<ul id="comments-list" class="comments-list">
			
							<li>
								<div class="comment-main-level">
									<!-- Avatar -->
									<div class="comment-avatar"><img
										src="https://images.unsplash.com/photo-1492106087820-71f1a00d2b11?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"
										alt=""></div>
									<!-- Contenedor del Comentario -->
									<div class="comment-box">
										<div class="comment-head">
											<h6 class="comment-name by-author">
												<a href="http://creaticode.com/blog">Agustin Ortiz</a>
											</h6>
											<span>hace 20 minutos</span>
											<i class="fa fa-reply"></i>
											<i class="fa fa-heart"></i>
										</div>
										<div class="comment-content">
											Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit omnis animi et
											iure laudantium vitae, praesentium optio, sapiente distinctio illo?
										</div>
									</div>
								</div>
							
								<!-- Respuestas de los comentarios -->
								<ul class="comments-list reply-list">
			
									<li>
			
										<!-- Avatar -->
										<div class="comment-avatar"><img
											src="https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1400&q=80"
											alt=""></div>
										<!-- Contenedor del Comentario -->
										<div class="comment-box">
											<div class="comment-head">
												<h6 class="comment-name">
													<a href="http://creaticode.com/blog">Lorena Rojero</a>
												</h6>
												<span>hace 10 minutos</span>
												<i class="fa fa-reply"></i>
												<i class="fa fa-heart"></i>
											</div>
											<div class="comment-content">
												Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit omnis animi et
												iure laudantium vitae, praesentium optio, sapiente distinctio illo?
											</div>
										</div>
									</li>
			
								</ul>
							</div>
							<footer class="footer">
								<input type="text" class="footer__input">
								<button class="footer__btn" value="test">
									<i class="far fa-keyboard"></i>
								</button>
							</footer>
						</div>
				</div> <!-- faq-content -->
			</li>
			
			
<%				
				checkNum = 1;
				//비밀글 + 글쓴이 아님
				} else if (vo.getBoard_secrete().equals("1") && !vo.getMem_id().equals(memId)) {
%>
			<li>
				<a class="trigger" href="#0">secret title</a>
				<div class="faq-content">
						<table class="boarding">	
						<tr><td colspan="4">secret content</td></tr></table>
				</div> <!-- faq-content -->
			</li>
<%				
				checkNum = 1;
				//공개글 + 관리자 or 글쓴이
				} else if (vo.getBoard_secrete().equals("0") && (vo.getMem_id().equals(memId) || vo.getMem_id().equals("admin"))) {
					String boarId = vo.getBoard_id();
%>
			<li>
				<a class="trigger" href="#0"><%=vo.getBoard_title() %></a>
				<div class="faq-content">
						<div>
								<span>writer : <%=vo.getMem_id()%>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>date : <%=vo.getBoard_date() %>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>product : <%=vo.getProd_id() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br><br>
								<P style="color: black;">content : </P><br>
								<P><%=vo.getBoard_content() %></P>
						</div>
					<br><div class="manager_btn">
							<form class="boardForm">
								<input type="hidden" name="board_id" class="board_id" value=<%=vo.getBoard_id() %>>
						<i class="fas fa-eraser"></i><input type="button" class="modify_btn" value="modify">
						<i class="far fa-trash-alt"></i><input type="button" class="delete_btn" value="delete" name="<%=vo.getBoard_id() %>" >
						</form>
						<!-- reply -->
								<br>
					<div class="comments-container">
						<h1>Comments
						</h1>
			
			<div class="container">
			
						<ul id="comments-list" class="comments-list">
			
							<li>
								<div class="comment-main-level">
									<!-- Avatar -->
									<div class="comment-avatar"><img
										src="https://images.unsplash.com/photo-1492106087820-71f1a00d2b11?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"
										alt=""></div>
									<!-- Contenedor del Comentario -->
									<div class="comment-box">
										<div class="comment-head">
											<h6 class="comment-name by-author">
												<a href="http://creaticode.com/blog">Agustin Ortiz</a>
											</h6>
											<span>hace 20 minutos</span>
											<i class="fa fa-reply"></i>
											<i class="fa fa-heart"></i>
										</div>
										<div class="comment-content">
											Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit omnis animi et
											iure laudantium vitae, praesentium optio, sapiente distinctio illo?
										</div>
									</div>
								</div>
							
								<!-- Respuestas de los comentarios -->
								<ul class="comments-list reply-list">
			
									<li>
			
										<!-- Avatar -->
										<div class="comment-avatar"><img
											src="https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1400&q=80"
											alt=""></div>
										<!-- Contenedor del Comentario -->
										<div class="comment-box">
											<div class="comment-head">
												<h6 class="comment-name">
													<a href="http://creaticode.com/blog">Lorena Rojero</a>
												</h6>
												<span>hace 10 minutos</span>
												<i class="fa fa-reply"></i>
												<i class="fa fa-heart"></i>
											</div>
											<div class="comment-content">
												Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit omnis animi et
												iure laudantium vitae, praesentium optio, sapiente distinctio illo?
											</div>
										</div>
									</li>
			
								</ul>
							</div>
							<footer class="footer">
								<input type="text" class="footer__input">
								<button class="footer__btn" value="test">
									<i class="far fa-keyboard"></i>
								</button>
							</footer>
						</div> 
					</div>
				</div> <!-- faq-content -->
			</li>
<%				
				checkNum = 1;
				//공개글 + 글쓴이 아님
				} else if (vo.getBoard_secrete().equals("0") && !vo.getMem_id().equals(memId)) {
%>
			<li>
				<a class="trigger" href="#0"><%=vo.getBoard_title() %></a>
				<div class="faq-content">
						<div>
								<span>writer : <%=vo.getMem_id()%>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>date : <%=vo.getBoard_date() %>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>product : <%=vo.getProd_id() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br><br>
								<P style="color: black;">content : </P><br>
								<P><%=vo.getBoard_content() %></P>
						</div>
						<!-- reply -->
								<br>
					<div class="comments-container">
						<h1>Comments
						</h1>
			
			<div class="container">
			
						<ul id="comments-list" class="comments-list">
			
							<li>
								<div class="comment-main-level">
									<!-- Avatar -->
									<div class="comment-avatar"><img
										src="https://images.unsplash.com/photo-1492106087820-71f1a00d2b11?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"
										alt=""></div>
									<!-- Contenedor del Comentario -->
									<div class="comment-box">
										<div class="comment-head">
											<h6 class="comment-name by-author">
												<a href="http://creaticode.com/blog">Agustin Ortiz</a>
											</h6>
											<span>hace 20 minutos</span>
											<i class="fa fa-reply"></i>
											<i class="fa fa-heart"></i>
										</div>
										<div class="comment-content">
											Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit omnis animi et
											iure laudantium vitae, praesentium optio, sapiente distinctio illo?
										</div>
									</div>
								</div>
							
								<!-- Respuestas de los comentarios -->
								<ul class="comments-list reply-list">
			
									<li>
			
										<!-- Avatar -->
										<div class="comment-avatar"><img
											src="https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1400&q=80"
											alt=""></div>
										<!-- Contenedor del Comentario -->
										<div class="comment-box">
											<div class="comment-head">
												<h6 class="comment-name">
													<a href="http://creaticode.com/blog">Lorena Rojero</a>
												</h6>
												<span>hace 10 minutos</span>
												<i class="fa fa-reply"></i>
												<i class="fa fa-heart"></i>
											</div>
											<div class="comment-content">
												Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit omnis animi et
												iure laudantium vitae, praesentium optio, sapiente distinctio illo?
											</div>
										</div>
									</li>
			
								</ul>
							</div>
							<footer class="footer">
								<input type="text" class="footer__input">
								<button class="footer__btn" value="test">
									<i class="far fa-keyboard"></i>
								</button>
							</footer>
						</div>
				</div> <!-- faq-content -->
			</li>
<%				
				checkNum = 1;
				} 
			}
		}
		if (checkNum == 0){
			%>
					<li>
						<a class="trigger" href="#0">You can write the first one.</a>
						<div class="faq-content">
							<p>You can write the first one.</p>
						</div> <!-- faq-content -->
					</li>
			<%
		checkNum = 0;
		}
%>
			</ul> <!-- faq-group -->
<%
	}
%>		
	</div> <!-- faq-items -->
	<a href="#0" class="cd-close-panel">CLOSE</a>
</section> <!-- faq -->

</html>
