package cn.xiaojia521.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.xiaojia521.dao.BaseDao;
import cn.xiaojia521.entity.Category;
import cn.xiaojia521.entity.Product;

public class ProductDao {
	public static ArrayList<Product> queryAll(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Product> list=new ArrayList<Product>();
		try {
			conn=BaseDao.getConn();
			String sql="select * from product";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product cate=new Product(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getInt("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME")
						);
				list.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	public static int insert(Product pro) {
		String sql="insert into product values(null,?,?,?,?,?,?,?)";
		Object[] params= {
				pro.getPRODUCT_NAME(),
				pro.getPRODUCT_DESCRIPTION(),
				pro.getPRODUCT_PRICE(),
				pro.getPRODUCT_STOCK(),
				pro.getPRODUCT_FID(),
				pro.getPRODUCT_CID(),
				pro.getPRODUCT_FILENAME()
		};
		return BaseDao.exectuIUD(sql, params);
	}

	public static Product selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product pro=null;
		try {
			conn=BaseDao.getConn();
			String sql="select * from product where PRODUCT_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
			pro=new Product(
					rs.getInt("PRODUCT_ID"),
					rs.getString("PRODUCT_NAME"),
					rs.getString("PRODUCT_DESCRIPTION"),
					rs.getInt("PRODUCT_PRICE"),
					rs.getInt("PRODUCT_STOCK"),
					rs.getInt("PRODUCT_FID"),
					rs.getInt("PRODUCT_CID"),
					rs.getString("PRODUCT_FILENAME")
					);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return pro;
	}
	
	public static ArrayList<Product> selectByFId(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product pro=null;
		ArrayList<Product> list=new ArrayList<Product>();
		try {
			conn=BaseDao.getConn();
			String sql="select * from product where PRODUCT_FID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
			pro=new Product(
					rs.getInt("PRODUCT_ID"),
					rs.getString("PRODUCT_NAME"),
					rs.getString("PRODUCT_DESCRIPTION"),
					rs.getInt("PRODUCT_PRICE"),
					rs.getInt("PRODUCT_STOCK"),
					rs.getInt("PRODUCT_FID"),
					rs.getInt("PRODUCT_CID"),
					rs.getString("PRODUCT_FILENAME")
					);
			list.add(pro);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	public static ArrayList<Product> selectByCId(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product pro=null;
		ArrayList<Product> list=new ArrayList<Product>();
		try {
			conn=BaseDao.getConn();
			String sql="select * from product where PRODUCT_CID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
			pro=new Product(
					rs.getInt("PRODUCT_ID"),
					rs.getString("PRODUCT_NAME"),
					rs.getString("PRODUCT_DESCRIPTION"),
					rs.getInt("PRODUCT_PRICE"),
					rs.getInt("PRODUCT_STOCK"),
					rs.getInt("PRODUCT_FID"),
					rs.getInt("PRODUCT_CID"),
					rs.getString("PRODUCT_FILENAME")
					);
			list.add(pro);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	public static int update(Category cate) {
		String sql="update category set"
				+ " CATE_NAME=?,"
				+ " CATE_PARENT_ID=?"
				+ " where CATE_ID=?";
		Object[] params= {				
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_ID(),
				cate.getCATE_ID()
		};
		return BaseDao.exectuIUD(sql, params);
	}

	public static int del(int id) {
		String sql="delete from category where CATE_ID=?";
		Object[] params= {id};
		return BaseDao.exectuIUD(sql, params);
	}
}
