<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/OnlineStore/manage/admin_douserupdate?user=${u.USER_ID }" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;用户名：</th>
                                <td>
                                    ${u.USER_ID}
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${u.USER_NAME}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;登录密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="password" size="50" value="${u.USER_PASSWORD}" type="password">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;性别：</th>
                                <td>
                                    <input type="radio" name="sex" value="T" checked="checked">男&nbsp;&nbsp;
                                    <input type="radio" name="sex" value="F">女
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>出生日期：</th>
                                <td><input class="common-text" name="birthday" size="50" value="${u.USER_BIRTHDAY}" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;E-mail：</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="${u.USER_MAIL}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>手机号：</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="${u.USER_MOBILE}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>收货地址：</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="${u.USER_ADDRESS}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>&nbsp;权限：</th>
                                <td>
                                    <input type="radio" name="status" value="1" checked="checked">普通用户&nbsp;&nbsp;
                                    <input type="radio" name="status" value="0">管理员
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