package branch.vote;
// 2016�⵵ �̱� �뼱 ��ǥ �ùķ��̼� 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// ���� vs ����
// donald trump vs hilary cliton
// �����δ� 538�� ( ��ǥ, ��ǥ�ϴ� �� ������ �ִ�ġ)
// �缱 Ȯ�� �ϰ� �Ǵ� �����δ��� ��ǥ��..... �� 270��
public class VoteMain2 {

	// ��� ����
	public static final int MAX_VOTES = 538; // �ִ� �����δ� ��ǥ��
	public static final int WIN_VOTES = 270; // �缱 Ȯ�� �����δ� ��ǥ��
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // ���� �ĺ���
	
	public static void main(String[] args) {
		// ���� ���� - party �ĺ��� ��ǥ�� ������ ����
		int voteCountDonald = 0; // 48% == 1 ~ 48 => 'D'
		int voteCountHilary = 0; // 48% == 49 ~ 96 => 'H'
		int voteCountEtc = 0; // 4% == 97 ~ 100 => 'E'
		// ���� �δ��� ���� ��ǥ�� �ϴ�() 
		//=> 1���� ��ǥ�� ����, ��ǥ�� ���� ��ǥ�� �÷��� ��
		
		int vorder = 1; // vote order ��ǥ ȸ���� ī���� (���� ��ȣ)
		 
		while(vorder <= MAX_VOTES) { // vorder <= 538
			
		
		// �����ϰ� �����δ��� ��ǥ��.
		// 48:48:4
		char party = 0;
		int ranvote = (int) (Math.random() * 100) + 1; // 1 ~ 100
			if(ranvote >= 1 && ranvote <= 48) party = DONALD_PARTY; 
			//else if(ranvote > 48 && ranvote <= 96)	party = HILARY_PARTY;
			else if(ranvote <= 96) party = HILARY_PARTY;
			else party = ETC_PARTY;
			System.out.printf(">> [%d ȸ��] �����δ� ��ǥ => %c \n", vorder, party); // ���� ���� Ÿ�� ��ġ�ؾ���.
			//System.out.printf(">> �����δ� ��ǥ => %c \n", party);
			vorder++;
		} // loop exit
			System.out.println("=== ���� �δ� ��ǥ �� ��ǥ �� ===");
	}

}
