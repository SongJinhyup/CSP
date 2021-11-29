<%@page import="cosmetic.vo.MemberVO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="cosmetic.vo.OrderVO"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@page import="java.util.Currency"%>
<%@page import="cosmetic.vo.DetailOrderVO"%>
<%@page import="cosmetic.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Cart</title>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
  <script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="<%=request.getContextPath()%>/css/cart.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script defer src="<%=request.getContextPath()%>/js/cart.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<style>

</style>
<script>

</script>
</head>
<body>
<input type="hidden" id = "mem_id" value="<%= session.getAttribute("mem_id") %>">
<!-- <input type="hidden" id = "mem_id" value="a002"> -->
<!-- partial:index.partial.html -->
 <div class="wrap cf">
  <h1 class="projTitle"> Shopping Cart</h1>
  <div class="heading cf"> 
    <h1>My Cart  <i class="fas fa-leaf"></i></h1>
    <a href="<%=request.getContextPath()%>/view/product" id="goProd" class="continue">Continue Shopping</a> <!-- 상품페이지 서블릿 경로 -->
  </div>
  <div class="cart">
    <ul class="cartWrap">
<%
List<DetailOrderVO> olist = (List<DetailOrderVO>)request.getAttribute("orderList");
List<ProductVO> plist = (List<ProductVO>)request.getAttribute("prodList");
OrderVO vo = (OrderVO)request.getAttribute("oderVO");
List<MemberVO> mlist = (List<MemberVO>)request.getAttribute("cupon");
NumberFormat numberFormat = NumberFormat.getInstance();
for(int i = 0; i < olist.size(); i++){
	if(i%2 == 1){
%>
     <!-- items odd -->
      <li class="items odd">
        <div class="infoWrap"> 
          <div class="cartSection qtySection">
            <img src="<%=plist.get(i).getProd_img()%>" style="width: 120px; height: 100px;" alt="" class="itemImg"/>
            <p class="itemNumber">#<%=olist.get(i).getOrder_id()+"_"+plist.get(i).getProd_id()%></p>
            <h3><%=plist.get(i).getProd_name()%></h3>
            <p> 
              <input type="text" class="qty" value="<%=olist.get(i).getDel_quanity()%>"/> x &#8361; <%=numberFormat.format(plist.get(i).getProd_price())%>
            </p>
         <%if(plist.get(i).getProd_stock()> 0){
        %>
		    <p class="stockStatus"> 
				IN STOCK        
		    </p>
    	<%
        	}else{
		%>
		    <p class="stockStatus out">
			OUT OF STOCK
		    </p>
		<%        	 
         }
        %>
        </div>  
        <div class="prodTotal cartSection">
          <p>&#8361; <%=numberFormat.format(plist.get(i).getProd_price()*olist.get(i).getDel_quanity())%></p>
        </div>
        <div class="cartSection removeWrap">
       	  <input type="hidden" class = "orderId" value = "<%=olist.get(i).getOrder_id()%>"> 
       	  <input type="hidden" class = "prodId" value = "<%=plist.get(i).getProd_id()%>"> 
		  <input type="hidden" class = "price" value="<%= plist.get(i).getProd_price() %>">
          <a href="#" class="remove">x</a>
        </div>
      </div>
    </li>
<%
}else{
%>
    <!-- items even -->
     <li class="items even">
      <div class="infoWrap"> 
       <div class="cartSection">
       <img src="<%=plist.get(i).getProd_img()%>" style="width: 120px; height: 100px;" alt="" class="itemImg"/>
         <p class="itemNumber">#<%=olist.get(i).getOrder_id()+"_"+plist.get(i).getProd_id()%></p>
         <h3><%=plist.get(i).getProd_name()%></h3>
       
          <p> <input type="text"  class="qty" value="<%=olist.get(i).getDel_quanity()%>"/> x 
			&#8361; <%=numberFormat.format(plist.get(i).getProd_price())%></p>
		   <%if(plist.get(i).getProd_stock()> 0){
        	%>
         	<p class="stockStatus"> 
				IN STOCK        
			</p>
       		 <%
         	}else{
			%>
			<p class="stockStatus out">
				OUT OF STOCK
			</p>
			<%        	 
        	 }
        	%>
       </div>  
   
       
       <div class="prodTotal cartSection">
         <p>&#8361; <%=numberFormat.format(plist.get(i).getProd_price()*olist.get(i).getDel_quanity())%></p>
       </div>
       <div class="cartSection removeWrap">
         <input type="hidden" class = "price" value="<%= plist.get(i).getProd_price() %>">
         <input type="hidden" class = "orderId" value = "<%=olist.get(i).getOrder_id()%>"> 
       	 <input type="hidden" class = "prodId" value = "<%=plist.get(i).getProd_id()%>"> 
         <a href="#" class="remove">x</a>
       </div>
     </div>
     </li>

<%
	}
}
%>
         <div class="special"><div class="specialContent">Free gift with purchase!, gift wrap, etc!!</div></div>
      </li>
      <!--<li class="items ev en">Item 2</li>-->
    </ul>
  </div>
  

  <!-- promote code -->
  <div class="address"><label for="promo">  Please enter your address</label>
    <input type="text" name="add" placholder="Enter Code" id="address1" />
    
    <a href="#" class="btn" id="addBtn"></a>
    
    <input type="text" name="add" placholder="Enter Code" id="address2" />

</div>

  <div class="subtotal cf">
    <ul>
      <li class="totalRow"><span class="label">Subtotal</span><span class="value" ><%=numberFormat.format(vo.getTotal_price())%></span></li>
          <li class="totalRow"><span class="label">Shipping</span><span class="value">2500</span></li>
            <li class="totalRow final"><span class="label">Total</span><span class="value totalPrice" >
            <input type="hidden" id = "payPrice" value="<%=vo.getTotal_price()+2500%>">
            <input type="hidden" id="orderId" value="<%=vo.getOrder_id()%>">
            <%=numberFormat.format(vo.getTotal_price()+2500)%></span></li>
            <hr class="promoLine">
            <li class="totalRow">
              <div class="promoCode ">
                <label for="promo">Have A Promo Code?</label>
                <input id="textPromo" type="text" name="promo" placholder="Enter Code" />
                <a href="#" class="btn" id="myBtn">
                </a>
              </div>
            </li>
           <br><br><br><br><br>
            
      <li class="totalRow"><a href="#" class="btn continue checkout">Checkout</a></li>
    </ul>
  </div>
</div>

<%
	
%>
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <%
    if(mlist.size() == 0 || mlist.get(0).getMem_cupon()== null){
    %>
	  <p>Don't Have A Promo Code</p>    	
    <%
    }else{
    	for(int i = 0; i < mlist.size(); i++){
    		
    %>
     <p class="cupon"><%=mlist.get(i).getMem_cupon()%></p>
    <%
 	   }
    }
    %>
    
  </div>
</div>
<%
	int plistQty= 0;
	if(plist.size() > 1){
		plistQty = plist.size()-1;
	}
	
	if(plistQty > 0){
%>
	<input id="orderName" type="hidden" value="<%=plist.get(0).getProd_name()%> 외 <%=plist.size()-1 %>개 ")>
<%
	}else if(plist.size() == 1){
%>
	<input id="orderName" type="hidden" value="<%=plist.get(0).getProd_name()%>")>
<%
}else{
	%>
	<input id="orderName" type="hidden" value="상품 없음")>
	<%
}
%>
</body>
</html>
