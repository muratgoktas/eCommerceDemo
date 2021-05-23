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

			System.out.println("Adýnýz ve Soyadýný doðru ." + user.getFirstName() + " " + user.getMiddleName() + " "
					+ user.getLastName());
		} else {
			System.out.println("Girmiþ olduðunuz Adýnýz ve/veya Soyadýnýz 3 karekterin altýndadýr.");
			return;
		}

		if (emailControlService.checkedEmailSyntax(user.getEmail())) {
			System.out.println("Email adresiniz doðru :" + user.getEmail());
		} else {
			System.out.println("Email adresiniz hatalý :" + user.getEmail());
			return;
		}
		if (this.passwordValidatorService.passwordValidator(user.getParola())) {
			System.out.println("Password geçerli :" + user.getParola());
		} else {
			System.out.println("Password yazým kurallarýna uygun deðil." + user.getParola());
			return;
		}

		if (this.gmailValidatorService.gmailAccountValidator(forGmailParameter)) {
			System.out.println("Gmail Account servisi ile girdi.");
			this.userDao.add(user);
		}

		else if (this.emailControlService.reciveEmailValidator(this.emailControlService.sendEmailValidator())) {

			this.userDao.add(user);
		} else {
			System.out.println("Email adresiniz doðrulanamadý. Lütfen yeni ve/veya baþka bir  mail adresi giriniz.");
		}
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);

	}

	@Override
	public void update(User user) {
		if (nameValidatorService.checkedName(user.getNames())) {
			System.out.println("Adýnýz ve Soyadýný doðru ." + user.getFirstName() + " " + user.getMiddleName() + " "
					+ user.getLastName());
		} else {
			System.out.println("Girmiþ olduðunuz Adýnýz ve/veya Soyadýnýz 3 karekterin altýndadýr.");
			return;
		}

		if (emailControlService.checkedEmailSyntax(user.getEmail())) {
			System.out.println("Email adresiniz doðru :" + user.getEmail());
		} else {
			System.out.println("Email adresiniz hatalý :" + user.getEmail());
			return;
		}
		if (this.passwordValidatorService.passwordValidator(user.getParola())) {
			System.out.println("Password geçerli :" + user.getParola());
		} else {
			System.out.println("Password yazým kurallarýna uygun deðil." + user.getParola());
			return;
		}
		this.userDao.update(user);

	}

}
