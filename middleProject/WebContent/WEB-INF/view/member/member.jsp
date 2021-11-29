<%@page import="java.util.Map"%>
<%@page import="cosmetic.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Member management</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css">
  <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js">

<!-- partial -->

<script defer src="<%=request.getContextPath()%>/js/member.js"></script>
<script type="text/javascript">

$(function(){
	$.ajax({
     	url : "<%=request.getContextPath()%>/view/AdminMemberList",
     	dataType : "json" ,
     	success : function(res){    
     		var code = '';
     		var count = 0;
     		
     		  var array = [
					['#fee4cb','#ff942e','#ff942e'],
					['#e9e7fd','#4f3ff0','#4f3ff0'],
					['#DBF6FD','#096c86','#096c86'],
					['#ffd3e2','#df3670','#df3670'],
					['#c8f7dc','#34c471','#34c471'],
					['#d5deff','#4067f9','#4067f9']
			];  
     		
     	/* 	if(res.length==0){
				code += '<tr><td colspan="5">회원이 한명도 없습니다.</td></tr>';
			} else{  */
				console.log(res);
			$.each(res,function(i,v){
				console.log(array[i%6][0], array[i%6][1], array[i%6][2])
		        code +='<div class="project-box-wrapper">';
// 	          	code +='<div class="project-box" style="background-color: #fee4cb;">';
	          	code +='<div class="project-box" style="background-color:' + array[i%6][0] + '">';
		        code +='<div class="project-box-header">';
	            code +='<span>가입일: 2021. 07. 21</span>';
	            code +='<div class="more-wrapper">';
	            code +='<button class="project-btn-more">';
	            code +='<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">';
	            code +='<circle cx="12" cy="12" r="1" />';
	            code +='<circle cx="12" cy="5" r="1" />';
	            code +='<circle cx="12" cy="19" r="1" /></svg>';
	            code +='</button>';
		        code +='</div>';
				code +='</div>';
				code +='<div class="project-box-content-header">';
				//code +='<p class="box-content-header" id="memId">' + res[i].mem_id + '</p>';
				code +='<p class="box-content-header">' + res[i].mem_id + '</p>';
				code +='<p class="box-content-subheader">' + res[i].mem_name + '</p>';
				code +='<p class="box-content-subheader">' + res[i].mem_email + '</p>';
				code +='<p class="box-content-subheader">' + res[i].mem_tel + '</p>';
				code +='</div>';

				code +='<div class="project-box-footer">';
				          
				 //code +='<button class="days-left UpdateB" style="color:' + array[i%6][1] + '" value= "'+ res[i].mem_id + '">수정</button>';
				 code +='<button class="days-left Del" style="color: ' + array[i%6][2] + '" value= "'+ res[i].mem_id + '">삭제</button>';
				 code +='</div>';
				 code +='</div>';
				 code +='</div>';
				 count++;
				    
     				});
				    $('#Mem').html(code);
				    $('.status-number').html(count);
				    
				    console.log(count);
				//}
     		},
				error : function(xhr){
					alert(xhr.status);
				},
				dataType : 'json'
     	});
	

	<%-- $(document).on("click", '.UpdateB', function(){
		var mem_id = $(this).val();
		console.log(mem_id);
		location.href="<%=request.getContextPath()%>/ABlacklistUpdateServlet?mem_id="+mem_id ;
	}); --%>

	$(document).on("click", '.Del', function(){
		var mem_id = $(this).val();
		console.log(mem_id);
		location.href="<%=request.getContextPath()%>/view/AMemberDelete?mem_id="+mem_id ;
	});
	
	$.ajax({
		url : "<%=request.getContextPath()%>/view/AdminBlackListView",
		dataType : "json", 
		success : function(res){
			
			var code = '';
					  code += '<button class="messages-close">';
					  code += '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x-circle">';
					  code += '<circle cx="12" cy="12" r="10" />';
					  code += '<line x1="15" y1="9" x2="9" y2="15" />';
					  code += '<line x1="9" y1="9" x2="15" y2="15" /></svg>';
					  code += '</button>';
					  code += '<div class="projects-section-header">';
					  code += '<p>Black list</p>';
					  code += '</div>';
			/* if(res.length==0){
				code += '<tr><td colspan="5">블랙리스트 회원이 한명도 없습니다.</td></tr>';
			}else{ */
				$.each(res,function(i,v){
					console.log(res);
					  code += '<div class="message-box">';
					  code += '<div class="message-content">';
					  code += '<div class="message-header">';
					  code += '<div class="name">' + res[i].mem_name + '</div>';
					  code += '</div>';
					  code += '<p class="message-line">사유: 게시판 욕설</p>';
					  code += '<div class="message-line">';
					  code += '</div>';
					  code += '<p class="message-line time">등록일: 2021.01.08';
					  code += '<br>';
					 // code += '<button class="days-left" style="color: #00363a;">수정</button>';
					  code += '<button class="days-left DelB" style="color: #00363a;" value= "' + res[i].mem_id + '">삭제</button>';
					  code += '</p>';
					  code += '</div>';
					  code += '</div>';
					  
					});
					$('#Black').html(code);
					
				//}
			

					$(document).on("click", '.DelB', function(){
						var mem_id = $(this).val();
						console.log(mem_id);
						location.href="<%=request.getContextPath()%>/view/AdminBlackListDelete?mem_id="+mem_id ;
					});
		},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json'
			
	});

});

