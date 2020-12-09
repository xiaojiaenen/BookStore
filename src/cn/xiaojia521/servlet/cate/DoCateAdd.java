package cn.xiaojia521.servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaojia521.entity.Category;
import cn.xiaojia521.service.CateDao;

@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid=Integer.parseInt(request.getParameter("parentid"));
		String name = request.getParameter("catename");
		
		Category cate=new Category(name, fid);
		CateDao.insert(cate);
		response.sendRedirect("admin_cateselect");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
