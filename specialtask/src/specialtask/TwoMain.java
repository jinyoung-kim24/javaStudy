package specialtask;

import java.util.Scanner;

public class TwoMain {

	public static void main(String[] args) {
		boolean flag = true;
		String email = "0623jia@naver.com";
		char[] c = new char[email.length()];
		char[] c2 = new char[email.length()];
		 int count = 0;
		char[] em = email.toCharArray();
		for (int i = 0; i < em.length; i++) {
			if(flag == true && em[i] != '@') {
				count++;
			}
			if(em[i] == '@')
				flag = false;
			if(i < count) {
				 c[i] = em[i];
			}else if(i > count) {
				 c2[i] = em[i];
			}
		}
		
		System.out.println(c);
		System.out.println(c2);
		
		
		
	}
}
