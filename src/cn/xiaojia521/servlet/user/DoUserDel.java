package cn.xiaojia521.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaojia521.entity.User;
import cn.xiaojia521.service.UserDao;

@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("user");
		PrintWriter out = response.getWriter();
		
		int count=0;
		count=UserDao.del(userName);
		
		if(count>0){
			response.sendRedirect("/OnlineStore/manage/admin_douserquery?cp="+request.getParameter("cp"));
		}else {
			out.println("<script>");
			out.println("alert('用户删除失败')");
			out.println("location.href='/OnlineStore/manage/admin_douserquery'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] ids = request.getParameterValues("id[]");
		System.out.println(ids.length);
		for(int i=0;i<ids.length;i++) {
			UserDao.del(ids[i]);
		}
		response.sendRedirect("/OnlineStore/manage/admin_douserquery");
	}

}
