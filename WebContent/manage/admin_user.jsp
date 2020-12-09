<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.html">首页</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span>
		</div>
	</div>
	<div class="search-wrap">
		<div class="search-content">
			<form action="/OnlineStore/manage/admin_douserquery" method="post">
				<table class="search-tab">
					<tr>
						<th width="120">选择分类:</th>
						<td><select name="search-sort" id="">
								<option value="">全部</option>
								<option value="19">精品界面</option>
								<option value="20">推荐界面</option>
						</select></td>
						<th width="70">关键字:</th>
						<td><input class="common-text" placeholder="关键字"
							name="keywords" value="" id="" type="text"></td>
						<td><input class="btn btn-primary btn2" name="sub" value="查询"
							type="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<form action="/OnlineStore/manage/admin_douserdel" id="myform"
			method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a> 
					<a
						id="batchDel" href="javascript:delMore('确定删除这些用户吗？','myform')"><i
						class="icon-font"></i>批量删除</a>
					<!--   <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th class="tc" width="5%"><input class="allChoose" name=""
							type="checkbox" onclick="selAll(this)"></th>
						<th>用户名</th>
						<th>姓名</th>
						<th>密码</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>邮箱</th>
						<th>手机号</th>
						<th>收货地址</th>
						<th>注册时间</th>
						<th>权限</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${userlist}" var="user">
						<tr>
							<td class="tc"><input name="id[]" value="${user.USER_ID }"
								type="checkbox"></td>
							<td>${user.USER_ID }</td>
							<td>${user.USER_NAME }</td>
							<td>********</td>
							<td>${user.USER_SEX=='T'?'男':'女' }</td>
							<td>${user.USER_BIRTHDAY }</td>
							<td>${user.USER_MAIL }</td>
							<td>${user.USER_MOBILE }</td>
							<td>${user.USER_ADDRESS }</td>
							<td>${user.USER_REGTIME }</td>
							<td>${user.USER_STATUS==0?'管理员':'普通用户' }</td>
							<td><a class="link-update"
								href="/OnlineStore/manage/admin_dousermodify?user=${user.USER_ID }">修改</a>
								<c:if test="${user.USER_STATUS==1}">
									<a class="link-del"
										href="javascript:del('你确定要删除用户【${user.USER_NAME }】吗？',
                                	'/OnlineStore/manage/admin_douserdel?user=${user.USER_ID }&cp=${cpage }')">删除</a>
								</c:if></td>
						</tr>
					</c:forEach>
					<script>
						function del(msg, url) {
							if (confirm(msg)) {
								location.href = url;
							}
						}

						function selAll(o) {
							var a = document.getElementsByName('id[]');

							for (var i = 0; i < a.length; i++) {
								a[i].checked = o.checked;
							}
						}

						function delMore(msg, name) {
							if (confirm(msg)) {
								var form = document.getElementById(name);
								form.submit();
							}
						}
					</script>
				</table>
				<div class="list-page">
					<a href="admin_douserquery?cp=1">首页</a> <a
						href="admin_douserquery?cp=${cpage-1<1?1:cpage-1 }">上一页</a> 共
					${count } 条&nbsp;&nbsp; ${cpage }&nbsp;/&nbsp;${tpage }&nbsp; 页 <a
						href="admin_douserquery?cp=${cpage+1>tpage?tpage:cpage+1 }">下一页</a>
					<a href="admin_douserquery?cp=${tpage }">尾页</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>