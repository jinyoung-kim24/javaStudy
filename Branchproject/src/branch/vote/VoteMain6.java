package branch.vote;
// 2016�⵵ �̱� �뼱 ��ǥ �ùķ��̼� 
// https://ko.wikipedia.org/wiki/2016%EB%85%84_%EB%AF%B8%EA%B5%AD_%EB%8C%80%ED%86%B5%EB%A0%B9_%EC%84%A0%EA%B1%B0
// https://namu.wiki/w/2016%EB%85%84%20%EB%AF%B8%EA%B5%AD%20%EB%8C%80%ED%86%B5%EB%A0%B9%20%EC%84%A0%EA%B1%B0
// https://ww.namu.la/s/28813ddfc7dc7c38c07003f9b20a79b8492da9d171794eb6ae40fe19de385b50ea70ccb95cbfcf2c3b84112e9a372d581767e695c67f2e9dd629469e862d86fb1cadb604521d984fa1c3586daf348895a4739172b863a9b519e53dc7d1b4e40796e23f1757cd5437f6fd584a7b5975dc
// ���� vs. ���� ����
// donald trump vs. hilary cliton
// �����δ� 538�� (��ǥ, ��ǥ�ϴ� �� ������ �ִ�ġ)
// '�缱 Ȯ��'�ϰ� �Ǵ� �����δ��� ��ǥ��... �� 270�� 

public class VoteMain6 {

	// ��� ���� 
	public static final int MAX_VOTES = 538; // �ִ� �����δ� ��ǥ��
	public static final int WIN_VOTES = 270; // �缱Ȯ�� �����δ� ��ǥ��
	public static final char DONALD_PARTY = 'D';
	public static final char HILARY_PARTY = 'H';
	public static final char ETC_PARTY = 'E'; // ���� �ĺ���?
	public static final int GAP = 30; //40; //30; //50; //20; // ����
	
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
				"[%03d ȸ��] ��ǥ��Ȳ: Donald %dǥ vs. Hilary %dǥ (��Ÿ: %dǥ)\r\n",						
				vorder, voteCountDonald, voteCountHilary,
				voteCountEtc);
//				status += GAP;  //status = status + GAP;
				
				// �̹� ���� ������ �켼 ����
				System.out.println("\t === �켼 ���� ===");
				if(voteCountDonald > voteCountHilary)
					System.out.println("\t ���ε尡 winning~~~");
				else if(voteCountDonald < voteCountHilary)
					System.out.println("\t �������� winnig~~~");
				else
					System.out.println("\t �� �ĺ����� ���º���~~~");
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

