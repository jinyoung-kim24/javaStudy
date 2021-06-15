# 회원제 Cafe 주문시스템
> 음료, 음식... 주문할 수 있는 카페 관리 시스템
> 회원제로 운영됨.
> 관리자를 통해 주문 관리/통계, 회원관리, ...

## 패키지 구조
+cafe
+cafe.ui
+cafe.ui.member
+cafe.ui.admin
+cafe.db.data
+cafe.db.mgr
+cafe.db.util

## 액터
- 비회원(주문 가능?)
- 회원 (가입, 승인?)
- 관리자(회원의 한 종류? 별도?)

## 주요기능
- 신규회원 가입 할 수 있다 C 
- 기존 회원이 자신의 정보를 편집수정 (갱신) 할 수 있다. U
- 모든 기존 회원들을 조회핳 수 있다 R
- 특정 기존 회원 한 명을 조회할 수 있다. R
- 기존 회원이 탈퇴할 수 있다.(삭제?) D
- 특정 활동에 대한 보상으로 회원 마일리지 적립할 수 있다.
- 회원이 로그인/로그아웃...
- (회원 통계)
- (관리자는/스탭) 음료/음식을 추가할 수 있다
- (관리자는) 음료/음식의 내용 수정갱신 할 수 있다. 
- (관리자는) 음료/음식을 삭제 할 수 있다.
- (관리자는) 음료/음식을 모두 조회 할 수 있다.
- (관리자는) 음료/음식을 한 개를 상세 조회 할 수 있다.
- (관리자는) 음료/음식 통계?
- 회원은 음료/음식을 좋아요 할 수 있다. (추천, 퍼가기, 찜, 팔로우, 구독)
- 회원이 음료/음식을 주문 할 수 있다.
- 회원이 음료/음식을 주문하면 주문서가 발행될 수 있다.
- 주문... 최소, 확인, 갱신, .. , 통계?

## 스키마
> 음식(음료), 회원, 주문, ...
> DB: CAFE (oracle)

### 회원 Member (액터)
> CAFE.members TBL 테이블
> data.db.Member 데이터 클래스
> db.mgr.MemberDBMgr 테이터 DB중개자 클래스

- id 관리번호(DB 기준 생성, 중복x, not null) 
	int <<PK>> + 시퀀스 적용(CAFE.member_seq 시퀀스 적용)
- name 회원 실명 (UI 입력) varchar2 24 (* 편집가능)
- login 로그인명 (UI 입력) varchar2 4~12 중복x unique <<UQ>> NN
- pw 패스워드 (UI 입력) varchar2 4~12 NN (* 편집가능)
- age 회원 나이 (UI 입력) int 18세 기본 18~50세... (* 편집가능)
- gender 회원 성별 (UI 입력) int 1 여성, 2 남성 
- mileage 마일리지 활동 포인트 (DB 기준 생성) int 1000점 기본 (* 편집가능)
- joinedAt 가입날자(DB 기준 생성) Date 

### 음식(음료) Food (대상 컨텐트)
> CAFE.foods TBL
> data.db.Food 데이터 클래스
> db.mgr.FoodDBMgr 테이터 DB중개자 클래스

- id 관리번호(DB 기준 생성, 중복x, not null) 
	int <<PK>> + 시퀀스 적용(CAFE.food_seq 시퀀스 적용)
- name 음식/음료 이름 (관리자가 UI 입력) varchar2 32 NN
- category 종류카테고리 (관리자가 UI 입력) varchar2 32 기본 '음료' 
- imagePath (관리자가 UI 입력/선택) 음식/음료 사진 파일 경로 varchar2 512
- <1.1> description (관리자가 UI 입력/선택) 설명문 varchar 1024
- price 가격 (관리자가 UI 입력) int 1000원 기본
- hotIce 핫아이스 (관리자가 UI 입력/선택) int 1 HOT 2 ICE
- regDate 등록날자(개시) (관리자가 UI 입력/선택) date
- like_members 좋아요 한회원들 id, (login) 기억... String
- like_count 좋아요한회원명수 int

### 주문 Order (기능)
> CAFE.orders TBL
> db.data.Order 테이터 클래스
> db.mgr.OrderDBMgr 데이터 중개자 클래스
> 회원 누가? 어느 음식을 무엇을? 주문하는가?

- id 관리번호(DB 기준 생성, 중복x, not null) 
	int <<PK>> + 시퀀스 적용(CAFE.order_seq 시퀀스 적용)
- orderNum 주문번호 10자리 문자들 char 10 NN (unique)
- member_id <<PK>> => 외래키 <<FK>> 누가 주문
		회원 1명 여러개의 주문을 할 수 있다. 1:n 대응관계
- member_login <<UQ>>
- memberName 
- food_id <<FK>> 무엇을 주문 외래키
- foodName
- orderAt 주문날자 
- unit 주문상품단위개수 int 기본 1개
- totalPrice 총합가격 (옵션, 단위수량...) int 기본 0원
- .....


