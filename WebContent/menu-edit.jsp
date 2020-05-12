﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>

<!-- Basic Page Needs
================================================== -->
<meta charset="utf-8">
<title>“食”全“食”美</title>

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


<!-- Navigation
================================================== -->
    <div class="thirteen columns navigation">
        <nav id="navigation" class="menu nav-collapse">
            <ul>
       
            </ul>
        </nav>
    </div>

</div>
<!-- Container / End -->
</header>


<!-- Titlebar
================================================== -->



<!-- Content
================================================== -->
<div class="container">
	<div class="sixteen columns">
		<div class="submit-recipe-form">

	<form action="<%=request.getContextPath() %>/adminServlet?operator=Old_Food_Save&foodname=${sessionScope.food_edit.foodName }" method="post">
			<!-- Recipe Title -->
			<h4>菜谱名称</h4>
			<nav class="title">
				<h5>${sessionScope.food_edit.foodName }</h5>
			</nav>
			<div class="clearfix"></div>


			<div class="margin-top-25"></div>


			<!-- Choose Category -->
			<div class="select">
				<h4>输入类别</h4>
				<input class="search-field" name="foodtype" type="text" value="${sessionScope.food_edit.sort }"/>
			</div>


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
						<td><input name="material1" tabindex="6" type="text"  value="${sessionScope.food_edit.material1 }"/> </td>
						<td><input name="material2" tabindex="6" type="text"  value="${sessionScope.food_edit.material2 }"/></td>
						<td><input name="material3" tabindex="6" type="text"  value="${sessionScope.food_edit.material3 }"/></td>					
						<td><input name="material4" tabindex="6" type="text"  value="${sessionScope.food_edit.material4 }"/></td>
						<td><input name="material5" tabindex="6" type="text"  value="${sessionScope.food_edit.material5 }"/></td>
					</tr>
				</table>

				
			</fieldset>


			<div class="margin-top-25"></div>


			<!-- Directions -->
			<h4>食谱制作步骤</h4>
 					<tr class="ingredients-cont">
					<td class="label"><label for="9">制作步骤一</label></td>
					<td><input name="step1" id="4" type="text" value="${sessionScope.food_edit.step1 }"/></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤二</label></td>
					<td><input name="step2" id="4" type="text" value="${sessionScope.food_edit.step2 }"/></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤三</label></td>
					<td><input name="step3" id="4" type="text" value="${sessionScope.food_edit.step3 }"/></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤四</label></td>
					<td><input name="step4" id="4" type="text" value="${sessionScope.food_edit.step4 }"/></td>
				</tr>
					<tr class="ingredients-cont">
					<td class="label"><label for="4">制作步骤五</label></td>
					<td><input name="step5" id="4" type="text" value="${sessionScope.food_edit.step5 }"/></td>
				</tr>

			<div class="margin-top-25 clearfix"></div>

			<!-- Additional Informations -->
				<h4>补充资料</h4>

			<fieldset class="additional-info">
				<table>

				<td class="label"><label for="2">烹饪时间</label></td>
					<td><input id="2" name="time" type="text" value="${sessionScope.food_edit.time }"/></td>

				</table>
			</fieldset>

			<div class="margin-top-25"></div>

			<div class="margin-top-30"></div>
			<input type="submit" value="修改菜谱" class="button color big">
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
    <!-- Footer / End -->

<!-- Footer Bottom / Start -->
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