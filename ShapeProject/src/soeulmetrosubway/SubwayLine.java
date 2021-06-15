package soeulmetrosubway;

import java.util.Arrays;

/*
 * �������� �ϳ��� ����ö �뼱�� ǥ���� ��Ű�� Ŭ����
 * > ��ο� ���� ��� �����̼ǵ��� ������ �������� ����
 * - �뼱 �̸� 
 * - �뼱 ������ȣ
 * - �뼱 ����
 * - �뼱 �Ѱ�α���
 * - �뼱 �����ϴ� ��� ���� ����(�����̼� ��)
 * - �뼱 �����ϴ� �����̼ǵ�
 * - �뼱 �����ϴ� Station
 * - �뼱 �����ϴ� Railway
 * - ��߿�
 * - ������ (ȯ�¿��� ���� ����)
 * - ���� ��ռӵ��� ����ö�� ����ȴٸ� ��ü �뼱 ���� �ð��� ����.
 * 
 */
public class SubwayLine {
	public static final int MIN_STATIONS = 4;
	public String sbName; // �뼱 �̸�
	public int sbOrder; // �뼱 ������ȣ
	public String sbColor; // �뼱 ����
	public double sbTotalDist; // �뼱 �Ѱ�α���
	public int sbNumberOfStations; // �뼱 �����ϴ� ��� ���� ����(�����̼� ��)

	public Station[] sbStations; // ����
	// �뼱 �����ϴ� Station
	public RailWay[] sbRailways; // ������
	// �뼱 �����ϴ� Railway
	public Station sbStartSt; // ��߿�
	public Station sbEndSt; // ������ (ȯ�¿��� ���� ����)
	// 2ȣ������ �����뼱(��ȯ��)�� ��߿� == ������
	
	// ���̻����� �⺻
	public SubwayLine() {
		this.sbNumberOfStations = MIN_STATIONS;
		this.sbStations = new Station[sbNumberOfStations];
		this.sbRailways = new RailWay[sbNumberOfStations-1];
	}

	public SubwayLine(String sbName, int sbOrder, String sbColor, int sbNumberOfStations) {
		super();
		this.sbName = sbName;
		this.sbOrder = sbOrder;
		this.sbColor = sbColor;
		if(sbNumberOfStations < MIN_STATIONS)
			sbNumberOfStations = MIN_STATIONS;
		this.sbNumberOfStations = sbNumberOfStations;
		this.sbStations = new Station[sbNumberOfStations];
		this.sbRailways = new RailWay[sbNumberOfStations-1];
		this.sbStartSt = sbStations[0];
		this.sbEndSt = sbStations[sbNumberOfStations-1];
		this.sbTotalDist = computeToralDist();
	}
	
	public double computeToralDist() {
		double total = 0.0;
		for (RailWay rw : sbRailways) {
			if(rw != null) {
			total += rw.getDistance(); // MyLine::getDistance
			}
		}
		this.sbTotalDist = total;
		return total;
	}


	// Ǯ������
	public SubwayLine(String sbName, int sbOrder, String sbColor, double sbTotalDist, int sbNumberOfStations,
			Station[] sbStations, RailWay[] sbRailways, Station sbStartSt, Station sbEndSt) {
		super();
		this.sbName = sbName;
		this.sbOrder = sbOrder;
		this.sbColor = sbColor;
		this.sbNumberOfStations = sbNumberOfStations;
		this.sbStations = sbStations;
		this.sbRailways = sbRailways;
		this.sbStartSt = sbStartSt;
		this.sbEndSt = sbEndSt;
		this.sbTotalDist = sbTotalDist;
	}
	
	@Override
	public String toString() {
		return "SubwayLine [sbName=" + sbName + ", sbOrder=" + sbOrder + ", sbColor=" + sbColor + ", sbTotalDist="
				+ sbTotalDist + ", sbNumberOfStations=" + sbNumberOfStations + ", sbStations="
				+ Arrays.toString(sbStations) + ", sbRailways=" + Arrays.toString(sbRailways) + ", sbStartSt="
				+ sbStartSt + ", sbEndSt=" + sbEndSt + ", computeToralDist()=" + computeToralDist() + "]";
	}
	
	
	
}
