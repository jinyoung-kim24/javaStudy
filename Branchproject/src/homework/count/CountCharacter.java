package homework.count;

public class CountCharacter {
	public static final int Ran = 1000;
	public static final char Number = 48;
	public static final char NumberEnd = 57;
	public static final char EN = 65;
	public static final char ENEnd = 90;
	public static final char en = 97;
	public static final char enEnd = 122;
	
	
	public static void main(String[] args) {
		int English = 0;
		int english = 0;
		int NumericCharacters = 0;
		int Symbol = 0;
		int count = 1;
		while(count <= Ran) {
			int text = (char) ((Math.random() * 95) +32);
				System.out.printf("%d회차 '%c' 생성 => ",count, text);
				count++;
				if(text >= Number && text <= NumberEnd) {
					System.out.println("숫자문자.");
				}else if(text >= EN && text <= ENEnd) {
					System.out.println("영문 대문자.");
				}else if(text >= en && text <= enEnd) {
					System.out.println("영문 소문자.");
				}else {
					System.out.println("기호문자.");
				}
				if(text >= Number && text <= NumberEnd)
					NumericCharacters++;
				else if(text >= EN && text <= ENEnd)
					English++;
				else if(text >= en && text <= enEnd)
					english++;
				else Symbol++;
			
			double perCent = PerCentNumBer(English);
			
		}
		System.out.println("------------------------------");
		System.out.printf("영문대문자:%d개 (%.2f%%)\n",English, PerCentNumBer(English));
		System.out.printf("영문소문자:%d개 (%.2f%%)\n",english, PerCentNumBer(english));
		System.out.printf("숫자문자:%d개 (%.2f%%)\n",NumericCharacters, PerCentNumBer(NumericCharacters));
		System.out.printf("기호문자:%d개 (%.2f%%)\n",Symbol, PerCentNumBer(Symbol));
	}

	
	public static double PerCentNumBer(int English) {
		double perCent = 0.0;
		
		perCent = (English / 1000.0) * 100.0;
		 
		return perCent;
	
	
	}
	
}
