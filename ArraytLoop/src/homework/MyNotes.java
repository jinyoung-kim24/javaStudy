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
		System.out.println("===  계이름 출력 프로그램 ===");
		Scanner sc = new Scanner(System.in);
		int piano;
		int fail = 4;
		do {
			System.out.println("마디 수 입력:");
			piano = sc.nextInt();
			if (piano < Fa) {
				System.out.println("마디 수 입력이 4미만입니다!!");
			}

		} while (piano < fail);

		int count = 0;
		String Snote = "";
		while (count < piano) {
			for (int i = 0; i < Fa; i++) {
				int note = (int) (Math.random() * UpDo) + 1;
				if (note == Do) {
					Snote = "도";
				} else if (note == Re) {
					Snote = "레";
				} else if (note == Mi) {
					Snote = "미";
				} else if (note == Fa) {
					Snote = "파";
				} else if (note == Sol) {
					Snote = "솔";
				} else if (note == La) {
					Snote = "라";
				} else if (note == Ti) {
					Snote = "시";
				} else {
					Snote = "도'";
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
