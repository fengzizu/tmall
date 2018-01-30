package com.kjlink.privilege.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;

import org.apache.commons.dbutils.DbUtils;

public class DBContext {

	private static Queue<Connection> connQueue = new LinkedList<Connection>();
	private static Map<String, Connection> localThreadMap = new HashMap<String, Connection>();

	public static void initJdbcConn() {
		Connection conn = null;
		try {
			Properties properties = new Properties();
			InputStream is = DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

			properties.load(is);
			is.close();

			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String driver = properties.getProperty("driver");

			Class.forName(driver);
			for (int i = 0; i <= 20; i++) {
				conn = DriverManager.getConnection(url, username, password);
				connQueue.offer(conn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放数据库连接对象
	 */
	public static void closeJdbcConn() {

		Iterator<Connection> iterator = connQueue.iterator();

		while (iterator.hasNext()) {

			Connection conn = iterator.next();

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * 连接模块
	 */
	public static Connection getConnection() {

		// 获取当前线程的名称
		String currentThreadName = Thread.currentThread().getName();

		// 尝试用当前进程名称作为key的map，去获取一个连接对象
		Connection conn = localThreadMap.get(currentThreadName);

		// 如果没有从map中获取到连接对象，则从连接池中获取对象
		if (conn == null) {

			// 从连接池在去除一个连接对象
			conn = connQueue.poll();

			// 如果成功从连接池中取出一个连接对象，则将该对象放入以当前线程名为key的map中
			if (conn != null) {

				localThreadMap.put(currentThreadName, conn);
			}

		}
		return conn;
	}

	/**
	 * 关闭与数据库连接的对象
	 * 
	 * @param conn
	 * @param rs
	 * @param ps
	 */
	public static void close(Connection conn, ResultSet rs, PreparedStatement ps) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (conn != null) {

					// 获取当前线程名
					String name = Thread.currentThread().getName();

					localThreadMap.remove(name);
					connQueue.offer(conn);
				}

			}
		}
	}

	/**
	 * 开启事务
	 * 
	 * @throws SQLException
	 */
	public static void beginTransaction() throws SQLException {

		Connection conn = getConnection();
		conn.setAutoCommit(false);
	}

	/**
	 * 提交事务
	 * 
	 * @throws SQLException
	 */
	public static void submitTransaction() throws SQLException {

		Connection conn = getConnection();
		conn.commit();
	}

	/**
	 * 回滚事务
	 * 
	 * @throws SQLException
	 */
	public static void rollback() throws SQLException {

		Connection conn = getConnection();
		conn.rollback();
	}
}
