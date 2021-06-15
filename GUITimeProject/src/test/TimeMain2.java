package test;

import java.util.Calendar;
import java.util.Date;

public class TimeMain2 {

	public static void main(String[] args) {
		// JVM �ý��� �޷� ��ü�� �����ϱ�
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		Date today = cal.getTime();
		System.out.println(today);
		
		System.out.println("�޷� ���� ��: " + cal.get(Calendar.YEAR));
		System.out.println("�޷� ���� ��: " +
				(cal.get(Calendar.MONTH)+1) );
				// �޷¿����� ���� 0 ~ 11
		System.out.println("�޷� ���� ��: " + cal.get(Calendar.DATE)); // DAY_OF_MONTH
		//
		System.out.println("�޷� ���� ��: " 
				+ cal.get(Calendar.HOUR));
		System.out.println("�޷� ���� ��: " 
				+ cal.get(Calendar.MINUTE));
		System.out.println("�޷� ���� ��: " 
				+ cal.get(Calendar.SECOND));
		System.out.println("�޷� ���� �и���: " 
				+ cal.get(Calendar.MILLISECOND) + "ms");
		//
		System.out.println("�޷� ���� ������(24h): " 
				+ cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("�޷� ���� AMPM: " 
				+
				(cal.get(Calendar.AM_PM) == Calendar.PM 
						? "����" : "����")	); // AM 0, PM 1
		System.out.println("�޷� ���� Ÿ����: " 
				+ cal.get(Calendar.ZONE_OFFSET));
		// 32400000 �и��� => 32400/3600 = 9 
		// (���� �׸���ġ���� 9�ð� �ð���) GMT/UTC + 9  
	}

}
/*
java.util.GregorianCalendar[time=1620711583033,
areFieldsSet=true,areAllFieldsSet=true,
lenient=true,
zone=sun.util.calendar.ZoneInfo[
id="Asia/Seoul",offset=32400000,
dstSavings=0,useDaylight=false,transitions=22,
lastRule=null],firstDayOfWeek=1,
minimalDaysInFirstWeek=1,ERA=1,
YEAR=2021,MONTH=4,WEEK_OF_YEAR=20,
WEEK_OF_MONTH=3,DAY_OF_MONTH=11,DAY_OF_YEAR=131,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=39,SECOND=43,MILLISECOND=33,ZONE_OFFSET=32400000,DST_OFFSET=0]


Tue May 11 15:02:50 KST 2021
�޷� ���� ��: 2021
�޷� ���� ��: 5
�޷� ���� ��: 11
�޷� ���� ��: 3
�޷� ���� ��: 2
�޷� ���� ��: 50
�޷� ���� �и���: 77ms
�޷� ���� ������(24h): 15
�޷� ���� AMPM: ����
�޷� ���� Ÿ����: 32400000

*/