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

@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("user");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		int status = Integer.parseInt(request.getParameter("status"));
		PrintWriter out = response.getWriter();
		
		int count=0;
		User user=new User(userName,name,password,sex,birthday,null,email,mobile,address,status,DateFormat.getDateTimeInstance().format(new Date()));
		count=UserDao.update(user);
		
		if(count>0){
			response.sendRedirect("/OnlineStore/manage/admin_douserquery");
		}else {
			out.println("<script>");
			out.println("alert('用户修改失败')");
			out.println("location.href='/OnlineStore/manage/admin_douserquery'");
			out.println("</script>");
		}
		
	}
}