[1 ȸ��] �����δ� ��ǥ => H 
[2 ȸ��] �����δ� ��ǥ => H 
[3 ȸ��] �����δ� ��ǥ => D 
[4 ȸ��] �����δ� ��ǥ => H 
[5 ȸ��] �����δ� ��ǥ => H 
[6 ȸ��] �����δ� ��ǥ => H 
[7 ȸ��] �����δ� ��ǥ => D 
[8 ȸ��] �����δ� ��ǥ => D 
[9 ȸ��] �����δ� ��ǥ => H 
[10 ȸ��] �����δ� ��ǥ => D 
[11 ȸ��] �����δ� ��ǥ => H 
[12 ȸ��] �����δ� ��ǥ => H 
[13 ȸ��] �����δ� ��ǥ => H 
[14 ȸ��] �����δ� ��ǥ => D 
[15 ȸ��] �����δ� ��ǥ => H 
[16 ȸ��] �����δ� ��ǥ => D 
[17 ȸ��] �����δ� ��ǥ => H 
[18 ȸ��] �����δ� ��ǥ => D 
[19 ȸ��] �����δ� ��ǥ => D 
[20 ȸ��] �����δ� ��ǥ => H 
[21 ȸ��] �����δ� ��ǥ => H 
[22 ȸ��] �����δ� ��ǥ => D 
[23 ȸ��] �����δ� ��ǥ => D 
[24 ȸ��] �����δ� ��ǥ => D 
[25 ȸ��] �����δ� ��ǥ => H 
[26 ȸ��] �����δ� ��ǥ => D 
[27 ȸ��] �����δ� ��ǥ => H 
[28 ȸ��] �����δ� ��ǥ => D 
[29 ȸ��] �����δ� ��ǥ => H 
[30 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 13ǥ vs. Hilary 17ǥ (��Ÿ: 0ǥ)
[31 ȸ��] �����δ� ��ǥ => E 
[32 ȸ��] �����δ� ��ǥ => D 
[33 ȸ��] �����δ� ��ǥ => D 
[34 ȸ��] �����δ� ��ǥ => D 
[35 ȸ��] �����δ� ��ǥ => D 
[36 ȸ��] �����δ� ��ǥ => H 
[37 ȸ��] �����δ� ��ǥ => D 
[38 ȸ��] �����δ� ��ǥ => D 
[39 ȸ��] �����δ� ��ǥ => H 
[40 ȸ��] �����δ� ��ǥ => D 
[41 ȸ��] �����δ� ��ǥ => D 
[42 ȸ��] �����δ� ��ǥ => D 
[43 ȸ��] �����δ� ��ǥ => H 
[44 ȸ��] �����δ� ��ǥ => D 
[45 ȸ��] �����δ� ��ǥ => D 
[46 ȸ��] �����δ� ��ǥ => D 
[47 ȸ��] �����δ� ��ǥ => H 
[48 ȸ��] �����δ� ��ǥ => D 
[49 ȸ��] �����δ� ��ǥ => H 
[50 ȸ��] �����δ� ��ǥ => D 
[51 ȸ��] �����δ� ��ǥ => D 
[52 ȸ��] �����δ� ��ǥ => D 
[53 ȸ��] �����δ� ��ǥ => D 
[54 ȸ��] �����δ� ��ǥ => H 
[55 ȸ��] �����δ� ��ǥ => H 
[56 ȸ��] �����δ� ��ǥ => H 
[57 ȸ��] �����δ� ��ǥ => H 
[58 ȸ��] �����δ� ��ǥ => H 
[59 ȸ��] �����δ� ��ǥ => D 
[60 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 32ǥ vs. Hilary 27ǥ (��Ÿ: 1ǥ)
[61 ȸ��] �����δ� ��ǥ => D 
[62 ȸ��] �����δ� ��ǥ => H 
[63 ȸ��] �����δ� ��ǥ => H 
[64 ȸ��] �����δ� ��ǥ => D 
[65 ȸ��] �����δ� ��ǥ => D 
[66 ȸ��] �����δ� ��ǥ => H 
[67 ȸ��] �����δ� ��ǥ => D 
[68 ȸ��] �����δ� ��ǥ => D 
[69 ȸ��] �����δ� ��ǥ => H 
[70 ȸ��] �����δ� ��ǥ => D 
[71 ȸ��] �����δ� ��ǥ => H 
[72 ȸ��] �����δ� ��ǥ => H 
[73 ȸ��] �����δ� ��ǥ => D 
[74 ȸ��] �����δ� ��ǥ => D 
[75 ȸ��] �����δ� ��ǥ => H 
[76 ȸ��] �����δ� ��ǥ => D 
[77 ȸ��] �����δ� ��ǥ => D 
[78 ȸ��] �����δ� ��ǥ => D 
[79 ȸ��] �����δ� ��ǥ => D 
[80 ȸ��] �����δ� ��ǥ => H 
[81 ȸ��] �����δ� ��ǥ => H 
[82 ȸ��] �����δ� ��ǥ => D 
[83 ȸ��] �����δ� ��ǥ => D 
[84 ȸ��] �����δ� ��ǥ => D 
[85 ȸ��] �����δ� ��ǥ => H 
[86 ȸ��] �����δ� ��ǥ => D 
[87 ȸ��] �����δ� ��ǥ => H 
[88 ȸ��] �����δ� ��ǥ => H 
[89 ȸ��] �����δ� ��ǥ => H 
[90 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 49ǥ vs. Hilary 40ǥ (��Ÿ: 1ǥ)
[91 ȸ��] �����δ� ��ǥ => H 
[92 ȸ��] �����δ� ��ǥ => D 
[93 ȸ��] �����δ� ��ǥ => H 
[94 ȸ��] �����δ� ��ǥ => H 
[95 ȸ��] �����δ� ��ǥ => D 
[96 ȸ��] �����δ� ��ǥ => H 
[97 ȸ��] �����δ� ��ǥ => D 
[98 ȸ��] �����δ� ��ǥ => H 
[99 ȸ��] �����δ� ��ǥ => E 
[100 ȸ��] �����δ� ��ǥ => H 
[101 ȸ��] �����δ� ��ǥ => E 
[102 ȸ��] �����δ� ��ǥ => D 
[103 ȸ��] �����δ� ��ǥ => D 
[104 ȸ��] �����δ� ��ǥ => H 
[105 ȸ��] �����δ� ��ǥ => H 
[106 ȸ��] �����δ� ��ǥ => H 
[107 ȸ��] �����δ� ��ǥ => H 
[108 ȸ��] �����δ� ��ǥ => H 
[109 ȸ��] �����δ� ��ǥ => H 
[110 ȸ��] �����δ� ��ǥ => H 
[111 ȸ��] �����δ� ��ǥ => D 
[112 ȸ��] �����δ� ��ǥ => D 
[113 ȸ��] �����δ� ��ǥ => H 
[114 ȸ��] �����δ� ��ǥ => H 
[115 ȸ��] �����δ� ��ǥ => H 
[116 ȸ��] �����δ� ��ǥ => E 
[117 ȸ��] �����δ� ��ǥ => D 
[118 ȸ��] �����δ� ��ǥ => D 
[119 ȸ��] �����δ� ��ǥ => H 
[120 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 58ǥ vs. Hilary 58ǥ (��Ÿ: 4ǥ)
[121 ȸ��] �����δ� ��ǥ => H 
[122 ȸ��] �����δ� ��ǥ => D 
[123 ȸ��] �����δ� ��ǥ => D 
[124 ȸ��] �����δ� ��ǥ => H 
[125 ȸ��] �����δ� ��ǥ => H 
[126 ȸ��] �����δ� ��ǥ => D 
[127 ȸ��] �����δ� ��ǥ => H 
[128 ȸ��] �����δ� ��ǥ => D 
[129 ȸ��] �����δ� ��ǥ => H 
[130 ȸ��] �����δ� ��ǥ => D 
[131 ȸ��] �����δ� ��ǥ => D 
[132 ȸ��] �����δ� ��ǥ => D 
[133 ȸ��] �����δ� ��ǥ => D 
[134 ȸ��] �����δ� ��ǥ => H 
[135 ȸ��] �����δ� ��ǥ => D 
[136 ȸ��] �����δ� ��ǥ => H 
[137 ȸ��] �����δ� ��ǥ => D 
[138 ȸ��] �����δ� ��ǥ => D 
[139 ȸ��] �����δ� ��ǥ => D 
[140 ȸ��] �����δ� ��ǥ => D 
[141 ȸ��] �����δ� ��ǥ => D 
[142 ȸ��] �����δ� ��ǥ => D 
[143 ȸ��] �����δ� ��ǥ => H 
[144 ȸ��] �����δ� ��ǥ => D 
[145 ȸ��] �����δ� ��ǥ => H 
[146 ȸ��] �����δ� ��ǥ => D 
[147 ȸ��] �����δ� ��ǥ => H 
[148 ȸ��] �����δ� ��ǥ => H 
[149 ȸ��] �����δ� ��ǥ => D 
[150 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 77ǥ vs. Hilary 69ǥ (��Ÿ: 4ǥ)
[151 ȸ��] �����δ� ��ǥ => H 
[152 ȸ��] �����δ� ��ǥ => D 
[153 ȸ��] �����δ� ��ǥ => D 
[154 ȸ��] �����δ� ��ǥ => D 
[155 ȸ��] �����δ� ��ǥ => D 
[156 ȸ��] �����δ� ��ǥ => D 
[157 ȸ��] �����δ� ��ǥ => D 
[158 ȸ��] �����δ� ��ǥ => H 
[159 ȸ��] �����δ� ��ǥ => H 
[160 ȸ��] �����δ� ��ǥ => D 
[161 ȸ��] �����δ� ��ǥ => H 
[162 ȸ��] �����δ� ��ǥ => D 
[163 ȸ��] �����δ� ��ǥ => H 
[164 ȸ��] �����δ� ��ǥ => D 
[165 ȸ��] �����δ� ��ǥ => H 
[166 ȸ��] �����δ� ��ǥ => D 
[167 ȸ��] �����δ� ��ǥ => D 
[168 ȸ��] �����δ� ��ǥ => D 
[169 ȸ��] �����δ� ��ǥ => H 
[170 ȸ��] �����δ� ��ǥ => D 
[171 ȸ��] �����δ� ��ǥ => D 
[172 ȸ��] �����δ� ��ǥ => D 
[173 ȸ��] �����δ� ��ǥ => D 
[174 ȸ��] �����δ� ��ǥ => D 
[175 ȸ��] �����δ� ��ǥ => H 
[176 ȸ��] �����δ� ��ǥ => H 
[177 ȸ��] �����δ� ��ǥ => H 
[178 ȸ��] �����δ� ��ǥ => D 
[179 ȸ��] �����δ� ��ǥ => D 
[180 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 97ǥ vs. Hilary 79ǥ (��Ÿ: 4ǥ)
[181 ȸ��] �����δ� ��ǥ => D 
[182 ȸ��] �����δ� ��ǥ => H 
[183 ȸ��] �����δ� ��ǥ => H 
[184 ȸ��] �����δ� ��ǥ => D 
[185 ȸ��] �����δ� ��ǥ => H 
[186 ȸ��] �����δ� ��ǥ => H 
[187 ȸ��] �����δ� ��ǥ => D 
[188 ȸ��] �����δ� ��ǥ => D 
[189 ȸ��] �����δ� ��ǥ => H 
[190 ȸ��] �����δ� ��ǥ => H 
[191 ȸ��] �����δ� ��ǥ => H 
[192 ȸ��] �����δ� ��ǥ => H 
[193 ȸ��] �����δ� ��ǥ => H 
[194 ȸ��] �����δ� ��ǥ => H 
[195 ȸ��] �����δ� ��ǥ => D 
[196 ȸ��] �����δ� ��ǥ => D 
[197 ȸ��] �����δ� ��ǥ => H 
[198 ȸ��] �����δ� ��ǥ => D 
[199 ȸ��] �����δ� ��ǥ => H 
[200 ȸ��] �����δ� ��ǥ => D 
[201 ȸ��] �����δ� ��ǥ => H 
[202 ȸ��] �����δ� ��ǥ => E 
[203 ȸ��] �����δ� ��ǥ => H 
[204 ȸ��] �����δ� ��ǥ => D 
[205 ȸ��] �����δ� ��ǥ => H 
[206 ȸ��] �����δ� ��ǥ => H 
[207 ȸ��] �����δ� ��ǥ => D 
[208 ȸ��] �����δ� ��ǥ => D 
[209 ȸ��] �����δ� ��ǥ => D 
[210 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 109ǥ vs. Hilary 96ǥ (��Ÿ: 5ǥ)
[211 ȸ��] �����δ� ��ǥ => D 
[212 ȸ��] �����δ� ��ǥ => H 
[213 ȸ��] �����δ� ��ǥ => H 
[214 ȸ��] �����δ� ��ǥ => H 
[215 ȸ��] �����δ� ��ǥ => H 
[216 ȸ��] �����δ� ��ǥ => H 
[217 ȸ��] �����δ� ��ǥ => H 
[218 ȸ��] �����δ� ��ǥ => D 
[219 ȸ��] �����δ� ��ǥ => H 
[220 ȸ��] �����δ� ��ǥ => H 
[221 ȸ��] �����δ� ��ǥ => H 
[222 ȸ��] �����δ� ��ǥ => D 
[223 ȸ��] �����δ� ��ǥ => H 
[224 ȸ��] �����δ� ��ǥ => H 
[225 ȸ��] �����δ� ��ǥ => D 
[226 ȸ��] �����δ� ��ǥ => H 
[227 ȸ��] �����δ� ��ǥ => H 
[228 ȸ��] �����δ� ��ǥ => D 
[229 ȸ��] �����δ� ��ǥ => H 
[230 ȸ��] �����δ� ��ǥ => H 
[231 ȸ��] �����δ� ��ǥ => H 
[232 ȸ��] �����δ� ��ǥ => H 
[233 ȸ��] �����δ� ��ǥ => D 
[234 ȸ��] �����δ� ��ǥ => H 
[235 ȸ��] �����δ� ��ǥ => D 
[236 ȸ��] �����δ� ��ǥ => H 
[237 ȸ��] �����δ� ��ǥ => H 
[238 ȸ��] �����δ� ��ǥ => H 
[239 ȸ��] �����δ� ��ǥ => H 
[240 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 117ǥ vs. Hilary 118ǥ (��Ÿ: 5ǥ)
[241 ȸ��] �����δ� ��ǥ => H 
[242 ȸ��] �����δ� ��ǥ => H 
[243 ȸ��] �����δ� ��ǥ => D 
[244 ȸ��] �����δ� ��ǥ => H 
[245 ȸ��] �����δ� ��ǥ => E 
[246 ȸ��] �����δ� ��ǥ => D 
[247 ȸ��] �����δ� ��ǥ => D 
[248 ȸ��] �����δ� ��ǥ => D 
[249 ȸ��] �����δ� ��ǥ => D 
[250 ȸ��] �����δ� ��ǥ => D 
[251 ȸ��] �����δ� ��ǥ => H 
[252 ȸ��] �����δ� ��ǥ => D 
[253 ȸ��] �����δ� ��ǥ => H 
[254 ȸ��] �����δ� ��ǥ => D 
[255 ȸ��] �����δ� ��ǥ => D 
[256 ȸ��] �����δ� ��ǥ => D 
[257 ȸ��] �����δ� ��ǥ => D 
[258 ȸ��] �����δ� ��ǥ => D 
[259 ȸ��] �����δ� ��ǥ => D 
[260 ȸ��] �����δ� ��ǥ => D 
[261 ȸ��] �����δ� ��ǥ => D 
[262 ȸ��] �����δ� ��ǥ => H 
[263 ȸ��] �����δ� ��ǥ => H 
[264 ȸ��] �����δ� ��ǥ => H 
[265 ȸ��] �����δ� ��ǥ => H 
[266 ȸ��] �����δ� ��ǥ => H 
[267 ȸ��] �����δ� ��ǥ => H 
[268 ȸ��] �����δ� ��ǥ => H 
[269 ȸ��] �����δ� ��ǥ => D 
[270 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 134ǥ vs. Hilary 130ǥ (��Ÿ: 6ǥ)
[271 ȸ��] �����δ� ��ǥ => D 
[272 ȸ��] �����δ� ��ǥ => H 
[273 ȸ��] �����δ� ��ǥ => D 
[274 ȸ��] �����δ� ��ǥ => D 
[275 ȸ��] �����δ� ��ǥ => H 
[276 ȸ��] �����δ� ��ǥ => D 
[277 ȸ��] �����δ� ��ǥ => H 
[278 ȸ��] �����δ� ��ǥ => H 
[279 ȸ��] �����δ� ��ǥ => D 
[280 ȸ��] �����δ� ��ǥ => E 
[281 ȸ��] �����δ� ��ǥ => D 
[282 ȸ��] �����δ� ��ǥ => H 
[283 ȸ��] �����δ� ��ǥ => E 
[284 ȸ��] �����δ� ��ǥ => H 
[285 ȸ��] �����δ� ��ǥ => D 
[286 ȸ��] �����δ� ��ǥ => D 
[287 ȸ��] �����δ� ��ǥ => D 
[288 ȸ��] �����δ� ��ǥ => D 
[289 ȸ��] �����δ� ��ǥ => D 
[290 ȸ��] �����δ� ��ǥ => H 
[291 ȸ��] �����δ� ��ǥ => H 
[292 ȸ��] �����δ� ��ǥ => H 
[293 ȸ��] �����δ� ��ǥ => H 
[294 ȸ��] �����δ� ��ǥ => H 
[295 ȸ��] �����δ� ��ǥ => H 
[296 ȸ��] �����δ� ��ǥ => E 
[297 ȸ��] �����δ� ��ǥ => H 
[298 ȸ��] �����δ� ��ǥ => H 
[299 ȸ��] �����δ� ��ǥ => D 
[300 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 146ǥ vs. Hilary 145ǥ (��Ÿ: 9ǥ)
[301 ȸ��] �����δ� ��ǥ => D 
[302 ȸ��] �����δ� ��ǥ => H 
[303 ȸ��] �����δ� ��ǥ => H 
[304 ȸ��] �����δ� ��ǥ => H 
[305 ȸ��] �����δ� ��ǥ => H 
[306 ȸ��] �����δ� ��ǥ => D 
[307 ȸ��] �����δ� ��ǥ => H 
[308 ȸ��] �����δ� ��ǥ => D 
[309 ȸ��] �����δ� ��ǥ => H 
[310 ȸ��] �����δ� ��ǥ => D 
[311 ȸ��] �����δ� ��ǥ => H 
[312 ȸ��] �����δ� ��ǥ => H 
[313 ȸ��] �����δ� ��ǥ => D 
[314 ȸ��] �����δ� ��ǥ => H 
[315 ȸ��] �����δ� ��ǥ => H 
[316 ȸ��] �����δ� ��ǥ => D 
[317 ȸ��] �����δ� ��ǥ => D 
[318 ȸ��] �����δ� ��ǥ => H 
[319 ȸ��] �����δ� ��ǥ => H 
[320 ȸ��] �����δ� ��ǥ => D 
[321 ȸ��] �����δ� ��ǥ => H 
[322 ȸ��] �����δ� ��ǥ => H 
[323 ȸ��] �����δ� ��ǥ => D 
[324 ȸ��] �����δ� ��ǥ => H 
[325 ȸ��] �����δ� ��ǥ => H 
[326 ȸ��] �����δ� ��ǥ => H 
[327 ȸ��] �����δ� ��ǥ => D 
[328 ȸ��] �����δ� ��ǥ => D 
[329 ȸ��] �����δ� ��ǥ => D 
[330 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 158ǥ vs. Hilary 163ǥ (��Ÿ: 9ǥ)
[331 ȸ��] �����δ� ��ǥ => D 
[332 ȸ��] �����δ� ��ǥ => D 
[333 ȸ��] �����δ� ��ǥ => D 
[334 ȸ��] �����δ� ��ǥ => D 
[335 ȸ��] �����δ� ��ǥ => H 
[336 ȸ��] �����δ� ��ǥ => H 
[337 ȸ��] �����δ� ��ǥ => H 
[338 ȸ��] �����δ� ��ǥ => D 
[339 ȸ��] �����δ� ��ǥ => E 
[340 ȸ��] �����δ� ��ǥ => D 
[341 ȸ��] �����δ� ��ǥ => H 
[342 ȸ��] �����δ� ��ǥ => H 
[343 ȸ��] �����δ� ��ǥ => H 
[344 ȸ��] �����δ� ��ǥ => H 
[345 ȸ��] �����δ� ��ǥ => H 
[346 ȸ��] �����δ� ��ǥ => H 
[347 ȸ��] �����δ� ��ǥ => H 
[348 ȸ��] �����δ� ��ǥ => H 
[349 ȸ��] �����δ� ��ǥ => H 
[350 ȸ��] �����δ� ��ǥ => H 
[351 ȸ��] �����δ� ��ǥ => H 
[352 ȸ��] �����δ� ��ǥ => D 
[353 ȸ��] �����δ� ��ǥ => H 
[354 ȸ��] �����δ� ��ǥ => D 
[355 ȸ��] �����δ� ��ǥ => D 
[356 ȸ��] �����δ� ��ǥ => H 
[357 ȸ��] �����δ� ��ǥ => H 
[358 ȸ��] �����δ� ��ǥ => D 
[359 ȸ��] �����δ� ��ǥ => D 
[360 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 169ǥ vs. Hilary 181ǥ (��Ÿ: 10ǥ)
[361 ȸ��] �����δ� ��ǥ => D 
[362 ȸ��] �����δ� ��ǥ => D 
[363 ȸ��] �����δ� ��ǥ => H 
[364 ȸ��] �����δ� ��ǥ => D 
[365 ȸ��] �����δ� ��ǥ => H 
[366 ȸ��] �����δ� ��ǥ => H 
[367 ȸ��] �����δ� ��ǥ => H 
[368 ȸ��] �����δ� ��ǥ => H 
[369 ȸ��] �����δ� ��ǥ => E 
[370 ȸ��] �����δ� ��ǥ => D 
[371 ȸ��] �����δ� ��ǥ => D 
[372 ȸ��] �����δ� ��ǥ => D 
[373 ȸ��] �����δ� ��ǥ => D 
[374 ȸ��] �����δ� ��ǥ => H 
[375 ȸ��] �����δ� ��ǥ => E 
[376 ȸ��] �����δ� ��ǥ => H 
[377 ȸ��] �����δ� ��ǥ => E 
[378 ȸ��] �����δ� ��ǥ => D 
[379 ȸ��] �����δ� ��ǥ => H 
[380 ȸ��] �����δ� ��ǥ => H 
[381 ȸ��] �����δ� ��ǥ => D 
[382 ȸ��] �����δ� ��ǥ => H 
[383 ȸ��] �����δ� ��ǥ => H 
[384 ȸ��] �����δ� ��ǥ => H 
[385 ȸ��] �����δ� ��ǥ => D 
[386 ȸ��] �����δ� ��ǥ => H 
[387 ȸ��] �����δ� ��ǥ => D 
[388 ȸ��] �����δ� ��ǥ => H 
[389 ȸ��] �����δ� ��ǥ => H 
[390 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 181ǥ vs. Hilary 196ǥ (��Ÿ: 13ǥ)
[391 ȸ��] �����δ� ��ǥ => D 
[392 ȸ��] �����δ� ��ǥ => D 
[393 ȸ��] �����δ� ��ǥ => D 
[394 ȸ��] �����δ� ��ǥ => E 
[395 ȸ��] �����δ� ��ǥ => H 
[396 ȸ��] �����δ� ��ǥ => H 
[397 ȸ��] �����δ� ��ǥ => H 
[398 ȸ��] �����δ� ��ǥ => D 
[399 ȸ��] �����δ� ��ǥ => D 
[400 ȸ��] �����δ� ��ǥ => D 
[401 ȸ��] �����δ� ��ǥ => D 
[402 ȸ��] �����δ� ��ǥ => D 
[403 ȸ��] �����δ� ��ǥ => D 
[404 ȸ��] �����δ� ��ǥ => D 
[405 ȸ��] �����δ� ��ǥ => D 
[406 ȸ��] �����δ� ��ǥ => D 
[407 ȸ��] �����δ� ��ǥ => H 
[408 ȸ��] �����δ� ��ǥ => D 
[409 ȸ��] �����δ� ��ǥ => D 
[410 ȸ��] �����δ� ��ǥ => H 
[411 ȸ��] �����δ� ��ǥ => H 
[412 ȸ��] �����δ� ��ǥ => H 
[413 ȸ��] �����δ� ��ǥ => H 
[414 ȸ��] �����δ� ��ǥ => H 
[415 ȸ��] �����δ� ��ǥ => H 
[416 ȸ��] �����δ� ��ǥ => H 
[417 ȸ��] �����δ� ��ǥ => H 
[418 ȸ��] �����δ� ��ǥ => E 
[419 ȸ��] �����δ� ��ǥ => D 
[420 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 196ǥ vs. Hilary 209ǥ (��Ÿ: 15ǥ)
[421 ȸ��] �����δ� ��ǥ => H 
[422 ȸ��] �����δ� ��ǥ => D 
[423 ȸ��] �����δ� ��ǥ => D 
[424 ȸ��] �����δ� ��ǥ => H 
[425 ȸ��] �����δ� ��ǥ => D 
[426 ȸ��] �����δ� ��ǥ => D 
[427 ȸ��] �����δ� ��ǥ => H 
[428 ȸ��] �����δ� ��ǥ => D 
[429 ȸ��] �����δ� ��ǥ => D 
[430 ȸ��] �����δ� ��ǥ => H 
[431 ȸ��] �����δ� ��ǥ => D 
[432 ȸ��] �����δ� ��ǥ => H 
[433 ȸ��] �����δ� ��ǥ => H 
[434 ȸ��] �����δ� ��ǥ => D 
[435 ȸ��] �����δ� ��ǥ => D 
[436 ȸ��] �����δ� ��ǥ => H 
[437 ȸ��] �����δ� ��ǥ => D 
[438 ȸ��] �����δ� ��ǥ => D 
[439 ȸ��] �����δ� ��ǥ => H 
[440 ȸ��] �����δ� ��ǥ => D 
[441 ȸ��] �����δ� ��ǥ => D 
[442 ȸ��] �����δ� ��ǥ => D 
[443 ȸ��] �����δ� ��ǥ => D 
[444 ȸ��] �����δ� ��ǥ => D 
[445 ȸ��] �����δ� ��ǥ => H 
[446 ȸ��] �����δ� ��ǥ => D 
[447 ȸ��] �����δ� ��ǥ => H 
[448 ȸ��] �����δ� ��ǥ => H 
[449 ȸ��] �����δ� ��ǥ => H 
[450 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 213ǥ vs. Hilary 222ǥ (��Ÿ: 15ǥ)
[451 ȸ��] �����δ� ��ǥ => H 
[452 ȸ��] �����δ� ��ǥ => E 
[453 ȸ��] �����δ� ��ǥ => D 
[454 ȸ��] �����δ� ��ǥ => H 
[455 ȸ��] �����δ� ��ǥ => D 
[456 ȸ��] �����δ� ��ǥ => D 
[457 ȸ��] �����δ� ��ǥ => H 
[458 ȸ��] �����δ� ��ǥ => H 
[459 ȸ��] �����δ� ��ǥ => H 
[460 ȸ��] �����δ� ��ǥ => H 
[461 ȸ��] �����δ� ��ǥ => D 
[462 ȸ��] �����δ� ��ǥ => H 
[463 ȸ��] �����δ� ��ǥ => H 
[464 ȸ��] �����δ� ��ǥ => D 
[465 ȸ��] �����δ� ��ǥ => D 
[466 ȸ��] �����δ� ��ǥ => H 
[467 ȸ��] �����δ� ��ǥ => D 
[468 ȸ��] �����δ� ��ǥ => H 
[469 ȸ��] �����δ� ��ǥ => D 
[470 ȸ��] �����δ� ��ǥ => H 
[471 ȸ��] �����δ� ��ǥ => D 
[472 ȸ��] �����δ� ��ǥ => H 
[473 ȸ��] �����δ� ��ǥ => H 
[474 ȸ��] �����δ� ��ǥ => H 
[475 ȸ��] �����δ� ��ǥ => D 
[476 ȸ��] �����δ� ��ǥ => D 
[477 ȸ��] �����δ� ��ǥ => D 
[478 ȸ��] �����δ� ��ǥ => H 
[479 ȸ��] �����δ� ��ǥ => H 
[480 ȸ��] �����δ� ��ǥ => H 
	��ǥ��Ȳ: Donald 225ǥ vs. Hilary 239ǥ (��Ÿ: 16ǥ)
[481 ȸ��] �����δ� ��ǥ => D 
[482 ȸ��] �����δ� ��ǥ => H 
[483 ȸ��] �����δ� ��ǥ => H 
[484 ȸ��] �����δ� ��ǥ => D 
[485 ȸ��] �����δ� ��ǥ => H 
[486 ȸ��] �����δ� ��ǥ => H 
[487 ȸ��] �����δ� ��ǥ => H 
[488 ȸ��] �����δ� ��ǥ => D 
[489 ȸ��] �����δ� ��ǥ => D 
[490 ȸ��] �����δ� ��ǥ => D 
[491 ȸ��] �����δ� ��ǥ => H 
[492 ȸ��] �����δ� ��ǥ => H 
[493 ȸ��] �����δ� ��ǥ => H 
[494 ȸ��] �����δ� ��ǥ => D 
[495 ȸ��] �����δ� ��ǥ => D 
[496 ȸ��] �����δ� ��ǥ => D 
[497 ȸ��] �����δ� ��ǥ => H 
[498 ȸ��] �����δ� ��ǥ => D 
[499 ȸ��] �����δ� ��ǥ => H 
[500 ȸ��] �����δ� ��ǥ => H 
[501 ȸ��] �����δ� ��ǥ => H 
[502 ȸ��] �����δ� ��ǥ => D 
[503 ȸ��] �����δ� ��ǥ => D 
[504 ȸ��] �����δ� ��ǥ => D 
[505 ȸ��] �����δ� ��ǥ => D 
[506 ȸ��] �����δ� ��ǥ => D 
[507 ȸ��] �����δ� ��ǥ => H 
[508 ȸ��] �����δ� ��ǥ => H 
[509 ȸ��] �����δ� ��ǥ => H 
[510 ȸ��] �����δ� ��ǥ => D 
	��ǥ��Ȳ: Donald 240ǥ vs. Hilary 254ǥ (��Ÿ: 16ǥ)
[511 ȸ��] �����δ� ��ǥ => H 
[512 ȸ��] �����δ� ��ǥ => D 
[513 ȸ��] �����δ� ��ǥ => D 
[514 ȸ��] �����δ� ��ǥ => D 
[515 ȸ��] �����δ� ��ǥ => H 
[516 ȸ��] �����δ� ��ǥ => H 
[517 ȸ��] �����δ� ��ǥ => D 
[518 ȸ��] �����δ� ��ǥ => D 
[519 ȸ��] �����δ� ��ǥ => D 
[520 ȸ��] �����δ� ��ǥ => H 
[521 ȸ��] �����δ� ��ǥ => H 
[522 ȸ��] �����δ� ��ǥ => H 
[523 ȸ��] �����δ� ��ǥ => D 
[524 ȸ��] �����δ� ��ǥ => H 
[525 ȸ��] �����δ� ��ǥ => H 
[526 ȸ��] �����δ� ��ǥ => D 
[527 ȸ��] �����δ� ��ǥ => H 
[528 ȸ��] �����δ� ��ǥ => D 
[529 ȸ��] �����δ� ��ǥ => D 
[530 ȸ��] �����δ� ��ǥ => H 
[531 ȸ��] �����δ� ��ǥ => D 
[532 ȸ��] �����δ� ��ǥ => D 
[533 ȸ��] �����δ� ��ǥ => H 
[534 ȸ��] �����δ� ��ǥ => D 
[535 ȸ��] �����δ� ��ǥ => H 
[536 ȸ��] �����δ� ��ǥ => D 
[537 ȸ��] �����δ� ��ǥ => H 
[538 ȸ��] �����δ� ��ǥ => H 
 ===  ���� �δ� ��ǥ �� ��ǥ �� === 

 
 
 
[060 ȸ��] ��ǥ��Ȳ: Donald 34ǥ vs. Hilary 24ǥ (��Ÿ: 2ǥ)
[120 ȸ��] ��ǥ��Ȳ: Donald 60ǥ vs. Hilary 57ǥ (��Ÿ: 3ǥ)
[180 ȸ��] ��ǥ��Ȳ: Donald 85ǥ vs. Hilary 90ǥ (��Ÿ: 5ǥ)
[240 ȸ��] ��ǥ��Ȳ: Donald 114ǥ vs. Hilary 120ǥ (��Ÿ: 6ǥ)
[300 ȸ��] ��ǥ��Ȳ: Donald 144ǥ vs. Hilary 148ǥ (��Ÿ: 8ǥ)
[360 ȸ��] ��ǥ��Ȳ: Donald 177ǥ vs. Hilary 175ǥ (��Ÿ: 8ǥ)
[420 ȸ��] ��ǥ��Ȳ: Donald 204ǥ vs. Hilary 207ǥ (��Ÿ: 9ǥ)
[480 ȸ��] ��ǥ��Ȳ: Donald 226ǥ vs. Hilary 241ǥ (��Ÿ: 13ǥ)
 ===  ���� �δ� ��ǥ �� ��ǥ �� === 


 --- ���� ��ǥ ��� --- 
	���� ��ǥ��Ȳ: Donald 252ǥ vs. Hilary 269ǥ (��Ÿ: 17ǥ)
	 ****** �缱�� :  ������ Ŭ����!!!
 
 
 */
