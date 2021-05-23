package eCommerceDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.LoginService;
import eCommerceDemo.business.concretes.LoginManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.abstracts.EmailValidatorService;
import eCommerceDemo.core.abstracts.NameValidatorService;
import eCommerceDemo.core.adapter.JOutSourceGmailValidatorAdapter;
import eCommerceDemo.core.adapter.JOutSourcePasswordValidatorAdapter;
import eCommerceDemo.core.utils.EmailValidatorManager;
import eCommerceDemo.core.utils.NameValidatorManager;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;
import eCommerceDemo.entites.concretes.User;
import eCommerceDemo.jOutSourceValidators.JOutSourceGmailValidator;

public class Main {

	public static void main(String[] args) {
		/*
		 * String s = "mailhesabim@gmail.com";
		 * System.out.println(s.replaceAll("(^[^@]{1}|(?!^)\\G)[^@]", "$1*"));
		 */
		User user=new User(1,"Murat","GÖKTAÞ","muratgoktas@gmail.com","A123qweQ@",true);
		User user2=new User(2,"Hüseyin","GÖKTAÞ","huseyingoktas@biryetmez.com","H456ertZ@",true);
		
		EmailValidatorService emailChecked= new EmailValidatorManager();
		
		List<String> gmailAccount = new ArrayList<String>();
		gmailAccount.add(user.getEmail());
		gmailAccount.add(user.getParola());
		// Gmail out source ile mail ve password kontolü. Adapter kullanýldý.
		JOutSourceGmailValidatorAdapter gmailChecked = new JOutSourceGmailValidatorAdapter(new JOutSourceGmailValidator());
		
		/* isteðe baðlý kullanýmý iç kaynak kodu
		 * JOutSourcePasswordValidator passwordChecked =
		 * JOutSourcePasswordValidator.buildValidator(true, false, false, 6, 19) ;
		 * passwordChecked.validatePassword(user.getParola());
		 */
		 
		// dýþ kaynak kodundan alýnan mikro servis çalýþmasý
		JOutSourcePasswordValidatorAdapter passwordChecked =new JOutSourcePasswordValidatorAdapter(null);
		UserDao userDAo =new HibernateUserDao();
		NameValidatorService namesChecked= new NameValidatorManager();
		
		
		UserManager userManager = new UserManager(emailChecked,passwordChecked,userDAo,namesChecked,gmailChecked);
		userManager.add(user);
		userManager.delete(user);
	
		UserManager userManager2 = new UserManager(null,null,userDAo,namesChecked,null);
		userManager.add(user2);
		LoginService login=new LoginManager(gmailChecked, userDAo);
		login.singIn(user);
		login.singOut(user);
		//login.singIn(user2);
		
	}

}
