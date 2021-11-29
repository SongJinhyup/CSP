<%@page import="cosmetic.vo.DetailOrderVO"%>
<%@page import="cosmetic.vo.ShipVO"%>
<%@page import="cosmetic.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="cosmetic.vo.PayVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Detail Order Page</title>
  <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/order.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script type="text/javascript">
$(function() {
	if($('#step-1').is(':checked') == true){
		setTimeout(function() {
			$('#step-1').removeAttr('checked');
			$('#step-2').attr('checked', true);		
		}, 1000)
	}
})
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<%
String orderId = request.getParameter("order_id");
PayVO payInfo =	(PayVO)request.getAttribute("payInfo");
List<ProductVO> list = (List<ProductVO>)request.getAttribute("productList");
ShipVO ship = (ShipVO)request.getAttribute("ship");
String date = ship.getDel_date();
date = date.substring(0, 11);
List<DetailOrderVO> detailList = (List<DetailOrderVO>)request.getAttribute("detailOrder");
%>
<input type="hidden" id="orderId" value="<%=orderId%>">
<div class='progress'>
  <div class='progress_inner'>
    <div class='progress_inner__step' id="check1">
      <label for='step-1'>Loading...</label>
    </div>
    <div class='progress_inner__step' id="payInfo">
      <label for='step-2'>Payment Info</label>
    </div>
    <div class='progress_inner__step' id="deProduct">
      <label for='step-3'>Detail Product</label>
    </div>
    <div class='progress_inner__step' id="delivery">
      <label for='step-4'>Delivery status</label>
    </div>
    <div class='progress_inner__step' id="">
      <label for='step-5'>Delivery completed</label>
    </div>
    <%
    if(ship.getDel_status().equals("배송완료")){
    %>
    <input id='step-1' name='step' type='radio'>
    <input id='step-2' name='step' type='radio'>
    <input id='step-3' name='step' type='radio'>
    <input id='step-4' name='step' type='radio'>
    <input checked='checked' id='step-5' name='step' type='radio'>
    <%
    }else{
    %>
    <input checked='checked' id='step-1' name='step' type='radio'>
    <input id='step-2' name='step' type='radio'>
    <input id='step-3' name='step' type='radio'>
    <input id='step-4' name='step' type='radio'>
    <input id='step-5' name='step' type='radio' onclick="return(false)">
    <%
    }
    %>
    <div class='progress_inner__bar'></div>
    <div class='progress_inner__bar--set'></div>
    <div class='progress_inner__tabs'>
      <div class='tab tab-0'>
        <h1>Waiting for Loading...</h1>
        <p>Please wait some seconds...</p>
      </div>
      <div class='tab tab-1'>
        <h1>Payment Info</h1>
        <p>
		Pay Type : <%=payInfo.getPay_type()%><br>
		Pay Price : <%=payInfo.getPay_price()%> &#8361;        
        </p>
      </div>
      <div class='tab tab-2'>
      <!-- 상품 갯수만큼 출력해야함 근데 출력이 안됨 왜? -->
        <h1>Detail Product</h1>
        <br>
        <%
			for(int i = 0; i < list.size(); i++){
		%>
		<div>
			<img alt="상품 이미지" src="<%=list.get(i).getProd_img()%>" style="width: 100px; height: 100px;">
			<span class="indexProd">
		        <p>No.<%=i+1%><br> 
		        Product Name : <%=list.get(i).getProd_name()%> <br> 
		        Order Quanity : <%=detailList.get(i).getDel_quanity() %><br>
				Price : <%=list.get(i).getProd_price() %><br>
			</span>
		</div>
		<br><br>
		<%
			}
        %>
        </p>
      </div>
      <div class='tab tab-3'>
        <h1>Delivery status</h1>
        <p>
        Delivery No :  <%=ship.getDel_no()%><br>
		Delivery Date : <%=date%><br>
		Delivery Status : <%=ship.getDel_status()%><br> 
        </p>
      </div>
      <div class='tab tab-4'>
        <h1>Delivery completed</h1>
        <p>
        	This Order was completed!<br>
        	Thank You!
        </p>
      </div>
    </div>
    <div class='progress_inner__status'>
      <div class='box_base'></div>
      <div class='box_lid'></div>
      <div class='box_ribbon'></div>
      <div class='box_bow'>
        <div class='box_bow__left'></div>
        <div class='box_bow__right'></div>
      </div>
      <div class='box_item'></div>
      <div class='box_tag'></div>
      <div class='box_string'></div>
    </div>
  </div>
</div>
</body>
</html>
