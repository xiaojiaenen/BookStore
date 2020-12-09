package cn.xiaojia521.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.xiaojia521.dao.BaseDao;
import cn.xiaojia521.entity.Category;
import cn.xiaojia521.entity.User;

public class CateDao {
	public static ArrayList<Category> queryAll(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Category> list=new ArrayList<Category>();
		try {
			conn=BaseDao.getConn();
			String sql="select * from category";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category cate=new Category(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
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
	
	public static ArrayList<Category> queryChild(String flag){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Category> list=new ArrayList<Category>();
		try {
			String sql=null;
			conn=BaseDao.getConn();
			if(flag!=null&&flag.equals("father")) {
				sql="select * from category where CATE_PARENT_ID=0";
			}else {
				sql="select * from category where CATE_PARENT_ID!=0";
			}
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category cate=new Category(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
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

	public static int insert(Category cate) {
		String sql="insert into category(CATE_NAME,CATE_PARENT_ID) values(?,?)";
		Object[] params= {
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_ID()
		};
		return BaseDao.exectuIUD(sql, params);
	}

	public static Category selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Category cate=null;
		try {
			conn=BaseDao.getConn();
			String sql="select * from category where CATE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
			cate=new Category(
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3)
					);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return cate;
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
