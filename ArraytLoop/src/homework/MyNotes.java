package homework;

import java.util.Scanner;

public class MyNotes {
	public static final int Do = 1;
	public static final int Re = 2;
	public static final int Mi = 3;
	public static final int Fa = 4;
	public static final int Sol = 5;
	public static final int La = 6;
	public static final int Ti = 7;
	public static final int UpDo = 8;

	public static void main(String[] args) {
		System.out.println("===  ���̸� ��� ���α׷� ===");
		Scanner sc = new Scanner(System.in);
		int piano;
		int fail = 4;
		do {
			System.out.println("���� �� �Է�:");
			piano = sc.nextInt();
			if (piano < Fa) {
				System.out.println("���� �� �Է��� 4�̸��Դϴ�!!");
			}

		} while (piano < fail);

		int count = 0;
		String Snote = "";
		while (count < piano) {
			for (int i = 0; i < Fa; i++) {
				int note = (int) (Math.random() * UpDo) + 1;
				if (note == Do) {
					Snote = "��";
				} else if (note == Re) {
					Snote = "��";
				} else if (note == Mi) {
					Snote = "��";
				} else if (note == Fa) {
					Snote = "��";
				} else if (note == Sol) {
					Snote = "��";
				} else if (note == La) {
					Snote = "��";
				} else if (note == Ti) {
					Snote = "��";
				} else {
					Snote = "��'";
				}
				System.out.print(Snote);
			} // for
			count++;
			if (count % 4 == 0) {
				System.out.println("||");
			} else {
				System.out.print("|");
			}
		}
	}// main
}// class
