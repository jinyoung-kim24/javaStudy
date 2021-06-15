package ui.calendarMain.db;

import java.beans.Statement;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import ui.calendarMain.db.data.Todo;

// �߰�(����) Ŭ���� broker, manager, agent?
// �����(DB..) <==> UI�� (����?..) ���̿���
// todo ��Ű�� �������� ������� ��������� �������ִ� Ŭ����
// TodoVo (������) --- TodoDAO( �����Ϳ�����������Ʈ)

public class TodoManger {
	
	Connection conn; // DBMS ������ �����ϴ� ��� ���ذ�ü
	private static final String account = "DEVEL"; // ��Ű����/������
	private static final String pw = "1234";
	static final String url 
		= "jdbc:oracle:thin:@localhost:1521:xe"; 
			// IP �ּ�, port ��Ʈ 1521, SID ���񽺾��̵� xe 
				// XE ���� ���� ����Ŭ ���� (127.0.0.1 �ּ� �����Ŀ� �ִ� ���� - �������ּ�)
		//= "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL ���
	
	public TodoManger() { // �����ڿ��� ���ä�� ���� �¾�.
		beginConnection();
		
	}
	
	// DB�� �����ϱ� (�����ϱ� - ���ä�� �¾�)
	public boolean beginConnection() {
		try {
		// 1. ����Ŭ JDBC ������(����̹�) Ŭ���� '����' �ε�
		//Class.forName("oracle.jdbc.driver.racleDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. ����Ŭ DBMS ������ ��ſ����� ���� (���� ����) 
//		Connection conn = 
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB ���� ����! "
					+ new Date());
					//+ new java.util.Date());
		// 3. �������� �����̸� null�� �ƴ� ���ᰴü�� ���ϵ� 
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar�� ����ŬDB ����̹� �ε� ����!");
		} catch (SQLException e) {
			System.out.println("��� ���� ����!!! ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("java �Ϲ� ����!!!");
//			e.printStackTrace();
		}
		return false;
	}
	
	// DB���� ���������ϱ�
	public boolean endConnection() {
		if( conn != null ) {
			try {
				conn.close();
				System.out.println("DB ���� ����!!");
				return true;
			} catch (SQLException e) {
				System.out.println("DB ���� ����!!");
				e.printStackTrace();
			}
		}		
		return false;
	}
	
	// actor�� ~�� �� �ִ�.  
		// �ű� todo�� �ϳ��� ���ڵ�� �߰� �� �� �ִ�. 
		// id, memo, userName, memoType, // checked,// createdAt
		
		
		// memo, userName, memoType
		
