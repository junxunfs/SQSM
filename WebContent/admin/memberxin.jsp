<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<!-- Basic Page Needs
    ================================================== -->
    <meta charset="utf-8">
    <title>修改信息</title>

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="../css/colors/red.css">
    <!--<link rel="stylesheet" href="../css/mestyle.css">-->
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/colors/red.css" id="colors">

    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->


</head>
<body>
<script type="text/javascript">
	       $(function() {
	    	   alert($('#mess').text());
	       })
</script>
    <!--<a href="#small-dialog" class="popup-with-zoom-anim  margin-left-0">更改信息</a>-->
    <div class="ten columns navigation">
                    <!--<nav id="navigation" class="menu nav-collapse">
                        <ul> </ul>
                    </nav>-->
     </div>

     <div id="small-dialog" class="zoom-anim-dialog ">
            <h3 class="headline">修改用户信息</h3><span class="line margin-bottom-25"></span><div class="clearfix"></div>

            <!-- Form 私信界面-->
            <form id="add-comment" class="add-comment" action="<%=request.getContextPath() %>/adminServlet?operator=save_users&username=${sessionScope.user_edit.username}" method="post">
                <fieldset>
                    <div>
                        <label>真实姓名:<span>*</span></label>
                        <input type="text" value="${sessionScope.user_edit.realname}" name="realname" />
                    </div>
                    <div>
                        <label>性别: <span>*</span></label>
                        <input type="radio" name="sex" value="男" ${sessionScope.user_edit.sex.trim().equals("男")?"checked":""}>男
                        <input type="radio" name="sex" value="女" ${sessionScope.user_edit.sex.trim().equals("女")?"checked":""}>女
                    </div>
                    <div class="margin-top-20">
                        <label>年龄: <span>*</span></label>
                        <input type="text" value="${sessionScope.user_edit.age}" name="age" />
                    </div>

                    <div>
                        <label>描述: <span>*</span></label>
                        <textarea cols="40" rows="3" name="message" id="mess">${sessionScope.user_edit.message}</textarea>
                    </div>

                </fieldset>

              <!--   <a href="#" class="button color">修改</a> -->
                <input type="submit" class="button color" value="修改"/>
                <div class="clearfix"></div>
            </form>

        </div>
     
    <script src="../scripts/jquery-1.11.0.min.js"></script>
    <script src="../scripts/jquery-migrate-1.2.1.min.js"></script>
    <script src="../scripts/jquery.superfish.js"></script>
    <script src="../scripts/jquery.royalslider.min.js"></script>
    <script src="../scripts/responsive-nav.js"></script>
    <script src="../scripts/hoverIntent.js"></script>
    <script src="../scripts/isotope.pkgd.min.js"></script>
    <script src="../scripts/chosen.jquery.min.js"></script>
    <script src="../scripts/jquery.tooltips.min.js"></script>
    <script src="../scripts/jquery.magnific-popup.min.js"></script>
    <script src="../scripts/jquery.pricefilter.js"></script>
    <script src="../scripts/custom.js"></script>
    <script src="../scripts/switcher.js"></script>
</body>
</html>