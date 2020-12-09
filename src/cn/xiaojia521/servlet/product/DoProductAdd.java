package cn.xiaojia521.servlet.product;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.xiaojia521.entity.Product;
import cn.xiaojia521.service.ProductDao;
import cn.xiaojia521.utils.FileUploadUtil;

@WebServlet("/manage/admin_doproductadd")
@MultipartConfig()
public class DoProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("productname");
		String desc = request.getParameter("productdesc");
		int price = Integer.parseInt(request.getParameter("productprice"));
		int stock = Integer.parseInt(request.getParameter("productstock"));
		String cfid = request.getParameter("parentid");
		String[] split = cfid.split("-");
		int cid = Integer.parseInt(split[0]);
		int fid = Integer.parseInt(split[1]);
		File path = new File("/home/xiaojia/projects/eclipseProjects/OnlineStore/WebContent/manage/images/product");
		if(!path.exists()) {
			path.mkdir();
		}
		Part part = request.getPart("productcover");
		String fname=FileUploadUtil.getFileName(part);
		if(fname!=null) {
			part.write(path+File.separator+fname);
		}
		Product pro=new Product(0, name, desc, price, stock, fid, cid, fname);
		ProductDao.insert(pro);
		response.sendRedirect("admin_productselect");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
