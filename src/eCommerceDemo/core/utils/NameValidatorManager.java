package eCommerceDemo.core.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.core.abstracts.NameValidatorService;
import eCommerceDemo.core.abstracts.Service;

public class NameValidatorManager implements NameValidatorService, Service {

	@Override
	public boolean checkedName(List<String> names) {
		String turkishWords =",ç,Ç,ö,Ö,þ,Þ,Ý,ý,Ð,ð,Ü,ü";
		String regex = "^[A-Z,a-z"+turkishWords+"]{3,20}$";

		Pattern pattern = Pattern.compile(regex);
		for (String name : names) {
			Matcher matcher = pattern.matcher(name);
			if (!matcher.matches()) {
				return false;
			}
		}
		return true;

	}

}
