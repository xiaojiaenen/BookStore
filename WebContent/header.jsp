<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="head">
	<div class="wrapper clearfix">
		<div class="clearfix" id="top">
			<h1 class="fl">
				<a href="indexselect"><img src="img/logo.png" /></a>
			</h1>
			<div class="fr clearfix" id="top1">
				<p class="fl">
					<c:choose>
						<c:when test="${isLogin!=1 }">
							<a href="login.jsp" id="login">登录</a>
							<a href="reg.jsp" id="reg">注册</a>
						</c:when>
						<c:when test="${isLogin==1 }">
							<a href="login.jsp" id="login">你好 , <b>${user.USER_NAME }</b></a>
						</c:when>
					</c:choose>
					<c:if test="${isAdminLogin==1}">
						<a href="/OnlineStore/manage/admin_index.jsp"
							style="color: #A10000;">后台</a>
					</c:if>
				</p>
				<form action="#" method="get" class="fl">
					<input type="text" placeholder="热门搜索：干花花瓶" /><input type="button" />
				</form>
				<div class="btn fl clearfix">
					<a href="#" class="er1"><img src="img/ewm.png" /></a>
					<c:if test="${isLogin==1 }">
						<a href="mygxin.jsp"><img src="img/grzx.png" /></a>
						<a href="cart.html"><img src="img/gwc.png" /></a>
						<a href="logout" id="logout" style="color: #A10000;">注销</a>
					</c:if>
					<p>
						<a href="#"><img src="img/smewm.png" /></a>
					</p>
				</div>
			</div>
		</div>
		<ul class="clearfix" id="bott">
			<li><a href="indexselect">首页</a></li>

			<c:forEach items="${father }" var="f">
			<li><a href="selectproductlist?fid=${f.CATE_ID }">${f.CATE_NAME }</a>
				<div class="sList2">
					<div class="clearfix">
						<c:forEach items="${child }" var="c">
							<c:if test="${c.CATE_PARENT_ID==f.CATE_ID }">
							<a href="selectproductlist?cid=${c.CATE_ID }&fid=${c.CATE_PARENT_ID}">${c.CATE_NAME }</a> 
							</c:if>
						</c:forEach>
					</div>
				</div></li>
			</c:forEach>
			
		</ul>
	</div>
</div>