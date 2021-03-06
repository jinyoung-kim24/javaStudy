package ui.calendarMain.db.data;

import java.util.Date;

/* 달력 날자기반 할일을 표현하는 스키마
 * 
 * 투두
 * todo 개념
 * 
 * Todo 클래스 <------> MYTIME.todos 테이블
 * 
 * id 관리번호 int <------>	 number <<pk>>
 * memo 할일(내용) String <------> varchar2(145)
 * userName 사용자이름 String <------> user_name varchar2(24)
 * memoType 투두 종류 int <------> memo_type number
 * 			default 1; 1 약속, 2. 회의, 3. 구매, 4. 업무, 5. 일반... 
 * checked 완료상태 boolean <------> number(int) 1 완료, 0미완료
 * createdAt 생성날자 Date <------> created_at date
 * 
 */
public class Todo {
	public static final int DONE = 1; // 1 완료 true
	public static final int UNDONE = 0; // 0 미완료 false
	public static final int MT_PROMISE = 1;
	public static final int MT_MEETING = 2;
	public static final int MT_PURCHASE = 3;
	public static final int MT_JOB = 4;
	public static final int MT_NORMAL = 5;
	public static final String[] MTYPES = { 
			" ", "1 약속", "2. 회의", "3. 구매", "4. 업무", "5. 일반"
	};
	private int id; // 관리번호 int <------> number <<pk>>
	private String memo; // 할일(내용) String <------> varchar2(145)
	private String userName; // 사용자이름 String <------> user_name varchar2(24)
	private int memoType; // 투두 종류 int <------> memo_type number
	// default 1; 1 약속, 2. 회의, 3. 구매, 4. 업무, 5. 일반...
	private boolean checked; // 완료상태 boolean <------> number(int) 1 완료, 0미완료
	private Date createdAt; // 생성날자 Date <------> created_at date 타겟날자 범위 유효날자

	public Todo() {
	}

	public Todo(String memo, String userName, int memoType) {
		super();
		this.memo = memo;
		this.userName = userName;
		this.memoType = memoType;
	}

	public Todo(int id, String memo, String userName, int memoType, boolean checked, Date createdAt) {
		super();
		this.id = id;
		this.memo = memo;
		this.userName = userName;
		this.memoType = memoType;
		this.checked = checked;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMemoType() {
		return memoType;
	}

	public void setMemoType(int memoType) {
		this.memoType = memoType;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", memo=" + memo + ", userName=" + userName + ", memoType=" + memoType + ", checked="
				+ checked + ", createdAt=" + createdAt + "]";
	}

	public String toList() {
		return (checked ? "[v]" : "[ ]") + "#" + id + " | " + memo + " | " + MTYPES[memoType] + " | " + userName + " | " + createdAt + " | ";
				//		return "Todo [id=" + id + ", memo=" + memo + ", userName=" + userName + ", memoType=" + memoType + ", checked="
//				+ checked + ", createdAt=" + createdAt + "]";
	}
}
