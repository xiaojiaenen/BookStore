<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
				class="crumb-step">&gt;</span><a class="crumb-name"
				href="admin_user.jsp">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span>
		</div>
	</div>
	<div class="result-wrap">
		<div class="result-content">
			<form action="/OnlineStore/manage/admin_doproductadd" method="post" enctype="multipart/form-data"
				id="myform" name="myform">
				<table class="insert-tab" width="100%">
					<tbody>
					<tr>
							<th><i class="require-red">*</i>&nbsp;图书名称：</th>
							<td><input class="common-text required" id="title"
								name="productname" size="20" value="" type="text"></td>
						</tr>
						
						<tr>
							<th><i class="require-red">*</i>&nbsp;图书分类：</th>
							<td><select class="common-text required" name="parentid">
									<c:forEach items="${father }" var="f">
									<option value="${f.CATE_ID }" disabled="disabled">- ${f.CATE_NAME }</option>
									<c:forEach items="${child }" var="c">
										<c:if test="${c.CATE_PARENT_ID==f.CATE_ID }">
											<option value="${c.CATE_ID }-${f.CATE_ID }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ${c.CATE_NAME }</option>
										</c:if>
										
									</c:forEach>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>&nbsp;图书封面：</th>
							<td><input class="common-text required" id="title"
								name="productcover" size="20" value="" type="file" style="height:30px;"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>&nbsp;图书价格：</th>
							<td><input class="common-text required" id="title"
								name="productprice" size="20" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>&nbsp;图书介绍：</th>
							<td><input class="common-text required" id="title"
								name="productdesc" size="20" value="" type="text"></td>
						</tr>
						<tr>
							<th><i class="require-red">*</i>&nbsp;图书库存：</th>
							<td><input class="common-text required" id="title"
								name="productstock" size="20" value="" type="text"></td>
						</tr>
						
						<tr>
							<th></th>
							<td><input class="btn btn-primary btn6 mr10" value="提交"
								type="submit"> <input class="btn btn6"
								onClick="history.go(-1)" value="返回" type="button"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</div>
<!--/main-->
</div>
</body>
</html>