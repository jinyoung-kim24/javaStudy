package homework;

public class ForLoopArray {

	public static void main(String[] args) {
		char alphabets[] = new char[26];
		alphabets[0] = 'A';
		for (int i = 0; i < alphabets.length; i++) {
			System.out.print((char) (alphabets[0] + i));

		}
		System.out.println();
		alphabets[0] = 'a';
		for (int i = 0; i < alphabets.length; i++) {
			System.out.print((char) (alphabets[0] + i));
		}
		System.out.println();
		alphabets[0] = 'A';
		for (int i = 0; i < alphabets.length; i++) {
			System.out.print((char) (alphabets[0] + Math.random() * 26));
		}
		System.out.println();
		for (int i = 0; i < alphabets.length; i++) {
			System.out.print((char) ('z' - Math.random() * 25));
		}
	}
}
