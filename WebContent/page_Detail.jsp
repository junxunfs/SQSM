<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
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
<link rel="stylesheet" href="css/colors/green.css" id="colors">

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
			<h1><a href="Index.jsp"><img src="images/logo.png" alt="Chow" /></a></h1>
		</div>
	</div>


<!-- Navigation  导航
================================================== -->
 <div class="ten columns navigation">
        <nav id="navigation" class="menu nav-collapse">
            <ul>
                <li><a href="<%=request.getContextPath()%>/login?operator=foodServlet" >首页</a></li>
                <li>
                    <a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=香港小吃">全国人气小吃</a>
                
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
             <p style="text-align:right">歡迎<a href="<%=request.getContextPath()%>/message_Edit?operator=show_mess_upload">&nbsp;${sessionScope.user.username }&nbsp;</a>進入</p>
            
        </nav>
    </div>

</div>
<!-- Container / End -->
</header>


<!-- Recipe Background -->
<div class="recipeBackground">
	<img src="images/recipeBackground.jpg" alt="" />
</div>


<!-- Content
================================================== -->
<div class="container" itemscope itemtype="http://schema.org/Recipe">

	<!-- Recipe -->
	<div class="twelve columns">
	<div class="alignment">

		<!-- Header -->
		<section class="recipe-header">
			<div class="title-alignment">
				<h2>${food_one.foodName}</h2>
				<div class="rating five-stars">
					<div class="star-rating"></div>
					<div class="star-bg"></div>
				</div>
				<span><a href="#reviews">(4 条评论)</a></span>
			</div>
		</section>
		

		<!-- Slider 美食图片-->
		<div class="recipeSlider rsDefault">
		    <img itemprop="image" class="rsImg" src="${food_one.foodImg}" alt="" />
		    <img itemprop="image" class="rsImg" src="${food_one.foodImg}" alt="" />
		</div>


		<!-- Details -->
		<section class="recipe-details" itemprop="nutrition">
			<ul>
				<li>人气值 <strong itemprop="recipeYield">${food_one.hot_degree}</strong></li>
				<li>烹饪时间 <strong itemprop="cookTime">${food_one.time}</strong></li>
				<li>上传者 <strong itemprop="calories">${food_one.upload_user}</strong></li>
			</ul>
			<a href="#" class="print"><i class="fa fa-print"></i> 导出Excel</a>
			<a href="<%=request.getContextPath()%>/page_Detail?operator=save&foodname=${food_one.foodName}" class="print"><i class="fa fa-print"></i>收藏该菜谱</a>
			<div class="clearfix"></div>
		</section>

		<!-- Ingredients -->
		<h3>食材明细</h3>
		<ul class="ingredients">
			<li>
				<input id="check-1" type="checkbox" name="check" value="check-1">
				<label itemprop="ingredients" for="check-1">${food_one.material1}</label>
			</li>

			<li>
				<input id="check-2" type="checkbox" name="check" value="check-2">
				<label itemprop="ingredients" for="check-2">${food_one.material2}</label>
			</li>

			<li>
				<input id="check-3" type="checkbox" name="check" value="check-3">
				<label itemprop="ingredients" for="check-3">${food_one.material3}</label>
			</li>

			<li>
				<input id="check-4" type="checkbox" name="check" value="check-4">
				<label itemprop="ingredients" for="check-4">${food_one.material4}</label>
			</li>

			<li>
				<input id="check-5" type="checkbox" name="check" value="check-5">
				<label itemprop="ingredients" for="check-5">${food_one.material5}</label>
			</li>

			
		</ul>


		<!-- Directions -->
		<h3>做法</h3>
		<ol class="directions" itemprop="recipeInstructions">
			<li >${food_one.step1}</li>
			<li>${food_one.step2}</li>
			<li>${food_one.step3}</li>
			<li>${food_one.step4}</li>
			<li>${food_one.step5}</li>
		</ol>


		<!-- Share Post -->
		<ul class="share-post">
			<li ><a class="twitter-share">${food_one.hot_degree}人收藏</a></li>
		
		</ul>
		<div class="clearfix"></div>



		<div class="margin-bottom-40"></div>


		<!-- Headline -->
 		<h3 class="headline">你 可 能 还 会 喜 欢</h3>
		<span class="line margin-bottom-35"></span>
		<div class="clearfix"></div>

		<div class="related-posts">
		<!-- Recipe #1 -->
		<c:forEach items="${sessionScope.food_tj }" var="f"> 
			<div class="four recipe-box columns">

				<!-- Thumbnail -->
			
				<div class="thumbnail-holder">
					<a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">
						<img src="${f.foodImg}" alt=""/>
						<div class="hover-cover"></div>
						<div class="hover-icon">View Recipe</div>
					</a>
				</div>

				<!-- Content -->
				<div class="recipe-box-content">
					<h3><a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">${f.foodName}</a></h3>
					
					<div class="rating five-stars">
						<div class="star-rating"></div>
						<div class="star-bg"></div>
					</div>

					<div class="recipe-meta"><i class="fa fa-clock-o"></i> ${f.time}</div>

					<div class="clearfix"></div>
				</div>
			</div>
			</c:forEach>	

			

		
		</div>
		<div class="clearfix"></div>


		<div class="margin-top-15"></div>



	</div>
	</div>


<!-- Sidebar
================================================== -->
<div class="four columns">

	<!-- Search Form -->
	<div class="widget search-form">
		<nav class="search">
			<form action="<%=request.getContextPath() %>/page_Detail?operator=search01&foodname=${sessionScope.foodname01}" method="post">
				<input class="search-field" type="text" placeholder="请输入菜谱/食材" value="" name="foodname01"/>
				<input class="fa fa-search" type="submit" value="搜索"/>
			</form>
		</nav>
		<div class="clearfix"></div>
	</div>


	<!-- Author Box 作者介绍-->
	<div class="widget">
		<div class="author-box">  
     
		<h2 class="title">${sessionScope.upload_User.username}</h2> 
            <p>真实姓名：${sessionScope.upload_User.realname}</p>
            <p>性别：${sessionScope.upload_User.sex}</p>
            <p>年龄：${sessionScope.upload_User.age}</p>
             <p>描述：${sessionScope.upload_User.message}</p>
		</div>
	</div> 


	<!-- Popular Recipes 热门食谱-->
	<div class="widget">
		<h4 class="headline">热门食谱</h4>
		<span class="line margin-bottom-30"></span>
		<div class="clearfix"></div>
		
		<!-- Recipe #1 -->
		<c:forEach items="${sessionScope.food_hot}" var="f">
		<a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}" class="featured-recipe">
			<img src="${f.foodImg}" alt="">

			<div class="featured-recipe-content">
				<h4>${f.foodName}</h4>
			
				<div class="rating five-stars">
					<div class="star-rating"></div>
					<div class="star-bg"></div>
				</div>
			</div>
			<div class="post-icon"></div>
		</a>
		</c:forEach>
		
		<div class="clearfix"></div>
	</div>


</div>


</div>
<!-- Container / End -->


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
            <div class="eight columns">© Copyright 2019 by <a href="#">"食"全"食"美</a>. All Rights Reserved.</div>
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