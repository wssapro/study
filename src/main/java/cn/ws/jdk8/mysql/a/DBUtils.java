package cn.ws.jdk8.mysql.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: DBUtil
 * @Description: DB测试工具类
 * @author wsq E-mail：
 * @date 2018年9月13日 上午12:47:57
 * 
 */
public class DBUtils {

	// 定义连接所需的常量
	private static String USERNAMR = "xxx"; // Oracle数据库的用户名
	private static String PASSWORD = "xxx"; // Oracle数据库的用户密码
	private static String DRVIER = "oracle.jdbc.OracleDriver"; // 驱动
	private static String URL = "jdbc:oracle:thin:@10.1.2.24:1521:xxx";

	// 创建一个数据库连接
	Connection conn = null;
	// 创建预编译语句对象
	PreparedStatement pstm = null;
	Statement stm = null;
	// 创建一个结果集对象
	ResultSet rs = null;

	/**
	 * @Title: updateTest
	 * @Description: PreparedStatement批量更新
	 * @return void    返回类型
	 */
	public void updateTest() {
		try {
			Class.forName(DRVIER);
			// 创建数据连接
			conn = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
			// 关闭自动提交，即开启事务
			conn.setAutoCommit(false);
			String sql = "update tableName set cloumn1 = ? where id = ?";
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < 10000; i++) {
				pstm.setString(1, "11");
				pstm.setInt(2, 00001);
				// 添加批处理SQL
				pstm.addBatch();
				// 每200条执行一次，避免内存不够的情况
				/*
				 * if (i > 0 && i % 200 == 0) { pstm.executeBatch(); }
				 */
			}
			// 最后执行剩余不足200条的
			pstm.executeBatch();
			pstm.close();
			// 执行完后，手动提交事务
			conn.commit();
			// 在把自动提交打开
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("class not find !", e);
		} catch (SQLException e) {
			try {
				// 发生异常，事务回滚！
				if (conn != null && !conn.isClosed()) {
					conn.rollback();
					conn.setAutoCommit(true);
					System.out.println("更新失败，事务回滚！");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
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
	
	/**
	 * @Title: updateTest1
	 * @Description: Statement批量更新
	 * @return void    返回类型
	 */
	public void updateTest1() {
		try {
			Class.forName(DRVIER);
			// 创建数据连接
			conn = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
			stm = conn.createStatement();
			// 关闭自动提交，即开启事务
			conn.setAutoCommit(false);
			for (int i = 0; i < 10000; i++) {
				// 添加批处理SQL
				stm.addBatch("update people set firstname='John' where id=123");
				stm.addBatch("update people set firstname='Eric' where id=456");
				stm.addBatch("update people set firstname='May'  where id=789");
			}
			// 最后执行剩余不足200条的
			stm.executeBatch();
			stm.close();
			// 执行完后，手动提交事务
			conn.commit();
			// 在把自动提交打开
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("class not find !", e);
		} catch (SQLException e) {
			try {
				// 发生异常，事务回滚！
				if (conn != null && !conn.isClosed()) {
					conn.rollback();
					conn.setAutoCommit(true);
					System.out.println("更新失败，事务回滚！");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stm != null) {
				try {
					stm.close();
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
}

