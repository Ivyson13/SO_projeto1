
public class RandomizadorAlphaNumerico {
	
	static String getRandomString(int i) { 
		
		String theAlphaNumericS;
		StringBuilder builder;

		theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"; 

		// criar o StringBuffer
		builder = new StringBuilder(i); 

		for (int m = 0; m < i; m++) { 

			// gerarador numérico
			int myindex 
			= (int)(theAlphaNumericS.length() 
					* Math.random()); 

			// adicionar os characters
			builder.append(theAlphaNumericS 
					.charAt(myindex)); 
		} 

		return builder.toString(); 
	} 
}
