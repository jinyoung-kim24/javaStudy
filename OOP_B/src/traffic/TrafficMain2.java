package traffic;

import traffic.land.ByCycle;
import traffic.land.Car;

public class TrafficMain2 {
	
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
	
	public static void printVehicle(Vehicle vh) {
		System.out.println("==== Ż�� ====");
		System.out.printf("<<VH>> %d���� ������ ������ %s �̸���\n\t %d�ν� '%s'������ Ż�� \n",
				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
		System.out.println("------------------------------");
	}
	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO, "Ż�� ����ǰ 1", 1);
		TrafficMain2.printVehicle(vh1);
		
		ByCycle bc1 = new ByCycle("��õ��2021k(��������)", 1);
//		System.out.println(bc1);
		printVehicle(bc1);
		
		ByCycle bc2 = new ByCycle("������", 2, ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
		printVehicle(bc2);
		
		Car cr1 = new Car(); // ����ī
//		System.out.println(cr1);
//		printVehicle(cr1);
		// �ڵ����� Ż���� �� �����ν� ���� ��� ������
		printCar(cr1);
		
	}

}
