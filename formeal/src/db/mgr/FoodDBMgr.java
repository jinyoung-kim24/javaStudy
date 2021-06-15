package db.mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import db.data.Food;
import db.util.OrcaleDBUtil;

public class FoodDBMgr {

	static Connection conn;
	
	public FoodDBMgr() {
		this.conn = OrcaleDBUtil.getConn();
	}
	
	public boolean insertFood(Food fd) {
		if(this.conn != null && fd != null) {
			String sql = "INSERT INTO food VALUES (? ? ? ? ? )";
			System.out.println(sql);
			try {
				PreparedStatement pstmt
					= conn.prepareStatement(sql);
				pstmt.setInt(1, fd.getFoodnum());
				pstmt.setString(2, fd.getFoodname());
				pstmt.setString(3, fd.getFooding());
				pstmt.setInt(4, fd.getFoodquantity());
				pstmt.setInt(5, fd.getFoodprice());
				pstmt.setString(6, fd.getFoodimage());
				int r = pstmt.executeUpdate();
				if(r == 1) {
					System.out.println("DBMgr: 음식 장바구니 추가" + fd);
				} else {
					System.out.println("DBMgr: 음식 장바구니 추가 실패" + fd);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("DB 통신 에러!");
		}
		return false;
	}
	public ArrayList<Food> selectAllMembers() {
		if( this.conn != null ) {
			ArrayList<Food> mbList = new ArrayList<>();
			String sql = "select * from food ORDER BY food_num desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
						// varchar --> date
//					java.sql.Date joinDay 
//						= (java.sql.Date)rs.getDate("joined_at");
					Food fd 
						= new Food(rs.getInt("food_num"),
								rs.getString("food_name"), 
								rs.getString("food_ing"),
								rs.getInt("food_quantity"),
								rs.getInt("food_price"),
								rs.getString("food_image"));
//								rs.getDate("joined_at"));
							// joinedAt <-----> joined_at
					mbList.add(fd);
				}
				System.out.println("DBMgr: 회원 조회 명수 => " + mbList.size());
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	public ArrayList<Food> selectMembers(String FName) {
		if( this.conn != null ) {
			ArrayList<Food> mbList = new ArrayList<>();
			String sql = "select * from food where food_name = '" + FName + "'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
						// varchar --> date
//					java.sql.Date joinDay 
//						= (java.sql.Date)rs.getDate("joined_at");
					Food fd 
						= new Food(rs.getInt("food_num"),
								rs.getString("food_name"), 
								rs.getString("food_ing"),
								rs.getInt("food_quantity"),
								rs.getInt("food_price"),
								rs.getString("food_image"));
					mbList.add(fd);
				}
				System.out.println("DBMgr: 회원 조회 명수 => " + mbList.size());
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	// 수량 갱신하기
	public boolean updateCountFood(int fdquantity) {
		if(conn != null) {
			String sql = "update food set foodquantity = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fdquantity);
				int r = pstmt.executeUpdate();
				if(r == 1) {
					System.out.println("db 좋아요 회원리스트 갱신 성공!");
					return true;
				} else {
					System.out.println("db 좋아요 회원리스트 갱신 실패..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public int selectLikeCountForFood(int fdId) {
		if(conn != null) {
			String sql = "select food_quantity from "
					+ "foods where food_num = " + fdId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					return rs.getInt("food_quantity");
				} else {
					System.out.println("재료가 없어요");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public boolean updateLikeMembers(int foodquantity,int fdId) {
		if(conn != null) {
			String sql = "UPDATE food SET food_quantity = ? where food_num = ?;";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, foodquantity);
				pstmt.setInt(2, fdId);
				int r = pstmt.executeUpdate();
				if(r == 1) {
					System.out.println("db 좋아요 회원리스트 갱신 성공!");
					return true;
				} else {
					System.out.println("db 좋아요 회원리스트 갱신 실패..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		FoodDBMgr fdMgr = new FoodDBMgr();
		
		ArrayList<Food> fd = fdMgr.selectMembers(null);
		for (Food fd1 : fd) {
			System.out.println(fd1);
		}
//		((OrcaleDBUtil) conn).endConnection();
		
	}
}
