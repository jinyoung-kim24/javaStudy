package dbtest;

import java.sql.*; // JDBC ��� ����� ��� Ÿ��
import java.util.ArrayList;

import dbtest.data.Company;

// ojdbc6.jar jar ���̺귯���� �ٿ�ε� �޾Ƽ� ���
// 11gXE�� ȣȯ������ ������ jar�� ����.
// �����ͺ��̽������� �ڹ�(Ŭ���̾�Ʈ) ���α׷��� ����ϴ� ���� TCP ������ 
// ���� ����� ���ؼ� �����.

// DB corporations TBL <----> java Company Ŭ���� ��������
//		���ڵ� �ϳ� 						��ü�ϳ�
public class DBTest3 {

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
	public static ArrayList<Company> printAllCompaniesFromDB() {
		ArrayList<Company> companyList = new ArrayList<>();
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
				// next()�� false�� ���̻� ���ڵ尡 ���ٰ� ���� ���� ����.
				while(rs.next()) {
					// 9. �̹� ���� �ش� ���ڵ� ���� ��� �ʵ�(�÷�)���� �� Ÿ������ ���� get��.
//					rs.getInt(1); // ù��° �ʵ�/�÷�
					// ���̺� ���ڵ尡 ��Ű�� ��ü�� ���� 1:1
					Company cp = new Company(rs.getInt("id"),rs.getString("name"),
							rs.getString("domain"),rs.getString("ceo"),rs.getFloat("rate"),
							rs.getString("rank"));
//					System.out.println(cp);
					companyList.add(cp);
				}
				System.out.println("** ITȸ���: " + companyList.size() + "��");
//				for (Company cp : companyList) {
//					System.out.println(cp);
//				}
				return companyList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("��� ä�� ����!!");
		}
		return null;
	}
	public static void main(String[] args) {
		beginConnection(); // ����
		
		// DB ����, ����... ��ɵ��� �����ϼ� �ִ� ����
		ArrayList<Company> list = printAllCompaniesFromDB();
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				Company cp = list.get(i);
				System.out.println(cp.getName() + "(" + cp.getCeo() + ")");
			}
		}
		endConnection(); // ����
	}
}