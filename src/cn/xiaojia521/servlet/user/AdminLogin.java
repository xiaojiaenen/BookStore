package cn.xiaojia521.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xiaojia521.entity.User;
import cn.xiaojia521.service.UserDao;

@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
		PrintWriter out = response.getWriter();
		
		int count=UserDao.queryByName(username,pwd);
		
		if(count>0) {
			HttpSession session = request.getSession();
			User user = UserDao.selectAdmin(username, pwd);
			session.removeAttribute("user");
			session.removeAttribute("isLogin");
			session.setAttribute("user", user);
			session.setAttribute("isLogin", "1");
			if(user.getUSER_STATUS()==0) {
				session.removeAttribute("isAdminLogin");
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("/OnlineStore/manage/admin_index.jsp");
			}else {
				response.sendRedirect("/OnlineStore/index.jsp");
			}
		}else {
			out.println("<script>");
			out.println("alert('账号或密码错误')");
			out.println("location.href='./login.jsp'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
