package db.mgr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.data.Foods;
import db.util.OracleDBUtil;
import formeal.shop.formealMainFrame;
import formeal.ui.foods.FoodsMainFrame;





public class FoodsDBMgr {
	
//String type;
//String cookM;
//String eatP;
//String cookG;
	
Connection conn;
	
	public FoodsDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	public ArrayList<Foods> selectAllFoods() {
		if( this.conn != null ) {
			ArrayList<Foods> mbList = new ArrayList<>();
			String sql = "select * from foods";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					
					Foods fb 
						= new Foods(rs.getString("food_type"),
								rs.getString("food_name"), 
								rs.getInt("make_minute"),
								rs.getInt("eating_person"),
								rs.getString("cook_grade"),
								rs.getString("image_path")
								);

					mbList.add(fb);
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
	
	public Foods selectFoodforType(String FName){
		System.out.println(FName);
		
		if( this.conn != null ) {
			
			String sql = "select * from foods where food_name = '" + FName + "'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) {	
					
					Foods fb 
						= new Foods(rs.getString("food_type"),
								rs.getString("food_name"), 
								rs.getInt("make_minute"),
								rs.getInt("eating_person"),
								rs.getString("cook_grade"),
								rs.getString("image_path")
								);
System.out.println(fb);
					return fb;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	public ArrayList<Foods> selectAllFoodforType(String FName){
		System.out.println(FName);
		
		if( this.conn != null ) {
			
			String sql = "select * from foods where food_name = '" + FName + "'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if( rs.next() ) {	
					
					Foods fb 
						= new Foods(rs.getString("food_type"),
								rs.getString("food_name"), 
								rs.getInt("make_minute"),
								rs.getInt("eating_person"),
								rs.getString("cook_grade"),
								rs.getString("image_path")
								);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}


	public ArrayList<Foods> selectFoodforType(String type,String cookM,String eatP,String cookG) {
		if( this.conn != null ) {
			ArrayList<Foods> mbList = new ArrayList<>();
			String sql = "select * from foods where food_type like '"+type
					+"' and  make_minute like '"+cookM
					+"' and eating_person like '"+eatP
					+"' and cook_grade like '"+cookG+"'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					
					Foods fb 
						= new Foods(rs.getString("food_type"),
								rs.getString("food_name"), 
								rs.getInt("make_minute"),
								rs.getInt("eating_person"),
								rs.getString("cook_grade"),
								rs.getString("image_path")
								);

					mbList.add(fb);
				}
				System.out.println("DBMgr: 음식 조회 명수 => " + mbList.size());
				return mbList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	public ArrayList<Foods> selectKoreaFood() {
		if( this.conn != null ) {
			ArrayList<Foods> mbList = new ArrayList<>();
			String sql = "select * from foods where food_type like '한식'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					
					Foods fb 
						= new Foods(rs.getString("food_type"),
								rs.getString("food_name"), 
								rs.getInt("make_minute"),
								rs.getInt("eating_person"),
								rs.getString("cook_grade"),
								rs.getString("image_path")
								);

					mbList.add(fb);
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
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		FoodsDBMgr fbMgr = new FoodsDBMgr();
		
		ArrayList<Foods> newList = fbMgr.selectFoodforType("한식", "15", "1","초급");
		for (Foods mb : newList) {
			System.out.println(mb);
		}

	}
}

