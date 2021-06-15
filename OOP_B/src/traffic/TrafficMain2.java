package traffic;

import traffic.land.ByCycle;
import traffic.land.Car;

public class TrafficMain2 {
	
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
	
	public static void printVehicle(Vehicle vh) {
		System.out.println("==== 탈것 ====");
		System.out.printf("<<VH>> %d개의 바퀴를 장착한 %s 이름의\n\t %d인승 '%s'종류의 탈것 \n",
				vh.wheel, vh.brand, vh.seats, Vehicle.TYPES[vh.type]);
		System.out.println("------------------------------");
	}
	public static void main(String[] args) {
		Vehicle vh1 = new Vehicle(2, Vehicle.TYPE_ZERO, "탈것 시제품 1", 1);
		TrafficMain2.printVehicle(vh1);
		
		ByCycle bc1 = new ByCycle("삼천리2021k(보조바퀴)", 1);
//		System.out.println(bc1);
		printVehicle(bc1);
		
		ByCycle bc2 = new ByCycle("레스포", 2, ByCycle.ADV_PEDAL, 2);
//		System.out.println(bc1);
		printVehicle(bc2);
		
		Car cr1 = new Car(); // 더미카
//		System.out.println(cr1);
//		printVehicle(cr1);
		// 자동차도 탈것의 한 종류로써 담긴다 상속 다형성
		printCar(cr1);
		
	}

}
