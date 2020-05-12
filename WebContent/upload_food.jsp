<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/colors/red.css" id="colors">

<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>

<body class="overflow-reset">

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
                    <a href="<%=request.getContextPath()%>/ranking_Page?operator=steam_of_people" >菜单排名</a>
                  
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/health_food?operator=jianfei">健康食谱</a>
                  
                </li>
                
                <li><a href="upload_food.jsp" id="current">上传菜单</a></li>
            	<li> &nbsp;&nbsp;&nbsp;</li>
                <li style="font-size: 10px !important;"><a href="Login.jsp">注册</a></li>
                <li style="font-size: 10px !important;"><a href="Login.jsp">登陆</a></li>
            </ul>
        </nav>
    </div>
</div>
<!-- Container / End -->
</header>


<!-- Titlebar
================================================== -->
<section id="titlebar">
	<!-- Container -->
	<div class="container">

		<div class="eight columns">
			<h2>上传菜谱</h2>
		</div>

	</div>
	<!-- Container / End -->
</section>



<!-- Content
================================================== -->
<div class="container">
	<div class="sixteen columns">
		<div class="submit-recipe-form">

		<form action="<%=request.getContextPath() %>/uploadFood?operator=AddFood" method="post">
			<!-- Recipe Title -->
			<h4>菜谱名称</h4>
			<nav class="title">
				<input class="search-field" name="food_name" type="text" placeholder="" value=""/>
			</nav>
			<div class="clearfix"></div>


			<div class="margin-top-25"></div>


			<!-- Choose Category -->
			<div class="select">
				<h4>输入类别</h4>
				<input class="search-field" name="food_type" type="text" placeholder="家常菜、甜品、小吃" value=""/>
			</div>


			<div class="margin-top-25"></div>

			<div class="margin-top-25"></div>


			<!-- Upload Photos -->
			<h4>上传你的照片</h4>

			<ul class="recipe-gallery">
				<li>尚未上传照片</li>
			</ul>

			<label class="upload-btn">
			    <input type="file" multiple />
			    <i class="fa fa-upload"></i> 上传
			</label>


			<div class="clearfxix"></div>
			<div class="margin-top-15"></div>


			<!-- Ingredients -->
			<fieldset class="addrecipe-cont" name="ingredients">
				<h4>食材:</h4>

				<table id="ingredients-sort">

					<tr class="ingredients-cont ing">
						<!-- <td class="icon"><i class="fa fa-arrows"></i></td> -->
						<td><input name="material1" tabindex="5" type="text" placeholder="食材一" /> </td>
						<td><input name="material2" tabindex="6" type="text" placeholder="食材二" /></td>
						<td><input name="material3" tabindex="6" type="text" placeholder="食材三" /></td>					
						<td><input name="material4" tabindex="6" type="text" placeholder="食材四" /></td>
						<td><input name="material5" tabindex="6" type="text" placeholder="食材五" /></td>
					</tr>
				</table>

				
			</fieldset>


			<div class="margin-top-25"></div>


			<!-- Directions -->
			<h4>食谱制作步骤</h4>
 					<tr class="ingredients-cont">
					<td class="label"><label for="9">制作步骤一</label></td>
					<td><input name="step1" id="4" type="text" /></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤二</label></td>
					<td><input name="step2" id="4" type="text" /></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤三</label></td>
					<td><input name="step3" id="4" type="text" /></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤四</label></td>
					<td><input name="step4" id="4" type="text" /></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤五</label></td>
					<td><input name="step5" id="4" type="text" /></td>
				</tr>

			<div class="margin-top-25 clearfix"></div>


			<!-- Additional Informations -->
			<h4>补充资料</h4>

			<fieldset class="additional-info">
				<table>

				<td class="label"><label for="2">烹饪时间</label></td>
					<td><input id="2" name="time" type="text" /></td>

				</table>
			</fieldset>

			<div class="margin-top-25"></div>

			<div class="margin-top-30"></div>
			<input type="submit" value="上传菜谱" class="button color big">
			</form>
		</div>
	</div>
</div>
<!-- Container / End -->

<div class="margin-top-50"></div>

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
<script src="scripts/jquery-ui.min.js"></script>
<script src="scripts/custom.js"></script>


<!-- WYSIWYG Editor -->
<script type="text/javascript" src="scripts/jquery.sceditor.bbcode.min.js"></script>
<script type="text/javascript" src="scripts/jquery.sceditor.js"></script>




</body>
</html>