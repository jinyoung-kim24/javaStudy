package db.mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.data.Food;
import db.util.OracleDBUtil;

public class FoodDBMgr {
	Connection conn;
	public FoodDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// ����/������ Ư�� ������ �ϳ��� �߰� �� �� �ִ�.
	public boolean addNewOneFood(Food fd) {
		if( conn != null && fd != null ) {
//	String sql = "INSERT INTO foods VALUES("
//	+ "FOOD_SEQ.nextval,'ī��ḶŰ����', 'Ŀ��',"
//	+ "'./images/menu_thumb/ī��ḶŰ����.PNG', "
//	+ "3800, 2, sysdate,'',0,'����...')";		
			String sql = "INSERT INTO foods VALUES("
				+ "FOOD_SEQ.nextval, ?, ?, ?, ?, ?, "
				+ "sysdate,'',0, ?)";
			try {
				PreparedStatement pstmt =
						conn.prepareStatement(sql);
				pstmt.setString(1, fd.getName());
				pstmt.setString(2, fd.getCategory());
				pstmt.setString(3, fd.getImagePath());
				pstmt.setInt(4, fd.getPrice());
				pstmt.setInt(5, fd.getHotIce());
				pstmt.setString(6, fd.getDescription());
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(
							fd.getName() + " ���� ���ڵ� �߰� ����!");
					return true;
				} else {
					System.out.println(
							fd.getName() + " ���� ���ڵ� �߰� ����..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // else ..
		return false;
	}
	public boolean addNewOneFood(String name, String category, 
			String imagePath, int price, int hotIce, 
			String description) {
		
		return false;
	}
	
	// ����/������ Ư�� ������ �ϳ��� id�� ��ȸ�� �� �ִ�. 
	// ����/������ Ư�� ������ �ϳ��� �̸��� ��ȸ�� �� �ִ�.
	// ����ڴ� ��ü ������ ��ȸ�� �� �ִ�.
	public ArrayList<Food> selectAllFoods() {
		if( conn != null ) {
			//String sql = "select * from foods";
			String sql = "select * from foods order by id asc";
			ArrayList<Food> foodList = new ArrayList<>();
			try {
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
					Food food
					 = new Food(
					rs.getInt("id"), rs.getString("name"),
					rs.getString("category"),
					rs.getString("image_path"), 
					rs.getInt("price"),
					rs.getInt("hot_ice"),
					rs.getDate("reg_date"),
					rs.getString("like_members"),
					rs.getInt("like_count"), 
					rs.getString("description"));// 1.1
					foodList.add(food);
				}
				System.out.println("��ȸ�� ���� DB���ڵ� ��: " + 
						foodList.size());
				return foodList;				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	// ����/������ Ư�� ������ �ϳ��� ���� ������ �� �ִ�.
	// Ư�� ī�װ��� ���ĵ��� ��ȸ�� �� �ִ�. 
	// ��ü ���� ������ üũ�� �� �ִ�.
	// Ư�� Ű������ �κ���ġ�ϴ� ��� ���ĵ��� �˻��� �� �ִ�.
	
	// *�α��� ���� ȸ���� Ư�� ���Ŀ� ���� ���ƿ�/����� �� �ִ�.
	// Ư�� ������ ���ƿ�ȸ������Ʈ (���ڿ�) 
	public String selectLikeMembersForFood(int fdId) {
		if( conn != null ) {
			String sql = "select like_members from "
					+ "foods where id = "+ fdId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {					
					return rs.getString("like_members");
				} else {
					System.out.println(fdId + " ������ �����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return null;
	}
	// Ư�� ������ ���ƿ�ȸ��ī��Ʈ (����)
	public int selectLikeCountForFood(int fdId) {
		if( conn != null ) {
			String sql = "select like_count from "
					+ "foods where id = "+ fdId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {					
					return rs.getInt("like_count");
				} else {
					System.out.println(fdId + " ������ �����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return 0;
	}
	
	// Ư�� ������ ���ƿ� ȸ������ ����Ʈ�� �����ϴ� �Լ�
	public static final String SEP = ",";
	public ArrayList<String>
		selectLikeMembersForFoodAsList(int fdId){
		ArrayList<String> lkList = new ArrayList<String>();
		String oldLikeMembers = selectLikeMembersForFood(fdId);
		// null
		// ""
		// "4"
		// 3,5,10,2 => [3,5,10,2] split() 
		if(oldLikeMembers != null && !oldLikeMembers.isEmpty()) {
			// �Ѹ��̻� �ֳ�
			if(oldLikeMembers.contains(SEP)) {	
				// �� ������ ���ƿ� split ����
				String[] temps = oldLikeMembers.split(SEP);
				for (String mbIdStr : temps) {
					lkList.add(mbIdStr);
				}
			} else {
				// ȥ�ڼ� �Ѹ� ���ƿ� �ĸ��� ��� split() �ƴ�.
				lkList.add(oldLikeMembers);
			}
			return lkList;
		} else {
			return null;
		}
	}
	
	// �̹� mbIdȸ���� fdId ������ �̸� ���� ���ƿ� üũ
	public boolean isAlreadyLikeFood(int fdId, int mbId) {
		ArrayList<String> lkList = selectLikeMembersForFoodAsList(fdId);
		if(lkList == null || lkList.isEmpty()) {
			System.out.println("���� �ƹ��� ���ƿ� ���߾��..");
			return false;
		} else { // �̹� ���ƿ� �� ȸ������ �־��.
			for (String lkMbId : lkList) {
				if(lkMbId.equals(String.valueOf(mbId))) {
					System.out.println(mbId + "ȸ������ �̹� ���ƿ� �ϼ̾��!!");
					return true;
				}
			}
		}
		return false;
	}
	
	// Ư�� ������ ���ƿ�ȸ������Ʈ�� �α����� ȸ���� id�� �߰��� �� �ִ�.
	public boolean addLikeToFood(int fdId, int mbId) {
		// �̹� mbIdȸ���� fdId ������ �̸� ���� ���ƿ� ���� ���?
		if(isAlreadyLikeFood(fdId, mbId) == true){
			System.out.println(mbId + " ȸ���� �̹� ���ƿ� �߾��");
			return true;
		}
		// Ư�� ������ ���� ���ƿ�ȸ������Ʈ (���ڿ�)
		String oldLikeMembers = selectLikeMembersForFood(fdId);
		// Ư�� ������ ���� ���ƿ�ȸ��ī��Ʈ (����)
		int oldLikeCount = selectLikeCountForFood(fdId);
		
		boolean b = false;
		// ������ ���ƿ� �߰��� ���...
		//if( oldLikeMembers == null || oldLikeMembers.isEmpty() )
		if( oldLikeCount == 0 ) {
			b = updateLikeMembers(fdId, ""+mbId, 1);
		} else {
			// �̹� ���ƿ��� �ٸ� ȸ������ 1�� �̻��� ���... 
			// "1" ==> "1,7"    "3,100,32" ==> "3,100,32,7" 
			String newLikeMermbers =
					oldLikeMembers + "," + mbId;
			b = updateLikeMembers(fdId, newLikeMermbers,
					oldLikeCount+1);
		}
		
		if( b ) {
			System.out.println("foods ���ƿ� DB ���� ����!");
			return true;
		} else {
			System.out.println("foods ���ƿ� DB ���� ����..");
			return false;
		}
	}
	
	// Ư�� ���Ŀ� ���� ���ƿ�ȸ������Ʈ, ���ƿ䴩��ī��Ʈ ���ÿ� �����ϱ�
	public boolean updateLikeMembers(int fdId, 
			String likeMembers, int likeCount) {
		if( conn != null ) {
			String sql = "update foods set "
					+ " like_members = ?, "
					+ " like_count = ? "
					+ " where id = ?"; 
			try {
				PreparedStatement pstmt
					= conn.prepareStatement(sql);
				pstmt.setString(1, likeMembers);
				pstmt.setInt(2, likeCount);
				pstmt.setInt(3, fdId);
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println("db ���ƿ� ȸ������Ʈ ���� ����!");
					return true;
				} else {
					System.out.println("db ���ƿ� ȸ������Ʈ ���� ����..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
