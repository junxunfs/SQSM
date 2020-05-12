<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico" >
<LINK rel="Shortcut Icon" href="/favicon.ico" />


<link href="<%=request.getContextPath() %>/admin/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/admin/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="<%=request.getContextPath() %>/admin/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/admin/css/style.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>食全食美-后台管理系统</title>

</head>
<body>
<header class="Hui-header cl"> <a class="Hui-logo l" title="H-ui.admin v2.3" href="/">"食"全"食"美</a> <a class="Hui-logo-m l" href="/" title="H-ui.admin">H-ui</a> <span class="Hui-subtitle l">后台管理系统</span>
	
	<ul class="Hui-userbar">
		<li>管理员</li>
		<li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">${sessionScope.user.username }<i class="Hui-iconfont">&#xe6d5;</i></a>
		</li>
		
	</ul>
	<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> </header>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
		
		
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> <a _href="<%=request.getContextPath() %>/admin/menu-list.jsp" href="javascript:void(0)">菜谱管理</a><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			
		</dl>
        <dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> <a _href="<%=request.getContextPath() %>/admin/article-list.jsp" href="javascript:void(0)">资讯管理</a><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			
		</dl>
		
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="<%=request.getContextPath() %>/admin/member-list.jsp" href="javascript:;">用户列表</a></li>	
					<li><a _href="<%=request.getContextPath() %>/admin/member-record-upload.jsp" href="javascript:void(0)">上传记录</a></li>
					<li><a _href="<%=request.getContextPath() %>/admin/member-record-collect.jsp" href="javascript:void(0)">收藏记录</a></li>
                  
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 数据统计分析<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				
			</dd>
		</dl>
		
	</div>
</aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="<%=request.getContextPath() %>/admin/welcome.jsp">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="<%=request.getContextPath() %>/admin/welcome.jsp"></iframe>
		</div>
	</div>
</section>
<script type="text/javascript" src="<%=request.getContextPath() %>/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/admin/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/admin/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/admin/js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}





/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 
<script type="text/javascript">
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s)})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>