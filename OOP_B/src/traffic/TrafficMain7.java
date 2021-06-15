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
	
	// 자동차 (류의객체) 하나 받아서 그내용을 출력하기
	public static void printCar(Car vh) {
		System.out.println("==== 탈것 ====");
		// 탈것 공통 정보 출력
		System.out.printf("<<VH>> %d개의 바퀴를 장착한 %s 이름의\n\t %d인승 '%s'종류의 탈것 \n",
				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
		System.out.println("------------------------------");
		// 탈것 중에서도 자동차의 정보 출력
		System.out.printf("\t + %s 바퀴를 탑재, 구동방식 %s식 made by %s!\n",
				vh.tire,Car.IMWD[vh.immobility], vh.maker);
	}
	
//	public static void printVehicle(Vehicle vh) {
//		System.out.println("==== 탈것 ====");
//		System.out.printf("<<VH>> %d개의 바퀴를 장착한 %s 이름의\n\t %d인승 '%s'종류의 탈것 \n",
//				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
//		System.out.println("------------------------------");
//	}
	// 탈것 하나 받아서 그 내용을 출력하기
	// 탈것 중의 하나 탈것의 하위 호환은 가능함
	// 상속 다양성을 이용하여 부모의 타입으로 자식 자손 클래스
	// v2 
	public static void printVehicle(Vehicle vh) {
		System.out.println("==== 탈것 ====");
		System.out.printf("<<VH>> %d개의 바퀴를 장착한 %s 이름의\n\t %d인승 '%s'종류의 탈것 \n",
				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
		System.out.println("------------------------------");
		
		// 하위 탈것의 상세(특수) 정보출력---------------
		// 탈것의 종류 필드 type의 값에 따라 객체를 분류하여 상세부가 정보 출력
		switch (vh.type) {
		case Vehicle.TYPE_CAR: // 자동차 타입의 객체가 vh
			// 객체지향형 클래스 타입 캐스팅!
			// 보통 상속관계에 있는 객체들끼리 클래스 타입캐스팅이 가능함.
			// (타입캐스팅 == 자료형 강제로 변환)
			System.out.printf("\t + %s 바퀴를 탑재, 구동방식 %s식 made by %s!\n",
					((Car)vh).tire,((Car)vh).IMWD[((Car)vh).immobility], ((Car)vh).maker);
			break;
		case Vehicle.TYPE_BYCYCLE: // 자전거 타입의 객체 vh
			System.out.printf("\t + %s 페달 적용, 구동방식 %s식\n",
					((ByCycle)vh).pedal, ByCycle.IM_TYPES[((ByCycle)vh).immobility]);
			break;
		case Vehicle.TYPE_MOTORBIKE: // 오토바이 타입의 객체가 vh
			break;
		case Vehicle.TYPE_TRUCK: // 화물차 타입의 객체가 vh		
			System.out.printf(
			"\t+ %s 바퀴를 탑재, 구동방식 %s 식 /"
			+ " 적재용량: %d(kl), 적재하중: %.2f(g)\n",
			((Truck)vh).tire, 
		Car.IMWD[((Truck)vh).immobility],
				((Truck)vh).volume, 
				((Truck)vh).weight ); // 동적연결! 
			System.out.println("=============");
			break;
		default:
			System.out.println("!!알 수 없는 교통수단 발견.");
			break;
		}
	}
	
	// v3
	public static void printVehicleInfo(Vehicle vh) {
		System.out.println("** VEHICLE TYPE:: " + vh.type + Vehicle.TYPES[vh.type]);
//		System.out.println(vh instanceof Vehicle ? "비클입니다" : "아닙니다");
		if(vh instanceof AISportsCar) {
			// AISportsCar 타입의 객체니? 맞으면 true 아니면 false
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
			System.out.println("Car 종류가 아님 다른 Vehicle종?");
		}
	}
	
	// v4
	public static void displayVehicleInfo(Vehicle vh) {
		System.out.println("** VEHICLE TYPE:: " + vh.type + Vehicle.TYPES[vh.type]);
//		System.out.println(vh instanceof Vehicle ? "비클입니다" : "아닙니다");
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
			System.out.println("아직 분류가 안되는 2세대 비클?");
			// 비행기, 배, 지하철, 탱크, 드론???
		}
	}
	
	
	
	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO, "탈것 시제품 1", 1);
//		TrafficMain6.printVehicle(vh1);
		
		ByCycle bc1 = new ByCycle("삼천리2021k(보조바퀴)", 1);
//		System.out.println(bc1);
//		printVehicle(bc1);
		
		ByCycle bc2 = new ByCycle("레스포", 2, ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
//		printVehicle(bc2);
		
		Car cr1 = new Car(); // 더미카
//		System.out.println(cr1);
//		printVehicle(cr1);
		// 자동차도 탈것의 한 종류로써 담긴다 상속 다형성
//		printCar(cr1);
		
		Truck tk1 = new Truck(Car.IM_4WD, "특제 코딩 티타늄 타이어", 200000L, 200.0);
		tk1.brand = "Volvo 볼보";
//		printVehicle(tk1);
		
		
		SportsCar sc1 = new SportsCar("금호타이어 F2", "KIA", 7.0);
//		System.out.println(sc1);
//		printVehicle(sc1);
		
		CampingCar cc1 = new CampingCar();
		cc1.wheel = 8;
		cc1.maker = "뉴 캠프 트레일러";
		cc1.bed = "넓은 간이 침대";
//		printVehicle(cc1);
		
		Van vn1 = new Van();
		vn1.immobility = Car.IM_4WD;
		vn1.maker = "스타렉스 x";
		vn1.seats = 11;
//		printVehicle(vn1);
		
		// Car tyoe들을 묶어서 일괄 실행  상속배열 다형성
		Car cars[] = { cr1, sc1, cc1, vn1, new AISportsCar("네이버클로버2식AI")};
			for (Car car : cars) {
			displayVehicleInfo(car);
//			printVehicle(car);	
//			System.out.println(car);
			// toString 상속의 계보에서 위로 올라가며 처음 만나는 메소드 toString()을 실행함
			// 그런데 최상위 조상클래스 object까지 올라가는데 없다면 
			// methodMissing 류의 에러가 발생함
//				printVehicleInfo(car);
			}
			
		
		
		}
	

}
