
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_dark.css">
     
        <title>Main_Manager</title>
        <script src="https://kit.fontawesome.com/20c5a1496b.js" crossorigin="anonymous"></script>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link
            rel="preconnect"
            href="https://fonts.gstatic.com"
            crossorigin="crossorigin">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link
            rel="preconnect"
            href="https://fonts.gstatic.com"
            crossorigin="crossorigin">
        <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,600;1,400&display=swap"
            rel="stylesheet">
            <script defer src="<%=request.getContextPath()%>/js/main_dark.js" ></script>
    
            <!-- <script src='https://codepen.io/rikschennink/pen/amxZqR.js'></script> -->
            </head>
    <body>

        <!--header(navbar)-->
        <!-- navbar -->
        <!-- Toggle button -->
        <nav class="navbar " id="navbar">
            <div class="container-fluid">
                <button class="navbar__toggle-btn">
                    <i class="fas fa-bars"></i>
                </button>
                <ul class="navbar_menu">
                    <li class="navbar_menu_item active" data-link ="#main">
                    	<a href="<%=request.getContextPath()%>/view/AdminViewMmeber" target="_blank">MEMBER</a>
                    </li>
                    <li class="navbar_menu_item" data-link ="#product">PRODUCT</li>
                    <li class="navbar_menu_item" >
                    <a href="<%=request.getContextPath()%>/review/reviewList?mem_id='admin'" target="_blank">REVIEW</a></li>
                    <li class="navbar_menu_item" data-link ="#news">
                    	<a href="<%=request.getContextPath()%>/AdminMemberView.jsp">STOCK</a>
             		</li>
                    <li class="navbar_menu_item" data-link ="#about">ABOUT US</li>
                    <li class="navbar_menu_item"></li>
                    <li class="navbar_menu_item"></li>
                    <a href="<%=request.getContextPath()%>/AdminHomeView.jsp" ><img src="<%=request.getContextPath() %>/imgs/menlogo.png" class = "logo" alt=""></a>
                    
                </ul>


     
                <ul class="navbar_menu">
                    <li class="navbar_menu_item">
                        <i class="fas fa-search"></i>
                    </li>
                    
                    <%
                    if(session.getAttribute("mem_id") != null){
                    %>
                    <li class="navbar_menu_item">
                        <a href="<%=request.getContextPath()%>/logout">
                            LogOut
                        </a>
                    </li>
                    
                    <%	
                    }else{
                    %>
                    <li class="navbar_menu_item">
                        <a href="<%=request.getContextPath()%>/showlogin">
                            LogIn
                        </a>
                    </li>
                    <%
                    }
                    %>
                    
                    <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdownMenuLink"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false">
                            English
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <a class="dropdown-item" href="#">Japan</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">China</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">Russian</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

    
    <!--main(description)-->
    <!-- slide effect -->
    <section class="main" id="main">
        <div
            id="carouselExampleFade"
            class="carousel slide carousel-fade"
            data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="<%=request.getContextPath() %>/imgs/main1.jpg" class="d-block w-100" alt="main1" >
                    <div class='slide__con'>
                        <div class="main_left">
                            <p class="main__tit">EXFOLIATING PEEL, EXCESS</p>
                            <p class="main__tail">PORE CARING + PEEL</p>
                        </div>
                        <p class="main__tag">NEW VOLCANIC
                            <br>
                            CALMING PORE CLAY
                            <br>
                            MASK
                        </p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="<%=request.getContextPath() %>/imgs/main2.jpg" class="d-block w-100" alt="main2" >
                    <div class='slide__con'>
                        <div class="main_left">
                            <p class="main__tit">Make up, Beauty</p>
                            <p class="main__tail">NATRURAL POWDER</p>
                        </div>
                        <p class="main__tag">POWDER MASKARA
                            <br>
                            RIPSTICK
                        </p>
                    </div>
                </div>
            </div>
            <button
                class="carousel-control-prev"
                type="button"
                data-bs-target="#carouselExampleFade"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button
                class="carousel-control-next"
                type="button"
                data-bs-target="#carouselExampleFade"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <!-- description -->

    </section>

    <!--insta(button)-->
    <!-- common sub -->
    <section class="innistar" id="innistar" >
        <div class="section_container" id="innistar" >
            <div class="common__head">
                <p class="common__head-tit">
                    <span class="innistar__head">Member </span>
                
                </p>
                <p class="common__head-tail">Management System</p>
            </div>

            <div class="insta__in">
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star1.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Anna@gmail.com</h3>
                        <span>5667457</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star2.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Joy@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star3.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Diana@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star4.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Angela@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star5.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Simon@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star6.jpg" alt="insta" class="insta_img" >
                    <div class="insta_description">
                        <h3>Josh@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star7.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Elie@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
                <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" class="project" target="_blank">
                    <img src="<%=request.getContextPath() %>/imgs/star8.jpg" alt="insta" class="insta_img">
                    <div class="insta_description">
                        <h3>Choi@gmail.com</h3>
                        <span>Clon coding</span>
                    </div>
                </a>
            </div>
            <a href="<%=request.getContextPath()%>/view/AdminViewMmeber" target="_blank">
                <button class="innistar__view">
                    <a href="<%=request.getContextPath()%>/view/AdminViewMmeber"><div class="view" >View more 
                        <i class="fas fa-arrow-down"></i></a>
                    </div>
                </button>
        </a>
        </div>
       
    </div>
