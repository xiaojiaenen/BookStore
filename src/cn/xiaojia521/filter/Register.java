package cn.xiaojia521.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Register
 */
@WebFilter("/register")
public class Register implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String userName=request.getParameter("user_id");
		String name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String rePassword=request.getParameter("repassword");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("user_birthday");
		String email=request.getParameter("user_mail");
		String mobile=request.getParameter("user_mobile");
		String address=request.getParameter("user_address");
		
		if(userName=="") {
			out.write("<script>");
			out.write("alert('用户名不能为空')");
			out.write("</script>");
		}else if(name=="") {
			out.write("<script>");
			out.write("alert('姓名不能为空')");
			out.write("</script>");
		}else if(password=="") {
			out.write("<script>");
			out.write("alert('密码不能为空')");
			out.write("</script>");
		}else if(rePassword=="") {
			out.write("<script>");
			out.write("alert('确认密码不能为空')");
			out.write("</script>");
		}else if(birthday=="") {
			out.write("<script>");
			out.write("alert('生日不能为空')");
			out.write("</script>");
		}else if(email=="") {
			out.write("<script>");
			out.write("alert('邮箱不能为空')");
			out.write("</script>");
		}
		
		chain.doFilter(req, resp);
	}


}
