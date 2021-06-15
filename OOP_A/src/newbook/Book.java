package newbook;
// 도서관 도서관리 프로젝트
// 요구사항정의문서 SRS: SW 제품(프로젝트)에 필요한 모든 내용을 기술한 기획서..
// 스토리에 등장하는 모든 개념들 중에서... 주요 기능을 분석하고,
// 여기에 필요한 모든 개념들을 스키마(Schema)로 표현하고 이를 개별 클래스로 구현,

// 책이라는 개념(스키마)은 복합적인 속성 들로 구성됨
// 제목, 저자, 출판사, 가격, 거버이미지, 출간/발행년도 쪽수, ISBN, 장르....
// + 관리번호(입고순서), 평점, 코멘트(리뷰), 이력관리..

// 클래스는 새로운 타입(설계도), 
//클래스 = 데이터(필드=상수/변수) + 기능(함수;메소드)
public class Book {
	// 제목, 저자, 출판사, 가격, 거버이미지, 출간/발행년도 쪽수, ISBN, 장르....
	// + 관리번호(입고순서), 평점, 코멘트(리뷰), 이력관리..
	// 상수 필드( 클래스에 속한 공통상수)
	public static final String NO_TITLE = "제목 없음";
	public static final String NO_AUTHOR = "저자 없음";
	public static final int DEF_PUB = 0; // 국영 출판사
	public static final String DUMMY_COVER = "default/dummy.png";
	public static final String DUMMY_ISBN = "9876543210123";
	public static final String NO_COMMENT = "댓글없음"; // "";
	public static final String[] PUB_NAMES = {
			"국영 출판사", "재욱도서", "고전문학사", "길벗출판사", "생능출판사", "일본문화사"
	}; // publisher는 PUB_NAMES의 순서번호
	// 변수 필드
	public String title; // 제목
	public String author; // 저자
//	public String publisher; // 출판사
	public int publisher; // 출판사 등록번호?
//	public int price; // 가격
//	public Image cover; // 책표지사진? 
	public String imgPath; // 책표지 커버이미지 파일의 파일명/경로명 문자열
	public String ISBN; // 바코드
	
	public int no; // 관리번호(입고순서) 0 자동초기화
	public float rate; // 평점(5점척도) 0.0f 자동초기화
	public String comment; // 코멘트(리뷰)
	
	// 도서관에 입고 처리된 상태 필드
	public boolean stamp; // false 입고전, true 도장이 찍혀서 입고 완료
	
	
	// 생성자들
	// 생성자함수(클래스동일명; constructor)
	// => new를 통해 만들어지는 객체의 초기화를 담당.
	// => 리턴형이 없이 객체를 만들고 나서 초기화도 끝내고 나서
	// 그 정상 객체의 메모리상의 위치정보(주소 address 힙heap공간)를 리턴함
	
	// 기본생성자(더미생성자) 자동으로 정의되는 생성자함수
//	public Book() {} // 기본생성자는 (클래스내 생성자가 하나도 없을 때 생략가능)
	public Book() {} // 각 변수필드들은 자신의 타입의 기본값으로 자동 초기화..
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.comment = Book.NO_COMMENT;
		this.imgPath = DUMMY_COVER;
		publisher = DEF_PUB;
		this.no = 0;
		this.rate = 0.0f;
		this.ISBN = DUMMY_ISBN;
	}
	
	
	// 중간 생성자(필드들의 일부만 가지고 객체를 우선 만들기)
	public Book(String atitle, String aauthor, int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
//		imgPath = null; // 자동초기화
//		ISBN = null; // 자동초기화
//		no = 0; // 자동초기화
//		rate = 0.0f; // 자동초기화
//		comment = null; // 자동초기화
	}
	
	public Book(int no, String atitle, String aauthor, int apublisher) {
		title = atitle;
		author = aauthor;
		publisher = apublisher;
		// 객체필드변수 = 지역변수(인자)
		// this.필드변수 = 지역변수(인자)
//		imgPath = null; // 자동초기화
//		ISBN = null; // 자동초기화
//		no = no; // 자동초기화
		this.no = no; //자신에게 속한 no변수 필드에 인자 no를 활당.
//		this는  객체 자신의 주소(자기자신) ==> 이름공간을 구별.
//		rate = 0.0f; // 자동초기화
//		comment = null; // 자동초기화
	}
	
	// old 풀 생성자 (모든 필드 초기화 가능)
	public Book(String atitle, String aauthor, int apublisher,String aimgPath,
			String aISBN, int ano, float arate, String acomment) {
		
			title = atitle;
			author = aauthor;
			publisher = apublisher;
			imgPath = aimgPath;
			ISBN = aISBN;
			no = ano;
			rate = arate;
			comment = acomment;
					
	}
	// 입고 스탬프용 풀생성자
	public Book(String title, String author, int publisher, String imgPath, String iSBN, int no, float rate,
			String comment, boolean stamp) {
//		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.imgPath = imgPath;
		ISBN = iSBN;
		this.no = no;
		this.rate = rate;
		this.comment = comment;
		this.stamp = stamp;
	}

	// 입고 유무만 판단하여 출력하고 그 상태도 리턴해주는 함수
	public boolean isBookRegister() {
//		if(stamp == true) {
//			System.out.println(this.title + "이 책은 입고 되었습니다");
//		}else {
//			System.out.println(this.title + "이 책은 입고 전 입니다.");
//		}
		System.out.println(this.title + "책은" + (stamp ? "입고 되었습니다" : "입고 전 입니다"));		
		return stamp;
	}
	
	// 메소드
	// 평점 필드 변경 기능 - (평점 처리)
	// 0.0 ~ 5.0 범위제한?
