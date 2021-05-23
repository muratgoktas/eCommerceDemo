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
			System.out.println(user.getFullName() + " Gmail hesab�yla Login oldu.");
		} else if (userDao.getAll().equals(user.getEmail()) && userDao.getAll().equals(user.getParola())) {
			System.out.println(user.getFullName() + " Hibernate veri taban�nda kay�tl� olan hesab�yla Login oldu.");
		} else {
			System.out.println("Ge�ersiz kullan�c� giri�i. L�tfen tekrar deneyiniz.");
		}

	}

	@Override
	public void singOut(User user) {
		System.out.println("Say�n : "+user.getFullName()+". Bizi tercih etti�iniz te�ekk�r ederiz. Yine bekleriz.");

	}

	

}
