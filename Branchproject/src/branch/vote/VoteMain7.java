package branch.vote;
// 2016�⵵ �̱� �뼱 ��ǥ �ùķ��̼� 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// ���� vs. ���� ����
// donald trump vs. hilary cliton
// �����δ� 538�� (��ǥ, ��ǥ�ϴ� �� ������ �ִ�ġ)
// '�缱 Ȯ��'�ϰ� �Ǵ� �����δ��� ��ǥ��... �� 270�� 

public class VoteMain7 {

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
			
			// GAP ==> 30ȸ �ֱ�� ������ ������ǥ��Ȳ ǥ��
			//if( vorder == GAP ) {
			//if( vorder == status ) {
			if( vorder % GAP == 0 ) { 
				// ������ �����ڷ�.. �������ó��.. �� ������ ������ ������ ���ϱ������� �ݺ���
				System.out.printf(
				//"[%3d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
				//"[%03d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
						"[��ǥ �����%.02f%%] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
				(double)vorder / MAX_VOTES * 100.0, voteCountDonald, voteCountHilary,
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
			}
			
			
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
[030 ȸ��] ��ǥ��Ȳ: Donald 14ǥ vs. Hilary 13ǥ (��Ÿ: 3ǥ)
	=== �켼 ���� ===
	 ���ε尡 winning~~~
[060 ȸ��] ��ǥ��Ȳ: Donald 26ǥ vs. Hilary 28ǥ (��Ÿ: 6ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[090 ȸ��] ��ǥ��Ȳ: Donald 39ǥ vs. Hilary 43ǥ (��Ÿ: 8ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[120 ȸ��] ��ǥ��Ȳ: Donald 54ǥ vs. Hilary 52ǥ (��Ÿ: 14ǥ)
	=== �켼 ���� ===
	 ���ε尡 winning~~~
[150 ȸ��] ��ǥ��Ȳ: Donald 67ǥ vs. Hilary 68ǥ (��Ÿ: 15ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[180 ȸ��] ��ǥ��Ȳ: Donald 82ǥ vs. Hilary 81ǥ (��Ÿ: 17ǥ)
	=== �켼 ���� ===
	 ���ε尡 winning~~~
[210 ȸ��] ��ǥ��Ȳ: Donald 94ǥ vs. Hilary 97ǥ (��Ÿ: 19ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[240 ȸ��] ��ǥ��Ȳ: Donald 109ǥ vs. Hilary 111ǥ (��Ÿ: 20ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[270 ȸ��] ��ǥ��Ȳ: Donald 122ǥ vs. Hilary 127ǥ (��Ÿ: 21ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[300 ȸ��] ��ǥ��Ȳ: Donald 137ǥ vs. Hilary 141ǥ (��Ÿ: 22ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[330 ȸ��] ��ǥ��Ȳ: Donald 155ǥ vs. Hilary 150ǥ (��Ÿ: 25ǥ)
	=== �켼 ���� ===
	 ���ε尡 winning~~~
[360 ȸ��] ��ǥ��Ȳ: Donald 167ǥ vs. Hilary 166ǥ (��Ÿ: 27ǥ)
	=== �켼 ���� ===
	 ���ε尡 winning~~~
[390 ȸ��] ��ǥ��Ȳ: Donald 179ǥ vs. Hilary 183ǥ (��Ÿ: 28ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[420 ȸ��] ��ǥ��Ȳ: Donald 193ǥ vs. Hilary 197ǥ (��Ÿ: 30ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[450 ȸ��] ��ǥ��Ȳ: Donald 208ǥ vs. Hilary 212ǥ (��Ÿ: 30ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[480 ȸ��] ��ǥ��Ȳ: Donald 221ǥ vs. Hilary 227ǥ (��Ÿ: 32ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
[510 ȸ��] ��ǥ��Ȳ: Donald 233ǥ vs. Hilary 244ǥ (��Ÿ: 33ǥ)
	=== �켼 ���� ===
	 �������� winning~~~
 ===  ���� �δ� ��ǥ �� ��ǥ �� === 


 --- ���� ��ǥ ��� --- 
	���� ��ǥ��Ȳ: Donald 246ǥ vs. Hilary 258ǥ (��Ÿ: 34ǥ)
	 ****** �缱�� :  ������ Ŭ����!!!
 
 */

