package eCommerceDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.business.abstracts.LoginService;
import eCommerceDemo.core.abstracts.GmailValidatorService;
import eCommerceDemo.core.abstracts.PasswordValidatorService;
import eCommerceDemo.core.utils.EmailValidatorManager;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entites.concretes.User;

public class LoginManager implements LoginService {
	private GmailValidatorService gmailValidatorService;
	private UserDao userDao;

	public LoginManager(GmailValidatorService gmailValidatorService, UserDao userDao) {
		super();
		this.gmailValidatorService = gmailValidatorService;
		this.userDao = userDao;
	}

	@Override
	public void singIn(User user) {
		List<String> values = new ArrayList<String>();
		values.add(user.getEmail());
		values.add(user.getParola());

		if (gmailValidatorService.gmailAccountValidator(values)) {
			System.out.println(user.getFullName() + " Gmail hesabýyla Login oldu.");
		} else if (userDao.getAll().equals(user.getEmail()) && userDao.getAll().equals(user.getParola())) {
			System.out.println(user.getFullName() + " Hibernate veri tabanýnda kayýtlý olan hesabýyla Login oldu.");
		} else {
			System.out.println("Geçersiz kullanýcý giriþi. Lütfen tekrar deneyiniz.");
		}

	}

	@Override
	public void singOut(User user) {
		System.out.println("Sayýn : "+user.getFullName()+". Bizi tercih ettiðiniz teþekkür ederiz. Yine bekleriz.");

	}

	

}
