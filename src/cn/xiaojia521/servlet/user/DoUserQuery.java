package cn.xiaojia521.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaojia521.entity.User;
import cn.xiaojia521.service.UserDao;

@WebServlet("/manage/admin_douserquery")
public class DoUserQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp=request.getParameter("cp");
		String keywords=request.getParameter("keywords");
		int count=UserDao.queryCount(keywords);
		int cpage=1;
		if(cp!=null) {
			cpage=Integer.parseInt(cp);
		}
		
		ArrayList<User> list = UserDao.query(5, cpage,keywords);
		
		int tpage=0;
		if(count%5==0) {
			tpage=count/5;
		}else {
			tpage=(count/5)+1;
		}
		
		request.setAttribute("keywords", keywords);
		request.setAttribute("userlist", list);
		request.setAttribute("tpage", tpage);
		request.setAttribute("cpage", cpage);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/manage/admin_user.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
