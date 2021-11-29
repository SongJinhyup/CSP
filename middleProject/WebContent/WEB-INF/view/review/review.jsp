<%@page import="cosmetic.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Review</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/review.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=STIX+Two+Math&display=swap" rel="stylesheet">
 <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/js/review.js"></script>
<script>
currentPage = 1;	//페이지 전역변수 지정

$(document).ready(function(){

	//이전버튼 클릭 이벤트
	$('.prev').on('click', function(){
		 var prod_id = $('#prod_id').text();
			vnext = $('#sp').text().trim();
			currentPage = parseInt(vnext) - 1;
			location.href="<%=request.getContextPath()%>/review/reviewList?page="+currentPage+"&prod_id="+prod_id;
	})
			
	//다음버튼 클릭 이벤트
	$('.next').on('click', function(){
	    var prod_id = $('#prod_id').text();
		vnext = $('#sp').text().trim();
		currentPage = parseInt(vnext) + 1;
		location.href="<%=request.getContextPath()%>/review/reviewList?page="+currentPage+"&prod_id="+prod_id;
	})
	
	
	//리뷰삭제- 관리자만 가능
	$('.delete_btn').on('click', function(){
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
		location.reload();

	})
	
})
	
// 	사용하지 않는 기능
// 	$('.modify_btn').on('click', function(){
// 		var id = $('')
<%-- 		$('.review').attr('action', '<%=request.getContextPath()%>/review/reviewUpdate'); --%>
// 		$('.review').submit();
// 	})

</script>
<script type="text/javascript">
function popup(url) { window.open(url, "게시글 등록", "width=460px, height=425px, left=100, top=50"); }
</script>
</head>
<body>
<span id="pagesadfds">1</span>
<%
String memId = (String) session.getAttribute("mem_id");
System.out.print(memId);
List<BoardVO> reviewList = (List<BoardVO>) request.getAttribute("reviewList");
int ordercnt = 0;
int sp = 0;
int ttp = 0;
String prodId = "";
String prodName = "";
if (memId == null) {
	memId = "guest";
}
if (reviewList.size() != 0) {
sp = (int) request.getAttribute("start");
ttp = (int) request.getAttribute("ttpage");
ordercnt = (int) request.getAttribute("ordercnt");
prodId = (String) request.getAttribute("prod_id");
if (request.getAttribute("prod_id") == null) {
}
prodName = (String) reviewList.get(0).getProd_name();
%>

<!-- partial:index.partial.html -->
<header>
  <h1>Review <i class="fas fa-leaf"></i>
  </h1>
</header>
	<h3 id="prod_id" style="display: none"><%=reviewList.get(0).getProd_id() %></h3>
<h2> <%=reviewList.get(0).getProd_name() %></h2>

<br><div class="user_btn">
<%} else { %>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><h1> there is no review.</h1>
<h2> You can buy it.</h2>
<h2>You can review it.</h2>
<%}%>
<%
//구매한 사람만 리뷰를 쓸 수 있음
if (ordercnt != 0) {
%>
  <button class="plus_btn"><i class="fas fa-plus" onclick="popup('<%=request.getContextPath()%>/board/boardInsertForm?memId=<%=memId%>&prodName=<%=prodName%>')"></i></button>
<%  
}
%>
  </div>

<div class="wrapper">
  <div class="masonry js-masonry"  data-masonry-options='{ "columnWidth": 320 }'>
<%
if (reviewList.size() == 0){
%>
	<div></div>
<%
}else if (reviewList != null && reviewList.size() != 0) {
		for (int i = 0 ; i < reviewList.size(); i++) {
			BoardVO vo = reviewList.get(i);
%>
    <div class="item">
      <h3 class="author">ID : <%=vo.getMem_id() %></h3>
      <span class="mark"><i class="fa fa-quote-left"></i></span>
      <div class="quote">
      	<div class="star">
<%
			for (int j = 0; j < Integer.parseInt(vo.getBoard_secrete()); j++){
%>
        <i class="fas fa-star"></i>
<%
			}
			for (int j = 0; j < 5 - Integer.parseInt(vo.getBoard_secrete()); j++){
%>
        <i class="far fa-star"></i>
<%
			}
%>        
        </div>
        <p><%=vo.getBoard_content() %></p>
<%
				if(memId.equals("admin")) {
%>
		<form class="review">
			<input type="hidden" name="board_id" value="<%=vo.getBoard_id()%>">
<!-- 			<button class="modify_btn"><i class="fas fa-eraser"></i></button> -->
	        <button class="delete_btn" name="<%=vo.getBoard_id()%>"><i class="far fa-trash-alt"></i></button>
        </form>
<%
				} else {
%>        
        <button class="hidden"></button>    
<%
				}
%>
      </div>
    </div>
<%
		}
	}
%>
  </div>
</div>

<footer> 
<%if (sp != 0) {%>
  <div> 
  <span>Showing</span>
  <span id="sp"><%=sp %></span>
  <span>of</span>
  <span id="ttp"><%=ttp %></span>
  <span>page</span>
<!--   <span> -->
<%--     Showing 1 of <%=(reviewList.size()-1)/6 +1 %> page   --%>
<!--   </span> -->
  </div> 
<%} %>
  <div class="next_btn">
  <%
  	if (sp !=1 && sp !=0){
  %>
  <!-- <div class="prev_btn"> -->
  <a class="prev"> <i class="fas fa-arrow-left"></i> Prev 
  </a>
  <%
  	}
  	if (sp != ttp){
  %>
  <a class="next">  Next <i class="fas fa-arrow-right"></i>
  </a>
  <%
  	}
  %>
</div>
</footer>
<!-- partial -->
  <script src='https://masonry.desandro.com/masonry.pkgd.js'></script>
</body>
</html>
