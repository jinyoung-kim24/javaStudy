package homework;

public class TempConverter2 {	
	
    
	public static void main(String[] args) {
		
		
		float Celsius3r = 00.00f;
		float Celsius = 36.50f;
		float Celsius2 = 00.00f;
		float Celsius3 = 00.00f;
		
		float Fahrenheit = 00.00f;
		float Fahrenheit2 = 80.00f;
		float Fahrenheit3r = 00.00f;
		float Fahrenheit3 = 00.00f;
		
		Celsius3 = (float) (Math.random() * (60.00) - 20.00);
		
		Fahrenheit3 = (float) Math.random() * 100 + 4;
		
		
		Celsius2 = fToC(Fahrenheit2);
		Celsius3r = fToC(Fahrenheit3);
		
		Fahrenheit = cToF(Celsius);
		Fahrenheit3r = cToF(Celsius3);
		
		System.out.println("======= �µ� ��ȯ�� =======");
		System.out.printf("\t �Է�:%.2fC(����)\n", Celsius);
		System.out.printf("\t ���:%.2fF(ȭ��)\n",Fahrenheit);
		System.out.println("--------------------------");
		System.out.printf("\t �Է�:%.2fF(ȭ��)\n", Fahrenheit2);
		System.out.printf("\t ��� %.2fC(����)\n", Celsius2);
		System.out.println("--------------------------");
		System.out.printf("\t �Է�:%.2fC(����)\n", Celsius3);
		System.out.printf("\t ���:%.2fF(ȭ��)\n",Fahrenheit3r);
		System.out.println("--------------------------");
		System.out.printf("\t ���:%.2fF(ȭ��)\n",Fahrenheit3);
		System.out.printf("\t �Է�:%.2fC(����)\n", Celsius3r);
		
	}

	private static float fToC(float Fahrenheit) {
		float resultCa = 0.0f;
		resultCa = (float)((float)(Fahrenheit - 32) / 1.8);
		return resultCa;
	}

	private static float cToF(float Celsius) {
		float resultFa = 0.0f;
		
		resultFa = (float) (Celsius * 1.8 + 32);
		return resultFa;
	}
	
	

	
	
}