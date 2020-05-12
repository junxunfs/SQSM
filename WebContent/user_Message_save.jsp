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
    <title>“食”全“食”美</title>

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="css/mestyle.css">
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
			                  <a href="<%=request.getContextPath()%>/ranking_Page?operator=steam_of_people">菜单排名</a>
			                
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


        <!-- Titlebar
        ================================================== -->
        <section id="titlebar">
            <!-- Container -->
            <div class="container">

                <div class="eight columns">
                    <h2>我的美食空间</h2>
                </div>

                <div class="eight columns">
                    
                </div>

            </div>
            <!-- Container / End -->
        </section>



        <!-- Content
        ================================================== -->


        <div class="container">

           <!-- Slider
            ================================================== -->
             <div class="five columns">
           
                <div class="productSlider rsDefault">
                    <img class="rsImg" src="images/product_01.jpg" alt="" />
                </div>
                <div class="clearfix"></div>
            </div> 


            <!-- Content
            ================================================== -->
            <div class="eleven columns">
                <div class="product-page">

                    <!-- Headline -->
                    <section class="title">
                        <h1>账号：${sessionScope.user.username }</h1>
                        <!--<span class="product-price">$2.99</span>-->
                        <div class="focus">
                            <a href="#small-dialog" class="popup-with-zoom-anim button margin-left-0">更改信息</a>
                        </div>
                      
                    </section>

                    <!-- Text Parapgraph -->
                    <section>
                        <p class="margin-reset">真实姓名：${sessionScope.user.realname }</p>
                        <p class="margin-reset">性别：${sessionScope.user.sex}</p>
                        <p class="margin-reset">年龄: ${sessionScope.user.age}</p>
                    </section>
                    <section>
                        <p style="color:#606060;">${sessionScope.user.message }</p>
                    </section>


                   

                </div>
            </div>
        </div>
        <script type="text/javascript">
	       $(function() {
	    	   alert($('#mess').text());
	       })
        </script>

        <div id="small-dialog" class="zoom-anim-dialog mfp-hide">
            <h3 class="headline">修改个人信息</h3><span class="line margin-bottom-25"></span><div class="clearfix"></div>

            <!-- Form 信息修改界面-->
            <form id="add-comment" class="add-comment" action="<%=request.getContextPath()%>/message_Edit?operator=update_message" method="post">
                <fieldset>
                    <div>
                        <label>真实姓名:<span>*</span></label>
                        <input type="text" value="${sessionScope.user.realname }" name="realname" />
                    </div>

                    <div>
                        <label>性别: <span>*</span></label>
                        <input type="radio" name="sex" value="男" ${sessionScope.user.sex.trim().equals("男")?"checked":""}>男
                        <input type="radio" name="sex" value="女" ${sessionScope.user.sex.trim().equals("女")?"checked":""}>女
                    </div>
                    <div class="margin-top-20">
                        <label>年龄: <span>*</span></label>
                        <input type="text" value="${sessionScope.user.age}" name="age" />
                    </div>

                    <div>
                        <label>描述: <span>*</span></label>
                        <textarea cols="20" rows="3" name="mess" id="mess">${sessionScope.user.message}</textarea>
                    </div>

                </fieldset>

                <input type="submit" class="button color"/>
                <div class="clearfix"></div>
            </form>

        </div>

        <!--</section>-->


        <div class="clearfix"></div>
        <div class="margin-top-30"></div>


        <div class="container">
            <div class="sixteen columns">
                <!-- Tabs Navigation -->
                <ul class="tabs-nav">
                    <li ><a href="<%=request.getContextPath()%>/message_Edit?operator=show_mess_upload">菜谱作品</a></li>
                    <li class="active"><a href="<%=request.getContextPath()%>/message_Edit?operator=show_mess_save">菜谱收藏</a></li>
                    
                </ul>

                <!-- Tabs Content -->
                <div class="tabs-container">

                    <div class="tab-content" id="tab1">
                        <!-- Related Products -->
                        <div class="container margin-top-5">
   						<c:forEach items="${sessionScope.foods}" var="f">
                            <!-- Products -->
                            <div class="products">

                                <!-- Product #1 -->
                        
                                <div class="four columns">
                                    <figure class="product">
                                        <div class="mediaholder">
                                            <a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">
                                                <img alt="" src="${f.foodImg }" />
                                            </a>
                                            
                                        </div>
                                        <a href="<%=request.getContextPath()%>/page_Detail?operator=page&foodname=${f.foodName}">
                                            <section>
                                                <h5>${f.foodName }</h5>
                                                <span class="product-category">人气值：${f.hot_degree}</span>
                                                <span class="product-category">时间：${f.time }</span>
                                            </section>
                                        </a>  
                                    </figure>
                                    <a href="<%=request.getContextPath()%>/message_Edit?operator=delete_save&foodname_delete=${f.foodName}">取消收藏</a>
                                </div>
                                 <div class="sixteen columns">
		                                <span class="line margin-bottom-0"></span>
		                        </div>
                            </div>
                            
                         </c:forEach>  
                         
                        </div>                             
                    </div>               
        
                </div>
            </div>
        </div>


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
                    <h1><a href="index.html"><img src="images/logo.png" alt="Chow" /></a></h1>
                </div>
            </div>
            <div class="three columns">
                <!-- Headline -->
                <h3 class="headline footer">食谱档案</h3>
                <span class="line"></span>
                <div class="clearfix"></div>
                <ul class="footer-links">
                    <li><a href="#">2018.11</a></li>
                    <li><a href="#">2018.12</a></li>
                    <li><a href="#">2019.01</a></li>
                    <li><a href="#">2019.02</a></li>
                    <li><a href="#">2019.03</a></li>
                </ul>
            </div>
            <div class="three columns">
                <!-- Headline -->
                <h3 class="headline footer">友情连接</h3>
                <span class="line"></span>
                <div class="clearfix"></div>
                <ul class="footer-links">
                    <li><a href="http://www.meishichina.com">美食天下</a></li>
                    <li><a href="http://www.zhms.cn">中华美食网</a></li>
                    <li><a href="http://food.39.net">39健康饮食</a></li>
                    <li><a href="https://www.meishij.net/">美食杰</a></li>
                </ul>
            </div>
            <div class="five columns">
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

            <div class="eight columns">© Copyright 2014 by <a href="#">Chow</a>. All Rights Reserved.</div>

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