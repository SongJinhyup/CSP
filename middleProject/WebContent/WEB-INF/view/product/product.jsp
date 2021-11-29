<%@page import="cosmetic.vo.LprodVO"%>
<%@page import="cosmetic.vo.DetailOrderVO"%>
<%@page import="cosmetic.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Product</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/product.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- partial -->
  <script defer src="<%= request.getContextPath() %>/js/product.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>
<%
List<ProductVO> list = (List<ProductVO>)request.getAttribute("prodList");//17
List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");//16
String orderId = (String)request.getAttribute("orderId");
List<ProductVO> orderList = (List<ProductVO>)request.getAttribute("orderList");
List<LprodVO> totalLprod = (List<LprodVO>)request.getAttribute("allLprod");
%>
<input type="hidden" id="orderId" value="<%= orderId %>">
	<!-- partial:index.partial.html -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
<div id="wrapper">
<div class="cart-icon-top">
</div>

<div class="cart-icon-bottom">
</div>

<div id="checkout">
	Buy Now
</div>


<div id="header">	
	<ul>
        <li><a href="<%=request.getContextPath()%>/ShowMainServlet">Home</a></li>
        <li><a href="">REVIEW</a></li>
        <li><a href="">CONTACT</a></li>       
        <%
        if(session.getAttribute("mem_id") != null){
        %>
        <li><a href="myPage">MY PAGE</a></li>
		<%        
        }
        %>                                       
    </ul>		
</div>

<div id="sidebar">
	<h3>CART</h3>
    <div id="cart">
    <%
    if(orderList.size() > 0){
    int i = 0;
     for(ProductVO vo : orderList){
    %>
    	<div class='cart-item'>
    	  <div class='img-wrap'>
    	    <input type='hidden' class = 'cartProdId' value='<%=vo.getProd_id()%>'>
    	    <img src="<%=vo.getProd_img()%>" alt="상품이미지<%=i%>">
    	  </div>
    	  <span><%=vo.getProd_name()%></span>
    	  <strong><%=vo.getProd_price()%></strong>
    	  <div class='cart-item-border'>
    	  </div>
    	  <div class='delete-item'>
    	  </div>
    	</div>
    <%
     	i++;
     }
    }else{
    %>
      <span class="empty">No items in cart.</span>       
    <%
    }
    %>
    </div>
    
    <h3>Category</h3>
    <div class="checklist categories">
    	<ul>
    	<%
    	for(LprodVO vo : totalLprod){
    	%>
    		<li class = "lprodCheck">
    		  <a href="" id="<%=vo.getLprod_id()%>">
    		    <span></span>
    		    <%=vo.getLprod_type() %>
    		  </a>
    		</li>
    	<%
    	}
    	%>
        </ul>
    </div>
    
    <h3>Line</h3>
    <div class="checklist colors">
    	<ul>
            <li><a href=""><span style="background:#222"></span>Black</a></li>
            <li><a href=""><span style="background:#094d0c"></span>Avocado</a></li>
            <li><a href=""><span style="background:#379c72"></span>Tea tree</a></li>
        </ul>
        
        <ul>
            <li><a href="/product/product2.html"><span style="background:#f79858"></span>Orange</a></li>
            <li><a href=""><span style="background:#b27ef8"></span>Grape</a></li>
            <li><a href=""><span style="background:#f56060"></span>Pomegranate</a></li>
            </li>
        </ul>        
    </div>
    

    
     <h3>PRICE RANGE</h3>
     <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/245657/price-range.png" alt="" />
</div>

<div id="grid-selector">
       <div id="grid-menu">
       	   View:
           <ul>           	   
               <li class="largeGrid"><a href=""></a></li>
               <li class="smallGrid"><a class="active" href=""></a></li>
           </ul>
       </div>
       
       Showing 1–9 of 36 product 
</div>

<div id="grid">
<%
for(int i = 0; i < list.size(); i++){
%>
<input type="hidden" name = "price" value="<%= orderId %>" id="prodPrice">
<form class="product">
  <input type="hidden" class="lprodId" value="<%=lprodList.get(i).getLprod_id()%>">
    <div class="product">
        <div class="make3D">
            <div class="product-front">
                <div class="shadow"></div>
                <img src="<%=list.get(i).getProd_img()%>" alt="상품이미지<%=i%>"/>
                <div class="image_overlay"></div>
                
                <div class="add_to_cart">Add to cart</div>
                <input type="hidden" name="prodId" value="<%= list.get(i).getProd_id() %>" class = "prodId">
                <input type="hidden" name="memeId" value="<%= session.getAttribute("mem_id") %>" class="memeId">
 				<input type="hidden" name = "priice" value="<%= list.get(i).getProd_price() %>" class="prodPrice">
 			<%
 				if(i>=1 && i<=5){
				%>
				<a href="detail<%=i%>?prod_id=<%=list.get(i).getProd_id()%>&order_id=<%=orderId%>">				
 			
                   <div class="stats">   
                     <div class="stats-container">
                        <span class="product_price"><%=list.get(i).getProd_price()%></span>
                        <span class="product_name"><%= list.get(i).getProd_name() %></span>    
                        <p class="lprod_name"><%=lprodList.get(i).getLprod_type() %></p>                                                                   
                        <div class="product-options">
	                       <strong>REVIEW</strong>
	                       <span>10</span>                       
                        </div>                       
                      </div>  
                   </div>
				  </a>
			<%
 				}else{
 			%>
                <div class="stats">   
                    <div class="stats-container">
                        <span class="product_price"><%=list.get(i).getProd_price()%></span>
                        
                        <span class="product_name"><%= list.get(i).getProd_name() %></span>    
                        <p><%=lprodList.get(i).getLprod_type() %></p>                                                                   
                        <div class="product-options">
                        <strong>REVIEW</strong>
                        <span>10</span>                       
                    </div>                       
                    </div>  
                </div>
 			<%
 				}
 			%>
            </div>	  
        </div>	
    </div>
</form>
<%
}
%>
 
</div>
</div>

</body>
</html>
