package cn.xiaojia521.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import cn.xiaojia521.dao.BaseDao;
import cn.xiaojia521.entity.User;

public class UserDao {
	public static int insert(User user) {
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {
				user.getUSER_ID(),
				user.getUSER_NAME(),
				user.getUSER_PASSWORD(),
				user.getUSER_SEX(),
				user.getUSER_BIRTHDAY(),
				user.getUSER_IDENITY_CODE(),
				user.getUSER_MAIL(),
				user.getUSER_MOBILE(),
				user.getUSER_ADDRESS(),
				user.getUSER_STATUS(),
				user.getUSER_REGTIME()
		};
		return BaseDao.exectuIUD(sql, params);
	}
	
	public static int update(User user) {
		String sql="update user set"
				+ " USER_NAME=?,"
				+ " USER_PASSWORD=?,"
				+ " USER_SEX=?,"
				+ " USER_BIRTHDAY=?,"
				+ " USER_IDENITY_CODE=?,"
				+ " USER_MAIL=?,"
				+ " USER_MOBILE=?,"
				+ " USER_ADDRESS=?,"
				+ " USER_STATUS=?"
				+ " where USER_ID=?";
		Object[] params= {				
				user.getUSER_NAME(),
				user.getUSER_PASSWORD(),
				user.getUSER_SEX(),
				user.getUSER_BIRTHDAY(),
				user.getUSER_IDENITY_CODE(),
				user.getUSER_MAIL(),
				user.getUSER_MOBILE(),
				user.getUSER_ADDRESS(),
				user.getUSER_STATUS(),
				user.getUSER_ID()
		};
		return BaseDao.exectuIUD(sql, params);
	}
	
	public static int del(String userName) {
		String sql="delete from user where USER_ID=? and USER_STATUS!=0";
		Object[] params= {userName};
		return BaseDao.exectuIUD(sql, params);
	}
	
	public static int queryCount(String keywords) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql=null;
		try {
			conn=BaseDao.getConn();
			if(keywords!=null) {
				sql="select count(*) from user where USER_ID like"+"'%"+keywords+"%' or USER_NAME like '%"+keywords+"%'"; 
			}else {
				sql="select count(*) from user";
				}
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return count;
	}
	
	public static User selectID(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			conn=BaseDao.getConn();
			String sql="select * from user where USER_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
			user=new User(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9),
					rs.getInt(10),
					rs.getString(11)
					);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return user;
	}
	public static User selectAdmin(String id,String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			conn=BaseDao.getConn();
			String sql="select * from user where USER_ID=? and USER_PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()) {
				user=new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getString(11)
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return user;
	}
	
	public static ArrayList<User> query(int count,int cpage,String keywords){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<User> list=new ArrayList<User>();
		try {
			conn=BaseDao.getConn();
			String sql=null;
			if(keywords!=null) {
				sql="select * from user where USER_ID like"+"'%"+keywords+"%' or USER_NAME like '%"+keywords+"%' order by USER_REGTIME desc limit ?,?"; 
			}else {
				sql="select * from user order by USER_REGTIME desc limit ?,?";
				}
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (cpage-1)*count);
			ps.setInt(2, count);
			rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_MAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"),
						rs.getString("USER_REGTIME")
						);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static int selectByName(String id) {
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="select count(*) from user where USER_ID=?"; 
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return count;
	}

	public static int queryByName(String username, String pwd) {
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql="select count(*) from user where USER_ID=? and USER_PASSWORD=?"; 
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeall(rs, ps, conn);
		}
		return count;
	}

}
