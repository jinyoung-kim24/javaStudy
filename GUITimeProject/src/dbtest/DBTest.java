package dbtest;

import java.sql.*; // JDBC ��� ����� ��� Ÿ��

// ojdbc6.jar jar ���̺귯���� �ٿ�ε� �޾Ƽ� ���
// 11gXE�� ȣȯ������ ������ jar�� ����.
// �����ͺ��̽������� �ڹ�(Ŭ���̾�Ʈ) ���α׷��� ����ϴ� ���� TCP ������ 
// ���� ����� ���ؼ� �����.

// DB corporations TBL <----> java Company Ŭ���� ��������
//		���ڵ� �ϳ� 						��ü�ϳ�
public class DBTest {

	static Connection conn; // DBMS ������ �����ϴ� ��� ���ذ�ü
	private static final String account = "DEVEL"; // ��Ű����/������
	private static final String pw = "1234";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// IP �ּ� , port ��Ʈ 1521, SID ���񽺾��̵�xe
	// xe ���� ���� ����Ŭ ���� (127.0.0.1 �ּ� �����Ŀ� �ִ� ���� - �������ּ�)

	// DB�� �����ϱ� (�����ϱ� - ���ä�� �¾�)
	public static boolean beginConnection() {
		try {
			// 1. ����Ŭ JDBC ������(����̹�) Ŭ���� ���� �ι�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. ����Ŭ DBSM ������ ��ſ����� ���� (��������)
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB ���� ����! " + new java.util.Date());
			// 3. �������� �����̸� null�� �ƴ� ���ᰴü�� ���ϵ�.
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar�� ����ŬDB ����̹� �ε� ����!!");
		} catch (SQLException e) {
			System.out.println("��� ���� ����!!!");
		} catch (Exception e) {
			System.out.println("java �Ϲ� ����!!!");
//			e.printStackTrace();
		}
		return false;
	}

	// DB���� ������ü�ϱ�
	public static boolean endConnection() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("DB ���� ����");
				return true;
			} catch (SQLException e) {
				System.out.println("DB ���� ����");
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		beginConnection(); // ����
		
		// DB ����, ����... ��ɵ��� �����ϼ� �ִ� ����
		
		endConnection(); // ����
		
	}

}
