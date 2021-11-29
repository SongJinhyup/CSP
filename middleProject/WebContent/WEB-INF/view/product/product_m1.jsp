<%@page import="java.util.Map"%>
<%@page import="cosmetic.vo.LprodVO"%>
<%@page import="cosmetic.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>product manager1</title>
  <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">-->
   <link rel="stylesheet" href="<%= request.getContextPath() %>/css/product_m.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js">
  <script src="menu.js"></script>
  
  <!-- partial -->
  <script defer src="<%= request.getContextPath() %>/js/product_m.js"></script>
  <script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
  
  <script type="text/javascript">
  $(function(){
 	  
<%--       $("#Cplus").on("click", function(){
		  var lprod_type = $("#lprodVal").val();
	 	  console.log(lprod_type);
	 	  if(lprod_type.length < 1){
			  alert("추가할 카테고리명을 입력하세요.");
			  return;
		  }
		  location.href="<%=request.getContextPath()%>/view/AdminLprodInsert?lprod_type="+lprod_type ;
	  	  
      });
 --%>     
 		 $("#Cplus").on("click", function(){
		  var lprod_type = $("#lprodVal").val();
	 	  console.log(lprod_type);
	 	  if(lprod_type==""){
			  alert("추가할 카테고리명을 입력하세요.");
			  return;
		  }
		  location.href="<%=request.getContextPath()%>/view/AdminLprodInsert?lprod_type="+lprod_type ;
	  	  
      });

       $(".item__delete").on("click", function(){
		  var lprod_type = $(this).val();
		  console.log(lprod_type);
		  location.href="<%=request.getContextPath()%>/view/AdminLprodDelete?lprod_type="+lprod_type ;
	  });

       $(".save").on("click", function(){
		  var lprod_id = $(this).val();
		  var lprod_type = $("#"+ lprod_id).val(); 
		  console.log(lprod_id);
		  console.log(lprod_type);
		  location.href="<%=request.getContextPath()%>/view/AdminLprodUpdate?lprod_id="+lprod_id+ "&lprod_type=" +lprod_type;
 		});

      $("#Supdate").on("click", function(){
		  var prod_id = $(this).val();
		  var prod_stock = $("#number").val();
		  console.log(prod_id);
		  console.log(prod_stock);
		  $.ajax({
			  url : "<%=request.getContextPath()%>/view/AdminProductStockUpdate",
			  data : {'prod_id' : prod_id, "prod_stock" : prod_stock},
			  dataType : 'json'
		  })
		  alert('update 성공');
		  location.href="<%=request.getContextPath()%>/view/AdminProduct1View"
 		});
	  
  });
  </script>
</head>
<body>
<%	
	LprodVO lprodVo = (LprodVO)request.getAttribute("lprodVO");
	List<ProductVO> list = (List<ProductVO>)request.getAttribute("prodList");//17
	List<ProductVO> prodStockList = (List<ProductVO>)request.getAttribute("prodStockList");//17
	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");//16
	List<LprodVO> lprodAList = (List<LprodVO>)request.getAttribute("lprodAList");
%>
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
        <li><a href="<%= request.getContextPath() %>/view/AdminHomeMain  ">HOME</a></li>
        <li><a href="<%= request.getContextPath() %>/view/AdminProduct2View">PRODUCT2</a></li>
        <li><a href="<%= request.getContextPath() %>/view/AdminViewMmeber">MEMBER</a></li>
        <li><a href="">REVIEW</a></li>
        <li><a href="">CONTACT</a></li>                                              
    </ul>		
</div>

<div id="sidebar">
	<h3>CART</h3>
    <div id="cart">
    	<span class="empty">No items in cart.</span>       
    </div>
    
    
    <h3>Category</h3>
    
    <div class="footer">
        <input type="text" class="footer__input" id="lprodVal">
        <button class="footer__btn" id="Cplus">
            <i class="fas fa-plus"></i>
        </button>
    </div>
    
    <div class="checklist categories">
    	<ul class="items">
        <%
    	for(LprodVO vo : lprodAList){
    	%>
    	     <li class="item__row">
    	     	<div class="item"><input class="item__name" id="<%=vo.getLprod_id()%>" type="text" onclick="" value="<%=vo.getLprod_type() %>"/>
    	     		<button class="item__delete" value="<%=vo.getLprod_type() %>">
    	     			<i class="fas fa-minus-circle"></i>
    	     		</button>
                    <button class="save" value="<%=vo.getLprod_id()%>">저장</button>
    	       </div>
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
            <li><a href="../product/product_m2.html"><span style="background:#f79858"></span>Orange</a></li>
            <li><a href=""><span style="background:#b27ef8"></span>Grape</a></li>
            <li><a href=""><span style="background:#f56060"></span>Pomegranate</a></li>
        </ul>        
    </div>
    

    
     
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
    <div class="product">
        <div class="make3D">
            <div class="product-front">
                <div class="shadow"></div>
                <img src="<%=list.get(i).getProd_img()%>" alt="상품이미지<%=i%>"/>
                
                <div class="image_overlay"></div>
                <div class="add_to_cart">Add to cart</div>                             
                <div class="stats">   
                    <div class="stats-container">
                        <span class="product_price"><%=list.get(i).getProd_price()%></span>
                        
                        <span class="product_name"><%= list.get(i).getProd_name() %></span>    
                        <p><%=lprodList.get(i).getLprod_type() %></p>                                                                   
                        <div class="product-options">
                        <strong>STOCK</strong>
                        
                        	<br>
                        	<div class="stock">
                            	<input
                                   class="counting__btn"
                                   type="submit"
                                   onclick="descrementValue()"
                                   value="-"/>
                               <input type="text" id="number" value="<%=list.get(i).getProd_stock() %>"/>
                               <input
                                   class="counting__btn"
                                   type="button"
                                   onclick="incrementValue()"
                                   value="+"/>
                               <br>
                               <div class="counting__input">
                                   <button id="Supdate" value="<%=list.get(i).getProd_id() %>">재고수정</button>
                               </div>
                           </div>
               
                    </div>                       
                    </div>  

                </div>
            </div>	  
        </div>	
    </div>
<%
}
%>

</div>
</div>

</body>
</html>