package branch.vote;
// 2016�⵵ �̱� �뼱 ��ǥ �ùķ��̼� 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// ���� vs. ���� ����
// donald trump vs. hilary cliton
// �����δ� 538�� (��ǥ, ��ǥ�ϴ� �� ������ �ִ�ġ)
// '�缱 Ȯ��'�ϰ� �Ǵ� �����δ��� ��ǥ��... �� 270�� 

public class VoteMain12 {

	// ��� ���� 
	public static final int MAX_VOTES = 538; // �ִ� �����δ� ��ǥ��
	public static final int WIN_VOTES = 270; // �缱Ȯ�� �����δ� ��ǥ��
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // ���� �ĺ���?
	public static final int GAP = 30; // 60; //40; //30; //50; //20; // ����
	
	
	// html�� ����� �����ֱ����� �Լ� �߰� 
	public static void printHTMLStart() {
		final String HTML_START 
			= "<!DOCTYPE html>"
			+ "<html>"
				+ "<head>"
//				+ "<meta charset=\"EUC-KR\" />" // \" ū����ǥ ������ü
				+ "<meta charset='EUC-KR' />"
					+ "<title> 2016�⵵ �̱��뼱 ��� </title>"
				+ "</head>"
				+ "<body>"
					+ "<h1>2016�⵵ �̱��뼱 �ùķ��̼�</h1>"
					+ "<img src= 'USA_vote2016.png' width='60%'>"
					+ "<hr>";
		System.out.println(HTML_START);				
	}
	public static void printHTMLEnd() {
		final String HTML_END = 
				  "</body>"
			+ "</html>";
		System.out.println(HTML_END);
	}

	
	public static void main(String[] args) {
		printHTMLStart();
		
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
		System.out.println("<ul>");
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
						"<div style='color: green; padding: 20px;"
						+ "border: solid 2px gray'> "
						+ "@@@ ���ε�Ʈ���� �缱 ���� �缱Ȯ�� @@@ " + vorder 
							+ "ȸ������ " + voteCountDonald + "��ǥ!");
					bAlmostWin = true;
					System.out.println("</div>");
				}
				if( voteCountHilary == WIN_VOTES ) {
					System.out.println(
						"<div style='color: pink; padding: 20px;"
						+ "border: solid 2px gray'> "
						+ " @@@ ������Ŭ���� �缱 ���� �缱Ȯ�� @@@ "+ vorder 
							+ "ȸ������ " + voteCountHilary + "��ǥ!");
					bAlmostWin = true;
					System.out.println("</div>");
				}
			}
			// GAP ==> 30ȸ �ֱ�� ������ ������ǥ��Ȳ ǥ��
			//if( vorder == GAP ) {
			//if( vorder == status ) {
			if( vorder % GAP == 0 ) { // ���� ����
				System.out.println("<li>");
				// ������ �����ڷ�.. �������ó��.. �� ������ ������ ������ ���ϱ������� �ݺ���
				System.out.printf(
				//"[%3d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
				//"[%03d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",						
				"<b style='color: blue'>[��ǥ ����� %.2f%%] ��ǥ��Ȳ:</b> <br> Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",						
				(double)vorder / MAX_VOTES * 100.0, 
				voteCountDonald, voteCountHilary,
				voteCountEtc);
//				status += GAP;  //status = status + GAP;
				
				// �̹� ���� ������ �켼 ����
				double donaldRatio = 
					(double)voteCountDonald / MAX_VOTES * 100.0;
							
				System.out.println("<br>");
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
				System.out.println("</li>");
			} // ���� ��
			
			
			//			
			++vorder; //vorder++; //vorder += 1;  // vorder = vorder + 1;
		} // loop exit
		System.out.println("</ul>");
		
		System.out.println(" ===  ���� �δ� ��ǥ �� ��ǥ �� === ");
		
		// ���� ��� ��� 
		System.out.println("\n\n <h2>--- ���� ��ǥ ��� ---</h2> ");
		System.out.printf(
			"\t���� ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",
				voteCountDonald, voteCountHilary,
				voteCountEtc);
		// �缱�� �����Ͽ� ��� d, h (��Ÿ�� ������)
		System.out.print("\t <p style='color: orange'> <b>****** �缱�� : ");
		if(voteCountDonald > voteCountHilary) // trump win
			System.out.println(" ���ε� Ʈ����!!!");
		else if(voteCountDonald < voteCountHilary) // clinton win
			System.out.println(" ������ Ŭ����!!!");
		else // draw ���� 
			System.out.println(" ���º�! ���� �ٽ�!!");
		System.out.println("</b> </p>");	
		printHTMLEnd();
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
[��ǥ ����� 5.58%] ��ǥ��Ȳ: Donald 12ǥ vs. Hilary 17ǥ (��Ÿ: 1ǥ)
	=== �켼 ���� ===
	 ���ε� 2.23% < ������ 3.16% 
