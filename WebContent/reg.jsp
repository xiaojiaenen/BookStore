<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="css/calendar.css">
    
	<script type="text/javascript" src="js/calendar.js"></script>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>
	<style>
		.reg span.error{
			color:#f00;
			display:inline;
			margin-left:10px;
			height:25px;
			line-height:25px;
		}
		.reg span.ok{
			color:#32CD32;
			display:inline;
			margin-left:10px;
			height:25px;
			line-height:25px;
		}
	</style>
</head>
<body>
<!-------------------reg-------------------------->

<div class="reg">
    <form action="register" method="post" onsubmit=" return CheckForm(this)">
    <h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p style="height:30px;margin:5px;background:#767;text-align:center;font-size:22px;color:#fff">用户注册</p>
        <p><input type="text" name="user_id" value=""  onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="user_name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入姓名"><span></span></p>
        <p><input type="password" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="password" name="repassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <br>
        <input style="width:30px;height:20px;padding-top:5px" type="radio" name="sex" value="T" checked="checked">男
        <input style="width:30px;height:20px;padding:5px" type="radio" name="sex" value="F">女
        <p><input type="text" id="user_birthday" name="user_birthday" placeholder="请输入生日"><span></span></p>
        <p><input type="text" name="user_mail" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="user_mobile" value="" placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="user_address" value="" placeholder="请输入地址"><span></span></p>
        <p class="txtL txt"><input class="code" type="text" name="code" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
        <img src="${pageContext.request.contextPath}/getCode" alt="看不清，换一张" onclick="change(this)" id="imgObj" style="height:32px;border-radius:12px"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
       
</div>
<script type="text/javascript">
    $(function() {

    });
	
    
    
    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }

    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 20);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
    
   

</script>
</body>
</html>