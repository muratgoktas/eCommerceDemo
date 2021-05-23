package eCommerceDemo.core.adapter;

import java.util.List;

import eCommerceDemo.core.abstracts.GmailValidatorService;
import eCommerceDemo.jOutSourceValidators.JOutSourceGmailValidator;

public class JOutSourceGmailValidatorAdapter implements GmailValidatorService {

	private JOutSourceGmailValidator gmailValidator;


	public JOutSourceGmailValidatorAdapter(JOutSourceGmailValidator gmailValidator) {
		super();
		this.gmailValidator = gmailValidator;
	}

	@Override
	public boolean gmailAccountValidator(List<String> values) {

		return gmailValidator.checkedMailAndPassword(values);

	}

}
