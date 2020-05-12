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
                    <a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=香港小吃" id="current">全国人气小吃</a>
                
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/ranking_Page?operator=steam_of_people" >菜单排名</a>
                  
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


        
        
        <!-- Sidebar
            ================================================== -->
            <div class="container">
           
          
        </div>
        
        

        <!-- Content
         ================================================== -->
        <div class="container">
            <!-- Masonry -->
            <div class="twelve columns ">
                <!-- Headline -->
                <h3 class="headline">${sessionScope.sort01}</h3>
                <span class="line rb margin-bottom-35"></span>
                <div class="clearfix"></div>
                <!-- Isotope -->
                <div class="list-style">
                    <!-- Recipe #1 -->
               <c:forEach items="${sessionScope.foods_xc}" var="f">
                    <div class="four recipe-box columns">
                        <!-- Thumbnail -->
                        <div class="thumbnail-holder">
                            <a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">
                                <img src="${f.foodImg}" alt="" />
                                <div class="hover-cover"></div>
                                <div class="hover-icon">食谱做法</div>
                            </a>
                        </div>
                        <!-- Content -->
                        <div class="recipe-box-content">
                            <h3><a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">${f.foodName}</a></h3>
                            <p>${f.upload_user}  上传</p>
                            <div class="rating five-stars">
                                <div class="star-rating"></div>
                                <div class="star-bg"></div>
                            </div>
                            <div class="meta-alignment">
                            	<div class="recipe-meta"><i class="fa fa-clock-o"></i>人气值：${f.hot_degree} </div>
                                <div class="recipe-meta"><i class="fa fa-clock-o"></i>${f.time}</div>
                               
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
               </c:forEach>
                    </div>
                    <div class="clearfix"></div>
                <!-- Pagination -->
                <div class="pagination-container masonry">
                    <nav class="pagination">
                        <ul>
                            <li><a href="#" class="current-page">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
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
                
              <div class="four columns">
              
              <!-- Search Form -->
	      <div class="widget search-form">
		      <nav class="search">
			   <form action="<%=request.getContextPath() %>/country_food?operator=search02&sort=${sessionScope.sort01}" method="post">
				
               	 	<input class="search-field" type="text" placeholder="请输入食谱/食材" value="" name="sort01"/>
			   		<input  type="submit" class="fa fa-search" value="搜索"/>
			   </form>
		     </nav>
		    <div class="clearfix"></div>
	      </div>
              
                <h3 class="headline">分类</h3><span class="line margin-bottom-35"></span><div class="clearfix"></div>
                <!-- Accordion -->
              
                <div class="accordion">
                    <!-- Section 1 -->
                   <h3><span class="ui-accordion-header-icon ui-icon ui-accordion-icon"></span>全国小吃</h3>
                    <div>
                        <nav class="pagination">
                            <ul>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=安徽小吃">安徽小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=福建小吃">福建小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=甘肃小吃">甘肃小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=广东小吃">广东小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=贵州小吃">贵州小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=海南小吃">海南小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=河北小吃">河北小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=广西小吃">广西小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=湖北小吃">湖北小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=湖南小吃">湖南小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=吉林小吃">吉林小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=江苏小吃">江苏小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=江西小吃">江西小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=辽宁小吃">辽宁小吃</a></li> 
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=宁夏小吃">宁夏小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=青海小吃">青海小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=山东小吃">山东小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=陕西小吃">陕西小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=山西小吃">山西小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=上海小吃">上海小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=四川小吃">四川小吃</a></li>                            
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=台湾小吃">台湾小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=天津小吃">天津小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=西藏小吃">西藏小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=香港小吃">香港小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=新疆小吃">新疆小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=云南小吃">云南小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=浙江小吃">浙江小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=重庆小吃">重庆小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=黑龙江小吃">黑龙江小吃</a></li>
                                <li><a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=内蒙古小吃">内蒙古小吃</a></li>
                            </ul>
                        </nav>
                    </div>
                    
                </div>
                <!-- Accordion / End -->
            </div>
                
            </div>

            

        </div>
        <!-- Container / End -->
        <div class="margin-top-5"></div>

    </div>
    <!-- Wrapper / End -->
    <!-- Footer
    ================================================== -->
    <div id="footer">
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
    <div id="footer-bottom">
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