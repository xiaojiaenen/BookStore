<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/OnlineStore/manage/admin_docateupdate" method="post" id="myform" name="myform">
                <input type="hidden" name="id" value="${cate.CATE_ID }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;父级分类：</th>
                                <td>
                                    <select class="common-text required" name="parentid">
                                    	<option value="0">根分类</option>
                                    	<c:forEach items="${catelist }" var="c">
                                    		<c:if test="${c.CATE_PARENT_ID==0 }">
                                    			<c:if test="${cate.CATE_PARENT_ID==c.CATE_ID }">
                                    				<option value="${c.CATE_ID }" selected="selected">${c.CATE_NAME }</option>
                                    			</c:if>
                                    			<c:if test="${cate.CATE_PARENT_ID!=c.CATE_ID }">
                                    				<option value="${c.CATE_ID }">${c.CATE_NAME }</option>
                                    			</c:if>
                                    		</c:if>
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;分类名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="catename" size="20" value="${cate.CATE_NAME }" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>