</section>

<!--product(top/bottom)-->
<section class="product" id="product">
    <div class="section_container">
        <div class="common__head">
            <p class="common__head-tit">
                <span class="innistar__head">PRODUCT</span>
            </p>
            <p class="common__head-tail">Management System</p>
        </div>

            <div class="product__container">

            <div class="product__in-box1">
                <a href="<%=request.getContextPath()%>/view/AdminProduct1View">
                	<img src="<%=request.getContextPath() %>/imgs/pro1.jpg" alt="" class="product__img">
                </a>
                <p class="prodcuct__des">Clay Mask</p>
                <img src="<%=request.getContextPath() %>/imgs/pro2.jpg" class="product__img">
                <p class="prodcuct__des">serum</p>
            </div>
            <div class="product__in-box2">
                <a href="<%=request.getContextPath()%>/view/AdminProduct2View">
                	<img src="<%=request.getContextPath() %>/imgs/pro3.jpg" class="product__img big">
				</a>
                <p class="prodcuct__des">sunscreen</p>
            </div>
        
        </div>
        <a href="<%=request.getContextPath()%>/view/AdminProduct1View">
        <button class="product__buy">
            <div class="buy" >View product
                <i class="fas fa-arrow-right"></i>
            </div>
        </button>
    </a>
    </div>
</section>

<!--review(-slide page)-->
<section class="review" id="review">
    <div class="section_container">
        <div class="common__head">
            <p class="common__head-tit">
                <span class="innistar__head">REVIEW</span>
            </p>
            <p class="common__head-tail">Management System</p>
        </div>

<section id="iphone">
        <div class="phone">
            <div class="screen">
                <header>
                    <h1>회원님들의 실시간 사용후기</h1>
                </header>
                <div class="content-wrapper">
                    <div class="content">
                        <ol class="messages">
                            <li>
                                <p>ID: qwe87 </br> 몇번째 구매인지 몰라요 넘좋음!ㅎㅎㅎ </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: asd45 </br> 이거 쓰고 여드름 다 들어갔어요ㅠ 다들쓰세요 </br>Date: 2021.5.9</p>
                            </li>
                            <li>
                                <p>ID: jun64 </br> 세일기간에 저렴하게 구매했어요 잘맞았으면 좋겠네요. </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: choi87 </br> 7번째 구매입니다. 항상 칼배송이네요! 여기 제품은 말모..bbbb </br>Date: 2021.10.5</p>
                            </li>
                        
                            <li>
                                <p>ID: hasq87 </br> 몇번째 구매인지 몰라요 넘좋음!ㅎㅎㅎ </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: hanle5 </br> 이거 쓰고 여드름 다 들어갔어요ㅠ 다들쓰세요 </br>Date: 2021.5.9</p>
                            </li>
                            <li>
                                <p>ID: han64 </br> 세일기간에 저렴하게 구매했어요 잘맞았으면 좋겠네요. </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: sdfq87 </br> 7번째 구매입니다. 항상 칼배송이네요! 여기 제품은 말모..bbbb </br>Date: 2021.10.5</p>
                            </li>
                            <li>
                                <p>ID: s12x5 </br> 몇번째 구매인지 몰라요 넘좋음!ㅎㅎㅎ </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: seongmin </br> 이거 쓰고 여드름 다 들어갔어요ㅠ 다들쓰세요 </br>Date: 2021.5.9</p>
                            </li>
                            <li>
                                <p>ID: babo </br> 세일기간에 저렴하게 구매했어요 잘맞았으면 좋겠네요. </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: goza </br> 7번째 구매입니다. 항상 칼배송이네요! 여기 제품은 말모..bbbb </br>Date: 2021.10.5</p>
                            </li>
                            <li>
                                <p>ID: room </br> 몇번째 구매인지 몰라요 넘좋음!ㅎㅎㅎ </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: ouya </br> 이거 쓰고 여드름 다 들어갔어요ㅠ 다들쓰세요 </br>Date: 2021.5.9</p>
                            </li>
                            <li>
                                <p>ID: fds4 </br> 세일기간에 저렴하게 구매했어요 잘맞았으면 좋겠네요. </br>Date: 2021.3.2</p>
                            </li>
                            <li>
                                <p>ID: adfq7 </br> 7번째 구매입니다. 항상 칼배송이네요! 여기 제품은 말모..bbbb </br>Date: 2021.10.5</p>
                            </li>
                            
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <button class="innistar__view">
        <a href="<%=request.getContextPath()%>/review/reviewList?mem_id='admin'" target="_blank"><div class="view" >View more 
            <i class="fas fa-arrow-down"></i></a>
        </div>
    </button>
    </div>
