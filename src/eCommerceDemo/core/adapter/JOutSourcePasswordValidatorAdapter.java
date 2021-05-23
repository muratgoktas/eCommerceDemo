package eCommerceDemo.core.adapter;

import eCommerceDemo.core.abstracts.PasswordValidatorService;
import eCommerceDemo.entites.concretes.User;
import eCommerceDemo.jOutSourceValidators.JOutSourcePasswordValidator;

public class JOutSourcePasswordValidatorAdapter implements PasswordValidatorService {

	private JOutSourcePasswordValidator passwordChecked;

	public JOutSourcePasswordValidatorAdapter(JOutSourcePasswordValidator passwordChecked) {
		super();

		this.passwordChecked = passwordChecked.buildValidator(true, true, false, 6, 19);
	}

	@Override
	public boolean passwordValidator(String value) {
		return passwordChecked.validatePassword(value);
	}

}
