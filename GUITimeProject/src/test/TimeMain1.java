package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMain1 {

	public static void main(String[] args) {
		// ���� , �ð� => �޷�
		// �Ϸ�? 1 day = 24 x 60 x 60 = 86400 seconds
		// �ð����ڴ� ��ġ������ ǥ��... long��   2^64?
		// ���� �� ������ ǥ�� �����б���� �ð��� 
		// epoch time 1970.1.1.0��0��0��0�и��� ������ ��.
		
		// ���������̸� FQN
		java.util.Date today1 = new java.util.Date();
		Date today2 = new Date();
		System.out.println(today1.toString());
			// Tue May 11 14:16:29 KST 2021		
		System.out.println(today2);
	
		// KST => Korean Standard Time? GMT/UTC + 9 ����/�浵��...
		// Ÿ���� (TimeZone) => �ð���浵 ��ġ���� (������, �����ð� ����)
		// ����/�����  =>  8.5��?
		// ǥ�� �ð������� ������ OS�� �������� JVM�� �� �ð�������.
		
		System.out.println("long�� �ð� ��ġ��: " + today2.getTime()
				+ "ms"); // mile�� 1/1000��
		
		// ǥ�� ����ȭ�� long�� �ð��� �ٸ� ���?
		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.format(today2));
		// Ŀ���� ����ȭ
		SimpleDateFormat sdf = 
				new SimpleDateFormat("G yyyy�� MM�� dd�� HH:mm:ss z");
			// G era ����, z Ÿ����
		System.out.println(sdf.format(today2));
		// sdf.format() <=> sdf.parse()
	}

}

/*
Tue May 11 14:35:00 KST 2021
Tue May 11 14:35:00 KST 2021
long�� �ð� ��ġ��: 1620711300802ms
2021. 5. 11
���� 2021�� 05�� 11�� 14:35:00 KST
*/ 