</section>

<!--stock-->
<section class="news" id="news">
    <div class="section_container">
        <div class="common__head">
            <p class="common__head-tit">
                <span class="innistar__head">Stock & QnA</span>
            </p>
            <p class="common__head-tail">Management System</p>
        </div>

        <div class="news__container">
            <a href="<%=request.getContextPath() %>/noticeList" target="_blank">
            
             <img class="news__img" src="https://images.unsplash.com/photo-1556227996-370b60576b84?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80" alt="news__sale" >
                
            
            </a>

            
                    <a href="<%=request.getContextPath() %>/board/boardList" target="_blank">
                <img class="news__img" src="https://images.unsplash.com/photo-1531379410502-63bfe8cdaf6f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80" alt="news__sale" >
                
            </a>
            
        </div>
    </section>

    
    <!--store -->
    
    <div id="foot">
    <section class="store" id="store">
        <img src="<%=request.getContextPath() %>/imgs/store.jpg" alt="" class="store__img">

        <div class="store__box">
            <p class="store__box-title">NOTICE & FAQ</p>
            <p class="store__box-tail"> Management System </p>
            <p class="store__box-btn">
                <a href="<%=request.getContextPath()%>/noticeList" target="_blank">View more
                    <i class="fas fa-arrow-right" ></i>
                </a>
            </p>
        </div>

    </section>
    <!--footer -->
    <!-- Site footer -->
    <footer class="site-footer" id="about">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <h6>About</h6>
                    <p class="text-justify">Scanfcode.com
                        <i>CODE WANTS TO BE SIMPLE
                        </i>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. In, dolores et! Odio, totam. At distinctio sequi, sit iusto molestiae optio temporibus incidunt officiis a pariatur consectetur rerum molestias dolore excepturi.</p>
                </div>

                <div class="col-xs-6 col-md-3">
                    <h6>Categories</h6>
                    <ul class="footer-links">
                        <li>
                            <a href="http://scanfcode.com/category/c-language/">product</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/category/front-end-development/">review</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/category/back-end-development/">order</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/category/java-programming-language/">QnA</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/category/android/">notice</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/category/templates/">store</a>
                        </li>
                    </ul>
                </div>

                <div class="col-xs-6 col-md-3">
                    <h6>Quick Links</h6>
                    <ul class="footer-links">
                        <li>
                            <a href="http://scanfcode.com/about/">About Us</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/contact/">Contact Us</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/contribute-at-scanfcode/">Contribute</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/privacy-policy/">Privacy Policy</a>
                        </li>
                        <li>
                            <a href="http://scanfcode.com/sitemap/">Sitemap</a>
                        </li>
                    </ul>
                </div>
            </div>
            <hr>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-sm-6 col-xs-12">
                    <a href="../main/main.html"><p class="copyright-text">Customer Main  <i class="fas fa-arrow-right"></i>
                        
                    </p></a>
                </div>


                <div class="col-md-4 col-sm-6 col-xs-12">
                    <ul class="social-icons">
                        <li>
                            <a class="facebook" href="#">
                                <i class="fa fa-facebook"></i>
                            </a>
                        </li>
                        <li>
                            <a class="twitter" href="#">
                                <i class="fa fa-twitter"></i>
                            </a>
                        </li>
                        <li>
                            <a class="dribbble" href="#">
                                <i class="fa fa-dribbble"></i>
                            </a>
                        </li>
                        <li>
                            <a class="linkedin" href="#">
                                <i class="fa fa-linkedin"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>
</body>

</html>