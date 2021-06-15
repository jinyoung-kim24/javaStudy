package lotte;

import java.util.Scanner;

public class TestMain2 {

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

		// if(args.length == 4)
		if (args.length >= 4) { // ������ �ڵ�

			String name = args[0]; // ������
			int age = Integer.parseInt(args[1]); // "24" => 24; Ÿ�Ժ�ȯ
			// �Ľ� (parse), �Ľ�, �ļ�(parser)
			String engName = args[2]; // "kimjinyoung"
			double height = Double.parseDouble(args[3]); // "170.00" = 170.00; Ÿ�Ժ�ȯ
			System.out.println(name + "�� ���̰�" + age + "���� �Ǿ����ϴ�.");
			System.out.println("�׷��� �����̸�" + engName + "���� �Ҹ��� �Ǿ���," + "����� Ű��" + height + "cm�� �ڶ����ϴ�.");

		} else { // 4�� �̸��� ����
			System.out.println("ARGS ���ڰ� 4�� �̻� �ʿ�..");
		}

//		Scanner sc = new Scanner(System.in);
//		System.out.println(">> �̸� �Է�: ");
//		String name = sc.next(); // ���α׷� �����߿�
//		System.out.println(">> ���� �Է�: ");
//		int age = sc.nextInt(); // Ű���� �Է��� ������ ����
//		System.out.println("�̸�: " + name);
//		System.out.println("����: " + age);

	}//main

} // class