</script>

</head>
<body>


<!-- partial:index.partial.html -->
<div class="app-container">
  <div class="app-header">
    <div class="app-header-left">
<a href="<%=request.getContextPath()%>/AdminHomeView.jsp"><img src="../imgs/manlogo.png" alt="" class="logo" width="30%" height="30%"> </a>
    </div>

    <button class="messages-btn">
      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-message-circle">
        <path d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z" /></svg>
    </button>
  </div>
  <div class="app-content">
    <div class="app-sidebar">
  
     
   <!--    <a href="" class="app-sidebar-link active">
        <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-settings" viewBox="0 0 24 24">
          <defs />
          <circle cx="12" cy="12" r="3" />
          <path d="M19.4 15a1.65 1.65 0 00.33 1.82l.06.06a2 2 0 010 2.83 2 2 0 01-2.83 0l-.06-.06a1.65 1.65 0 00-1.82-.33 1.65 1.65 0 00-1 1.51V21a2 2 0 01-2 2 2 2 0 01-2-2v-.09A1.65 1.65 0 009 19.4a1.65 1.65 0 00-1.82.33l-.06.06a2 2 0 01-2.83 0 2 2 0 010-2.83l.06-.06a1.65 1.65 0 00.33-1.82 1.65 1.65 0 00-1.51-1H3a2 2 0 01-2-2 2 2 0 012-2h.09A1.65 1.65 0 004.6 9a1.65 1.65 0 00-.33-1.82l-.06-.06a2 2 0 010-2.83 2 2 0 012.83 0l.06.06a1.65 1.65 0 001.82.33H9a1.65 1.65 0 001-1.51V3a2 2 0 012-2 2 2 0 012 2v.09a1.65 1.65 0 001 1.51 1.65 1.65 0 001.82-.33l.06-.06a2 2 0 012.83 0 2 2 0 010 2.83l-.06.06a1.65 1.65 0 00-.33 1.82V9a1.65 1.65 0 001.51 1H21a2 2 0 012 2 2 2 0 01-2 2h-.09a1.65 1.65 0 00-1.51 1z" />
        </svg>
      </a> -->
    </div>
    <div class="projects-section">
      
      <div class="projects-section-line">
        <div class="projects-status">
          <div class="item-status">
            <span class="status-number"></span> <!-- 회원 총 합계 -->
            <span class="status-type">Total</span>
          </div>
  
        </div>
        <div class="view-actions">
          <button class="view-btn list-view" title="List View">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-list">
              <line x1="8" y1="6" x2="21" y2="6" />
              <line x1="8" y1="12" x2="21" y2="12" />
              <line x1="8" y1="18" x2="21" y2="18" />
              <line x1="3" y1="6" x2="3.01" y2="6" />
              <line x1="3" y1="12" x2="3.01" y2="12" />
              <line x1="3" y1="18" x2="3.01" y2="18" /></svg>
          </button>
          <button class="view-btn grid-view active" title="Grid View">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-grid">
              <rect x="3" y="3" width="7" height="7" />
              <rect x="14" y="3" width="7" height="7" />
              <rect x="14" y="14" width="7" height="7" />
              <rect x="3" y="14" width="7" height="7" /></svg>
          </button>
        </div>
      </div>

 <!-- 회원박스 -->
      <div class="project-boxes jsGridView" id = "Mem">

      </div> 
    </div>
 
<div class="messages-section" id = "Black">
 </div> 
  
  
</div>
</div> 


</body>
</html>









	

