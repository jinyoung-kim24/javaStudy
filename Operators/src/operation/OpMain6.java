package operation;

public class OpMain6 {

	public static void main(String[] args) {
		char c = 'Z'; //90
		c = (char)(c - 11); // 'O'
		c--; // 'N'
		
		//if(--c > 'M' && --c > 65) //System.out.println("맞아요");
		//if(--c > 'M') 
		//if(--c >= 'M' && --c > 65)
		//if(--c >= 'M' && c-- <= 76)
		if(--c >= 'M' || c-- <= 76)
			System.out.printf("c = %c [%d] 맞아요! \n", c, (int)c);
		else 
			System.out.printf("c = %c [%d] 아니요! \n", c, (int)c);
		
		
		if( 1 == 1) {
			//if(2 == 2 && c-- <= 76 && c> 75)
			if(2 == 2 && (c-- <= 76 || c--> 75))
				System.out.printf("c2 = %c [%d] 맞아요! \n", c, (int)c);
			else 
				System.out.printf("c2 = %c [%d] 아니요! \n", c, (int)c);
			
		}
		
		
	}

}
