package db.mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import db.data.Recipe;
import db.mgr.*;
import db.util.*;

public class RecipeDBMgr {
	Connection conn;

	public RecipeDBMgr() {
		this.conn = OracleDBUtilMan.getConn();
	}

	public boolean insertNewMember(Recipe mb) {

		System.out.println(mb.getDishName());

		if (this.conn != null && mb != null) {
			String sql = "INSERT INTO recipe VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getMainDish());
				pstmt.setString(2, mb.getProcessPicture());
				pstmt.setString(3, mb.getProcessTxt());
				pstmt.setString(4, mb.getYoutubeAddress());
				pstmt.setString(5, mb.getServings());
				pstmt.setString(6, mb.getCookingTime());
				pstmt.setString(7, mb.getDifficulty());
				pstmt.setString(8, mb.getMaterial());
				pstmt.setInt(9, mb.getDishNum());
				pstmt.setString(10, mb.getDishName());
//				int r = pstmt.executeUpdate(); // 전송
//				if (r == 1) {
//					System.out.println("회원가입 성공" + mb);
//				} else {
//					System.out.println("회원가입 실패" + mb);
//				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("통신 에러");
		}
		return false;
	}

	public ArrayList<Recipe> selectAllMembers(String foodname) {
		if (this.conn != null) {
			ArrayList<Recipe> List = new ArrayList<>();
			String sql = "select * from recipes ORDER BY dish_num asc where = '" + foodname + "'";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Recipe mb = new Recipe(rs.getString("Main_Dish"), rs.getString("Process_Picture"),
							rs.getString("Process_Txt"), rs.getString("Youtube_Address"), rs.getString("Servings"),
							rs.getString("Cooking_Time"), rs.getString("Difficulty"), rs.getString("Material"),
							rs.getInt("Dish_Num"), rs.getString("Dish_Name"));
					List.add(mb);
				}
				System.out.println("DBMgr: 음식 조회 갯수 => " + List.size());
				return List;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	public ArrayList<Recipe> selectAllMembers() {
		if (this.conn != null) {
			ArrayList<Recipe> List = new ArrayList<>();
			String sql = "select * from recipes ORDER BY dish_num asc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Recipe mb = new Recipe(rs.getString("Main_Dish"), rs.getString("Process_Picture"),
							rs.getString("Process_Txt"), rs.getString("Youtube_Address"), rs.getString("Servings"),
							rs.getString("Cooking_Time"), rs.getString("Difficulty"), rs.getString("Material"),
							rs.getInt("Dish_Num"), rs.getString("Dish_Name"));
					List.add(mb);
				}
				System.out.println("DBMgr: 음식 조회 갯수 => " + List.size());
				return List;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	public ArrayList<Recipe> selectFoodMember(String foodName) {
		if(this.conn != null) {
			ArrayList<Recipe> List = new ArrayList<>();
			String sql = "select * from recipes where dish_name = '"+foodName+"' ORDER BY dish_name asc";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Recipe mb = new Recipe(rs.getString("Main_Dish"), rs.getString("Process_Picture"),
							rs.getString("Process_Txt"), rs.getString("Youtube_Address"), rs.getString("Servings"),
							rs.getString("Cooking_Time"), rs.getString("Difficulty"), rs.getString("Material"),
							rs.getInt("Dish_Num"), rs.getString("Dish_Name"));
					List.add(mb);
				}
				return List;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	public static void main(String[] args) {
		RecipeDBMgr Mgr = new RecipeDBMgr();
		System.out.println("기존");
		ArrayList<Recipe> List = Mgr.selectAllMembers();
		for (Recipe mb : List) {
			System.out.println(mb.toString());
		}
		OracleDBUtil.endConnection();
	}
}