//	public void changeRate(float rate) {
//		this.rate = rate;
//	}
	//임의 안전한 범위의 평점으로 재설정
	public boolean changeRate(float rate) {
		if(rate >= 0.0f && rate <= 5.0f) {
		this.rate = rate;
		System.out.println(">> 도서[" + title + "]의 평점이 " +
		rate + "으로 변경되었습니다");return true; 
		}else {
			System.out.println("평점 정수 범위 벗어난 에러: " + rate);
			return false;
		}
	}
	public static final float RATE_UNIT = 0.5f;
	public void increaseRate() {
		if(this.changeRate(this.rate + RATE_UNIT) == false) {
			this.rate = 5.0f;
		}
	}
	public void decreaseRate() {
		if(this.changeRate(this.rate - RATE_UNIT) == false) {
			this.rate = 0.0f;
		}
	}
	
	// 실수값의 평점 rate을 그래픽요소인 별표시로 출력하기
	// ****** => ☆★ 
	// 0.0 ~ 5.0 => rate을 6구간 대음
	// ☆☆☆☆☆
	// ★☆☆☆☆
	// ★★☆☆☆
	// ★★★☆☆
	// ★★★★☆
	// ★★★★★
	// private은 클래스 내부에서만 오직 접근 사용이됨 (보여짐)
	public String getStarRating3() {
		String stars = "";
		final String RSTARS[] = {
				"☆☆☆☆☆",	"★☆☆☆☆", "★★☆☆☆",
				"★★★☆☆", "★★★★☆", "★★★★★"
		};
		int starIndex = Math.round(rate);
		stars = RSTARS[starIndex];
		
		return "[" + stars + ">>"; 
	}
	private String getStarRating() {
		String stars = "";
		int starIndex = Math.round(rate);
		// 0.0 ~ 5.0 ==> 0
		switch (starIndex) {
		case 0: stars = "☆☆☆☆☆"; break;
		case 1: stars = "★☆☆☆☆"; break;
		case 2: stars = "★★☆☆☆"; break;
		case 3: stars = "★★★☆☆"; break;
		case 4: stars = "★★★★☆"; break;
		case 5: stars = "★★★★★"; break;
			// case별 숫자가 검은별(채워진 별의 개수)
		default: stars = "에러";
			break;
		}
		return "[" + stars; 
	}
	private String getStarRating2() {
		String stars = "";
		if(rate >= 0.0f && rate < 0.5f) {
			stars = "☆☆☆☆☆";
		 }else if(rate >= 0.5f && rate < 1.5f) {
			 stars = "★☆☆☆☆";
		 }
		 else if(rate < 2.5f) {
			 stars = "★★☆☆☆";
		 }
		 else if(rate < 3.5f) {
			 stars = "★★★☆☆";
		 }
		 else if(rate < 4.5f) {
			 stars = "★★★★☆";
		 }else if(rate <= 5.0f){
			 stars = "★★★★★";
		 }else {
			 stars = "에러";
		 }
		 return stars;
	}
	
	
	// 기존 평점 1.0 올리기
//	public void increaseRate() {
////		this.rate = this.rate + RATE_UNIT;
//		float tempRate = this.rate + RATE_UNIT;
//		if(tempRate >= 5.0f) {
//			System.out.println(">> 정수 MAX 벗어남! 5.0상한처리");
//			this.rate = 5.0f;
//		}else {
//			this.rate = tempRate;
//		}
//	}
//	// 기존 평점 1.0 내리기
//	public void decreaseRate() {
////		this.rate = this.rate - RATE_UNIT;
//		float tempRate = this.rate - RATE_UNIT;
//		if(tempRate < 0.0f) {
//			System.out.println(">> 정수 MIN 벗어남! 0.0하한처리");
//			this.rate = 0.0f;
//		}else {
//			this.rate = tempRate;
//		}
//	}
	
	//책 객체 내용 출력
	public void printBook() {
		System.out.printf("도서관 책: #Bk-%06d\n", no);
		System.out.println("제목: " + title);
		System.out.println("\t\t\t\t" + this.author + "지음");
//		System.out.println("\t출판사: " + this.publisher);
		System.out.println("\t출판사: " + (publisher >= 0 && publisher < PUB_NAMES.length ?
				PUB_NAMES[publisher] : "출판사 없음"));
		System.out.println("\t커버표지: " + imgPath);
		System.out.println("\tISBN: " + this.ISBN);
			String stars = this.getStarRating3();
		System.out.printf("\t\t 평점: (%s) %.2f/5.0 pt \n",stars, this.rate);
		System.out.printf("\t\t 리뷰: %s \n", comment);
		System.out.println("---------------------------------");
	}
	
}
