import java.util.Scanner;

public class Jinyoung6 {

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("ют╥б:");
		String eMail = sc.next();

		char mail[] = new char[eMail.length()];
		for (int i = 0; i < mail.length; i++) {
			mail[i] = eMail.charAt(i);
			if(mail[i] == '@') {
				flag = true;
				System.out.print(mail[i]);				
			}
		}
	}

}
