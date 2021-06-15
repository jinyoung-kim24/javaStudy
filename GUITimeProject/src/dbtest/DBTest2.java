package dbtest;

import java.sql.*; // JDBC ��� ����� ��� Ÿ��

import dbtest.data.Company;

// ojdbc6.jar jar ���̺귯���� �ٿ�ε� �޾Ƽ� ���
// 11gXE�� ȣȯ������ ������ jar�� ����.
// �����ͺ��̽������� �ڹ�(Ŭ���̾�Ʈ) ���α׷��� ����ϴ� ���� TCP ������ 
// ���� ����� ���ؼ� �����.

// DB corporations TBL <----> java Company Ŭ���� ��������
//		���ڵ� �ϳ� 						��ü�ϳ�
public class DBTest2 {

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

	// ȸ�� ��Ű�� ����
	// IT ȸ�� ���̺��� ������ �����ͼ� ����ϱ� (��� ���ڵ� ��ȸ)
	// DEVEL.coporations ���̺� select ��ȸ
	public static void printAllCompaniesFromDB() {
		if(conn != null) { // ��� ���� ���� ������
			//4. ������ SQL ����� ���ڿ��� �غ���
			String sql = "select * from corporations";
			try {
				// 5. ���ä��conn���� ���� ���� ��ü ���� �غ�
				Statement stmt = conn.createStatement();
				// 6. ���� ��ü�� �����Լ��� ���� ���������� sql ������ ����
				// 7. (select) ������ ����� ResultSet ���̺� ������
				// 		��ȸ ��������͸� DB������ ���� �������� ���Ź���.
				ResultSet rs = stmt.executeQuery(sql);
				
				// 8. rs�� (���̾ƴ϶��)�� �߽����� ���ڵ� �������
				// 		�ϳ��� ���ڵ� ������ Ž���ϸ� ���� (ó���� ��� �����Ͱ� ������)
				while(rs.next()) {
					// 9. �̹� ���� �ش� ���ڵ� ���� ��� �ʵ�(�÷�)���� �� Ÿ������ ���� get��.
//					rs.getInt(1); // ù��° �ʵ�/�÷�
					int id = rs.getInt("id"); // id zjffja
					String name = rs.getString("name");
					String domain = rs.getString("domain");
					String ceo = rs.getString("ceo");
					float rate = rs.getFloat("rate");
					String rank = rs.getString("rank");
					// ���̺� ���ڵ尡 ��Ű�� ��ü�� ���� 1:1
					Company cp = new Company(id, name, domain, ceo, rate, rank);
					System.out.println(cp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("��� ä�� ����!!");
		}
	}
	
	public static void main(String[] args) {
		beginConnection(); // ����
		
		// DB ����, ����... ��ɵ��� �����ϼ� �ִ� ����
		printAllCompaniesFromDB();
		
		endConnection(); // ����
		
	}

}
