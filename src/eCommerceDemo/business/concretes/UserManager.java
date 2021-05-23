package eCommerceDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.abstracts.EmailValidatorService;
import eCommerceDemo.core.abstracts.GmailValidatorService;
import eCommerceDemo.core.abstracts.NameValidatorService;
import eCommerceDemo.core.abstracts.PasswordValidatorService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entites.concretes.User;

public class UserManager implements UserService {

	private EmailValidatorService emailControlService;
	private PasswordValidatorService passwordValidatorService;
	private UserDao userDao;
	private NameValidatorService nameValidatorService;
	private GmailValidatorService gmailValidatorService;

	public UserManager(EmailValidatorService emailControlService, PasswordValidatorService passwordValidatorService,
			UserDao userDao, NameValidatorService nameValidatorService, GmailValidatorService gmailValidatorService) {
		super();
		this.emailControlService = emailControlService;
		this.passwordValidatorService = passwordValidatorService;
		this.userDao = userDao;
		this.nameValidatorService = nameValidatorService;
		this.gmailValidatorService = gmailValidatorService;
	}

	@Override
	public List<User> getAll() {
		
		
		return null; 
	}

	@Override
	public void add(User user) {
		List<String> forGmailParameter = new ArrayList<String>();
		forGmailParameter.add(user.getEmail());
		forGmailParameter.add(user.getParola());
		if (nameValidatorService.checkedName(user.getNames())) {

			System.out.println("Ad�n�z ve Soyad�n� do�ru ." + user.getFirstName() + " " + user.getMiddleName() + " "
					+ user.getLastName());
		} else {
			System.out.println("Girmi� oldu�unuz Ad�n�z ve/veya Soyad�n�z 3 karekterin alt�ndad�r.");
			return;
		}

		if (emailControlService.checkedEmailSyntax(user.getEmail())) {
			System.out.println("Email adresiniz do�ru :" + user.getEmail());
		} else {
			System.out.println("Email adresiniz hatal� :" + user.getEmail());
			return;
		}
		if (this.passwordValidatorService.passwordValidator(user.getParola())) {
			System.out.println("Password ge�erli :" + user.getParola());
		} else {
			System.out.println("Password yaz�m kurallar�na uygun de�il." + user.getParola());
			return;
		}

		if (this.gmailValidatorService.gmailAccountValidator(forGmailParameter)) {
			System.out.println("Gmail Account servisi ile girdi.");
			this.userDao.add(user);
		}

		else if (this.emailControlService.reciveEmailValidator(this.emailControlService.sendEmailValidator())) {

			this.userDao.add(user);
		} else {
			System.out.println("Email adresiniz do�rulanamad�. L�tfen yeni ve/veya ba�ka bir  mail adresi giriniz.");
		}
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);

	}

	@Override
	public void update(User user) {
		if (nameValidatorService.checkedName(user.getNames())) {
			System.out.println("Ad�n�z ve Soyad�n� do�ru ." + user.getFirstName() + " " + user.getMiddleName() + " "
					+ user.getLastName());
		} else {
			System.out.println("Girmi� oldu�unuz Ad�n�z ve/veya Soyad�n�z 3 karekterin alt�ndad�r.");
			return;
		}

		if (emailControlService.checkedEmailSyntax(user.getEmail())) {
			System.out.println("Email adresiniz do�ru :" + user.getEmail());
		} else {
			System.out.println("Email adresiniz hatal� :" + user.getEmail());
			return;
		}
		if (this.passwordValidatorService.passwordValidator(user.getParola())) {
			System.out.println("Password ge�erli :" + user.getParola());
		} else {
			System.out.println("Password yaz�m kurallar�na uygun de�il." + user.getParola());
			return;
		}
		this.userDao.update(user);

	}

}
