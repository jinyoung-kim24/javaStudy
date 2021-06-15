package membership.manage;

//  7. ȸ������ �α��� ó���� �� �� �ִ�. (����/��ȣ)
// login, sign-in, authenticate
public interface MemberLogin {
	//public abstract boolean loginProcess(String id, String pw); 
				// {} no body
	boolean loginProcess(String id, String pw);
	 // public abstract ���� ������.
	
	//public abstract int loginProcessWithErrors(String id, String pw);
	int loginProcessWithErrors(String id, String pw);
	
	public static final int LOGIN_ERR_ID_NULL = 3;
	public static final int LOGIN_ERR_ID_EMPTY = 5;
	public static final int LOGIN_ERR_PW_NULL = 7;
	int LOGIN_ERR_PW_EMPTY = 9;
	int LOGIN_ERR_ID_NOT_FOUND = 11;
	int LOGIN_ERR_PW_MISMATCH = 13;
//	public static final int LOGIN_SUCCESS = 1;
	int LOGIN_SUCCESS = 1; // ����ƽ ���
	 // public static final ����
	
}
