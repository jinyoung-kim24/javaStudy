package homework;

public class HomeMain {

	public static void main(String[] args) {

		MessageKorean mk = new MessageKorean();
		for (int i = 0; i < mk.KOREAN_MSG.length; i++) {
			if (args.length == 1) {
				if (args[0].equals("kr")) {
					System.out.println(i + ". " + mk.KOREAN_MSG[i]);
				}
			}
		}
		if (args.length > 1) {
			if (args[0].equals("kr") && args[1].equals("0")) {
				System.out.println(0 + ". " + mk.KOREAN_MSG[0]);
			} else if (args[0].equals("kr") && args[1].equals("1")) {
				System.out.println(1 + ". " + mk.KOREAN_MSG[1]);
			} else if (args[0].equals("kr") && args[1].equals("2")) {
				System.out.println(2 + ". " + mk.KOREAN_MSG[2]);
			} else if (args[0].equals("kr") && args[1].equals("3")) {
				System.out.println(3 + ". " + mk.KOREAN_MSG[3]);
			} else if (args[0].equals("kr") && args[1].equals("4")) {
				System.out.println(4 + ". " + mk.KOREAN_MSG[4]);
			} else if (args[0].equals("kr") && args[1].equals("5")) {
				System.out.println(5 + ". " + mk.KOREAN_MSG[5]);
			} else if (args[0].equals("kr") && args[1].equals("6")) {
				System.out.println(6 + ". " + mk.KOREAN_MSG[6]);
			}
		}

	}

}
