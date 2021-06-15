package soeulmetro;

import shape.basic.MyPoint;
import shape.util.output.SubwayPrint;
import soeulmetrosubway.*; // * 이 패기지안에있는것들을 모두쓰겠다

/* 서울 지하철 공사에 수주를 받아.. 노선도 프로젝트 
 https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B6%84%EB%8B%B9%EC%84%A0
 https://www.sisul.or.kr/open_content/skydome/introduce/pop_subway.jsp
 http://seoulmetro.co.kr/kr/cyberStation.do#stationInfo
 
 각 호선별로 각 역을 연결하여 하나의 경로로 표현하는 문제.
 
 
 출발역  ~ 종착역까지의 전체 구간 = 경로  SubwayLine (8호선)
 그 경로를 구성하는 각 지하철역을 Station  (MyCirlce/MyPoint)
 역과 역을 연결하는 작은(단일) 구간 RailWay (MyLine)

 => 요구되는 기획사항을 모두 담아 표현하는 스키마 클래스들...

** 신분당선 

D07	강남	Gangnam	江南	● 서울 지하철 2호선	-	0.0	서울특별시	강남구
D08	양재(서초구청)	Yangjae
(Seocho-gu Office)	良才(瑞草區廳)	● 수도권 전철 3호선	1.5	1.5	서초구
D09	양재시민의숲(매헌)	Yangjae Citizen's Forest
(Maeheon)	良才市民의숲(梅軒)		1.6	3.1
D10	청계산입구	Cheonggyesan	淸溪山入口		2.9	6.0
D11	판교(판교테크노밸리)	Pangyo
(Pangyo Techno Valley)	板橋(板橋테크노밸리)	● 수도권 전철 경강선	8.2	14.2	경기도	성남시
D12	정자	Jeongja	亭子	● 수도권 전철 수인·분당선	3.1	17.3
D13	미금(분당서울대병원)	Migeum(Seoul National University Bundang Hospital)	美金	● 수도권 전철 수인·분당선	1.9	19.2
D14	동천	Dongcheon	東川		1.6	20.8	용인시
D15	수지구청	Suji-gu Office	水枝區廳		2.1	22.9
D16	성복	Seongbok	星福		1.7	24.6
D17	상현	Sanghyeon	上峴		2.1	26.7
D18	광교중앙(아주대)	Gwanggyo Jungang
(Ajou University)	光敎中央(亞洲大)		2.4	29.1	수원시
D19	광교(경기대)	Gwanggyo
(Kyonggi University)	光敎(京畿大)		1.9

*/
public class MetroMain2 {

	public static void main(String[] args) {
		// 신분당선 
		String sbName = "신분당선"; // 노선 고유이름
		int sbOrder = 7; // 노선 고유번호 d07~d19번 노선도
		String sbColor = "FF0000"; // 노선 고유컬러
		String[] stNames = {
				"강남", 
				"양재(서초구청)",
				"양재시민의숲(매헌)",
				"청계산입구",
				"판교(판교테크노밸리)",
				"정자",
				"미금(분당서울대병원)",
				"동천",
				"수지구청",
				"성복",
				"상현",
				"광교중앙(아주대)",
				"광교(경기대)"
		}; // 이 노선을 구성하는 역들의 이름 배열
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
			// null 각각 초기화된 13개의 공간을 가진 배열
		RailWay[] railways = new RailWay[sbStationNumber-1]; // 12
		
//		MyPoint[] pts = {
//				 new MyPoint(30,130), new MyPoint(30+80,130),
//				 new MyPoint(30+80+80,130), new MyPoint(30+80+80+80,130),
//				 new MyPoint(30+80+80+80+80,130), new MyPoint(30+80+80+80+80+80,130),
//				 new MyPoint(30+80+80+80+80+80+80,130), new MyPoint(30+80+80+80+80+80+80+80,130),
//		};
		// 실제 역을 공사하여 역배열에 배치, 실제 철로를 공사하여 구간배열에 배치 루프
		for (int i = 0; i < stations.length; i++) {
			Station st = new Station(i < 7 ? 30 + 80 * i : 30 + 480 - 80 * (i-7),
					i < 7 ? 130 : 260,
					stNames[i], i + sbOrder, sbColor, sbOrder);
			stations[i] = st; 
			if(i > 0) { // 첫번째 역을 제외하고
				RailWay rw = new RailWay(stations[i-1], stations[i], sbColor, sbOrder, i-1);
				railways[i-1] = rw; // 배열배치
			}
		}
		Station sbStartSt = stations[0]; // 시작역
		Station sbEndtSt = stations[stations.length-1];
		SubwayLine sbShinBundang = new SubwayLine(sbName, sbOrder, sbColor,
				0.0, sbStationNumber, stations, railways, sbStartSt, sbEndtSt);
		
//		sbShinBundang.computeToralDist();
//		System.out.println(sbShinBundang);
		SubwayPrint.printSubwayLine(sbShinBundang, 4);// html출력
		
		
		
		
		
		
	}
	

}
