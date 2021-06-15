package homework.datasize;

public class HomeWork {
	
	public static final double inputMega = 100.0; // MB
	public static final int DATA_RATIO = 1024;
	public static final int BIT_RATIO = 8;
	
	
	
	public static void main(String[] args) {
		
		double resultBit = 0.0;
		double resultByte = 0.0;
		double resultKiloByte = 0.0;		
		double resultGigaByte = 0.0;
		double resultTeraByte = 0.0;
		
		
		
		resultBit = mbToBit(inputMega);
		resultKiloByte = mbToKB(inputMega);
		resultByte = mbToByte(inputMega);
		resultGigaByte = mbToGB(inputMega);
		resultTeraByte = mbToTB(inputMega);
		
		
		
		
		
		
		System.out.println(inputMega + "�ް�����Ʈ(MB)��" + resultBit + "��Ʈ(Bit)");
		System.out.println(inputMega + "�ް�����Ʈ(MB)��" + resultByte + "����Ʈ(Byte)");
		System.out.println(inputMega + "�ް�����Ʈ(MB)��" + resultKiloByte + "ų�ι���Ʈ(KB)");
		System.out.println(inputMega + "�ް�����Ʈ(MB)��" + resultGigaByte + "�Ⱑ����Ʈ(GigaByte)");
		System.out.println(inputMega + "�ް�����Ʈ(MB)��" + resultTeraByte + "�׶����Ʈ(TeraByte)");
		System.out.println("---------------------------------------------------------");
		
	}



	
	

	private static double mbToTB(double inputMega2) {
		double mbToTB = 0.0;
		
		mbToTB = (double) ((inputMega / DATA_RATIO) / DATA_RATIO);
		
		return mbToTB;
	}






	private static double mbToGB(double inputMega2) {
		double mbToGB= 0.0;
		
		mbToGB = (double) (inputMega / DATA_RATIO);
		
		return mbToGB;
	}






	private static double mbToBit(double inputMega2) {
		double mbToBit = 0.0;
		
		mbToBit = (double) (((inputMega * DATA_RATIO) * DATA_RATIO) * BIT_RATIO);
		
		return mbToBit;
	}






	private static double mbToByte(double inputMega2) {
		double mbToByte = 0.0;
	
		mbToByte = (double) (inputMega * DATA_RATIO) * DATA_RATIO;
		return mbToByte;
	}






	private static double mbToKB(double inputMega2) {
		double mbToKB = 0.0;
		 mbToKB = (double) (inputMega * DATA_RATIO);
		
		return mbToKB;
	}




	
	}


	
	

