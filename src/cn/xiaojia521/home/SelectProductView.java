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

@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> father = CateDao.queryChild("father");
		ArrayList<Category> child = CateDao.queryChild("child");
		
		
		request.setAttribute("child", child);
		request.setAttribute("father", father);
		
		int id = Integer.parseInt(request.getParameter("id"));
		Product pro = ProductDao.selectById(id);
		for (Category cate : father) {
			if(cate.getCATE_ID()==pro.getPRODUCT_FID()) {
				request.setAttribute("fname", cate.getCATE_NAME());
			}
		}
		for (Category cate : child) {
			if(cate.getCATE_ID()==pro.getPRODUCT_CID()) {
				request.setAttribute("cname", cate.getCATE_NAME());
			}
		}
		
		if(pro!=null) {
			int cid=pro.getPRODUCT_CID();
			ArrayList<Product> cids = ProductDao.selectByCId(cid);
			request.setAttribute("cids", cids);
			
			Category cate = CateDao.selectById(cid);
			request.setAttribute("cate", cate);
		}
		
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("productview.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
