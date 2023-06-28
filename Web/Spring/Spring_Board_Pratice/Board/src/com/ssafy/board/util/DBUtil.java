package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// MySql 드라이버 클래스 이름
	private final String driverName = "com.mysql.cj.jdbc.Driver";
	// DB와 연결하기 위해 필요한 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	// USER 정보
	private final String username = "root";
	private final String password = "root";

	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		// JDBC 드라이버를 로딩
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	/**
	 * DriverManager를 통해 내 유저아이디와 유저비밀번호를 이용하여 연결을 반환하는 친구야
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 사용한 리소스들을 정리한다. Connection, Statement, PreparedStatement, ResultSet 모두
	 * AutoCloseable 타입 ... 을 이용하므로 필요에 한번에 정리가능
	 *
	 * @param autoCloseables
	 */
	public void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable ac : autoCloseables) {
			if (ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

//	public static void close(Connection conn, PreparedStatement pstmt) {
//		
//		try {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//		try {
//			if(conn != null) {
//				conn.close();
//			}
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
//	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
//		try {
//			if(rs != null) {
//				rs.close();
//			}
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//		
//		try {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//		try {
//			if(conn != null) {
//				conn.close();
//			}
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//	}

}
