<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <!--information css-->
    <link href="css/site.css" rel="stylesheet" type="text/css" />
    
    
    
   



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
		                <li><a href="<%=request.getContextPath()%>/login?operator=foodServlet " >首页</a></li>
		                <li>
		                    <a href="<%=request.getContextPath()%>/country_food?operator=ranking&sort=香港小吃">菜谱大全</a>
		                
		                </li>
		                <li>
		                    <a href="<%=request.getContextPath()%>/ranking_Page?operator=steam_of_people">菜单排名</a>
		                  
		                </li>
		                <li>
		                    <a href="<%=request.getContextPath()%>/health_food?operator=jianfei" id="current">健康食谱</a>
		    
		                </li>
		              
		                <li><a href="upload_food.jsp">上传菜单</a></li>
		              
                            <li>&emsp;&emsp;</li>
                            <li style="font-size: 10px !important;"><a href="Login.jsp">注册</a></li>
                            <li style="font-size: 10px !important;"><a href="Login.jsp">登陆</a></li>
                        </ul>
		            </ul>
		        </nav>
    </div>
            </div>
            <!-- Container / End -->
        </header>



        <!--information-->
        <section id="titlebar" class="browse-all">
            <!-- Container -->
            <div class="container">
                <div class="sixteen columns">
                    <h1>健康资讯</h1>
                </div>
            </div>
            <!-- Container / End -->
        </section>
        <div class="advanced-search-container">
            <div class="container">
                <div class="sixteen columns">
                    <!-- Tabs Navigation -->
                    <ul class="demo2 news-item">

                        <li><a href="https://www.tech-food.com/news/detail/n1426637.htm">水果减肥不可取，减肥期间为什么不推荐吃水果</a></li>

                        <li><a href="https://www.tech-food.com/news/detail/n1426533.htm">CFT2019年5月17日东北地区玉米价格行情</a></li>

                        <li><a href="https://www.tech-food.com/news/detail/n1426476.htm">“人造肉”概念股大爆发！中国会迎来人造肉时代吗？</a></li>

                        <li><a href="https://www.tech-food.com/news/detail/n1426450.htm">大蒜即将大量上市 后期价格有望突破3元/斤</a></li>

                        <li><a href="https://www.tech-food.com/news/detail/n1426230.htm">外卖健康证乱象源于违法成本低</a></li>

                        <li><a href="https://www.tech-food.com/news/detail/n1426231.htm">福州人吃不起荔枝？ 每500克售价14元至25元未现高价</a></li>
						 <li><a href="https://www.tech-food.com/news/detail/n1426267.htm">统计局回应水果涨价 不会持续</a></li>
						  <li><a href="https://www.tech-food.com/news/detail/n1426444.htm">2019年5月17日生猪价格走势表 今日猪价行情整体震荡偏弱调整</a></li>
						   <li><a href="https://www.tech-food.com/news/detail/n1426609.htm">发改委回应猪肉涨价：后期可能会有一定幅度上涨</a></li>


                    </ul>

                </div>
            </div>
        </div>
        <!--information end-->


        <!-- Container -->
        <section id="titlebar" class="browse-all">
            <!-- Container -->
            <div class="container">
                <div class="sixteen columns">
                    <h1>热门健康膳食</h1>
                </div>
            </div>
            <!-- Container / End -->
        </section>
        
        <div class="advanced-search-container">
            <div class="container">
                <div class="sixteen columns">
                    <!-- Tabs Navigation -->
                    <ul class="tabs-nav">
                        <li><a href="<%=request.getContextPath()%>/health_food?operator=jianfei"><font color=858585>减肥</font></a></li>
                        <li><a href="<%=request.getContextPath()%>/health_food?operator=shimian">失眠</a></li>
                        <li><a href="<%=request.getContextPath()%>/health_food?operator=buqi">补气 </a></li>
                        <li><a href="<%=request.getContextPath()%>/health_food?operator=buxue">补血</a></li>
                    
                    </ul>
                   
                </div>
            </div>
        </div>
        
        
    
        <div class="margin-top-35"></div>

        <!-- Content
     ================================================== -->

        <!-- Related Products -->
        <div class="container margin-top-5">
            <!-- Headline -->
            <div class="sixteen columns">
                
                <span class="line margin-bottom-0"></span>
            </div>
            <!-- Products -->
            <div class="products">
                <!-- Product #1 -->
                <c:forEach items="${sessionScope.food_health }" var="f">
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
                                <span class="product-category">${f.hot_degree }</span>
                                <span class="product-price">上传者:${f.upload_user}</span>
                            </section>
                        </a>
                    </figure>
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
        <div class="margin-top-50"></div>

    </div>

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


    


    <!--information js-->
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js" type="text/javascript"></script>

    <script src="js/jquery.bootstrap.newsbox.min.js" type="text/javascript"></script>

    <script type="text/javascript">

        $(function () {

            $(".demo2").bootstrapNews({

                newsPerPage: 4,

                autoplay: true,

                pauseOnHover: true,

                navigation: false,

                direction: 'down',

                newsTickerInterval: 2500,

                onToDo: function () {

                    //console.log(this);

                }

            });

        });

    </script>
</body>
</html>