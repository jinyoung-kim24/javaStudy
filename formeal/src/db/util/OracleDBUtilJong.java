package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class OracleDBUtilJong {
	
	public static Connection conn = null;
	public static final String account =  "FORMEAL"; 
	public static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe";
	
	// 통신채널을 재활용할 수 있게 만드는 함수 
	public static Connection getConn() {
		if( conn != null ) return conn;
		else {
			boolean c = beginConnection();
			return c ? conn : null;
		}
	}
	
	public static boolean beginConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB 연결 성공 " + new Date());
			
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar의 오라클DB 드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("통신 연결 실패");
		} catch (Exception e) {
			System.out.println("자바 일반 예외");
		}
		return false;
	}
	public static boolean endConnection() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("DB 종료 성공");
			} catch (Exception e) {
				System.out.println("DB 종료 실패");
				e.printStackTrace();
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Connection connect = OracleDBUtil.getConn();
		OracleDBUtil.endConnection();
	}
}
