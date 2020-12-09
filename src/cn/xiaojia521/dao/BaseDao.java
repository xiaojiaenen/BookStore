package cn.xiaojia521.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {
	private static ComboPooledDataSource cpds;
	static {
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8");
			cpds.setUser("root");
			cpds.setPassword("123456");
			cpds.setInitialPoolSize(5);
			cpds.setMaxPoolSize(15);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return cpds.getConnection();
	}

	public static int exectuIUD(String sql, Object[] params) {
		int count = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = BaseDao.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeall(null, ps, conn);
		}
		return count;
	}

	public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
