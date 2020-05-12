<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
 <!--<![endif]-->
<head>

    <!-- Basic Page Needs
    ================================================== -->
    <meta charset="utf-8">
    <title>"食"全"食"美</title>

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/colors/red.css" id="colors">

    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Wrapper -->
    <div id="wrapper">


        <!-- Header
        ================================================== -->
         <header id="header">

            <!-- Container -->
            <div class="container">

                <!-- Logo / Mobile Menu -->
                <div class="three columns">
                    <div id="logo">
                        <h1><a href="index.html"><img src="images/logo.png" alt="Chow" /></a></h1>
                    </div>
                </div>


                <!-- Navigation
                ================================================== -->
                <div class="ten columns navigation">
        <nav id="navigation" class="menu nav-collapse">
            <ul>
                <li><a href="<%=request.getContextPath()%>/login?operator=foodServlet" >首页</a></li>
                <li>
                    <a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=香港小吃">全国人气小吃</a>
                
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/ranking_Page?operator=steam_of_people" id="current">菜单排名</a>
                  
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/health_food?operator=jianfei">健康食谱</a>
                  
                </li>
                
                <li><a href="upload_food.jsp">上传菜单</a></li>
            	<li> &nbsp;&nbsp;&nbsp;</li>
                <li style="font-size: 10px !important;"><a href="Login.jsp">注册</a></li>
                <li style="font-size: 10px !important;"><a href="Login.jsp">登陆</a></li>
            </ul>
        </nav>
    </div>
  </div>
            <!-- Container / End -->
 </header>
        <!-- Container -->
        <section id="titlebar" class="browse-all">
            <!-- Container -->
            <div class="container">
                <div class="sixteen columns">
                    <h1>菜谱排行</h1>
                </div>
            </div>
            <!-- Container / End -->
        </section>
        <div class="advanced-search-container">
            <div class="container">
                <div class="sixteen columns">
                    <!-- Tabs Navigation -->
                     <ul class="tabs-nav">
                        <li><a href="<%=request.getContextPath()%>/ranking_Page?operator=hot_week"><font color=858585>北京家常菜</font></a></li>
                        <li><a href="<%=request.getContextPath()%>/ranking_Page?operator=steam_of_people">广州家常菜</a></li>
                        <li id="current"><a href="<%=request.getContextPath()%>/ranking_Page?operator=show">节目菜单（向往的生活）</a></li>
                        <li ><a href="<%=request.getContextPath()%>/ranking_Page?operator=tianpin">甜品面包</a></li>
                    </ul>

                </div>
            </div>
        </div>

        <div class="margin-top-35"></div>
        <!-- Content
        ================================================== -->
        <div class="container">

            <!-- Masonry -->
            <div class="twelve columns">

                <!-- Headline -->
                <h3 class="headline">大众点评人气菜谱分析</h3>
                <span class="line rb margin-bottom-35"></span>
                <div class="clearfix"></div>

                <!-- Isotope -->
                <div class="list-style">

                   <c:forEach items="${sessionScope.food_ranking}" var="f">
                    <div class="four recipe-box columns">            
                        <div class="thumbnail-holder">
                            <a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">
                                <img src="${f.foodImg}" alt="" />
                                <div class="hover-cover"></div>
                                <div class="hover-icon">食谱做法</div>
                            </a>
                        </div>
                     
                        <div class="recipe-box-content">
                            <h3><a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">${f.foodName}</a></h3>
                            <p>${f.upload_user} 上传</p>
                            <div class="rating five-stars">
                                <div class="star-rating"></div>
                                <div class="star-bg"></div>
                            </div>
                            <div class="meta-alignment">               
                                <div class="recipe-meta"><i class="fa fa-clock-o"></i>${f.time}</div>
                         	    <div class="recipe-meta"><i class="fa fa-clock-o"></i>人气值：${f.hot_degree}</div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                   </c:forEach>

                </div>
                <div class="clearfix"></div>

                <!-- Pagination -->
                <div class="pagination-container masonry">
                    <nav class="pagination">
                        <ul>
                           <%
				if(request.getAttribute("pageCount")!=null){
					int count=(Integer)request.getAttribute("pageCount");
					for(int i=1;i<=count;i++){
				%>
					<a href="<%=request.getContextPath()%>/userServlet?operator=queryUserByPage&pageNum=<%=i%>"><%=i%></a>&nbsp;&nbsp;
				<% 
					}
				}
				%>
                        </ul>
                    </nav>

                    <nav class="pagination-next-prev">
                        <ul>
                            <li><a href="#" class="prev"></a></li>
                            <li><a href="#" class="next"></a></li>
                        </ul>
                    </nav>
                </div>

            </div>


            <!-- Sidebar
            ================================================== -->
           
        <!-- Container / End -->

        <div class="margin-top-5"></div>


    </div>
    <!-- Wrapper / End -->
    <!-- Footer
        ================================================== -->
    <div>
        <!-- Container -->
        <div class="container">
            <div class="five columns">
                <!-- Headline -->
                <div>
                    <h1><a href="Index.jsp"><img src="images/logo.png" alt="Chow" /></a></h1>
                </div>
            </div>
           
            <div class="five columns">
                <!-- Headline -->
                <h3 class="headline footer">友情链接</h3>
                <span class="line"></span>
                <div class="clearfix"></div>
                <ul class="footer-links">
                    <li><a href="http://www.meishichina.com">美食天下</a></li>
                    <li><a href="http://www.zhms.cn">中华美食网</a></li>
                    <li><a href="http://food.39.net">39健康饮食</a></li>
                    <li><a href="https://www.meishij.net/">美食杰</a></li>
                </ul>
            </div>
            <div class="six columns">
                <!-- Headline -->
                <h3 class="headline footer">联系我们</h3>
                <span class="line"></span>
                <div class="clearfix"></div>
                <p>一日三餐不可随意对付！<br />为食而生，精致生活！</p>
                <form action="#" method="get">
                    <button class="newsletter-btn" type="submit">广告合作</button>
                </form>
            </div>
        </div>
        <!-- Container / End -->
    </div>
    <!-- Footer / End -->
    <!-- Footer Bottom / Start -->
    <div>

        <!-- Container -->
        <div class="container">

            <div class="eight columns">© Copyright 2019 by <a href="#">十全十美</a>. All Rights Reserved.</div>

        </div>
        <!-- Container / End -->

    </div>
    <!-- Footer Bottom / End -->
    <!-- Back To Top Button -->
    <div id="backtotop"><a href="#"></a></div>



    <!-- Java Script
    ================================================== -->
    <script src="scripts/jquery-1.11.0.min.js"></script>
    <script src="scripts/jquery-migrate-1.2.1.min.js"></script>
    <script src="scripts/jquery.superfish.js"></script>
    <script src="scripts/jquery.royalslider.min.js"></script>
    <script src="scripts/responsive-nav.js"></script>
    <script src="scripts/hoverIntent.js"></script>
    <script src="scripts/isotope.pkgd.min.js"></script>
    <script src="scripts/chosen.jquery.min.js"></script>
    <script src="scripts/jquery.tooltips.min.js"></script>
    <script src="scripts/jquery.magnific-popup.min.js"></script>
    <script src="scripts/jquery.pricefilter.js"></script>
    <script src="scripts/custom.js"></script>


 


</body>
</html>