[��ǥ ����� 11.15%] ��ǥ��Ȳ: Donald 31ǥ vs. Hilary 27ǥ (��Ÿ: 2ǥ)
	=== �켼 ���� ===
	 ���ε� 5.76% > ������ 5.02% 
[��ǥ ����� 16.73%] ��ǥ��Ȳ: Donald 43ǥ vs. Hilary 45ǥ (��Ÿ: 2ǥ)
	=== �켼 ���� ===
	 ���ε� 7.99% < ������ 8.36% 
[��ǥ ����� 22.30%] ��ǥ��Ȳ: Donald 57ǥ vs. Hilary 59ǥ (��Ÿ: 4ǥ)
	=== �켼 ���� ===
	 ���ε� 10.59% < ������ 10.97% 
[��ǥ ����� 27.88%] ��ǥ��Ȳ: Donald 74ǥ vs. Hilary 70ǥ (��Ÿ: 6ǥ)
	=== �켼 ���� ===
	 ���ε� 13.75% > ������ 13.01% 
[��ǥ ����� 33.46%] ��ǥ��Ȳ: Donald 87ǥ vs. Hilary 83ǥ (��Ÿ: 10ǥ)
	=== �켼 ���� ===
	 ���ε� 16.17% > ������ 15.43% 
[��ǥ ����� 39.03%] ��ǥ��Ȳ: Donald 108ǥ vs. Hilary 91ǥ (��Ÿ: 11ǥ)
	=== �켼 ���� ===
	 ���ε� 20.07% > ������ 16.91% 
[��ǥ ����� 44.61%] ��ǥ��Ȳ: Donald 124ǥ vs. Hilary 104ǥ (��Ÿ: 12ǥ)
	=== �켼 ���� ===
	 ���ε� 23.05% > ������ 19.33% 
[��ǥ ����� 50.19%] ��ǥ��Ȳ: Donald 136ǥ vs. Hilary 118ǥ (��Ÿ: 16ǥ)
	=== �켼 ���� ===
	 ���ε� 25.28% > ������ 21.93% 
[��ǥ ����� 55.76%] ��ǥ��Ȳ: Donald 151ǥ vs. Hilary 133ǥ (��Ÿ: 16ǥ)
	=== �켼 ���� ===
	 ���ε� 28.07% > ������ 24.72% 
[��ǥ ����� 61.34%] ��ǥ��Ȳ: Donald 167ǥ vs. Hilary 146ǥ (��Ÿ: 17ǥ)
	=== �켼 ���� ===
	 ���ε� 31.04% > ������ 27.14% 
[��ǥ ����� 66.91%] ��ǥ��Ȳ: Donald 182ǥ vs. Hilary 159ǥ (��Ÿ: 19ǥ)
	=== �켼 ���� ===
	 ���ε� 33.83% > ������ 29.55% 
[��ǥ ����� 72.49%] ��ǥ��Ȳ: Donald 201ǥ vs. Hilary 170ǥ (��Ÿ: 19ǥ)
	=== �켼 ���� ===
	 ���ε� 37.36% > ������ 31.60% 
[��ǥ ����� 78.07%] ��ǥ��Ȳ: Donald 219ǥ vs. Hilary 182ǥ (��Ÿ: 19ǥ)
	=== �켼 ���� ===
	 ���ε� 40.71% > ������ 33.83% 
[��ǥ ����� 83.64%] ��ǥ��Ȳ: Donald 238ǥ vs. Hilary 193ǥ (��Ÿ: 19ǥ)
	=== �켼 ���� ===
	 ���ε� 44.24% > ������ 35.87% 
[��ǥ ����� 89.22%] ��ǥ��Ȳ: Donald 248ǥ vs. Hilary 212ǥ (��Ÿ: 20ǥ)
	=== �켼 ���� ===
	 ���ε� 46.10% > ������ 39.41% 
[��ǥ ����� 94.80%] ��ǥ��Ȳ: Donald 262ǥ vs. Hilary 225ǥ (��Ÿ: 23ǥ)
	=== �켼 ���� ===
	 ���ε� 48.70% > ������ 41.82% 
 @@@ ���ε�Ʈ���� �缱 ���� �缱Ȯ�� @@@ 528ȸ������ 270��ǥ!
 ===  ���� �δ� ��ǥ �� ��ǥ �� === 


 --- ���� ��ǥ ��� --- 
	���� ��ǥ��Ȳ: Donald 275ǥ vs. Hilary 238ǥ (��Ÿ: 25ǥ)
	 ****** �缱�� :  ���ε� Ʈ����!!!
 
 */