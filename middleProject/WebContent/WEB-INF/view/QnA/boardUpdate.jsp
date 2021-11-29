<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    table.tbs {
  border-collapse: separate;
  border-spacing: 0;
  line-height: 1.5;
  border: 0px ;
  margin : 10px 5px;
}
th {
    text-align: middle;
    vertical-align: middle;
    padding-right: 15px;
}
td{
    text-align: left;
    height: 50px;
}
.tbs input, select{
    height: 30px;
}
.tbs textarea{
    width: 300px;
    height: 150px;
    background-color: #fffffffa;
}

select{
    width: 150px;
    height: 30px;
    /* border: none; */
}
form div{
    /* text-align: center; */
    margin-left: 190px;
}

#board_title, #prod_id{
    width: 300px;
}

#content_id{
    vertical-align: top;
}

.insert{
    position:sticky; top:50%; left:35%;
}

.board_secrete{
    vertical-align: bottom;
}
</style>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script defer src="<%=request.getContextPath() %>/js/qna.js"></script>
<script>
	
$(function(){
	
	$('.send').on('click', function(){
		if ($('select').val() == ''){
			alert("게시판을 선택해주세요");
			return false;
		}
		$('.updateForm').submit();
	})
	
})


</script>
</head>
<body>
<%
String boardTitle = (String) request.getAttribute("board_title");
String prodId = (String) request.getAttribute("prod_id");
String boardContent = (String) request.getAttribute("board_content");
String boardSecrete = (String) request.getAttribute("board_secrete");
String boardIndex = (String) request.getAttribute("board_index");
String boardId = (String) request.getAttribute("board_id");
String n = (String) request.getAttribute("n");

System.out.println("확인용"+ boardTitle);
System.out.println("확인용"+ prodId);
System.out.println("확인용"+ boardContent);
System.out.println("확인용"+ boardSecrete);
System.out.println("확인용"+ boardIndex);
System.out.println("확인용"+ boardId);
if (boardId.contains("b")){
%>
      <div class="modal_content" title="전송이나 취소버튼을 클릭하면 창이 닫힙니다.">
           <form class="updateForm" action="<%=request.getContextPath()%>/board/boardUpdate">
	            <input type="hidden" name="board_id" id="board_id" value="<%=boardId %>">
	             <table class="tbs">
                     <tr>
                     	<th scope="row">category</th>
                        <td><select id="board_index" name="board_index">
                                <option value="">게시판을 선택하세요</option>
                                <option value="0">SHIPPING</option>
                                <option value="1">EXCHANGE</option>
                                <option value="2">REFUND</option>
                                <option value="3">PAYMENT</option>
                                <option value="4">PRODUCT</option>
                                <option value="5">FREEBOARD</option>
                            </select>
                            <span>&emsp;    &emsp;&emsp;&emsp; 비밀글</span>
                            <input type="checkbox" value="1" name="board_secrete" class="board_secrete"
<%	if(boardSecrete.equals("1")) { %>	checked <%} %> >
                         </td>
                    </tr>
                    <tr>
					 	<th scope="row"><span><label for="board_title">title</label></span></th>
                    	<td><span><input type="text" name="board_title" id="board_title" value="<%=boardTitle%>"></span></td>
                    	<td></td>
                    	<td></td>
                    </tr>
                    
                    <tr>
                        <th scope="row" id="content_id"><label for="board_content">content</label></th>
                        <td><textarea rows="10" cols="40" name="board_content" id="board_content" ><%=boardContent %></textarea></td>
                        <td></td>
                        <td></td>
                    </tr>
				</table>
				
				<div>
					<input type="submit" class="send" value="전송"> 
					<input type="reset" class="cancel" value="취소" onclick="window.close()">
				</div>
           </form>
        </div>
<%}else { %>
	<div class="modal_content" title="전송이나 취소버튼을 클릭하면 창이 닫힙니다.">
           <form class="updateForm" action="<%=request.getContextPath()%>/noticeUpdate">
	            <input type="hidden" name="board_id" id="board_id" value="<%=boardId %>">
	             <table class="tbs">
                     <tr>
                     	<th scope="row">category</th>
                        <td><select id="board_index" name="board_index">
                                <option value="">게시판을 선택하세요</option>
                                <option value="7">NOTICE</option>
                                <option value="8">POLICY</option>
                                <option value="9">LOGIN</option>
                                <option value="10">MYPAGE</option>
                                <option value="11">PAYMENT</option>
                                <option value="12">DELIVERY</option>
                            </select>
                         </td>
                    </tr>
                    <tr>
					 	<th scope="row"><span><label for="board_title">title</label></span></th>
                    	<td><span><input type="text" name="board_title" id="board_title" value="<%=boardTitle%>"></span></td>
                    	<td></td>
                    	<td></td>
                    </tr>
                    
                    <tr>		
                        <th scope="row" id="content_id"><label for="board_content">content</label></th>
                        <td><textarea rows="10" cols="40" name="board_content" id="board_content" ><%=boardContent %></textarea></td>
                        <td></td>
                        <td></td>
                    </tr>
				</table>
				
				<div>
					<input type="submit" class="send" value="전송"> 
					<input type="reset" class="cancel" value="취소" onclick="window.close()">
				</div>
           </form>
        </div>
<%} %>
</body>
</html>