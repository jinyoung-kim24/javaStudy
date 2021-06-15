package branch.vote;
// 2016�⵵ �̱� �뼱 ��ǥ �ùķ��̼� 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// ���� vs. ���� ����
// donald trump vs. hilary cliton
// �����δ� 538�� (��ǥ, ��ǥ�ϴ� �� ������ �ִ�ġ)
// '�缱 Ȯ��'�ϰ� �Ǵ� �����δ��� ��ǥ��... �� 270�� 

public class VoteMain8 {

	// ��� ���� 
	public static final int MAX_VOTES = 538; // �ִ� �����δ� ��ǥ��
	public static final int WIN_VOTES = 270; // �缱Ȯ�� �����δ� ��ǥ��
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // ���� �ĺ���?
	public static final int GAP = 30; // 60; //40; //30; //50; //20; // ����
	
	public static void main(String[] args) {
		// ���� ���� - ���� party �ĺ��� ��ǥ�� ī���� ���� 
		int voteCountDonald = 0;// = 0; // 48% == 1 ~ 48 => 'D'
		int voteCountHilary = 0; // 48% == 49 ~ 96 => 'H'
		int voteCountEtc = 0; // 4% => 'E'
		
		// �����δ��� ���� ��ǥ�� �ϴ�() 
		// => 1���� ��ǥ�� ����, ��ǥ�� ���� ��ǥ�� �÷��� �� 
		
		int vorder = 1; // vote order ��ǥ ȸ���� ī���� (������ȣ)
		boolean bAlmostWin = false; // ���ݼ� �缱Ȯ�� '����' ��ǥ ����
		//final int GAP = 30; //50; //20; // ����
		//int status = GAP; // ���� ���� ���� 30, 60, 90,...
		//while(bFlag == true) {
		// �������ǽ� 
		while(vorder <= MAX_VOTES) { // vorder <= 538
			// �����ϰ� �����δ��� ��ǥ��.
			// 48 : 48 : 4   =>   3�� party ����
			char party = voteToParty(); // 'D', 'H', 'E'
			
			// ��ǥ�� ���� ���� D, H, E
			if( party == DONALD_PARTY ) // 'D')
				voteCountDonald++; // ���ε�� ��ǥ 1+
			else if( party == HILARY_PARTY )
				voteCountHilary++;
			else 
				voteCountEtc++;
			
//			System.out.printf("[%d ȸ��] �����δ� ��ǥ => %c \n", 
//					vorder, party); // ����, ����, Ÿ�� ��ġ...
			
			// ���ݼ� '�缱Ȯ��' ó��!!  
			if( bAlmostWin == false ) {
				if( voteCountDonald == WIN_VOTES ) {
					System.out.println(
						" @@@ ���ε�Ʈ���� �缱 ���� �缱Ȯ�� @@@ " + vorder 
							+ "ȸ������ " + voteCountDonald + "��ǥ!");
					bAlmostWin = true;
				}
				if( voteCountHilary == WIN_VOTES ) {
					System.out.println(
						" @@@ ������Ŭ���� �缱 ���� �缱Ȯ�� @@@ "+ vorder 
							+ "ȸ������ " + voteCountHilary + "��ǥ!");
					bAlmostWin = true;
				}
			}
			// GAP ==> 30ȸ �ֱ�� ������ ������ǥ��Ȳ ǥ��
			//if( vorder == GAP ) {
			//if( vorder == status ) {
			if( vorder % GAP == 0 ) { // ���� ����
				// ������ �����ڷ�.. �������ó��.. �� ������ ������ ������ ���ϱ������� �ݺ���
				System.out.printf(
				//"[%3d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
				//"[%03d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",						
				"[��ǥ ����� %.2f%%] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",						
				(double)vorder / MAX_VOTES * 100.0, 
				voteCountDonald, voteCountHilary,
				voteCountEtc);
//				status += GAP;  //status = status + GAP;
				
				// �̹� ���� ������ �켼 ����
				double donaldRatio = 
					(double)voteCountDonald / MAX_VOTES * 100.0;
							
				System.out.println("\t=== �켼 ���� ===");
				char winLose; // ><=
				if( voteCountDonald > voteCountHilary )
					winLose = '>';
					//System.out.println("\t ���ε尡 winning~~~");
//					System.out.printf("\t ���ε� %.2f%% > ������ %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				else if( voteCountDonald < voteCountHilary )
					winLose = '<';
//					System.out.println("\t �������� winning~~~");
//					System.out.printf("\t ���ε� %.2f%% < ������ %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				else 
					winLose = '=';
//					System.out.println("\t �� �ĺ����� ���º� ��~~~");
//					System.out.printf("\t ���ε� %.2f%% = ������ %.2f%% \n", 
//							donaldRatio, 
//							(double)voteCountHilary /MAX_VOTES * 100.0 );
				
					// %% => '%' ���ڷ� ���
				System.out.printf("\t ���ε� %.2f%% %c ������ %.2f%% \n", // '>' '<' '=' 
						donaldRatio, 
						winLose,
						(double)voteCountHilary /MAX_VOTES * 100.0 );
			} // ���� ��
			
			
			//			
			++vorder; //vorder++; //vorder += 1;  // vorder = vorder + 1;
		} // loop exit
		
		System.out.println(" ===  ���� �δ� ��ǥ �� ��ǥ �� === ");
		
		// ���� ��� ��� 
		System.out.println("\n\n --- ���� ��ǥ ��� --- ");
		System.out.printf(
			"\t���� ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
				voteCountDonald, voteCountHilary,
				voteCountEtc);
		// �缱�� �����Ͽ� ��� d, h (��Ÿ�� ������)
		System.out.print("\t ****** �缱�� : ");
		if(voteCountDonald > voteCountHilary) // trump win
			System.out.println(" ���ε� Ʈ����!!!");
		else if(voteCountDonald < voteCountHilary) // clinton win
			System.out.println(" ������ Ŭ����!!!");
		else // draw ���� 
			System.out.println(" ���º�! ���� �ٽ�!!");
			
	}

