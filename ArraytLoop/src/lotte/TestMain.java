package lotte;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// args ������ main ���۽� ���α׷� �� ó�� ���࿡
		// �ԷµǴ� �ʱⰪ �Ķ���� ==> Arguments
		System.out.println("Arguments == Parameters ����, �Էº���");
		System.out.println(args);
		System.out.println("args.length = " + args.length);
		
//		Arguments == Parameters ����, �Էº���
//				[Ljava.lang.String;@15db9742
//				args.length = 0
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println(">> �̸� �Է�: ");
//		String name = sc.next(); // ���α׷� �����߿�
//		System.out.println(">> ���� �Է�: ");
//		int age = sc.nextInt(); // Ű���� �Է��� ������ ����
//		System.out.println("�̸�: " + name);
//		System.out.println("����: " + age);

	}

}
