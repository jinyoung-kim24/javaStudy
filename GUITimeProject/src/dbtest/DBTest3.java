package dbtest;

import java.sql.*; // JDBC 통신 연결용 모든 타입
import java.util.ArrayList;

import dbtest.data.Company;

// ojdbc6.jar jar 라이브러리를 다운로드 받아서 사용
// 11gXE에 호환가능한 버젼의 jar가 좋음.
// 데이터베이스서버와 자바(클라이언트) 프로그램이 통신하는 것은 TCP 수준의 
// 동기 통신을 통해서 진행됨.

// DB corporations TBL <----> java Company 클래스 대응관계
//		레코드 하나 						객체하나
public class DBTest3 {

	static Connection conn; // DBMS 서버와 접속하는 통로 기준객체
	private static final String account = "DEVEL"; // 스키마명/유저명
	private static final String pw = "1234";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// IP 주소 , port 포트 1521, SID 서비스아이디xe
	// xe 서비스 지역 오라클 서버 (127.0.0.1 주소 같은컴에 있는 서버 - 루프백주소)

	// DB에 연결하기 (접속하기 - 통신채널 셋업)
	public static boolean beginConnection() {
		try {
			// 1. 오라클 JDBC 연걸자(드라이버) 클래스 동적 로밍
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 DBSM 서버와 통신연결을 수행 (계정인증)
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB 접속 성공! " + new java.util.Date());
			// 3. 인증으로 정상이면 null이 아닌 연결객체가 리턴됨.
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar의 오라클DB 드라이버 로딩 실해!!");
		} catch (SQLException e) {
			System.out.println("통신 연결 실패!!!");
		} catch (Exception e) {
			System.out.println("java 일반 예외!!!");
//			e.printStackTrace();
		}
		return false;
	}
	// DB에서 접속해체하기
	public static boolean endConnection() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("DB 종료 성공");
				return true;
			} catch (SQLException e) {
				System.out.println("DB 종료 실패");
				e.printStackTrace();
			}
		}
		return false;
	}
	// 회사 스키마 접근
	// IT 회사 테이블의 내용을 가져와서 출력하기 (모든 레코드 조회)
	// DEVEL.coporations 테이블 select 조회
	public static ArrayList<Company> printAllCompaniesFromDB() {
		ArrayList<Company> companyList = new ArrayList<>();
		if(conn != null) { // 통신 정상 접속 연결중
			//4. 전송할 SQL 명령을 문자열로 준비함
			String sql = "select * from corporations";
			try {
				// 5. 통신채널conn으로 부터 문장 객체 얻어내서 준비
				Statement stmt = conn.createStatement();
				// 6. 문장 객체의 실행함수를 통해 실제적으로 sql 내용을 전송
				// 7. (select) 실행의 결과로 ResultSet 테이블 형태의
				// 		조회 결과데이터를 DB서버로 부터 응답으로 수신받음.
				ResultSet rs = stmt.executeQuery(sql);
				
				// 8. rs가 (널이아니라면)를 중심으로 레코드 순서대로
				// 		하나씩 레코드 단위로 탐색하며 루프 (처리할 결과 데이터가 있으면)
				// next()가 false면 더이상 레코드가 없다고 보고 루프 종료.
				while(rs.next()) {
					// 9. 이번 차례 해당 레코드 각각 대상 필드(컬럼)들을 각 타입으로 접근 get함.
//					rs.getInt(1); // 첫번째 필드/컬럼
					// 테이블 레코드가 스키마 객체에 대응 1:1
					Company cp = new Company(rs.getInt("id"),rs.getString("name"),
							rs.getString("domain"),rs.getString("ceo"),rs.getFloat("rate"),
							rs.getString("rank"));
//					System.out.println(cp);
					companyList.add(cp);
				}
				System.out.println("** IT회사들: " + companyList.size() + "개");
//				for (Company cp : companyList) {
//					System.out.println(cp);
//				}
				return companyList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("통신 채널 오류!!");
		}
		return null;
	}
	public static void main(String[] args) {
		beginConnection(); // 접속
		
		// DB 생성, 조작... 명령들을 수행하수 있는 영역
		ArrayList<Company> list = printAllCompaniesFromDB();
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				Company cp = list.get(i);
				System.out.println(cp.getName() + "(" + cp.getCeo() + ")");
			}
		}
		endConnection(); // 해제
	}
}