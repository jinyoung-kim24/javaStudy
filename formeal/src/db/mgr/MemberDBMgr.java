package db.mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import db.data.Member;
import db.util.OracleDBUtilJong;

public class MemberDBMgr {
	Connection conn;
	
	public MemberDBMgr() {
		this.conn = OracleDBUtilJong.getConn();
	}
	
	public boolean insertNewMember(Member mb) {
		
		System.out.println(mb.getBirthday());
		
		if(this.conn != null && mb != null) {
			String sql
					= "INSERT INTO manager  VALUES (?, ?, to_date(?,'RRRRMMDD'), ?, ?, " + 
							"        ?, ?, ?, ?, manager_SEQ.nextval, ?, sysdate)";
			System.out.println(sql);
			try {
				PreparedStatement pstmt 
							= conn.prepareStatement(sql);
				pstmt.setString(1, mb.getId());
				pstmt.setString(2, mb.getPw());
				pstmt.setString(3, mb.getBirthday());
				pstmt.setInt(4, mb.getGender());
				pstmt.setString(5, mb.getName());
				pstmt.setString(6, mb.getAddress());
				pstmt.setString(7, mb.getPostNum());
				pstmt.setString(8, mb.getEmail());				
				pstmt.setString(9, mb.getPhoneNumber());				
				pstmt.setInt(10, mb.getAge());
				int r = pstmt.executeUpdate(); // 전송
				if( r == 1 ) {
					System.out.println("회원가입 성공" + mb);
				} else {
					System.out.println("회원가입 실패" + mb);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		} else {
			System.out.println("통신 에러");
		}
		return false;
	}
	public Member selectMemberLogin(String mbLogin) {
		if(conn != null) {
			String sql = "select * from manager" 
						+ " where id = ?"; // 무조건 띄어쓰기
		try {
			PreparedStatement pstmt =
					conn.prepareStatement(sql);		
			pstmt.setString(1, mbLogin);
			ResultSet rs = pstmt.executeQuery();
			if( rs.next() ) {
				Member mb =
						new Member(rs.getString("id"),
								rs.getString("password"), 
								rs.getString("birthday"),
								rs.getInt("gender"),
								rs.getString("name"),
								rs.getString("address"),
								rs.getString("postNum"),
								rs.getString("email"),
								rs.getString("phoneNumber"),
								rs.getInt("controlnum"),
								rs.getInt("age"),
								rs.getDate("joinDay"));
				return mb;
			} else {
				System.out.println(mbLogin + "로그인 계정이 DB에 없거나 에러가 남");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	} else {
		System.out.println("DB 통신 불안정");
	}
		return null;
}
	
	public ArrayList<Member> selectAllMembers() {
		if( this.conn != null ) {
			ArrayList<Member> List = new ArrayList<>();
			String sql = "select * from manager ORDER BY controlnum desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {	
					Member mb 
						= new Member(rs.getString("id"),
								rs.getString("password"), 
								rs.getString("birthday"),
								rs.getInt("gender"),
								rs.getString("name"),
								rs.getString("address"),
								rs.getString("postnum"),
								rs.getString("email"),
								rs.getString("phonenumber"),
								rs.getInt("controlnum"),
								rs.getInt("age"),
								rs.getDate("joinDay"));
					List.add(mb);
				}
				System.out.println("DBMgr: 회원 조회 명수 => " + List.size());
				return List;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	public static final int LOGIN_SUCCESS = 1; // 인증 성공
	public static final int LOGIN_FAIL_PW_MISMATCH = 2; // 암호 불일치
	public static final int LOGIN_FAIL_NOT_FOUND = 3; // 회원계정 없음
	public static final int LOGIN_ERROR = 4; // 기타 에러
	public int loginProcess(String id, String pw) {
		if( id == null || pw == null || 
				id.isEmpty() || pw.isEmpty() ) {
			System.out.println("로그인 인증에 대한 입력 에러");
			return LOGIN_ERROR;
		}
		if( this.conn != null ) {
			Member mb = selectMemberLogin(id);
			if( mb != null ) {
				String mPw = mb.getPw();
				if( mPw != null && !mPw.isEmpty() ) {
					if( mPw.equals(pw) ) {
						System.out.println("로그인 인증 성공");
						return LOGIN_SUCCESS;
					} else {
						System.out.println("암호 불일치");
						return LOGIN_FAIL_PW_MISMATCH;
					}
				} else {
					System.out.println("로그인 인증에 대한 PW 에러");
					return LOGIN_ERROR;
				}						
			} else {
				System.out.println("잘못된 로그인 이름이거나 없는 회원");
				return LOGIN_FAIL_NOT_FOUND;
			}
		}
		else {
			System.out.println("DB 통신 에러!!");
		}		
		return LOGIN_ERROR;
	}
	
	public Member checkID(String name, String phoneNumber) {
		
		if(this.conn != null) {
			String sql = "select * from manager id "
					+ "where name='"+name+"' and phonenumber= '"+phoneNumber+"'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				Member mb = null;
				if(rs.next()) {
				mb = new Member(rs.getString("id"));
			}
			System.out.println("DB 조회 " + mb);
			return mb;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("오류");
		}
		return null;
	}
	
public Member checkPW(String id, String phoneNumber) {
		if(this.conn != null) {
			String sql = "select * from manager password "
					+ "where id='"+id+"' and phonenumber= '"+phoneNumber+"'";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				Member mb = null;
				if(rs.next()) {
				mb = new Member(rs.getString("password"));
			}
			System.out.println("DB 조회 " + mb);
			return mb;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("오류");
		}
		return null;
	}

	
//	public String findID() {
//		if(this.conn != null) {
//			String sql = "select * from manager id "
//					+ "where name='호랑이' and phonenumber= '01012345678'";
//	public String findID(String id, String phoneNumber) {
//		if(this.conn != null) {
//			String sql = "select * from manager id "
//					+ "where name='"+id+"' and phonenumber= '"+phoneNumber+"'";
//			try {
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
//				if(rs.equals(id) && rs.equals(phoneNumber)) {
//					return rs.getString("id");
//				} else {
//					System.out.println("그냥 찾지마");
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	
	public static void main(String[] args) {
		MemberDBMgr Mgr = new MemberDBMgr();
		System.out.println("기존");
		ArrayList<Member> List = Mgr.selectAllMembers();
		for (Member mb : List) {
			System.out.println(mb.toString());
		}
		
//		Mgr.insertNewMember(new Member("jsajsa", "1234", "2021-05-21", Member.GENDER_MALE, 
//				"김철수", "서울특별시 성동구 왕십리", 10821, "kkk@formeal.com", "01012345678", 21));
		
		System.out.println("추가 -----------");
		ArrayList<Member> newList = Mgr.selectAllMembers();
		for (Member mb : newList) {
			System.out.println(mb);
		}
		
//		ArrayList<Member> checkList = Mgr.checkID("호랑이", "01012345678");
//		for (Member mb : checkList) {
//			System.out.println(mb);
//		}
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">> 아이디: " );
//		String ID = sc.next();
//		System.out.print(">> 암호: " );
//		String PW = sc.next();
//		
//		int loginR = Mgr
//				.loginProcess(ID, PW);
//		if( loginR == LOGIN_SUCCESS ) {
//			Member mb = Mgr.selectMemberLogin(ID);
//			System.out.println(PW + "("+ 
//						mb.getName() +")인증 되었습니다");
//			System.out.println("메인페이지로 이동합니다");
//		}
		
		OracleDBUtilJong.endConnection();
	}
}
