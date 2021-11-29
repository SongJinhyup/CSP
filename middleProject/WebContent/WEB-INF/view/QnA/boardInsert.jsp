<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
h2 {
text-align: center;
}
</style>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script defer src="<%=request.getContextPath() %>/js/qna.js"></script>
<script>
	
$(function(){
	$('.send').on('click', function(){
		if ($('select').val() == '6'){
			alert("게시판을 선택해주세요");
			return false;
		}
		$('.insertForm').submit();
// 		window.close();
	})
})


</script>
</head>
<body>
<%
String memId = (String) request.getAttribute("memId");
String prodName = (String) request.getAttribute("prodName");
String n = (String) request.getAttribute("n");
if (prodName == null && n == null) {
%>
		<div title="전송이나 취소버튼을 클릭하면 창이 닫힙니다.">
			<form class="insertForm" action="<%=request.getContextPath()%>/board/boardInsert">
				<span><input type="hidden" name="mem_id" id="mem_id" value="<%=memId %>" readonly></span><br>
				 <table class="tbs">
                     <tr>
                     	<th scope="row">category</th>
                        <td><select id="board_index" name="board_index">
                                <option value="6">게시판을 선택하세요</option>
                                <option value="0">SHIPPING</option>
                                <option value="1">EXCHANGE</option>
                                <option value="2">REFUND</option>
                                <option value="3">PAYMENT</option>
                                <option value="4">PRODUCT</option>
                                <option value="5">FREEBOARD</option>
                            </select>
                            <span>&emsp;    &emsp;&emsp;&emsp; 비밀글</span>
                            <input type="checkbox" value="1" name="board_secrete" class="board_secrete">

                         </td>
                    </tr>
                    <tr>
					 	<th scope="row"><span><label for="board_title">title</label></span></th>
                    	<td><span><input type="text" name="board_title" id="board_title"></span></td>
                    	<td></td>
                    	<td></td>
                    </tr>
                    
                    <tr>
                        <th scope="row"><label for="prod_id">product</label></th>
                        <td><span><input type="text" name="prod_id" id="prod_id"></span></td>
                        <td></td>
                        <td></td>
                    </tr>
                    
                    <tr>
                        <th scope="row" id="content_id"><label for="board_content">content</label></th>
                        <td><textarea rows="10" cols="40" name="board_content" id="board_content"></textarea></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </table>

				<div>
					<input type="submit" class="send" value="전송" > 
					<input type="reset" class="cancel" value="취소" onclick="window.close()">
				</div>
			</form>
		</div>
<%
}else if (prodName == null && n != null) {
%>
		<div title="전송이나 취소버튼을 클릭하면 창이 닫힙니다.">
			<form class="insertForm" action="<%=request.getContextPath()%>/noticeInsert">
				<span><input type="hidden" name="mem_id" id="mem_id" value="<%=memId %>" readonly></span><br>
				 <table class="tbs">
                     <tr>
                     	<th scope="row">category</th>
                        <td><select id="board_index" name="board_index">
                                <option value="6">게시판을 선택하세요</option>
                                <option value="7">NOTICE</option>
                                <option value="8">POLICY</option>
                                <option value="9">LOG IN</option>
                                <option value="10">MY PAGE</option>
                                <option value="11">PAYMENT</option>
                                <option value="12">DELIVERY</option>
                            </select>
                         </td>
                    </tr>
                    <tr>
					 	<th scope="row"><span><label for="board_title">title</label></span></th>
                    	<td><span><input type="text" name="board_title" id="board_title"></span></td>
                    </tr>
                    
                    <tr>
                        <th scope="row" id="content_id"><label for="board_content">content</label></th>
                        <td><textarea rows="10" cols="40" name="board_content" id="board_content"></textarea></td>
                    </tr>
                    </table>

				<div>
					<input type="submit" class="send" value="전송"> 
					<input type="reset" class="cancel" value="취소" onclick="window.close()">
				</div>
			</form>
		</div>
<%}else {%>
<!-- 구매고객만!! 리뷰쓰기 -->
		<div title="전송이나 취소버튼을 클릭하면 창이 닫힙니다.">
			<form class="insertForm" action="<%=request.getContextPath()%>/board/boardInsert">
					<input type="hidden" name="mem_id" id="mem_id" value="<%=memId %>" readonly>
					<input type="hidden" name="board_index" id="board_index" value="5"><!-- 리뷰인덱스는 5임 -->
					<input type="hidden" name="prodName" id="prodName" value="<%=prodName %>">
					<h2> great review for <%=prodName %></h2> 
				 <table class="tbs">
				 	<tr>
				 		<th scope="row">별점</th>
                        <td><select id="board_secrete" name="board_secrete">
                                <option value="0">별점을 선택하세요</option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                         </td>
                    </tr>
                    
                     <tr>
                        <th scope="row" id="content_id"><label for="board_content">content</label></th>
                        <td><textarea rows="10" cols="40" name="board_content" id="board_content"></textarea></td>
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