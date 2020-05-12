<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />
  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	
	
	<link rel="stylesheet" href="./css/animate.css">
	
	<link rel="stylesheet" href="./css/icomoon.css">
	
	<link rel="stylesheet" href="./css/themify-icons.css">
	
	<link rel="stylesheet" href="./css/bootstrap.css">

	
	<link rel="stylesheet" href="./css/magnific-popup.css">

	
	<link rel="stylesheet" href="./css/owl.carousel.min.css">
	<link rel="stylesheet" href="./css/owl.theme.default.min.css">

	
	<link rel="stylesheet" href="./css/style2.css">

	
	<script src="../js/modernizr-2.6.2.min.js"></script>
	
    
        
	</head>
	<body>
	
	<script >
	var xmlhttp;
	function checkUsername(){
		var username= document.getElementById("username_signup").value;
		if (window.XMLHttpRequest)
		  {// code for all new browsers
		  xmlhttp=new XMLHttpRequest();
		  }
		else if (window.ActiveXObject)
		  {// code for IE5 and IE6
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		
		//alert(xmlhttp==null);
		
		//3.定义url，并创建该请求
		xmlhttp.open("get", "${pageContext.request.contextPath}/register?operator=checkUsername&username=" + username, true);
		//4.指定回调函数:就是当服务器返回数据时调用的函数，这个函数我们会让他获取servlet返回的数据并显示在页面
		xmlhttp.onreadystatechange = callback;

		//5.发送请求
		xmlhttp.send();
		}
		
		function callback()
		{
			//alert(xmlhttp.readyState);//0  1 2  3  4 
			//处理服务端响应数据的函数
			if(xmlhttp.readyState==4)
				{
				alert(xmlhttp.status);
					if(xmlhttp.status==200)
						{
							var mess=xmlhttp.responseText;
						//alert(mess);
							document.getElementById("message").innerHTML=mess;
						}
					
				}
			
		}
		
		 function ValidateLoginForm(){
				//获取需要进行非空验证的三个数据：用户名 密码 验证码
				var username= document.getElementById("username_login");
				var password= document.getElementById("password_login");
				var code= document.getElementById("code");
				//var boo=true;
				if(username.value.trim().length==0){
					alert("用户名不能为空");
					username.focus();
					return false;
				}
				if(password.value.trim().length==0){
					alert("密码不能为空");
					password.focus();
					return false;
				}
				if(code.value.trim().length==0){
					alert("验证码不能为空");
					code.focus();
					return false;
				}
				
				
				return true;
				
			}

			function UserLogin(){
			if(ValidateLoginForm()){
				document.getElementById("loginForm").submit();
			}
			
			} 
		 //刷新验证码的函数
		 function sx()
		 {
			document.getElementById("validateCode").src="validateCodeServlet?date="+new Date(); 
		 }
</script>
		
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<div class="page-inner">
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">
				
			<div class="row">
	     
	   <div class="container">
	                <!-- Logo / Mobile Menu -->
		<div class="three columns">
			<div id="logo">
				<h1><a href="index.html"><img src="images/logo.png" alt="Chow" style="background-size:50% 50%;"/></a></h1>
			</div>
	     </div>
		</div>				
		</div>
				
		</div>
		</nav>
	
	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(images/img_4.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">美食会使人心情愉悦</span>
							<h2>食为天性，静静地咀嚼，轻轻地回味，非比寻常的韵致</h2>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									<ul class="tab-menu">
										<li class="active gtco-first"><a href="#" data-tab="signup">注册</a></li>
										<li class="gtco-second"><a href="#" data-tab="login">登录</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<form action="<%=request.getContextPath()%>/register" method="post">
												<div class="row form-group">
													<div class="col-md-12">
														<input type="text" class="form-control" id="username_signup" name="username_signup" placeholder="请输入用户名" onblur="checkUsername()">
														<p id="message" name="message"></p>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<!--<label for="password">Password</label>-->
														<input type="password" class="form-control" id="password_signup" name="password_signup" placeholder="请输入密码">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
												
														<input type="password" class="form-control" id="password2" name="password2" placeholder="请确认输入密码">
                                                    
                                                    </div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary" value="注册">
													</div>
												</div>
											</form>	
										</div>

										<div class="tab-content-inner" data-content="login">
											<form method="post" action="<%=request.getContextPath()%>/login?operator=login1">
												<div class="row form-group">
													<div class="col-md-12">
														<!--<label for="username">Username or Email</label>-->
														<input type="text" class="form-control" id="username_login" name="username_login" placeholder="请输入用户名" value="huangrong">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<!--<label for="password">Password</label>-->
														<input type="password" class="form-control" id="password_login" name="password_login" placeholder="请输入密码" value="123456">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<input type="text" class="form-control" id="code" name="code" placeholder="请输入验证码" value="">
														<img src="validateCodeServlet" alt="" height="40" id="validateCode" onclick="sx()"/>
														<img src="images/text_sx.gif" width="32" height="18" onclick="sx()">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary" value="登录">
                                                        <a href="./FindPsw.jsp" class="nav pull-right">忘了密码？ </a>
													</div>
          
												</div>
											</form>	
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
							
					
				</div>
			</div>
		</div>
	</header>
	
	</div>

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	</body>
</html>

