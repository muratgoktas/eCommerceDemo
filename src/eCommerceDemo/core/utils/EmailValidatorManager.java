package eCommerceDemo.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.core.abstracts.EmailValidatorService;
import eCommerceDemo.core.abstracts.Service;

public class EmailValidatorManager implements EmailValidatorService, Service {

	public  boolean checkedEmailSyntax(String email) {

		// Simple regex for java...
		// String regex = "^(.+)@(.+)$";
		// Prof regex for java

		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*"
				+ "+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21"
				+ "\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
				+ "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]"
				+ "*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
				+ "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:"
				+ "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\"
				+ "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}
	
	@Override
	public  int sendEmailValidator() {
		// Belirli bir matematiksel hesaplamayla oluşturulmuş kod.
		int validatorCode=32214857;
		System.out.println(" Doğrulama link Adresi:"
				+ " https://www.kodlama.io/dogrulamaKodu/123564"+ validatorCode);
		return validatorCode;
	}

	@Override
	public boolean reciveEmailValidator(int validatorCode) {
		if (sendEmailValidator() == validatorCode) {
			return true;
		}
		return false;

	}
}