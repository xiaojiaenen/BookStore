package cn.xiaojia521.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaojia521.entity.Category;
import cn.xiaojia521.entity.Product;
import cn.xiaojia521.service.CateDao;
import cn.xiaojia521.service.ProductDao;

@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> father = CateDao.queryChild("father");
		ArrayList<Category> child = CateDao.queryChild("child");
		
		request.setAttribute("child", child);
		request.setAttribute("father", father);
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		
		int id=0;
		int id2=0;
		ArrayList<Product> list=null;
		
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list = ProductDao.selectByFId(id);
		}
		
		if(cid!=null) {
			id2=Integer.parseInt(cid);
			list = ProductDao.selectByCId(id2);
			request.setAttribute("title2", CateDao.selectById(id2).getCATE_NAME());
		}
		
		request.setAttribute("title", CateDao.selectById(id).getCATE_NAME());
		request.setAttribute("list", list);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