		// memo, userName, memoType, strDate
//	insert into todos(id, memo, user_Name, memo_type, checked, created_at) 
//	              VALUES(TODO_SEQ.nextval, '���Ÿ ����� �����ϱ�', '����', 3, 0, TO_DATE('2021-12-25','YYYY-MM-DD'));
	public boolean insertNewTodoOnDay(String memo, String userName, int memoType, String strDate) {
		if(this.conn != null) {
			String sql = "insert into todos(id, memo, user_Name, memo_type, checked, created_at) " + 
					"VALUES(TODO_SEQ.nextval, '" + memo + "', '" + userName + "'," + memoType + ", 0, TO_DATE('" + strDate + "','YYYY-MM-DD'))";
			System.out.println("sql : " + sql);
			try {
				java.sql.Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				if(r == 1) { // 1���� ���ڵ� insert ����
					System.out.println("todo ���ڵ� �߰� ����: " + memo);
					return true;
				}else {
					System.out.println("todo ���ڵ� �߰� ����: " + memo);
				}
			} catch (SQLException e) {
				System.out.println("todo ���ڵ� �߰� ����: - SQL ����");
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
	
		// memo, userName
		
		// ���� todo�� �ϳ��� ����, ���� �� �� �ִ�. (�Ϸ�??)
		// ���� todo�� �ϳ��� ������ �� �ִ�.
		
		// ���� todo�� �ϳ��� ��ȸ�� �� �ִ�. 
		// ���� todo ��θ� ��ȸ�� �� �ִ�. (��ü, �Ⱓ, �����, Ÿ��...)
		public ArrayList<Todo> selectAllTodos() {
			if(this.conn != null) {
				ArrayList<Todo> tdList = new ArrayList<Todo>();
				String sql = "select * from todos order by created_at desc";
				try {
					java.sql.Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						//rs.getInt("�ʵ��")
						int id = rs.getInt("id");
						String memo = rs.getString("memo");
						String userName = rs.getString("user_Name");
						int memoType = rs.getInt("memo_Type");
						int checked = rs.getInt("checked");
						Date createdAt = rs.getDate("created_at");
						
						Todo td = new Todo(id, memo, userName, memoType,
								checked == Todo.DONE, createdAt);
						tdList.add(td);
					}
					System.out.println("DB���� ��ȸ�� todo ����: " + tdList.size());
					return tdList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
		public void printAllTodos() {
			if(this.conn != null) {
				String sql = "select * from todos order by created_at desc";
				try {
					java.sql.Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						//rs.getInt("�ʵ��")
						int id = rs.getInt("id");
						String memo = rs.getString("memo");
						String userName = rs.getString("user_Name");
						int memoType = rs.getInt("memo_Type");
						int checked = rs.getInt("checked");
						Date createdAt = rs.getDate("created_at");
						
						System.out.println("����: " + id + ", " + memo + ", " + userName + ", "
						+ memoType + ", " + checked + ", " + createdAt);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// todo ���/����??
	
	public static void main(String[] args) {
//		beginConnection(); // static 
		TodoManger tdMgr = new TodoManger();
		//tdMgr.beginConnection();
		
		// todo ��Ű���� ��ɿ� �µ��� ���� ����
//		tdMgr.printAllTodos();
		ArrayList<Todo> todos = tdMgr.selectAllTodos();
		for (int i = 0; i < todos.size(); i++) {
			Todo td = todos.get(i);
			String memo = td.getMemo();
			if(memo.equals("���� ����")) {
				td.setChecked(true);
			}
		}
		
		for (Todo td : todos) {
//			System.out.println(td);
//			System.out.println(td.getMemo() + td.getUserName());
			System.out.println(td.toList());
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~");
		tdMgr.insertNewTodoOnDay("���డ��", "����", Todo.MT_NORMAL, "2021-05-15");
		tdMgr.insertNewTodoOnDay("����ī ����", "����", Todo.MT_PROMISE, "2021-05-16");
		
		ArrayList<Todo> jhList = tdMgr.selectAllTodosForUser("����");
		System.out.println("���� TODO ����Ʈ::");
		for (Todo jh : jhList) {
			System.out.println(jh);
		}
		
//		endConnection();
		tdMgr.endConnection();
	}
	public ArrayList<Todo> selectAllTodosForUser(String user) {
		if(this.conn != null) {
			ArrayList<Todo> tdList = new ArrayList<Todo>();
			String sql = "select * from todos where user_name = '" + user + "' order by created_at desc";
			try {
				java.sql.Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					//rs.getInt("�ʵ��")
					int id = rs.getInt("id");
					String memo = rs.getString("memo");
					String userName = rs.getString("user_Name");
					int memoType = rs.getInt("memo_Type");
					int checked = rs.getInt("checked");
					Date createdAt = rs.getDate("created_at");
					
					Todo td = new Todo(id, memo, userName, memoType,
							checked == Todo.DONE, createdAt);
					tdList.add(td);
				}
				System.out.println("DB���� ��ȸ�� todo ����: " + tdList.size());
				return tdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

		// Ư�� ���� strDate�� ���ϴ� todos ���ڵ�鸸 ��ȸ�ϱ�
		// strDate => "2021-05-14"
		public ArrayList<Todo> selectAllTodos(String strDate) {
			if( this.conn != null ) {
				ArrayList<Todo> tdList = new ArrayList<Todo>();
				String sql = 
				"select * from todos where created_at "
				+ ">= TO_DATE('"+strDate+"','YYYY-MM-DD') "  
				+ " and created_at "
				+ "< TO_DATE('"+strDate+"','YYYY-MM-DD')+1";
				System.out.println("sql: " + sql);
				try {
					java.sql.Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while( rs.next() ) {
//						rs.getŸ��("�ʵ��");  
						int id = rs.getInt("id");
						String memo = rs.getString("memo");
						String userName = rs.getString("user_name");
						int memoType = rs.getInt("memo_type");
						int checked = rs.getInt("checked");
						Date createdAt = rs.getDate("created_at");
						
						Todo td = new Todo(id, memo, userName,
								memoType, 
								checked == Todo.DONE,
								createdAt);
								//checked == Todo.DONE ? true: false,
								//	createdAt);
						tdList.add(td);
					}
					System.out.println("DB���� ��ȸ�� todo ����: "
							+ tdList.size());
					return tdList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
			return null;
		}

	}

