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

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("user_id");
		String name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String rePassword=request.getParameter("repassword");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("user_birthday");
		String email=request.getParameter("user_mail");
		String mobile=request.getParameter("user_mobile");
		String address=request.getParameter("user_address");
//		int status = Integer.parseInt(request.getParameter("status"));
		PrintWriter out = response.getWriter();
		
		int count=0;
//		if(password.equals(rePassword)) {
		User user=new User(userName,name,password,sex,birthday,null,email,mobile,address,1,DateFormat.getDateTimeInstance().format(new Date()));
		count=UserDao.insert(user);
//		}
		
		if(count>0){
			response.sendRedirect("login.jsp");
		}else {
			out.println("<script>");
			out.println("alert('用户注册失败')");
			out.println("location.href='./reg.jsp'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
