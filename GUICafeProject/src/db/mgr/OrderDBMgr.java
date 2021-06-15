package db.mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import db.data.Member;
import db.data.Order;
import db.util.OracleDBUtil;

public class OrderDBMgr {
	
	Connection conn;
	
	public OrderDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// �α����� ȸ�� ���Ͱ� �ű� �ֹ� �ϳ��� �߰��� �� �ִ�.
	public boolean insertNewOrder(Order od) {
		if(this.conn != null && od != null) {
//			String sql = "insert into orders VALUES"
//					+ "(ORDER_SEQ.nextval, 'ON32Hluf9F', 1, 'elsa', 4, '�ٴҶ��', sysdate, 2, 9000)";
			String sql = "insert into orders VALUES"
					+ "(ORDER_SEQ.nextval, ?, ?, ?, ?, ?, sysdate, ?, ?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, od.getOrderNum());
				pstmt.setInt(2, od.getMemberId());
				pstmt.setString(3, od.getMemberLogin());
				pstmt.setInt(4, od.getFoodId());
				pstmt.setString(5, od.getFoodName());
				pstmt.setInt(6, od.getUnit());
				pstmt.setInt(7, od.getTotalPrice());
				int r = pstmt.executeUpdate();
				if(r == 1) {
					System.out.println("DB�� �ֹ� record�� �� ����");
					return true;
				} else {
					System.out.println("DB�� �ֹ� record�� ���� ����");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	// �����ڴ� ��� �ֹ� ����Ʈ�� ��ȸ�� �� �ִ�.
	public ArrayList<Order> selectAllOrder(){
		if( this.conn != null ) {
			ArrayList<Order> odList = new ArrayList<>();
			String sql = "select * from orders ORDER BY ordered_at desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					Order od = new Order(rs.getInt("id"),
							rs.getString("order_Num"),
							rs.getInt("member_Id"),
							rs.getString("member_Login"),
							rs.getInt("food_Id"),
							rs.getString("food_Name"),
							rs.getDate("ordered_at"),
							rs.getInt("unit"),
							rs.getInt("total_Price"));
					odList.add(od);
				}
				System.out.println("DBMgr: ȸ�� ��ȸ ��� => " + odList.size());
				return odList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB ��� ����!!");
		}
		return null;
	}
	// ȸ���� �ڽ��� �ֹ��� ��� �ֹ� ����Ʈ�� ��ȸ�� �� �ִ�.
	
	// Ư�� ���ĸ޴��� �������� ��� �ֹ� ����Ʈ�� ��ȸ�� �� �ִ�.
	
	// Ư�� �ֹ���ȣ<<UQ>>�� �ϳ��� �ֹ��� �� ��ȸ �� �� �ִ�.
	
	// �ֹ� ������ȣ <<PK>>�� �ϳ��� �ֹ��� �� ��ȭ �� �� �ִ�.
	
	
	public static void main(String[] args) {
		OrderDBMgr odMgr = new OrderDBMgr();
		
		ArrayList<Order> odList = odMgr.selectAllOrder();
		System.out.println("--- ���� �ֹ� ����Ʈ ---");
		for (Order od : odList) {
			System.out.println(od);
		}
		Order tOd1 = new Order(Order.generateOrderNumber(), 2, "anna", 9, "ť���", 5400);
		if(odMgr.insertNewOrder(tOd1)) {
			System.out.println("anna �ֹ� ����!!");
		}
		System.out.println("--- ���ŵ� �ֹ� ����Ʈ ---");
		odList = odMgr.selectAllOrder();
		for (Order order : odList) {
			System.out.println(order);
		}
		OracleDBUtil.endConnection();
	}

}
