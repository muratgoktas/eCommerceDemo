package eCommerceDemo.jOutSourceValidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.core.abstracts.Service;

public class JOutSourcePasswordValidator implements Service {

	private static JOutSourcePasswordValidator INSTANCE = new JOutSourcePasswordValidator();
	private static String pattern = null;
	
	/*
	 *  (?=.*[a-z])     : En az bir küçük harf içermelidir.
	 *  (?=.*d)         : En az bir rakam(0-9) içermelidir. 
     *  (?=.*[@#$%])    : En az bir özel karekter içermelidir.
     *  ((?=.*[A-Z])    : En az bir büyük harf içermelidir.
     *  {6,16}          : En az 6 karakter en fazla 16 karekter olmalýdýr.
	 * 
	 * */
	
	
	
	/**
	 * No one can make a direct instance
	 */
	private JOutSourcePasswordValidator() {
		
	}

	/**
	 * Force the user to build a validator using this way only
	 */
	public static JOutSourcePasswordValidator buildValidator(boolean forceSpecialChar, boolean forceCapitalLetter,
			boolean forceNumber, int minLength, int maxLength) {
		StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");

		if (forceSpecialChar) {
			patternBuilder.append("(?=.*[@#$%])");
			//System.out.println("There is no special character in the password!  ");
		}

		if (forceCapitalLetter) {
			patternBuilder.append("(?=.*[A-Z])");
			//System.out.println("There is no capital letter in the password!  ");
		}

		if (forceNumber) {
			patternBuilder.append("(?=.*d)");
			//System.out.println("There is no digit i.e. 0-9 in the password!");
		}

		patternBuilder.append(".{" + minLength + "," + maxLength + "})");
		pattern = patternBuilder.toString();

		return INSTANCE;
	}

	/**
	 * Here we will validate the password
	 */
	public static boolean validatePassword(final String password) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		return m.matches();
	}
}
