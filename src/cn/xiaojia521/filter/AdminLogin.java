package cn.xiaojia521.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/manage/*")
public class AdminLogin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		String flag=(String)req.getSession().getAttribute("isAdminLogin");
		
		String uri=req.getRequestURI();
		String contextPath = req.getContextPath();
		String url = uri.substring(contextPath.length());
		
		if(url.contains("admin_")) {
			if(flag!=null&&flag.equals("1")) {
				chain.doFilter(req, resp);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('请先登录')");
				out.println("location.href='/OnlineStore/manage/login.jsp'");
				out.println("</script>");
				out.close();
			}
		}else {
			chain.doFilter(req, resp);
		}
		
	}


}