	public static char voteToParty() {
		char party;
		int ranVote = (int)(Math.random() * 100) + 1; // 1 ~ 100
		if( ranVote >= 1 && ranVote <= 48 ) 
			party = DONALD_PARTY; // 'D'; // �����尡 ��ǥ ����.		
		//else if( ranVote > 48 && ranVote <= 96 )
		else if( ranVote <= 96 )
			party = HILARY_PARTY; //'H'
		else 	
			party = ETC_PARTY; // 'E'
		
		return party;
	}

}

/*
[��ǥ ����� 5.58%] ��ǥ��Ȳ: Donald 17ǥ vs. Hilary 13ǥ (��Ÿ: 0ǥ)
=== �켼 ���� ===
 ���ε� 3.16% > ������ 2.42% 
[��ǥ ����� 11.15%] ��ǥ��Ȳ: Donald 35ǥ vs. Hilary 24ǥ (��Ÿ: 1ǥ)
=== �켼 ���� ===
 ���ε� 6.51% > ������ 4.46% 
[��ǥ ����� 16.73%] ��ǥ��Ȳ: Donald 48ǥ vs. Hilary 41ǥ (��Ÿ: 1ǥ)
=== �켼 ���� ===
 ���ε� 8.92% > ������ 7.62% 
[��ǥ ����� 22.30%] ��ǥ��Ȳ: Donald 65ǥ vs. Hilary 53ǥ (��Ÿ: 2ǥ)
=== �켼 ���� ===
 ���ε� 12.08% > ������ 9.85% 
[��ǥ ����� 27.88%] ��ǥ��Ȳ: Donald 81ǥ vs. Hilary 66ǥ (��Ÿ: 3ǥ)
=== �켼 ���� ===
 ���ε� 15.06% > ������ 12.27% 
[��ǥ ����� 33.46%] ��ǥ��Ȳ: Donald 92ǥ vs. Hilary 82ǥ (��Ÿ: 6ǥ)
=== �켼 ���� ===
 ���ε� 17.10% > ������ 15.24% 
[��ǥ ����� 39.03%] ��ǥ��Ȳ: Donald 101ǥ vs. Hilary 102ǥ (��Ÿ: 7ǥ)
=== �켼 ���� ===
 ���ε� 18.77% < ������ 18.96% 
[��ǥ ����� 44.61%] ��ǥ��Ȳ: Donald 114ǥ vs. Hilary 116ǥ (��Ÿ: 10ǥ)
=== �켼 ���� ===
 ���ε� 21.19% < ������ 21.56% 
[��ǥ ����� 50.19%] ��ǥ��Ȳ: Donald 132ǥ vs. Hilary 128ǥ (��Ÿ: 10ǥ)
=== �켼 ���� ===
 ���ε� 24.54% > ������ 23.79% 
[��ǥ ����� 55.76%] ��ǥ��Ȳ: Donald 151ǥ vs. Hilary 137ǥ (��Ÿ: 12ǥ)
=== �켼 ���� ===
 ���ε� 28.07% > ������ 25.46% 
[��ǥ ����� 61.34%] ��ǥ��Ȳ: Donald 164ǥ vs. Hilary 154ǥ (��Ÿ: 12ǥ)
=== �켼 ���� ===
 ���ε� 30.48% > ������ 28.62% 
[��ǥ ����� 66.91%] ��ǥ��Ȳ: Donald 177ǥ vs. Hilary 169ǥ (��Ÿ: 14ǥ)
=== �켼 ���� ===
 ���ε� 32.90% > ������ 31.41% 
[��ǥ ����� 72.49%] ��ǥ��Ȳ: Donald 194ǥ vs. Hilary 182ǥ (��Ÿ: 14ǥ)
=== �켼 ���� ===
 ���ε� 36.06% > ������ 33.83% 
[��ǥ ����� 78.07%] ��ǥ��Ȳ: Donald 208ǥ vs. Hilary 198ǥ (��Ÿ: 14ǥ)
=== �켼 ���� ===
 ���ε� 38.66% > ������ 36.80% 
[��ǥ ����� 83.64%] ��ǥ��Ȳ: Donald 221ǥ vs. Hilary 215ǥ (��Ÿ: 14ǥ)
=== �켼 ���� ===
 ���ε� 41.08% > ������ 39.96% 
[��ǥ ����� 89.22%] ��ǥ��Ȳ: Donald 233ǥ vs. Hilary 231ǥ (��Ÿ: 16ǥ)
=== �켼 ���� ===
 ���ε� 43.31% > ������ 42.94% 
[��ǥ ����� 94.80%] ��ǥ��Ȳ: Donald 248ǥ vs. Hilary 244ǥ (��Ÿ: 18ǥ)
=== �켼 ���� ===
 ���ε� 46.10% > ������ 45.35% 
===  ���� �δ� ��ǥ �� ��ǥ �� === 


--- ���� ��ǥ ��� --- 
���� ��ǥ��Ȳ: Donald 265ǥ vs. Hilary 253ǥ (��Ÿ: 20ǥ)
 ****** �缱�� :  ���ε� Ʈ����!!!
*/