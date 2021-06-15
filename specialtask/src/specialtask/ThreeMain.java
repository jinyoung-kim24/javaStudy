package specialtask;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeMain {

	public static void main(String[] args) {
		String msg = "MyBall!";
		char[] petmsg = msg.toCharArray();
		for (int i = 0; i < petmsg.length; i++) {

			for (int j = i+1; j < petmsg.length; j++) {
				if (petmsg[i] > petmsg[j]) {
					char temp = petmsg[i];
					petmsg[i] = petmsg[j];
					petmsg[j] = temp;
				}
			}
			System.out.printf("%c(%d)", petmsg[i], (int) (petmsg[i]));

		}

	}

}
