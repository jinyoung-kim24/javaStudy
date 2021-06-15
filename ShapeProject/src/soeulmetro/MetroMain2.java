package soeulmetro;

import shape.basic.MyPoint;
import shape.util.output.SubwayPrint;
import soeulmetrosubway.*; // * �� �б����ȿ��ִ°͵��� ��ξ��ڴ�

/* ���� ����ö ���翡 ���ָ� �޾�.. �뼱�� ������Ʈ 
 https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B6%84%EB%8B%B9%EC%84%A0
 https://www.sisul.or.kr/open_content/skydome/introduce/pop_subway.jsp
 http://seoulmetro.co.kr/kr/cyberStation.do#stationInfo
 
 �� ȣ������ �� ���� �����Ͽ� �ϳ��� ��η� ǥ���ϴ� ����.
 
 
 ��߿�  ~ ������������ ��ü ���� = ���  SubwayLine (8ȣ��)
 �� ��θ� �����ϴ� �� ����ö���� Station  (MyCirlce/MyPoint)
 ���� ���� �����ϴ� ����(����) ���� RailWay (MyLine)

 => �䱸�Ǵ� ��ȹ������ ��� ��� ǥ���ϴ� ��Ű�� Ŭ������...

** �źд缱 

D07	����	Gangnam	˰��	�� ���� ����ö 2ȣ��	-	0.0	����Ư����	������
D08	����(���ʱ�û)	Yangjae
(Seocho-gu Office)	���(����ϡ��)	�� ������ ��ö 3ȣ��	1.5	1.5	���ʱ�
D09	����ù��ǽ�(����)	Yangjae Citizen's Forest
(Maeheon)	�������ǽ�(����)		1.6	3.1
D10	û����Ա�	Cheonggyesan	��͢ߣ��Ϣ		2.9	6.0
D11	�Ǳ�(�Ǳ���ũ��븮)	Pangyo
(Pangyo Techno Valley)	����(������ũ��븮)	�� ������ ��ö �氭��	8.2	14.2	��⵵	������
D12	����	Jeongja	���	�� ������ ��ö ���Ρ��д缱	3.1	17.3
D13	�̱�(�д缭��뺴��)	Migeum(Seoul National University Bundang Hospital)	ڸ��	�� ������ ��ö ���Ρ��д缱	1.9	19.2
D14	��õ	Dongcheon	����		1.6	20.8	���ν�
D15	������û	Suji-gu Office	��ϡ��		2.1	22.9
D16	����	Seongbok	����		1.7	24.6
D17	����	Sanghyeon	߾��		2.1	26.7
D18	�����߾�(���ִ�)	Gwanggyo Jungang
(Ajou University)	��������(����)		2.4	29.1	������
D19	����(����)	Gwanggyo
(Kyonggi University)	����(��Ѳ��)		1.9

*/
public class MetroMain2 {

	public static void main(String[] args) {
		// �źд缱 
		String sbName = "�źд缱"; // �뼱 �����̸�
		int sbOrder = 7; // �뼱 ������ȣ d07~d19�� �뼱��
		String sbColor = "FF0000"; // �뼱 �����÷�
		String[] stNames = {
				"����", 
				"����(���ʱ�û)",
				"����ù��ǽ�(����)",
				"û����Ա�",
				"�Ǳ�(�Ǳ���ũ��븮)",
				"����",
				"�̱�(�д缭��뺴��)",
				"��õ",
				"������û",
				"����",
				"����",
				"�����߾�(���ִ�)",
				"����(����)"
		}; // �� �뼱�� �����ϴ� ������ �̸� �迭
		String[] stNamesEn = {
				"Gangnam", 
				"Yangjae",
				"Yangjae Citizen's Forest",
				"Cheonggyesan",
				"Pangyo",
				"Jeongja",
				"Migeum",
				"Dongcheon",
				"Suji-gu Office",
				"Seongbok",
				"Sanghyeon",
				"Gwanggyo Jungang",
				"Gwanggyo"
		}; 
		final int sbStationNumber = stNamesEn.length; // 13
		// 
//		Station[] stations = {};
//		RailWay[] railways = {};
		Station[] stations = new Station[sbStationNumber];
			// null ���� �ʱ�ȭ�� 13���� ������ ���� �迭
		RailWay[] railways = new RailWay[sbStationNumber-1]; // 12
		
//		MyPoint[] pts = {
//				 new MyPoint(30,130), new MyPoint(30+80,130),
//				 new MyPoint(30+80+80,130), new MyPoint(30+80+80+80,130),
//				 new MyPoint(30+80+80+80+80,130), new MyPoint(30+80+80+80+80+80,130),
//				 new MyPoint(30+80+80+80+80+80+80,130), new MyPoint(30+80+80+80+80+80+80+80,130),
//		};
		// ���� ���� �����Ͽ� ���迭�� ��ġ, ���� ö�θ� �����Ͽ� �����迭�� ��ġ ����
		for (int i = 0; i < stations.length; i++) {
			Station st = new Station(i < 7 ? 30 + 80 * i : 30 + 480 - 80 * (i-7),
					i < 7 ? 130 : 260,
					stNames[i], i + sbOrder, sbColor, sbOrder);
			stations[i] = st; 
			if(i > 0) { // ù��° ���� �����ϰ�
				RailWay rw = new RailWay(stations[i-1], stations[i], sbColor, sbOrder, i-1);
				railways[i-1] = rw; // �迭��ġ
			}
		}
		Station sbStartSt = stations[0]; // ���ۿ�
		Station sbEndtSt = stations[stations.length-1];
		SubwayLine sbShinBundang = new SubwayLine(sbName, sbOrder, sbColor,
				0.0, sbStationNumber, stations, railways, sbStartSt, sbEndtSt);
		
//		sbShinBundang.computeToralDist();
//		System.out.println(sbShinBundang);
		SubwayPrint.printSubwayLine(sbShinBundang, 4);// html���
		
		
		
		
		
		
	}
	

}
