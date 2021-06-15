package db.mgr;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
> CAFE.members TBL ���̺�
> db.data.Member ������ Ŭ����
> db.mgr.MemberDBMgr ������ DB�߰��� Ŭ���� 
 */
//import java.sql.Connection;
//import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import db.data.Member;
import db.util.OracleDBUtil;

public class MemberDBMgr {
	
	Connection conn;
	
	public MemberDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
//	- �ű� ȸ�� ���� �� �� �ִ�. C Member ��ü�� �Է�
	public boolean insertNewMember(Member mb) {
		if( this.conn != null && mb != null ) {
			String sql   // ����, ����, Ÿ��.. ����
			= "INSERT INTO members VALUES ("
		+ "MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, 1000, sysdate)";
			System.out.println(sql); // ? �����ڴ� ���� '��' �ڵ� ������..
			try {
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt
					= conn.prepareStatement(sql); // ���������غ�
				// ?�������� ����, ����, Ÿ�� set...
				pstmt.setString(1, mb.getName());				
				pstmt.setString(2, mb.getLogin());
				pstmt.setString(3, mb.getPw());
				pstmt.setInt(4, mb.getAge());
				pstmt.setInt(5, mb.getGender());				
				int r = pstmt.executeUpdate(); // ����
					// ������ ��ȭ(DML insert, update, delete)
				// ��ȭ ���� �ܼ� ������ ��ȸ�� stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: ȸ�� ���� ����! "
							+ mb);
				} else {
					System.out.println("DBMgr: ȸ�� ���� ����! " 
							+ mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return false;
	}
	
	public boolean insertNewMember2(Member mb) {
		if( this.conn != null && mb != null ) {
			String sql   // ����, ����, Ÿ��.. ����
			= "INSERT INTO members VALUES ("
			  + "MEMBER_SEQ.nextval, '"+mb.getName()+"', "
			  + "'"+mb.getLogin()+"', '"+mb.getPw()+"'" + 
				", "+mb.getAge()+", "+mb.getGender()+", 1000, sysdate)";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); 
					// ������ ��ȭ(DML insert, update, delete)
				// ��ȭ ���� �ܼ� ������ ��ȸ�� stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: ȸ�� ���� ����! "
							+ mb);
				} else {
					System.out.println("DBMgr: ȸ�� ���� ����! " 
							+ mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return false;
	}
	
//	- �ű� ȸ�� ���� �� �� �ִ�. C ȸ�� ��Ű���� ���� �Է�
	public boolean insertNewMember(
			String name, String login,
			String pw, int age, int gender) {
		if( this.conn != null ) {
			String sql   // ����, ����, Ÿ��.. ����
			= "INSERT INTO members VALUES ("
			  + "MEMBER_SEQ.nextval, '"+name+"', "
			  + "'"+login+"', '"+pw+"'" + 
				", "+age+", "+gender+", 1000, sysdate)";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql); 
					// ������ ��ȭ(DML insert, update, delete)
				// ��ȭ ���� �ܼ� ������ ��ȸ�� stmt.executeQuery() select
				if( r == 1 ) {
					System.out.println("DBMgr: ȸ�� ���� ����! "
							+ login);
					return true;
				} else {
					System.out.println("DBMgr: ȸ�� ���� ����! " 
							+ login);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return false;
	}
//	- ���� ȸ���� �ڽ��� ������ �������� (����) �� �� �ִ�. U
//		�̸�, ��ȣ, ����, ���ϸ��� ��..!! (* ��������)
//	- ���� ȸ���� �� ����� ����Ͽ� ��ȸ�� �� �ִ�.
	public int checkTotalNumberOfMembers() {
		if( this.conn != null ) {
//			String sql = "select COUNT(*) from members";
			String sql = "select COUNT(*) "
					+ "as member_cnt from members";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) {
					//int mbCnt = rs.getInt("COUNT(*)");
//					int mbCnt = rs.getInt(1); // ù��° �÷�
					int mbCnt = rs.getInt("member_cnt");
					return mbCnt;
				} else 
					return 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return -1;
	}
	
//	- ���� ȸ���� ���ϸ��� (����) �� �� �ִ�. U
//	- ���� ȸ���� ��ȣ (����) �� �� �ִ�. U
//	- ��� ���� ȸ������ ��ȸ�� �� �ִ�. R (����, ����, �˻�, ����, ���������̼�ȭ)
	public ArrayList<Member> selectAllMembers() {
		if( this.conn != null ) {
			ArrayList<Member> mbList = new ArrayList<>();
			String sql = "select * from members ORDER BY joined_at desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					Date joinDay = rs.getDate("joined_at");
						// varchar --> date
//					java.sql.Date joinDay 
//						= (java.sql.Date)rs.getDate("joined_at");
					Member mb 
						= new Member(rs.getInt("id"),
								rs.getString("name"), 
								rs.getString("login"),
								rs.getString("pw"),
								rs.getInt("age"),
								rs.getInt("gender"),
								rs.getInt("mileage"),
								joinDay);
//								rs.getDate("joined_at"));
							// joinedAt <-----> joined_at
					mbList.add(mb);
				}
				System.out.println("DBMgr: ȸ�� ��ȸ ��� => " + mbList.size());
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB ��� ����!!");
		}
		return null;
	}
	
//	- Ư�� ���� ȸ�� �� ���� ��ȸ�� �� �ִ�. R (�α��θ�, ������ȣ)	
	public Member selectOneMemberById(int mbId) {
		if( this.conn != null ) {
			String sql = "select * from members"
					+ " where id = " + mbId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) { // �� ���� ���ڵ常...
					Member mb 
					= new Member(rs.getInt("id"),
							rs.getString("name"), 
							rs.getString("login"),
							rs.getString("pw"),
							rs.getInt("age"),
							rs.getInt("gender"),
							rs.getInt("mileage"),
							rs.getDate("joined_at"));
					return mb;
				} else {
					System.out.println(mbId + 
							"��ȣ�� ȸ�� ���ڵ� ��ȸ DB ����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}		
		return null;
	}
	public Member selectOneMemberByLogin(String mbLogin) {
		if( this.conn != null ) {
//			String sql = "select * from members"
//				+ " where login = '" + mbLogin + "'";
			String sql = "select * from members"
					+ " where login = ?";
			try {
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt =
							conn.prepareStatement(sql);
//				ResultSet rs = stmt.executeQuery(sql);
				pstmt.setString(1, mbLogin);				
				ResultSet rs = pstmt.executeQuery();
				if( rs.next() ) { // �� ���� ���ڵ常...
					Member mb 
					= new Member(rs.getInt("id"),
							rs.getString("name"), 
							rs.getString("login"),
							rs.getString("pw"),
							rs.getInt("age"),
							rs.getInt("gender"),
							rs.getInt("mileage"),
							rs.getDate("joined_at"));
					return mb;
				} else {
					System.out.println(mbLogin + 
							" �α��θ��� ȸ�� ���ڵ� ��ȸ DB �����̰ų� ���� ������!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}		
		return null;
	}

//	- ���� ȸ������ Ű���� ��� ������ �������� �˻� �� �� �ִ�. R
	
//	- ���� ȸ���� Ż���� �� �ִ�. (����? => Ż��� ���·� Ư���÷� ����) D
//	- Ư�� Ȱ���� ���� �������� ȸ�� ���ϸ��� ������ �� �ִ�.
//	- ȸ���� �ٸ� ȸ���� ��õ/���ƿ�/�ȷ���..�� �� �ִ�.

//	- ȸ���� �α���/�α׾ƿ�... �� �� �ִ�.(���ȣȭ)
	public static final int LOGIN_SUCCESS = 1; // ���� ����
	public static final int LOGIN_FAIL_PW_MISMATCH = 2; // ��ȣ ����ġ
	public static final int LOGIN_FAIL_NOT_FOUND = 3; // ȸ������ ����..
	public static final int LOGIN_ERROR = 4; // ��Ÿ ����
	public int loginProcess(String login, String pw) {
		if( login == null || pw == null || 
				login.isEmpty() || pw.isEmpty() ) {
			System.out.println("�α��� ������ ���� �Է� ����!!");
			return LOGIN_ERROR;
		}
		if( this.conn != null ) {
			Member mb = selectOneMemberByLogin(login); // UQ
			if( mb != null ) { // ���Ե� ȸ�����ڵ� ã��!
				String mbPw = mb.getPw();
				if( mbPw != null && !mbPw.isEmpty() ) {
					if( mbPw.equals(pw) ) {
						System.out.println("�α��� ���� ����!!");
						return LOGIN_SUCCESS;
					} else {
						System.out.println("��ȣ ����ġ!!");
						return LOGIN_FAIL_PW_MISMATCH;
					}
				} else {
					System.out.println("�α��� ������ ���� PW ����!!");
					return LOGIN_ERROR;
				}						
			} else {
				System.out.println("�߸��� �α��� �̸��̰ų� ���� ȸ��!");
				return LOGIN_FAIL_NOT_FOUND;
			}
		}
		else {
			System.out.println("DB ��� ����!!");
		}		
		return LOGIN_ERROR;
	}
	
//	- ȸ�� ���
	
	public static void main(String[] args) {
		MemberDBMgr mbMgr = new MemberDBMgr();
		System.out.println("���� -----------");
		ArrayList<Member> oldList = mbMgr.selectAllMembers();
		for (Member mb : oldList) {
			System.out.println(mb.toString());
		}
		
//		System.out.println("���ڵ� 2�� �߰�....");
//		mbMgr.insertNewMember( 
//				new Member("�ö���", "olaf5", "1234",
//				18, Member.GENDER_MALE));
//		Member newMB = new Member("����", "sven5", "1234",
//				33, Member.GENDER_MALE);
//		mbMgr.insertNewMember(newMB);
//		mbMgr.insertNewMember("�ö���", "olaf", "1234",
//				18, Member.GENDER_MALE);
//		mbMgr.insertNewMember("����", "sven", "1234",
//				33, Member.GENDER_MALE);
		
		System.out.println("�߰� -----------");
		ArrayList<Member> newList = mbMgr.selectAllMembers();
		for (Member mb : newList) {
			System.out.println(mb);
		}
		
		System.out.println(">> ���� ȸ�� ���ڵ� ��: " 
				+ mbMgr.checkTotalNumberOfMembers() + "��");
		
		// login
		Scanner sc = new Scanner(System.in);
		System.out.print(">> ���̵�: " );
		String mbInputLogin = sc.next();
		System.out.print(">> ��ȣ: " );
		String mbInputPW = sc.next();
		
		int loginR = mbMgr
				.loginProcess(mbInputLogin, mbInputPW);
		if( loginR == LOGIN_SUCCESS ) {
			Member mb = mbMgr.selectOneMemberByLogin(mbInputLogin);
//			System.out.println(mbInputLogin + " ȸ���� ���� ����!");
			System.out.println(mbInputLogin + "("+ 
						mb.getName() +")ȸ���� ���� ����!");
			System.out.println("... ���������� �̵�!!");
		}
		
		OracleDBUtil.endConnection();
	}
}