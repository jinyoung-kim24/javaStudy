package traffic;

import traffic.land.ByCycle;
import traffic.land.Car;
import traffic.land.Truck;

public class TrafficMain4 {
	
	// �ڵ��� (���ǰ�ü) �ϳ� �޾Ƽ� �׳����� ����ϱ�
	public static void printCar(Car vh) {
		System.out.println("==== Ż�� ====");
		// Ż�� ���� ���� ���
		System.out.printf("<<VH>> %d���� ������ ������ %s �̸���\n\t %d�ν� '%s'������ Ż�� \n",
				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
		System.out.println("------------------------------");
		// Ż�� �߿����� �ڵ����� ���� ���
		System.out.printf("\t + %s ������ ž��, ������� %s�� made by %s!\n",
				vh.tire,Car.IMWD[vh.immobility], vh.maker);
	}
	
//	public static void printVehicle(Vehicle vh) {
//		System.out.println("==== Ż�� ====");
//		System.out.printf("<<VH>> %d���� ������ ������ %s �̸���\n\t %d�ν� '%s'������ Ż�� \n",
//				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
//		System.out.println("------------------------------");
//	}
	// Ż�� �ϳ� �޾Ƽ� �� ������ ����ϱ�
	// Ż�� ���� �ϳ� Ż���� ���� ȣȯ�� ������
	// ��� �پ缺�� �̿��Ͽ� �θ��� Ÿ������ �ڽ� �ڼ� Ŭ����
	// v2 
	public static void printVehicle(Vehicle vh) {
		System.out.println("==== Ż�� ====");
		System.out.printf("<<VH>> %d���� ������ ������ %s �̸���\n\t %d�ν� '%s'������ Ż�� \n",
				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
		System.out.println("------------------------------");
		
		// ���� Ż���� ��(Ư��) �������---------------
		// Ż���� ���� �ʵ� type�� ���� ���� ��ü�� �з��Ͽ� �󼼺ΰ� ���� ���
		switch (vh.type) {
		case Vehicle.TYPE_CAR: // �ڵ��� Ÿ���� ��ü�� vh
			// ��ü������ Ŭ���� Ÿ�� ĳ����!
			// ���� ��Ӱ��迡 �ִ� ��ü�鳢�� Ŭ���� Ÿ��ĳ������ ������.
			// (Ÿ��ĳ���� == �ڷ��� ������ ��ȯ)
			System.out.printf("\t + %s ������ ž��, ������� %s�� made by %s!\n",
					((Car)vh).tire,((Car)vh).IMWD[((Car)vh).immobility], ((Car)vh).maker);
			break;
		case Vehicle.TYPE_BYCYCLE: // ������ Ÿ���� ��ü vh
			System.out.printf("\t + %s ��� ����, ������� %s��\n",
					((ByCycle)vh).pedal, ByCycle.IM_TYPES[((ByCycle)vh).immobility]);
			break;
		case Vehicle.TYPE_MOTORBIKE: // ������� Ÿ���� ��ü�� vh
			break;
		case Vehicle.TYPE_TRUCK: // ȭ���� Ÿ���� ��ü�� vh		
			System.out.printf(
			"\t+ %s ������ ž��, ������� %s �� /"
			+ " ����뷮: %d(kl), ��������: %.2f(g)\n",
			((Truck)vh).tire, 
		Car.IMWD[((Truck)vh).immobility],
				((Truck)vh).volume, 
				((Truck)vh).weight ); // ��������! 
			System.out.println("=============");
			break;
		default:
			System.out.println("!!�� �� ���� ������� �߰�.");
			break;
		}
	}
	
	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO, "Ż�� ����ǰ 1", 1);
		TrafficMain4.printVehicle(vh1);
		
		ByCycle bc1 = new ByCycle("��õ��2021k(��������)", 1);
//		System.out.println(bc1);
		printVehicle(bc1);
		
		ByCycle bc2 = new ByCycle("������", 2, ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
		printVehicle(bc2);
		
		Car cr1 = new Car(); // ����ī
//		System.out.println(cr1);
		printVehicle(cr1);
		// �ڵ����� Ż���� �� �����ν� ���� ��� ������
//		printCar(cr1);
		
		Truck tk1 = new Truck(Car.IM_4WD, "Ư�� �ڵ� ƼŸ�� Ÿ�̾�", 200000L, 200.0);
		tk1.brand = "Volvo ����";
		printVehicle(tk1);
		
		
	}

}
