<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
   	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>
	<style>
		.login span.error{
			color:#f00;
			display:inline;
			margin-left:10px;
			height:25px;
			line-height:25px;
		}
		.login span.ok{
			color:#32CD32;
			display:inline;
			margin-left:10px;
			height:25px;
			line-height:25px;
		}
	</style>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post" onsubmit="return CheckForm1(this)">
    <h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="user_id" value="" onfocus="FocusItem(this)" onblur="CheckLoginItem(this)" placeholder="用户名/邮箱/手机号"><span></span></p>
        <p><input type="password" name="password" value="" onfocus="FocusItem(this)" onblur="CheckLoginItem(this)" placeholder="密码"><span></span></p>
        <p class="txtL txt"><input class="code" type="text" name="code" value="" onfocus="FocusItem(this)" onblur="CheckLoginItem(this)" placeholder="验证码">
        <img src="${pageContext.request.contextPath}/getCode" alt="看不清，换一张" onclick="change(this)" id="imgObj" style="height:32px;border-radius:12px"><span></span></p>
        
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.html">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>