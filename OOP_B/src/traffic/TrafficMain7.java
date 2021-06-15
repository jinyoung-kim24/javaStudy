package traffic;

import traffic.land.ByCycle;
import traffic.land.Car;
import traffic.land.Truck;
import traffic.land.car.AISportsCar;
import traffic.land.car.CampingCar;
import traffic.land.car.SportsCar;
import traffic.land.car.Van;

import javax.xml.bind.ValidationEvent;

import traffic.*;
public class TrafficMain7 {
	
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
	
	// v3
	public static void printVehicleInfo(Vehicle vh) {
		System.out.println("** VEHICLE TYPE:: " + vh.type + Vehicle.TYPES[vh.type]);
//		System.out.println(vh instanceof Vehicle ? "��Ŭ�Դϴ�" : "�ƴմϴ�");
		if(vh instanceof AISportsCar) {
			// AISportsCar Ÿ���� ��ü��? ������ true �ƴϸ� false
			System.out.println(">>> AISportsCar!!");
		}else if(vh instanceof CampingCar) {
			System.out.println(">>> CampingCar!!");
		}else if(vh instanceof Van) {
			System.out.println(">>> Van");
		}else if(vh instanceof SportsCar) {
			System.out.println(">>> SportsCar!!");
		}else if(vh instanceof Car) {
			System.out.println(">>> Car!!");
		}
		else {
			System.out.println("Car ������ �ƴ� �ٸ� Vehicle��?");
		}
	}
	
	// v4
	public static void displayVehicleInfo(Vehicle vh) {
		System.out.println("** VEHICLE TYPE:: " + vh.type + Vehicle.TYPES[vh.type]);
//		System.out.println(vh instanceof Vehicle ? "��Ŭ�Դϴ�" : "�ƴմϴ�");
		if(vh instanceof Car) { // type == Car_type
			System.out.println("\t Car::");
			if(vh instanceof Van) {
				System.out.println("\t\t Van::");
			}else if(vh instanceof CampingCar) {
				System.out.println("\t\t CampingCar::");
			}else if(vh instanceof SportsCar) {
				System.out.println("\t\t SportsCar::");
				if(vh instanceof AISportsCar) {
					System.out.println("\t\t AISportsCar");
				}
			}
		}else if(vh instanceof ByCycle) {
			System.out.println("\t ByCycle::");
		}else if(vh instanceof Truck) {
			System.out.println("\t Truck::");
		}else {
			System.out.println("���� �з��� �ȵǴ� 2���� ��Ŭ?");
			// �����, ��, ����ö, ��ũ, ���???
		}
	}
	
	
	
	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO, "Ż�� ����ǰ 1", 1);
//		TrafficMain6.printVehicle(vh1);
		
		ByCycle bc1 = new ByCycle("��õ��2021k(��������)", 1);
//		System.out.println(bc1);
//		printVehicle(bc1);
		
		ByCycle bc2 = new ByCycle("������", 2, ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
//		printVehicle(bc2);
		
		Car cr1 = new Car(); // ����ī
//		System.out.println(cr1);
//		printVehicle(cr1);
		// �ڵ����� Ż���� �� �����ν� ���� ��� ������
//		printCar(cr1);
		
		Truck tk1 = new Truck(Car.IM_4WD, "Ư�� �ڵ� ƼŸ�� Ÿ�̾�", 200000L, 200.0);
		tk1.brand = "Volvo ����";
//		printVehicle(tk1);
		
		
		SportsCar sc1 = new SportsCar("��ȣŸ�̾� F2", "KIA", 7.0);
//		System.out.println(sc1);
//		printVehicle(sc1);
		
		CampingCar cc1 = new CampingCar();
		cc1.wheel = 8;
		cc1.maker = "�� ķ�� Ʈ���Ϸ�";
		cc1.bed = "���� ���� ħ��";
//		printVehicle(cc1);
		
		Van vn1 = new Van();
		vn1.immobility = Car.IM_4WD;
		vn1.maker = "��Ÿ���� x";
		vn1.seats = 11;
//		printVehicle(vn1);
		
		// Car tyoe���� ��� �ϰ� ����  ��ӹ迭 ������
		Car cars[] = { cr1, sc1, cc1, vn1, new AISportsCar("���̹�Ŭ�ι�2��AI")};
			for (Car car : cars) {
			displayVehicleInfo(car);
//			printVehicle(car);	
//			System.out.println(car);
			// toString ����� �躸���� ���� �ö󰡸� ó�� ������ �޼ҵ� toString()�� ������
			// �׷��� �ֻ��� ����Ŭ���� object���� �ö󰡴µ� ���ٸ� 
			// methodMissing ���� ������ �߻���
//				printVehicleInfo(car);
			}
			
		
		
		}
	

}
