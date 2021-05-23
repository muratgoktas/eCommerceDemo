package eCommerceDemo.core.abstracts;

public interface PasswordValidatorService {
	boolean passwordValidator(String value);

	/*
	 * abstract PasswordValidatorService buildValidator(boolean forceSpecialChar,
	 * boolean forceCapitalLetter, boolean forceNumber, int minLength, int
	 * maxLength);
	 */
}
