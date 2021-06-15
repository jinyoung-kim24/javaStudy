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
	
	// 로그인한 회원 액터가 신규 주문 하나를 추가할 수 있다.
	public boolean insertNewOrder(Order od) {
		if(this.conn != null && od != null) {
//			String sql = "insert into orders VALUES"
//					+ "(ORDER_SEQ.nextval, 'ON32Hluf9F', 1, 'elsa', 4, '바닐라라떼', sysdate, 2, 9000)";
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
					System.out.println("DB에 주문 record가 잘 생성");
					return true;
				} else {
					System.out.println("DB에 주문 record가 생성 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	// 관리자는 모든 주문 리스트를 조회할 수 있다.
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
				System.out.println("DBMgr: 회원 조회 명수 => " + odList.size());
				return odList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	// 회원은 자신이 주문한 모든 주문 리스트를 조회할 수 있다.
	
	// 특정 음식메뉴를 기준으로 모든 주문 리스트를 조회할 수 있다.
	
	// 특정 주문번호<<UQ>>로 하나의 주문을 상세 조회 할 수 있다.
	
	// 주문 관리번호 <<PK>>로 하나의 주문을 상세 조화 할 수 있다.
	
	
	public static void main(String[] args) {
		OrderDBMgr odMgr = new OrderDBMgr();
		
		ArrayList<Order> odList = odMgr.selectAllOrder();
		System.out.println("--- 기준 주문 리스트 ---");
		for (Order od : odList) {
			System.out.println(od);
		}
		Order tOd1 = new Order(Order.generateOrderNumber(), 2, "anna", 9, "큐브라떼", 5400);
		if(odMgr.insertNewOrder(tOd1)) {
			System.out.println("anna 주문 성공!!");
		}
		System.out.println("--- 갱신된 주문 리스트 ---");
		odList = odMgr.selectAllOrder();
		for (Order order : odList) {
			System.out.println(order);
		}
		OracleDBUtil.endConnection();
	}

}
