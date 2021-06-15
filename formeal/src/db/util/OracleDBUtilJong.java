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
	
	// ���ä���� ��Ȱ���� �� �ְ� ����� �Լ� 
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
			System.out.println("DB ���� ���� " + new Date());
			
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar�� ����ŬDB ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("��� ���� ����");
		} catch (Exception e) {
			System.out.println("�ڹ� �Ϲ� ����");
		}
		return false;
	}
	public static boolean endConnection() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("DB ���� ����");
			} catch (Exception e) {
				System.out.println("DB ���� ����");
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
