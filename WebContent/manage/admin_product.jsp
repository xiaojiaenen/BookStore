<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.html">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span>
		</div>
	</div>
	<div class="result-wrap">
		<form action="/OnlineStore/manage/admin_douserdel" id="myform"
			method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="/OnlineStore/manage/admin_toproductadd"><i class="icon-font"></i>新增图书</a> 
					<!--   <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th>ID</th>
						<th>名称</th>
						<th>介绍</th>
						<th>价格</th>
						<th>库存</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pro}" var="pro">
						<tr>
							<td>${pro.PRODUCT_ID }</td>
							<td style="width:350px;"><img src="images/product/${pro.PRODUCT_FILENAME}" width="80" height="120">
							${pro.PRODUCT_NAME }</td>
							<td style="width:400px;">${pro.PRODUCT_DESCRIPTION }</td>
							<td>${pro.PRODUCT_PRICE }</td>
							<td>${pro.PRODUCT_STOCK }</td>
							<td><a href="/OnlineStore/manage/admin_productupdate?id=${c.CATE_ID }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:productdel(${c.CATE_ID })">删除</a></td>
						</tr>	
					</c:forEach>
					<script>
						function catedel(id) {
							if (confirm("确认删除这个分类吗？")) {
								location.href = "admin_docatedel?id="+id;
							}
						}

					</script>
				</table>
			</div>
		</form>
	</div>
<!--/main-->
</div>
</body>
</html>