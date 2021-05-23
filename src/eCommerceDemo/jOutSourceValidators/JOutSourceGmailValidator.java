package eCommerceDemo.jOutSourceValidators;

import java.util.List;

public class JOutSourceGmailValidator {
	public boolean checkedMailAndPassword(List<String> values) {
		boolean inGmailUserName = false;
		String name = "";
		for (String value : values) {
			if (value == "muratgoktas@gmail.com" || inGmailUserName) {
				if (inGmailUserName && value == "A123qweQ@") {
					System.out.println(name + " Geçerli Gmail hesabý.");
				return inGmailUserName;
				}
				name = value;
				inGmailUserName = true;
			}
		}
		inGmailUserName=false;
		System.out.println(inGmailUserName+" Üzgünüz Geçersiz Gmail Hesabý.");
		return inGmailUserName ;

	}
	
	
}
